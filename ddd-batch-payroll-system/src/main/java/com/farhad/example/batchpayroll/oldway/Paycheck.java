package com.farhad.example.batchpayroll.oldway;

//  <Paycheck>
//      <EmpId>1429</EmpId>
//      <Name>Robert Martin</Name>
//      <GrossPay>3215.88</GrossPay>
//  </Paycheck>
public interface Paycheck {
    
    Employee employee();
    Amount grossPay();
}
