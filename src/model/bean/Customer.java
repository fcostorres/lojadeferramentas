package model.bean;

import java.util.Objects;


public class Customer {
    public static String tabela = "customer";
    public static String nomeIdTabela = "customerId";
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String address;

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public Customer(String customerId, String customerName, String phoneNumber, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String custumerId) {
        this.customerId = custumerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String custumerName) {
        this.customerName = custumerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.customerId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.customerId, other.customerId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dados do cliente{" + "codigo=" + customerId + ",Nome=" + customerName + '}';
    }
    
    
}
