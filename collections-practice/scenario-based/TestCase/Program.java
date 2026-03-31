package com.example;

public class Program{
    int balance;

    public Program(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int amount){
        if(amount < 0){
            throw new RuntimeException("Deposit amount cannot be negative");
        }
        balance+=amount;
    }
    public void withdraw(int amount){
         if(amount < 0){
            throw new RuntimeException("withdraw amount cannot be negative");
        }
        else if(amount > balance){
            throw new RuntimeException("Insufficient funds.");
        }
    }

    public static void main(String[] args) {
        Program program = new Program(0);
    }
}