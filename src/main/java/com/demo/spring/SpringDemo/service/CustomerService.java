package com.demo.spring.SpringDemo.service;

import com.demo.spring.SpringDemo.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {
    private List<Customer> customerList = new CopyOnWriteArrayList<>();
    private int customerIdCount = 1;

    public Customer addCustomer(Customer customer) {
        customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;
        return customer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Customer getCustomer(int customerId) {
        return customerList.stream().filter(c ->
                        c.getCustomerId() == customerId)
                .findFirst().get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {
         customerList.stream().forEach(cust -> {
                    if (cust.getCustomerId() == customerId) {
                        cust.setCustomerEmail(customer.getCustomerEmail());
                        cust.setCustomerFirstName(customer.getCustomerFirstName());
                        cust.setCustomerLastName(customer.getCustomerLastName());

                    }
                });
        return customerList.stream().filter(c -> c.getCustomerId() == customerId).findFirst().get();
    }

    public void deleteCustomer(int customerId, Customer customer) {
        customerList.stream().forEach(cust -> {
            if (cust.getCustomerId() == customerId) {
                customerList.remove(cust);
            }
        });
    }

}
