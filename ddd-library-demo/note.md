From https://github.com/ddd-by-examples/library

also 

See https://github.com/romankh3/spring-boot-mapstruct-example
See https://reflectoring.io/java-mapping-with-mapstruct/
See https://github.com/gushakov/cargo-clean/tree/main
See https://www.arhohuttunen.com/hexagonal-architecture/
See https://www.educative.io/blog/hexagonal-architecture-tutorial
See https://dev.to/dyarleniber/hexagonal-architecture-and-clean-architecture-with-examples-48oi
See https://reflectoring.io/spring-hexagonal/
See https://github.com/thombergs/buckpal/tree/master
See https://github.com/wooxudong/ddd-example/tree/master

### What is a hold?

A hold is an online request to have a book, movie, or other material delivered to your nearest library branch.

### Why would I want to place a hold?

You may want to place a hold if the item you want is:

- currently on loan to another customer
- at a location that is not convenient for you to get to
- currently on order but not yet received by the library

### catalog

Online database with detailed descriptions and location information for materials in a library collection. 

### open-ende

An open-ended activity or situation does not have a planned ending, so it may develop in several ways:
We are not willing to enter into open-ended discussions.

### patron
 
Term often used for a library user.

### check out
    
Borrow materials from a library for a fixed period of time. Loan periods, borrowing limits, and renewal policies vary depending upon the status of the borrower (faculty, graduate student, undergraduate, etc.) and / or the type of item.
   
### circulate
    
To loan library materials to users.  (can be checked out).  

### circulation desk (Front Desk)

The service desk near the main entrance where you can check out, return, or renew library materials and get other types of assistance; currently referred to as the Front Desk.

### loan period

Amount of time library materials may be borrowed (checked out); varies depending on type of material borrowed and the borrower's status (student, faculty, staff).

### volume

Single book or bound periodical, often part of a set of books or series of periodicals.    


### Check Out 

To borrow library materials for use outside the library. This is done at the Circulation Desk. 
    
### Citation

Information which precisely identifies a book or an article: includes author, title, volume, page numbers and publication information.   


### Due Date 

The date or time by which checked-out items must be returned to the library. The due date is stamped at the back of the item.  


### Grace Period

The time from the due date of an item until extended use charges are levied. This varies with different types of materials.

### Hold 

Items that have been checked out by one borrower and requested by another patron. A hold is then placed on this item and upon its return, it is reserved for the person requesting it.

### Holdings 

All the materials in various formats owned by a library.

### ISBN 

International Standard Book Number; A unique ten digit number identifying a specific edition of a book.

### Non-Circulating Item 

An item that cannot be checked out of the Library. (e.g. Reference Collection, Periodicals)

### Overdue 

Library material is considered overdue when it is not returned on or before the due date indicated on the inside back cover.

### Renew

To extend the due date for a book in order to keep the item longer.

### Catalog 

A database (either online or on paper cards) listing and describing the books, journals, government documents, audiovisual and other materials held by a library. Various search terms allow you to look for items in the catalog.

### Descriptor 

A word that describes the subject of an article or book; used in many computer databases.



یک کتابخانه عمومی به مراجعه کنندگان اجازه می دهد تا کتاب ها را در شعبه های مختلف کتابخانه خود نگه دارند. کتاب‌های موجود را می‌توان تنها توسط یک مراجعه کننده در هر مقطع زمانی معین در انتظار نگه داشت. کتاب ها یا در گردش هستند یا محدود هستند و می توانند هزینه بازیابی یا استفاده داشته باشند. یک کتاب محدود را فقط یک محقق می تواند نگه دارد. یک مشتری معمولی محدود به نگه داشتن پنج کتاب در هر لحظه است، در حالی که یک مشتری محقق مجاز به تعداد نامحدودی است.

A public library allows patrons to place books on hold at its various library branches. Available books can be placed on hold only by one patron at any given point in time. Books are either circulating or restricted, and can have retrieval or usage fees. A restricted book can only be held by a researcher patron. A regular patron is limited to five holds at any given moment, while a researcher patron is allowed an unlimited number of holds.  An open-ended book hold is active until the patron checks out the book, at which time it is completed. A closed-ended book hold that is not completed within a fixed number of days after it was requested will expire.   This check is done at the beginning of a day by taking a look at daily sheet with expiring holds. Only a researcher patron can request an open-ended hold duration. Any patron with more than two overdue checkouts at a library branch will get a rejection if trying a hold at that same library branch. A book can be checked out for up to 60 days. Check for overdue checkouts is done by taking a look at daily sheet with overdue checkouts. Patron interacts with his/her current holds, checkouts, etc. by taking a look at patron profile. Patron profile looks like a daily sheet, but the information there is limited to one patron and is not necessarily daily. Currently a patron can see current holds (not canceled nor expired) and current checkouts (including overdue). Also, he/she is able to hold a book and cancel a hold.
 
 How actually a patron knows which books are there to lend? Library has its catalogue of books where books are added together with their specific instances. A specific book instance of a book can be added only if there is book with matching ISBN already in the catalogue. Book must have non-empty title and price. At the time of adding an instance we decide whether it will be Circulating or Restricted. This enables us to have book with same ISBN as circulated and restricted at the same time (for instance, there is a book signed by the author that we want to keep as Restricted)
 
 
 
close-ended book holding process:

- A **Regular Patron** can **place a book on a close-ended hold**
- A **Regular Patron** might **reach a maximum holds number** after a **hold is placed**
- A **Regular Patron** can either **cancel the hold** or **check out the book**
- While the book is **checked out** the **hold is completed** and so the **returning process** starts
- Whenever a new day starts, we check the **daily sheet** if a hold is not hanging for too long. If so, the **book hold is expired**

![](definitions-1.png)


open-ended book holding process:


- A **Researcher Patron** can **place a book on an open-ended hold**
- A **Researcher Patron** can **either cancel the hold** or **checkout a book**
- While the book is **checkedout** the **hold is completed** and so the **returning process** starts
- Within the **open-ended holding** a **hold** cannot **expire** (mind the lack of **hold expired** event)


All right. These two processes are very similar. The part that they have in common, and we know nothing about it yet is called the **book returning process**:


Here's what you see there described with words:

- **Any Patron** can **return a book**
- If the **checkout is overdue**, it is being unregistered as soon as the **book is returned**
- In the moment of **returning a book** we start the process of **Fees application**
- From the moment of **book checkout**, a patron might not return the book on time. Whenever a **new day starts** we check the **daily sheet** find and **register overdue checkouts**

what is this **checkout**?

![](definitions-2.png)


undamental question that raises now is where do these books come from?  **catalogue**


- A **library employee** can add a book into a catalogue
- A specific **book instance** can be **added** as well, thanks to which it can be made **available** under some not defined yet policy
- Both **Book removed from catalogue** and **Book instance removed from catalogue** are marked with **hot spots**, as they became problematic. We left answering those problems for the future.


![](book-catalogue-definitions.png)

we can assume that we have at least two **bounded contexts**:

- **lending** - context containing all business processes logically connected with book lending, including holding, checkout, and return
- **catalogue** - contexts for cataloguing books and their instances


