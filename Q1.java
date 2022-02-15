package com.daryl;

import java.util.Scanner;
import java.util.Date;

class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate=new Date();
    private double monthlyPayment=0;
    private double totalPayment=0;


    public Loan() {
        annualInterestRate=2.5;
        numberOfYears=1;
        loanAmount=1000;
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        this.annualInterestRate=annualInterestRate;
        this.numberOfYears=numberOfYears;
        this.loanAmount=loanAmount;
    }

    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }

    public double getNumberOfYears(){
        return this.numberOfYears;
    }

    public double getLoanAmount(){
        return this.loanAmount;
    }

    public Date getLoanDate(){
        return this.loanDate;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate=annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears=numberOfYears;
    }

    public void setLoanAmount(double loanAmount){
        this.loanAmount=loanAmount;
    }

    public double getMonthlyPayment(){
        monthlyPayment= (this.loanAmount*(this.annualInterestRate/12/100))/(1-(1/Math.pow(1+(this.annualInterestRate/12/100),this.numberOfYears*12)));
        return monthlyPayment;
    }

    public double getTotalPayment(){
        totalPayment=this.monthlyPayment*this.numberOfYears*12;
        return totalPayment;
    }

}



public class Main {

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        double annualInterest;
        int years;
        double loanAmount;
        System.out.println("Enter the annual interest rate:");
        annualInterest= input.nextDouble();
        System.out.println("Enter the number of years as an integer:");
        years= input.nextInt();
        System.out.println("Enter the loan amount:");
        loanAmount=input.nextDouble();
        Loan sampleLoan = new Loan(annualInterest,years,loanAmount);
        System.out.println("The loan was created on " + sampleLoan.getLoanDate());
        System.out.println("The monthly payment is " + String.format("%.2f", sampleLoan.getMonthlyPayment()));
        System.out.println("The total payment is " + String.format("%.2f", sampleLoan.getTotalPayment()));


    }
}
