package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches ;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            Branch newBranch = new Branch(branchName);
            branches.add(newBranch);
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        if (findBranch(branchName) != null) {
            return findBranch(branchName).newCustomer(customerName,initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double newTransaction) {
        if (findBranch(branchName) != null) {
            return findBranch(branchName).addCustomerTransaction(customerName, newTransaction);
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransactions){
        Branch checkBranch = findBranch(branchName);
        if (checkBranch != null) {
            System.out.println("Customer details for branch " + findBranch(branchName).getName() );
           // System.out.println(checkBranch.getCustomers().size());
            for (int i = 0; i < checkBranch.getCustomers().size(); i++) {
                System.out.print("Customer: ");
                System.out.println(checkBranch.getCustomers().get(i).getName() + "[" + (i+1) + "]");
                if (printTransactions) {
                    System.out.println("Transactions");
                    for (int j = 0; j < checkBranch.getCustomers().get(i).getTransactions().size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount  " + checkBranch.getCustomers().get(i).getTransactions().get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }

    private Branch findBranch(String branchName){
        for (int i=0 ; i< this.branches.size(); i++){
            if(this.branches.get(i).getName().equals(branchName)){
                return this.branches.get(i);
            }
        }
        return null;
    }
}
