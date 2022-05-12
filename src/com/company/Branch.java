package com.company;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers ;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if (findCustomer(customerName) == null){
            Customer customer= new Customer(customerName, initialAmount);
            this.customers.add(customer);
            return true;
        }
            //System.out.println(customerName + " was already existed.");
            return false;
    }

    public boolean addCustomerTransaction(String customerName, double newTransaction){
        if (findCustomer(customerName) != null) {
            findCustomer(customerName).addTransaction(newTransaction);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String name){
        for (int i=0 ; i< this.customers.size(); i++){
            if (this.customers.get(i).getName().equals(name)){
                return this.customers.get(i);
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }
}
