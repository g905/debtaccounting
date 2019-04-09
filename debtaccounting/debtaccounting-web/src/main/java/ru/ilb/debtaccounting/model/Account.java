/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.*;

/**
 * @author slavb
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Остаток на счете
     */
    @Basic
    @Column(scale = 2, precision = 15)
    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    @XmlTransient
    private List<DebtAccount> debtAccounts;

    @OneToMany(mappedBy = "account")
    @XmlTransient
    private List<AccountBalance> accountBalances;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get остаток на счете
     *
     * @return {@link #balance}
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Set остаток на счете
     *
     * @param balance {@link #balance}
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Set остаток на счете
     *
     * @param balance {@link #balance}
     * @return {@link #Account}
     */
    public Account withBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
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

    public Account withDebtAccounts(List<DebtAccount> debtAccounts) {
        this.debtAccounts = debtAccounts;
        return this;
    }

    public void addDebtAccount(DebtAccount debtAccount) {
        getDebtAccounts().add(debtAccount);
        debtAccount.setAccount(this);
    }

    public void removeDebtAccount(DebtAccount debtAccount) {
        getDebtAccounts().remove(debtAccount);
        debtAccount.setAccount(null);
    }

    public List<AccountBalance> getAccountBalances() {
        if (accountBalances == null) {
            accountBalances = new ArrayList<>();
        }
        return accountBalances;
    }

    public void setAccountBalances(List<AccountBalance> accountBalances) {
        this.accountBalances = accountBalances;
    }

    public Account withAccountBalances(List<AccountBalance> accountBalances) {
        this.accountBalances = accountBalances;
        return this;
    }

    public void addAccountBalance(AccountBalance accountBalance) {
        getAccountBalances().add(accountBalance);
        accountBalance.setAccount(this);
    }

    public void removeAccountBalance(AccountBalance accountBalance) {
        getAccountBalances().remove(accountBalance);
        accountBalance.setAccount(null);
    }

}