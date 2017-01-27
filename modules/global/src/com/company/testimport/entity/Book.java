package com.company.testimport.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import java.util.UUID;

@Table(name = "TESTIMPORT_BOOK")
@Entity(name = "testimport$Book")
public class Book extends BaseIntegerIdEntity implements HasUuid {
    private static final long serialVersionUID = 6141097040353804836L;

    @Column(name = "NAME_OF_BOOK")
    protected String nameOfBook;

    @Column(name = "UUID")
    private UUID uuid;

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }


    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }


}