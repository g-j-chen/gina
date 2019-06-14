/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class LyyraCard {
    private double balance;
    //private final double ECONOMICAL = 2.5;  these variables cannot be changed, named uppercase
    //private final double GOURMET = 4.0;
    
    public LyyraCard(double balanceAtStart) {
        this.balance = balanceAtStart;
    }
    
    
    public String toString() {
        return "The card has " + this.balance + " euros";
    }
    
    public void payEconomical() {
        double newBalanceEco = this.balance - 2.5;
        if (newBalanceEco >= 0) {
            this.balance = newBalanceEco;
        }
        /* 
        if (this.balance >= ECONOMICAL) {     use the same for GOURMET!!
            this.balance -= ECONOMICAL;
        }
        */
    }
    
    public void payGourmet() {
        double newBalanceGour = this.balance - 4.0;
        if (newBalanceGour >= 0) {
            this.balance = newBalanceGour;
        }
    }
    
    public void loadMoney(double amount) {
        if (amount > 0) {
            double tempBalance = this.balance + amount;
            if (tempBalance > 150) {
                this.balance = 150;
            } else {
                this.balance = tempBalance;
            }
        }
        /*
        if (amount < 0) {
            return;
        }
        
        this.balance += amount;
        if (this.balance > 150) {
            this.balance = 150;
        }
        */
    }
}
