package com.farhad.example.batchpayroll.domain.model;

import com.farhad.example.batchpayroll.domain.model.employee.Fee;

public interface Pay {

    Pay apply(Fee fee);
    
}
