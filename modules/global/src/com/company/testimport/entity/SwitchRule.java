package com.company.testimport.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.global.DesignSupport;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.BaseIdentityIdEntity;

@DesignSupport("{'imported':true}")
@NamePattern("%s|name")
@Table(name = "switch_rule")
@Entity(name = "testimport$SwitchRule")
public class SwitchRule extends BaseIdentityIdEntity {
    private static final long serialVersionUID = 1568583266171274574L;

    @Column(name = "index_name", nullable = false, length = 128)
    protected String indexName;

    @Column(name = "name", nullable = false, length = 128)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "begin_mode_id")
    protected Mode beginMode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "end_mode_id")
    protected Mode endMode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "before_dispatch_id")
    protected IntrospectionDispatch beforeDispatch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "after_dispatch_id")
    protected IntrospectionDispatch afterDispatch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condition_dispatch_id")
    protected IntrospectionDispatch conditionDispatch;

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBeginMode(Mode beginMode) {
        this.beginMode = beginMode;
    }

    public Mode getBeginMode() {
        return beginMode;
    }

    public void setEndMode(Mode endMode) {
        this.endMode = endMode;
    }

    public Mode getEndMode() {
        return endMode;
    }

    public void setBeforeDispatch(IntrospectionDispatch beforeDispatch) {
        this.beforeDispatch = beforeDispatch;
    }

    public IntrospectionDispatch getBeforeDispatch() {
        return beforeDispatch;
    }

    public void setAfterDispatch(IntrospectionDispatch afterDispatch) {
        this.afterDispatch = afterDispatch;
    }

    public IntrospectionDispatch getAfterDispatch() {
        return afterDispatch;
    }

    public void setConditionDispatch(IntrospectionDispatch conditionDispatch) {
        this.conditionDispatch = conditionDispatch;
    }

    public IntrospectionDispatch getConditionDispatch() {
        return conditionDispatch;
    }


}