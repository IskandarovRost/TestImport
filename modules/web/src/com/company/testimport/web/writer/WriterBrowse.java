package com.company.testimport.web.writer;

import com.company.testimport.entity.Writer;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.components.actions.RemoveAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class WriterBrowse extends AbstractLookup {

    /**
     * The {@link CollectionDatasource} instance that loads a list of {@link Writer} records
     * to be displayed in {@link WriterBrowse#writersTable} on the left
     */
    @Inject
    private CollectionDatasource<Writer, Integer> writersDs;

    /**
     * The {@link Datasource} instance that contains an instance of the selected entity
     * in {@link WriterBrowse#writersDs}
     * <p/> Containing instance is loaded in {@link CollectionDatasource#addItemChangeListener}
     * with the view, specified in the XML screen descriptor.
     * The listener is set in the {@link WriterBrowse#init(Map)} method
     */
    @Inject
    private Datasource<Writer> writerDs;

    /**
     * The {@link Table} instance, containing a list of {@link Writer} records,
     * loaded via {@link WriterBrowse#writersDs}
     */
    @Inject
    private Table<Writer> writersTable;

    /**
     * The {@link BoxLayout} instance that contains components on the left side
     * of {@link SplitPanel}
     */
    @Inject
    private BoxLayout lookupBox;

    /**
     * The {@link BoxLayout} instance that contains buttons to invoke Save or Cancel actions in edit mode
     */
    @Inject
    private BoxLayout actionsPane;

    /**
     * The {@link FieldGroup} instance that is linked to {@link WriterBrowse#writerDs}
     * and shows fields of the selected {@link Writer} record
     */
    @Inject
    private FieldGroup fieldGroup;

    /**
     * The {@link RemoveAction} instance, related to {@link WriterBrowse#writersTable}
     */
    @Named("writersTable.remove")
    private RemoveAction writersTableRemove;

    @Inject
    private DataSupplier dataSupplier;

    /**
     * {@link Boolean} value, indicating if a new instance of {@link Writer} is being created
     */
    private boolean creating;

    @Override
    public void init(Map<String, Object> params) {

        /**
         * Adding {@link com.haulmont.cuba.gui.data.Datasource.ItemChangeListener} to {@link writersDs}
         * The listener reloads the selected record with the specified view and sets it to {@link writerDs}
         */
        writersDs.addItemChangeListener(e -> {
            if (e.getItem() != null) {
                Writer reloadedItem = dataSupplier.reload(e.getDs().getItem(), writerDs.getView());
                writerDs.setItem(reloadedItem);
            }
        });

        /**
         * Adding {@link CreateAction} to {@link writersTable}
         * The listener removes selection in {@link writersTable}, sets a newly created item to {@link writerDs}
         * and enables controls for record editing
         */
        writersTable.addAction(new CreateAction(writersTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity newItem, Datasource parentDs, Map<String, Object> params) {
                writersTable.setSelected(Collections.emptyList());
                writerDs.setItem((Writer) newItem);
                enableEditControls(true);
            }
        });

        /**
         * Adding {@link EditAction} to {@link writersTable}
         * The listener enables controls for record editing
         */
        writersTable.addAction(new EditAction(writersTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity existingItem, Datasource parentDs, Map<String, Object> params) {
                if (writersTable.getSelected().size() == 1) {
                    enableEditControls(false);
                }
            }
        });

        /**
         * Setting {@link RemoveAction#afterRemoveHandler} for {@link writersTableRemove}
         * to reset record, contained in {@link writerDs}
         */
        writersTableRemove.setAfterRemoveHandler(removedItems -> writerDs.setItem(null));

        disableEditControls();
    }

    /**
     * Method that is invoked by clicking Save button after editing an existing or creating a new record
     */
    public void save() {
        getDsContext().commit();

        Writer editedItem = writerDs.getItem();
        if (creating) {
            writersDs.includeItem(editedItem);
        } else {
            writersDs.updateItem(editedItem);
        }
        writersTable.setSelected(editedItem);

        disableEditControls();
    }

    /**
     * Method that is invoked by clicking Save button after editing an existing or creating a new record
     */
    public void cancel() {
        Writer selectedItem = writersDs.getItem();
        if (selectedItem != null) {
            Writer reloadedItem = dataSupplier.reload(selectedItem, writerDs.getView());
            writersDs.setItem(reloadedItem);
        } else {
            writerDs.setItem(null);
        }

        disableEditControls();
    }

    /**
     * Enabling controls for record editing
     * @param creating indicates if a new instance of {@link Writer} is being created
     */
    private void enableEditControls(boolean creating) {
        this.creating = creating;
        initEditComponents(true);
        fieldGroup.requestFocus();
    }

    /**
     * Disabling editing controls
     */
    private void disableEditControls() {
        initEditComponents(false);
        writersTable.requestFocus();
    }

    /**
     * Initiating edit controls, depending on if they should be enabled/disabled
     * @param enabled if true - enables editing controls and disables controls on the left side of the splitter
     *                if false - visa versa
     */
    private void initEditComponents(boolean enabled) {
        fieldGroup.setEditable(enabled);
        actionsPane.setVisible(enabled);
        lookupBox.setEnabled(!enabled);
    }
}