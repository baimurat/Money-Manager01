package sample;

import java.util.ArrayList;

public class Person {
    private final String fistName;
    private final String lastName;
    private String currencyType;
    private int balance;
    private int income;
    private int expense;
    public String historyOfExpense;

    public Person(String firstName, String lastName, String currencyType, int balance, int income, int expense, String historyOfExpense){
        this.fistName = firstName;
        this.lastName = lastName;
        this.currencyType = currencyType;
        this.balance = balance;
        this.income = income;
        this.expense = expense;
        this.historyOfExpense = historyOfExpense;
    }

    public Person(String fistName, String lastName, String currencyType, int balance){
        this(fistName, lastName, currencyType, balance, 0, 0, null);
    }

    public Person(String fistName, String lastName, String currencyType, int balance, int income){
        this(fistName, lastName, currencyType, balance, income, 0, null);
    }


    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public int getBalance() {
        return balance;
    }

    public int getIncome() {
        return income;
    }

    public int getExpense() {
        return expense;
    }

    public String getHistoryOfExpense() {
        return historyOfExpense;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public void setHistoryOfExpense(String historyOfExpense) {
        this.historyOfExpense = historyOfExpense;
    }
}
