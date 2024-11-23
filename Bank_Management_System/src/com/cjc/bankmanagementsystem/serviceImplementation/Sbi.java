package com.cjc.bankmanagementsystem.serviceImplementation;

import com.cjc.bankmanagementsystem.model.Account;
import com.cjc.bankmanagementsystem.services.Rbi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sbi implements Rbi{
	private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccNo = 1; // Simple counter for account numbers
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void createAccount() {
        Account account = new Account();
        account.setAccNo(nextAccNo++);
        
        System.out.print("Enter name: ");
        account.setName(scanner.next());
        
        System.out.print("Enter mobile number: ");
        account.setMobileNo(scanner.nextLong());
        
        System.out.print("Enter address: ");
        account.setAddress(scanner.next());
        
        System.out.print("Enter gender: ");
        account.setGender(scanner.next());
        
        System.out.print("Enter age: ");
        account.setAge(scanner.nextInt());
        
        account.setBalance(0); // Initial balance
        
        accounts.put(account.getAccNo(), account);
        System.out.println("Account created with number: " + account.getAccNo());
    }

    @Override
    public void displayDetails(int accNo) {
        Account account = accounts.get(accNo);
        if (account != null) {
            System.out.println("Account Number: " + account.getAccNo());
            System.out.println("Name: " + account.getName());
            System.out.println("Mobile No: " + account.getMobileNo());
            System.out.println("Address: " + account.getAddress());
            System.out.println("Gender: " + account.getGender());
            System.out.println("Age: " + account.getAge());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void depositMoney(int accNo, double amount) {
        Account account = accounts.get(accNo);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposited: " + amount + ". New Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void withdrawMoney(int accNo, double amount) {
        Account account = accounts.get(accNo);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                System.out.println("Withdrawn: " + amount + ". New Balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public double balanceCheck(int accNo) {
        Account account = accounts.get(accNo);
        if (account != null) {
            return account.getBalance();
        } else {
            System.out.println("Account not found.");
            return 0;
        }
    }
	
}
