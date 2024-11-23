package com.cjc.bankmanagementsystem.test;

import com.cjc.bankmanagementsystem.serviceImplementation.Sbi;
import com.cjc.bankmanagementsystem.services.Rbi;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Rbi r1 = new Sbi(); // Reference to the interface

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Display Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        r1.createAccount();
                        break;
                    case 2:
                        System.out.print("Enter account number to display details: ");
                        int displayAccNo = sc.nextInt();
                        r1.displayDetails(displayAccNo);
                        break;
                    case 3:
                        System.out.print("Enter account number to deposit money: ");
                        int depositAccNo = sc.nextInt();
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        r1.depositMoney(depositAccNo, depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter account number to withdraw money: ");
                        int withdrawAccNo = sc.nextInt();
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        r1.withdrawMoney(withdrawAccNo, withdrawAmount);
                        break;
                    case 5:
                        System.out.print("Enter account number to check balance: ");
                        int balanceAccNo = sc.nextInt();
                        double balance = r1.balanceCheck(balanceAccNo);
                        System.out.println("Current Balance: " + balance);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                sc.next(); // Clear the invalid input
            }
        }
	}
}
