package com.farhad.example.springdatajpa.domailmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.money.MonetaryAmount;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.farhad.example.springdatajpa.domailmodel.dao.CustomerDao;
import com.farhad.example.springdatajpa.domailmodel.repository.CustomerRepository;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
public class Customer {
    
    @NonNull private final CustomerRepository repository;
    @Builder.Default private List<Product> purchases = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull private String name;
    @NonNull private MonetaryAmount money;
    @NonNull private CustomerDao customerDao;

    public void save() {
        Optional<Customer> customer = repository.findByName(name);
        if (customer.isPresent()) {
            this.id = customer.get().getId();
            repository.save(this);
        } else {
            repository.save(this);
        }
    }
    
    // Add product to purchases, save to db and withdraw money.
    public void buyProduct(Product product) {
        log.info("{} want to buy {}({})", name, product.getName(), product.getSalePrice());

        try {
            withdraw(product.getSalePrice());
        } catch(IllegalArgumentException e) {
            log.error(e.getMessage());
            return;
        }

        try{
            repository.addProduct(product, this.id);
            purchases.add(product);
            log.info("{} bought {}!", name, product.getName());
        } catch(Exception e) {
            receiveMoney(product.getSalePrice());
            log.error("{}", e.getMessage());
        } 
    }

    // Remove product from purchases, delete from db and return money.
    public void returnProduct(Product product) {
        log.info("{} want to return {}({})", name, product.getName(), product.getSalePrice());

        if (purchases.contains(product)) {
            try {
                repository.deleteProduct(product, this.id);
                purchases.remove(product);
                receiveMoney(product.getSalePrice());
                log.info("{} returned {}", name, product.getName());
            } catch (Exception e) {
                log.error(e.getMessage());
            }

        } else {
            log.error("{} did not buy {}", name, product.getName());
        }
    }

    public void showPurchases() {
        Optional<String> purchasesToShow = 
                purchases.stream()
                    .map(p -> p.getName() + " - $" + p.getSalePrice())
                    .reduce((p1, p2) -> p1 + ", " + p2 );
        if (purchasesToShow.isPresent()) {
            log.info("{} bouhgt: {}", name, purchasesToShow.get());
        } else {
            log.info("{} did not boughtanything", name);
        }
    }

    public void showBalance() {
        log.info("{} balance: {}", name, money);
    }   

    private void receiveMoney(MonetaryAmount amount) {
        money = money.add(amount);
    }

    private void withdraw(MonetaryAmount a) throws IllegalArgumentException {
        if (money.compareTo(a) < 0 ) {
            throw new IllegalArgumentException("Not enough money");
        } else {
            money = money.subtract(a);
        }
    }
}
