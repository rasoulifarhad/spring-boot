### ubiquitous language
- doctor
	- **add open time**: 
		- Start and end time for **each day** --> 
		- broken down into **30 minutes periods** (breakdown)
		- ignore less than 30 minutes 
		- error if end < start>
	- view open and taken appointment slot 
		- empty list
		- phonenumber and name of patients
	- delete open appointment
		- 404 if no open appointment
		- 406 apointment taken by patient
		- cuncurrency check
- appointment
- Patients
	- attriibutes
		- phonenumber
		- name
	- view open appointment  slot for given day
		- empty list if no open appointment on that day
	- take one of open appointment
		- by giving name & phonenumber
		- validation
			- error if either phone or name not given (appropraite error message)
			- error if appointment taken befor or deletet
			- cuncorrency check
	- view their own taken appointeement
		- search by only phonenumber
		- empty lis if no taken appointment
		- all showmn
  
- available time slots
- take on time slots




