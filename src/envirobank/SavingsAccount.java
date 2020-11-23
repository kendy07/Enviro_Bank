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
public class SavingsAccount {
//instances of the class

    private int id;
    private int accountNum;
    private BigDecimal balance;

    /**
     * Default constructor
     */
    public SavingsAccount() {
    }

    /**
     * Overloaded constructor
     *
     * @param id
     * @param accountNum
     * @param balance
     */
    public SavingsAccount(int id, int accountNum, BigDecimal balance) {
        setId(id);
        setAccountNum(accountNum);
        setBalance(balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" + "id=" + id + ", accountNum=" + accountNum + ", balance=" + balance + '}';
    }

    public static void initConnection() throws DataStorageException {
        SavingsAccountDA.initConnection();
    }

    //2
    public static void terminate() throws DataStorageException {
        SavingsAccountDA.terminate();
    }

    public static void withDraw(int accNum, Double minusAmnt) throws NotFoundException, SQLException {
        SavingsAccountDA.withDraw(accNum, minusAmnt);
    }

}
