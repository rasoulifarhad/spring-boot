package com.farhad.example.springdatajpa.anotheronetomany.boot;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.springdatajpa.anotheronetomany.model.Employee;
import com.farhad.example.springdatajpa.anotheronetomany.model.Leave;
import com.farhad.example.springdatajpa.anotheronetomany.repository.EmployeeRepository;
import com.farhad.example.springdatajpa.anotheronetomany.service.LeaveService;

@Configuration
public class BootRunner {

    @Bean
    public CommandLineRunner runner(EmployeeRepository employeeRepository, LeaveService leaveService) {
        return args -> {

            Employee employee = Employee.builder()
                                    .employeeId("1234")
                                    .firstName("far")
                                    .lastName("ras")
                                    .build();
            Leave leave01 = Leave.builder()
                                .dayOfWeek("4")
                                .dateTaken(LocalDate.of(2023, 1, 12))
                                .build();
            Leave leave02 = Leave.builder()
                                .dayOfWeek("5")
                                .dateTaken(LocalDate.of(2023, 1, 12))
                                .build();
            // employee.getLeaves().add(leave01);
            // employee.getLeaves().add(leave02);
            employee.addLeave(leave01);
            employee.addLeave(leave02);
            Employee createdEmployee = employeeRepository.save(employee);
            System.out.println("saveddddddddddddddddddd");
            leaveService.getEmployeeLeaves(createdEmployee.getId()).forEach(e -> System.out.println(e));;
        };
    }
}
