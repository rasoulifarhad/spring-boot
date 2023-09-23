package com.farhad.example.shop_demo.cart.internal.database.internal;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository  extends CrudRepository<ArticleDatabaseEntity, Long>{
    
}
