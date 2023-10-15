package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;

public class ChangeSalariedTransaction  extends ChangeClassificationTransaction {

    public ChangeSalariedTransaction(int empId) {
        super(empId);
        //TODO Auto-generated constructor stub
    }

    @Override
    PaymentSchedule getSchedule() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSchedule'");
    }

    @Override
    PaymentClassification getPaymentClassification() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentClassification'");
    }
    
}
