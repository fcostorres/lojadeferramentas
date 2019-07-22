package model.bean;

import java.util.Objects;


public class Customer {
    public String tabela = "customer";
    private String custumerId;
    private String custumerName;
    private String phoneNumber;
    private String address;

    public Customer(String custumerId) {
        this.custumerId = custumerId;
    }

    public Customer(String custumerId, String custumerName, String phoneNumber, String address) {
        this.custumerId = custumerId;
        this.custumerName = custumerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    

    public String getCustumerId() {
        return custumerId;
    }

    public void setCustumerId(String custumerId) {
        this.custumerId = custumerId;
    }

    public String getCustumerName() {
        return custumerName;
    }

    public void setCustumerName(String custumerName) {
        this.custumerName = custumerName;
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
        hash = 97 * hash + Objects.hashCode(this.custumerId);
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
        if (!Objects.equals(this.custumerId, other.custumerId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dados do cliente{" + "codigo=" + custumerId + ",Nome=" + custumerName + '}';
    }
    
    
}
