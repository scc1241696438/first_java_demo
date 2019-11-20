package com.chixing.pojo;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerPwd;

    public Customer(){}
    public Customer(int customerId, String customerName, String customerPwd) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPwd = customerPwd;
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

    public String getCustomerPwd() {
        return customerPwd;
    }

    public void setCustomerPwd(String customerPwd) {
        this.customerPwd = customerPwd;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPwd='" + customerPwd + '\'' +
                '}';
    }
}
