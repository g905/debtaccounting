/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

/**
 * @author slavb
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private LocalDate date;

    /**
     * Запрос
     */
    @Basic
    @Valid
    private EventRequest request;

    /**
     * Дата создания
     */
    @Basic
    private LocalDateTime createdDate;

    @ManyToOne
    private Debt debt;

    @OneToMany(mappedBy = "event")
    @XmlTransient
    private List<Transaction> transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event withId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Event withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    /**
     * Get запрос
     *
     * @return {@link #eventRequest}
     */
    public EventRequest getRequest() {
        return request;
    }

    /**
     * Set запрос
     *
     * @param request {@link #eventRequest}
     */
    public void setRequest(EventRequest request) {
        this.request = request;
    }

    /**
     * Set запрос
     *
     * @param request {@link #request}
     * @return {@link #Event}
     */
    public Event withRequest(EventRequest request) {
        this.request = request;
        return this;
    }

    /**
     * Get дата создания
     *
     * @return {@link #createdDate}
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Set дата создания
     *
     * @param createdDate {@link #createdDate}
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Set дата создания
     *
     * @param createdDate {@link #createdDate}
     * @return {@link #Event}
     */
    public Event withCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }

    public Event withDebt(Debt debt) {
        this.debt = debt;
        return this;
    }

    public List<Transaction> getTransactions() {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        getTransactions().add(transaction);
        transaction.setEvent(this);
    }

    public void removeTransaction(Transaction transaction) {
        getTransactions().remove(transaction);
        transaction.setEvent(null);
    }

    public Event withTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

}