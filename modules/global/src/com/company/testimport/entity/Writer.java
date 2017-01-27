package com.company.testimport.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import java.util.UUID;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Table(name = "TESTIMPORT_WRITER")
@Entity(name = "testimport$Writer")
public class Writer extends BaseIntegerIdEntity implements HasUuid {
    private static final long serialVersionUID = 918033704220158266L;

    @Column(name = "NAME")
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIRST_WRITTEN_BOOK_ID")
    protected Book firstWrittenBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECOND_WRITEN_BOOK_ID")
    protected Book secondWritenBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THIRD_WRITTEN_BOOK_ID")
    protected Book thirdWrittenBook;

    @Column(name = "UUID")
    private UUID uuid;

    public void setFirstWrittenBook(Book firstWrittenBook) {
        this.firstWrittenBook = firstWrittenBook;
    }

    public Book getFirstWrittenBook() {
        return firstWrittenBook;
    }

    public void setSecondWritenBook(Book secondWritenBook) {
        this.secondWritenBook = secondWritenBook;
    }

    public Book getSecondWritenBook() {
        return secondWritenBook;
    }

    public void setThirdWrittenBook(Book thirdWrittenBook) {
        this.thirdWrittenBook = thirdWrittenBook;
    }

    public Book getThirdWrittenBook() {
        return thirdWrittenBook;
    }


    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}