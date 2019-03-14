/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javafx.scene.control.TextField;

/**
 *
 * @author mahmoudezzat
 */
class Balance {
    private double balance = 0;
    private String ID = "1";
    private double[] history = new double[5];
    private int finalIdx = 0;
    
    //for (int i = 0; i < 4; i++) history[i] = 0;
    
    //setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //setter for ID
    public void setID(String ID) {
        this.ID = ID;
    }

    //getter for balance
    public double getBalance() {
        return balance;
    }

    //getter for ID
    public String getID() {
        return this.ID;
    }
    
    //Deposite
    public void deposite(double amount) {
        balance += amount;
    }
    
    //withDraw
    public void withDraw(double amount) {
        balance -= amount;
    }
    
    //set history
    public void setHistory(double amount) {
        if (finalIdx == 5) {
            for (int i = 0; i < 4; i++) {
                history[i] = history[i+1];
            }
            this.history[--finalIdx] = amount;
        } 
        if (finalIdx < 5) {
            this.history[finalIdx++] = amount;
        } 
        
        System.out.println("idx logic: "+finalIdx);
    }
    
    //get history
    public double getHistory(int show) {
        return this.history[show];
    }
    
    public int getFinalIdx() {
        return finalIdx;
    }
 
}
