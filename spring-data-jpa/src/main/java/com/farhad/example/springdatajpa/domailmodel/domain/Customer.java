package com.farhad.example.springdatajpa.domailmodel.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.TypeDef;

import com.farhad.example.springdatajpa.domailmodel.repository.CustomerRepository;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@Entity
@Table(name = "customers")
@TypeDef(
    typeClass = MonetaryAmount.class,
    defaultForType = MonetaryAmount.class
)
public class Customer {
    
    @NonNull 
    private final CustomerRepository repository;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull 
    private String name;
    @NonNull 
    @Columns(columns = {
        @Column(name = "money_amount"),
        @Column(name = "money_currency")
    })
    private MonetaryAmount money;

    // @Builder.Default 
    @ManyToMany
    @JoinTable(
        name = "purchased_products",
        joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")   
    )
    private List<Product> purchasedProducts = new ArrayList<>();

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
            purchasedProducts.add(product);
            log.info("{} bought {}!", name, product.getName());
        } catch(Exception e) {
            receiveMoney(product.getSalePrice());
            log.error("{}", e.getMessage());
        } 
    }

    // Remove product from purchases, delete from db and return money.
    public void returnProduct(Product product) {
        log.info("{} want to return {}({})", name, product.getName(), product.getSalePrice());

        if (purchasedProducts.contains(product)) {
            try {
                purchasedProducts.remove(product);
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
                purchasedProducts.stream()
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
