package com.company.testimport.web.switchrule;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.testimport.entity.SwitchRule;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;

public class SwitchRuleEdit extends AbstractEditor<SwitchRule> {
    @Inject
    private Datasource<SwitchRule> switchRuleDs;

    @Override
    protected void postInit() {
        SwitchRule sr = switchRuleDs.getItem();
        super.postInit();
    }
}