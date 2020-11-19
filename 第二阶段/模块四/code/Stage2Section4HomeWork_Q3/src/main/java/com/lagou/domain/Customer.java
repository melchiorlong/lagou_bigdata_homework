package com.lagou.domain;

/**
 * @author Administrator
 */
public class Customer {

    private int customerId;
    private String customerName;
    private int accountBankNumber;
    private String phone;
    private String address;
    private int managerId;


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", accountBankNumber=" + accountBankNumber +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", managerId=" + managerId +
                '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAccountBankNumber() {
        return accountBankNumber;
    }

    public void setAccountBankNumber(int accountBankNumber) {
        this.accountBankNumber = accountBankNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
