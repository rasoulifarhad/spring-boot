## online bookstore

See https://www.w3computing.com/articles/implementing-domain-driven-design-java/

### Business Requirements

1. Users can search for books.
2. Users can place books into a shopping cart.
3. Users can place an order with the books in their shopping cart.

### Entities, Value Objects, and Aggregates

- **User**: An entity, as each user has a unique identity.
- **Book**: An entity with a unique identifier like ISBN.
- **ShoppingCart**: An entity that belongs to a user.
- **Order**: An entity that contains the books a user wishes to purchase.
- **BookTitle**, **BookDescription**, **UserName**: Value objects
  
The **Order** aggregate might include the **Order** entity as the Aggregate Root, and **OrderLine** entities, which connect each **Book** entity to the **Order**.