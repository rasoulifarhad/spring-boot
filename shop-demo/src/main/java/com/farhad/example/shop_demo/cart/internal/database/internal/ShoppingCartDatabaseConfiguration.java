package com.farhad.example.shop_demo.cart.internal.database.internal;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories
public class ShoppingCartDatabaseConfiguration extends AbstractJdbcConfiguration {
    
}
