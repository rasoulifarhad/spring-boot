See https://java-design-patterns.com/patterns/domain-model/

##  build an e-commerce web application

- there are few nouns you talk about repeatedly
- Customer, and a Product the customer looks for
- These two are domain-specific classes 
- each of that classes will include some business logic specific to its domain.
  
***The Domain Model is an object model of the domain that incorporates both behavior and data.***

In e-commerce app: 

- we need to deal with the domain logic of **customers who want to buy products** and **return them** if they want.

- We can use the **domain model pattern** and create classes `Customer` and `Product` where every single instance of that class incorporates both behavior and data and represents only one record in the underlying table.


- `Product` domain class with fields `name`, `price`, `expirationDate` which is specific for each product.
- `productDao` for working with DB.
- `save` method for saving product.
- `getSalePrice` method which return price for this product with discount.

- `Customer` domain class with fields `name`, `money` which is specific for each customer
- `customerDao` for working with DB, 
- `save` for saving customer, 
- `buyProduct` which add a product to purchases and withdraw money, 
- `returnProduct` which remove product from purchases and return money, 
- `showPurchases` and `showBalance` methods for printing customer's purchases and money balance.