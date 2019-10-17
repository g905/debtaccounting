/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.*;

/**
 * @author slavb
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Entry implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private LocalDate date;

    @Embedded
    private Money amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Transaction transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    public Entry(LocalDate date, Money amount) {
        this.date = date;
        this.amount = amount;
    }

    public Entry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entry withId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Entry withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Entry withAmount(Money amount) {
        this.amount = amount;
        return this;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Entry withTransaction(Transaction transaction) {
        this.transaction = transaction;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Entry withAccount(Account account) {
        this.account = account;
        return this;
    }

}