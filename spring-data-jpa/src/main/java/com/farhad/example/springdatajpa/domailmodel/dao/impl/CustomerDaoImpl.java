package com.farhad.example.springdatajpa.domailmodel.dao.impl;

import java.util.Optional;

import com.farhad.example.springdatajpa.domailmodel.Customer;
import com.farhad.example.springdatajpa.domailmodel.Product;
import com.farhad.example.springdatajpa.domailmodel.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Optional<Customer> findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public void addProduct(Product product, Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }

    @Override
    public void deleteProduct(Product product, Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public Customer save(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Customer update(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
