package com.farhad.example.shop_demo.cart.internal.database.internal;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.farhad.example.shop_demo.cart.api.Article;
import com.farhad.example.shop_demo.cart.api.ArticleId;
import com.farhad.example.shop_demo.cart.api.ShoppingCart;
import com.farhad.example.shop_demo.cart.api.ShoppingCartId;
import com.farhad.example.shop_demo.cart.api.ShoppingCartItem;
import com.farhad.example.shop_demo.cart.api.UserId;
import com.farhad.example.shop_demo.cart.internal.database.api.ShoppingCartDatabase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SpringJdbcShoppingCartDatabase implements ShoppingCartDatabase {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ArticleRepository articleRepository;

    @Override
    public Optional<ShoppingCart> loadShoppingCartByUserId(UserId userId) {
        return shoppingCartRepository.findByUserId(userId.getId())
                .map(this::toDomainObject);
    }

    @Override
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        ShoppingCartDatabaseEntity shoppingCartToSave = fromDomainObject(shoppingCart);
        return toDomainObject(shoppingCartRepository.save(shoppingCartToSave));
    }

    private ShoppingCartDatabaseEntity fromDomainObject(ShoppingCart shoppingCart) {
        Set<ArticleRef> articleRefs = shoppingCart.getItems().stream()
                .map(i -> new ArticleRef(i.getArticleId().getId()))
                .collect(Collectors.toSet());

        return new ShoppingCartDatabaseEntity(shoppingCart.getId().getValue(), shoppingCart.getUserId().getId(), articleRefs);
    }

    private ShoppingCart toDomainObject(ShoppingCartDatabaseEntity shoppingCartDatabaseEntity) {
        Set<Long> articleIds = shoppingCartDatabaseEntity.getArticles().stream()
                .map(ArticleRef::getArticleId)
                .collect(Collectors.toSet());

        List<ShoppingCartItem> shoppingCartItems = StreamSupport.stream(articleRepository.findAllById(articleIds).spliterator(), false)
                .map(articleDatabaseEntity -> new ShoppingCartItem(
                        new ArticleId(articleDatabaseEntity.getId()),
                        1,
                        articleDatabaseEntity.getPriceInCents()))
                .collect(toList());

        return ShoppingCart.reconstitute(
                new ShoppingCartId(shoppingCartDatabaseEntity.getId()),
                new UserId(shoppingCartDatabaseEntity.getUserId()),
                shoppingCartItems);
    }


    @Override
    public void updateShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(fromDomainObject(shoppingCart));
    }

    @Override
    public Article addArticle(Article article) {
        ArticleDatabaseEntity savedArticle = articleRepository.save(fromDomainObject(article));
        return toDomainObject(savedArticle);
    }

    @Override
    public Optional<Article> loadArticle(ArticleId articleId) {
        return articleRepository.findById(articleId.getId())
                .map(this::toDomainObject);
    }

    private Article toDomainObject(ArticleDatabaseEntity savedArticle) {
        return Article.reconstitute(new ArticleId(savedArticle.getId()), savedArticle.getName(), savedArticle.getPriceInCents());
    }

    private ArticleDatabaseEntity fromDomainObject(Article article) {
        return new ArticleDatabaseEntity(article.getId().getId(), article.getName(), article.getPricrInCents());
    }
}
