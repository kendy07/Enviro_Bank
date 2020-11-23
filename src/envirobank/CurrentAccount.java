/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envirobank;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 *
 * @author Bubbles Tech
 */
public class CurrentAccount {
// instances of the class

    private long id;
    private long accountNum;
    private BigDecimal balance;
    private BigDecimal overdraft;

    /**
     * Default constructor
     */
    public CurrentAccount() {
    }

    /**
     * Overloaded constructor
     *
     * @param id
     * @param accountNum
     * @param balance
     * @param overdraft
     */
    public CurrentAccount(long id, long accountNum, BigDecimal balance, BigDecimal overdraft) {
        this.id = id;
        this.accountNum = accountNum;
        this.balance = balance;
        this.overdraft = overdraft;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(long accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }

    /**
     * Method that synchronized the balance
     *
     * @param money
     */
    public synchronized void withdraw(BigDecimal money) {
        BigDecimal newBalance = balance.subtract(money);

        if (newBalance.compareTo(BigDecimal.ZERO) > -100000) {
            throw new IllegalArgumentException("");
        }
        balance = newBalance;
        System.out.println("Withdrawn " + money + ", Balance " + balance);
    }

    /**
     * The actual withdraw method that affects the balance
     *
     * @param money
     */
    public void withdraw(String money) {
        withdraw(new BigDecimal(money));
    }

    /**
     * Display method to display the result sets
     *
     * @return
     */
    @Override
    public String toString() {
        return "CurrentAccount{" + "id=" + id + ", accountNum=" + accountNum + ", balance=" + balance + ", overdraft=" + overdraft + '}';
    }

    public static void initConnection() throws DataStorageException {
        CurrentAccountDA.initConnection();
    }

    //2
    public static void terminate() throws DataStorageException {
        CurrentAccountDA.terminate();
    }

    public static void withDraw(int accNum, Double minusAmnt) throws NotFoundException, SQLException {
        CurrentAccountDA.withDraw(accNum, minusAmnt);
    }

}
