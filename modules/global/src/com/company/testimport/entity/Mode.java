package com.company.testimport.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.global.DesignSupport;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.BaseIdentityIdEntity;

@DesignSupport("{'imported':true}")
@NamePattern("%s|name")
@Table(name = "mode")
@Entity(name = "testimport$Mode")
public class Mode extends BaseIdentityIdEntity {
    private static final long serialVersionUID = -1270750387268490992L;

    @Column(name = "index_name", nullable = false, length = 128)
    protected String indexName;

    @Column(name = "name", nullable = false, length = 128)
    protected String name;

    @Column(name = "stateful_flag")
    protected Boolean statefulFlag = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "effective_dt")
    protected Date effectiveDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiration_dt")
    protected Date expirationDt;

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

    public void setStatefulFlag(Boolean statefulFlag) {
        this.statefulFlag = statefulFlag;
    }

    public Boolean getStatefulFlag() {
        return statefulFlag;
    }

    public void setEffectiveDt(Date effectiveDt) {
        this.effectiveDt = effectiveDt;
    }

    public Date getEffectiveDt() {
        return effectiveDt;
    }

    public void setExpirationDt(Date expirationDt) {
        this.expirationDt = expirationDt;
    }

    public Date getExpirationDt() {
        return expirationDt;
    }


}