package com.cjc.bankmanagementsystem.services;

public interface Rbi {
	
	public void createAccount();
	public void displayDetails(int accNo);
	public void depositMoney(int accNo, double amount);
	public void withdrawMoney(int accNo, double amount);
	public double balanceCheck(int accNo);
	
}
