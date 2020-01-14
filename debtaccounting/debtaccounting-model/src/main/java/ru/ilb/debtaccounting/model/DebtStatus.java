/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

/**
 * Статус долга
 *
 * @author slavb
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class DebtStatus implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * код
     */
    @Basic
    @Enumerated(EnumType.STRING)
    private DebtStatusCode code;

    @Basic
    private String name;

    /**
     * Выдан
     */
    @Basic
    private boolean disbursed;

    public DebtStatus(Long id, DebtStatusCode code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public DebtStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DebtStatus withId(Long id) {
        this.id = id;
        return this;
    }

    public DebtStatusCode getCode() {
        return code;
    }

    public void setCode(DebtStatusCode code) {
        this.code = code;
    }

    /**
     * Set код
     *
     * @param code {@link #code}
     * @return {@link #DebtStatus}
     */
    public DebtStatus withCode(DebtStatusCode code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DebtStatus withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get выдан
     *
     * @return {@link #disbursed}
     */
    public boolean isDisbursed() {
        return disbursed;
    }

    /**
     * Set выдан
     *
     * @param disbursed {@link #disbursed}
     */
    public void setDisbursed(boolean disbursed) {
        this.disbursed = disbursed;
    }

    /**
     * Set выдан
     *
     * @param disbursed {@link #disbursed}
     * @return {@link #DebtStatus}
     */
    public DebtStatus withDisbursed(boolean disbursed) {
        this.disbursed = disbursed;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final DebtStatus other = (DebtStatus) obj;
        if (!java.util.Objects.equals(this.getCode(), other.getCode())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.getCode());
        return hash;
    }

}