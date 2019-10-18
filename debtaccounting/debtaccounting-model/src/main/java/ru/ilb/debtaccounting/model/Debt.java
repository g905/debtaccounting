/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.*;

/**
 * @author slavb
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Debt implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private DebtStatusCode status;

    /**
     * Счет основного долга
     */
    @OneToOne(fetch = FetchType.LAZY)
    private Account principalAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    private DebtStatus debtStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cashflow cashflow;

    @OneToMany(mappedBy = "debt", cascade = CascadeType.ALL)
    @XmlTransient
    private List<Event> events;

    @OneToMany(mappedBy = "debt", cascade = CascadeType.ALL)
    @XmlTransient
    private List<DebtAccount> debtAccounts;

    @OneToMany(mappedBy = "debt")
    @XmlTransient
    private List<DebtRight> debtRights;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Debt withId(Long id) {
        this.id = id;
        return this;
    }

    public DebtStatusCode getStatus() {
        return status;
    }

    public void setStatus(DebtStatusCode status) {
        this.status = status;
    }

    public Debt withStatus(DebtStatusCode status) {
        this.status = status;
        return this;
    }

    /**
     * Get счет основного долга
     *
     * @return {@link #principalAccount}
     */
    public Account getPrincipalAccount() {
        return principalAccount;
    }

    /**
     * Set счет основного долга
     *
     * @param principalAccount {@link #principalAccount}
     */
    public void setPrincipalAccount(Account principalAccount) {
        this.principalAccount = principalAccount;
    }

    /**
     * Set счет основного долга
     *
     * @param principalAccount {@link #principalAccount}
     * @return {@link #Debt}
     */
    public Debt withPrincipalAccount(Account principalAccount) {
        this.principalAccount = principalAccount;
        return this;
    }

    public DebtStatus getDebtStatus() {
        return debtStatus;
    }

    public void setDebtStatus(DebtStatus debtStatus) {
        this.debtStatus = debtStatus;
    }

    public Debt withDebtStatus(DebtStatus debtStatus) {
        this.debtStatus = debtStatus;
        return this;
    }

    public Cashflow getCashflow() {
        return cashflow;
    }

    public void setCashflow(Cashflow cashflow) {
        this.cashflow = cashflow;
    }

    public Debt withCashflow(Cashflow cashflow) {
        this.cashflow = cashflow;
        return this;
    }

    public List<Event> getEvents() {
        if (events == null) {
            events = new ArrayList<>();
        }
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Debt withEvents(List<Event> events) {
        this.events = events;
        return this;
    }

    public void addEvent(Event event) {
        getEvents().add(event);
        event.setDebt(this);
    }

    public void removeEvent(Event event) {
        getEvents().remove(event);
        event.setDebt(null);
    }

    public List<DebtAccount> getDebtAccounts() {
        if (debtAccounts == null) {
            debtAccounts = new ArrayList<>();
        }
        return debtAccounts;
    }

    public void setDebtAccounts(List<DebtAccount> debtAccounts) {
        this.debtAccounts = debtAccounts;
    }

    public Debt withDebtAccounts(List<DebtAccount> debtAccounts) {
        this.debtAccounts = debtAccounts;
        return this;
    }

    public void addDebtAccount(DebtAccount debtAccount) {
        getDebtAccounts().add(debtAccount);
        debtAccount.setDebt(this);
    }

    public void removeDebtAccount(DebtAccount debtAccount) {
        getDebtAccounts().remove(debtAccount);
        debtAccount.setDebt(null);
    }

    public List<DebtRight> getDebtRights() {
        if (debtRights == null) {
            debtRights = new ArrayList<>();
        }
        return debtRights;
    }

    public void setDebtRights(List<DebtRight> debtRights) {
        this.debtRights = debtRights;
    }

    public Debt withDebtRights(List<DebtRight> debtRights) {
        this.debtRights = debtRights;
        return this;
    }

    public void addDebtRight(DebtRight debtRight) {
        getDebtRights().add(debtRight);
        debtRight.setDebt(this);
    }

    public void removeDebtRight(DebtRight debtRight) {
        getDebtRights().remove(debtRight);
        debtRight.setDebt(null);
    }

}