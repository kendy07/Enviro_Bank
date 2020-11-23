/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envirobank;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Bubbles Tech
 */
public class EnviroBank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NotFoundException, SQLException {
        
        try {
            SavingsAccount.initConnection();
            JOptionPane.showMessageDialog(null, "You are now connected");
        } catch (DataStorageException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        try {
            int accNumber;
        double money;

        Scanner scan = new Scanner(System.in);

        //get the inputs
        System.out.println("Enter the Account Number");
        accNumber = scan.nextInt();

        System.out.println("Enter the amount that you want to with draw");
        money = scan.nextDouble();

        SavingsAccount save = new SavingsAccount(accNumber, accNumber, BigDecimal.ONE);

        save.withDraw(accNumber, money);
        System.out.println(save.toString());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

    }

}
