/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author elephant solutions
 */
public class Loan {
    int Id, userId, months;
    double amount, interest, amountToReturn, monthlyRate;

    public Loan() {
    }

    public Loan(int Id, int userId, double amount, double interest, double amountToReturn, double monthlyRate, int months) {
        this.Id = Id;
        this.userId = userId;
        this.amount = amount;
        this.interest = interest;
        this.amountToReturn = amountToReturn;
        this.monthlyRate = monthlyRate;
        this.months = months;
    }
    
    public Loan(int userId, double amount, double interest, double amountToReturn, double monthlyRate, int months) {
        this.userId = userId;
        this.amount = amount;
        this.interest = interest;
        this.amountToReturn = amountToReturn;
        this.monthlyRate = monthlyRate;
        this.months = months;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getAmountToReturn() {
        return amountToReturn;
    }

    public void setAmountToReturn(double amountToReturn) {
        this.amountToReturn = amountToReturn;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }
    
    
}
