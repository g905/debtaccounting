/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.*;
import ru.ilb.debtaccounting.exceptions.AlreadyDisbursedException;

/**
 * @author slavb
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
public class Debt implements Serializable, Disbursable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private DebtStatus debtStatus;

    @OneToMany(mappedBy = "debt", cascade = CascadeType.ALL)
    @XmlTransient
    private List<Event> events;

    @OneToMany(mappedBy = "debt", cascade = CascadeType.ALL)
    @XmlTransient
    private List<DebtAccount> debtAccounts;

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

    public Optional<DebtAccount> getDebtAccount(Class<? extends DebtAccount> type) {
        return getDebtAccounts().stream().filter(da -> type.isAssignableFrom(da.getClass())).findFirst();
    }

    @Override
    public void disburse() throws AlreadyDisbursedException {
        // To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

}