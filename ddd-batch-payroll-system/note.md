## batch payroll system

This system consists of a database of the employees in the company and their associated data, such as time
cards. The system must pay each employee. Employees must be paid the correct amount, on time, by the method
that they specify. Also, various deductions must be taken from their pay.

- Some employees work by the hour. They are paid an hourly rate that is one of the fields in their employee
record. They submit daily time cards that record the date and the number of hours worked. If they work more
than 8 hours per day, they are paid 1.5 times their normal rate for those extra hours. They are paid every
Friday.

- Some employees are paid a flat salary. They are paid on the last working day of the month. Their monthly
salary is one of the fields in their employee record.

- Some of the salaried employees are also paid a commission based on their sales. They submit sales receipts
that record the date and the amount of the sale. Their commission rate is a field in their employee record.
They are paid every other Friday.

- Employees can select their method of payment. They may have their paychecks mailed to the postal address
of their choice; they may have their paychecks held for pickup by the Paymaster; or they can request that
their paychecks be directly deposited into the bank account of their choice.

- Some employees belong to the union. Their employee record has a field for the weekly dues rate. Their dues
must be deducted from their pay. Also, the union may assess service charges against individual union mem-
bers from time to time. These service charges are submitted by the union on a weekly basis and must be
deducted from the appropriate employee’s next pay amount.

- The payroll application will run once each working day and pay the appropriate employees on that day. The
system will be told to what date the employees are to be paid, so it will calculate payments from the last time
the employee was paid up to the specified date.


### Use Case 1: Add New Employee

A new employee is added by the receipt of an AddEmp transaction. This transaction contains the employee’s
name, address, and assigned employee number. The transaction has the following three forms:

```
AddEmp <EmpID> “<name>” “<address>” H <hourly-rate>
AddEmp <EmpID> “<name>” “<address>” S <monthly-salary>
AddEmp <EmpID> “<name>” “<address>” C <monthly-salary> <commission-rate>
```

The employee record is created with its fields assigned appropriately.

**Alternative:**

> An error in the transaction structure  


If the transaction structure is inappropriate, it is printed out in an error message, and no action is taken.


### Use Case 2: Deleting an Employee

Employees are deleted when a DelEmp transaction is received. The form of this transaction is as follows:

```
DelEmp <EmpID>
```

When this transaction is received, the appropriate employee record is deleted.

**Alternative:**

> Invalid or unknown EmpID  


If the <EmpID> field is not structured correctly, or if it does not refer to a valid employee record, then the
transaction is printed with an error message, and no other action is taken.

### Use Case 3: Post a Time Card

Upon receipt of a TimeCard transaction, the system will create a time-card record and associate it with the
appropriate employee record.

```
TimeCard <Empld> <date> <hours>
```

**Alternative 1:**

> The selected employee is not hourly  


The system will print an appropriate error message and take no further action.

**Alternative 2:**

> An error in the transaction structure  


The system will print an appropriate error message and take no further action.

### Use Case 4: Posting a Sales Receipt

Upon receipt of the SalesReceipt transaction, the system will create a new sales-receipt record and asso-
ciate it with the appropriate commissioned employee.

```
SalesReceipt <EmpID> <date> <amount>
```

**Alternative 1:**

> The selected employee is not commissioned  


The system will print an appropriate error message and take no further action.

**Alternative 2:**

> An error in the transaction structure  
	

The system will print an appropriate error message and take no further action.

### Use Case 5: Posting a Union Service Charge

Upon receipt of this transaction, the system will create a service-charge record and associate it with the
appropriate union member.

```
ServiceCharge <memberID> <amount>
```

**Alternative:**

> Poorly formed transaction  


If the transaction is not well formed or if the <memberID> does not refer to an existing union member, then
the transaction is printed with an appropriate error message.

### Use Case 6: Changing Employee Details

Upon receipt of this transaction, the system will alter one of the details of the appropriate employee record.
There are several possible variations to this transaction.

```
ChgEmp <EmpID> Name <name>                     Change Employee Name
ChgEmp <EmpID> Address <address>               Change Employee Address
ChgEmp <EmpID> Hourly <hourlyRate>             Change to Hourly
ChgEmp <EmpID> Salaried <salary>               Change to Salaried
ChgEmp <EmpID> Commissioned <salary> <rate>    Change to Commissioned
ChgEmp <EmpID> Hold                            Hold Paycheck
ChgEmp <EmpID> Direct <bank> <account>         Direct Deposit
ChgEmp <EmpID> Mail <address>                  Mail Paycheck
ChgEmp <EmpID> Member <memberID> Dues <rate>   Put Employee in Union
ChgEmp <EmpID> NoMember                        Remove Employee from Union           
```

**Alternative:**

> Transaction Errors  


If the structure of the transaction is improper or <EmpID> does not refer to a real employee or <memberID>
already refers to a member, then print a suitable error and take no further action.


### Use Case 7: Run the Payroll for Today

Upon receipt of the Payday transaction, the system finds all those employees that should be paid upon the
specified date. The system then determines how much they are owed and pays them according to their
selected payment method.

```
Payday <date>
```
