package com.example.HWLibraries.HWLibraries.controller;

import com.example.HWLibraries.HWLibraries.exception.InvalidInputException;
import com.example.HWLibraries.HWLibraries.model.Employee;
import com.example.HWLibraries.HWLibraries.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class HwLibrariesController {
    private final EmployeeService employeeServiceimpl;

    public HwLibrariesController(EmployeeService employeeServiceImpl) {
        this.employeeServiceimpl = employeeServiceImpl;
    }

    @GetMapping
    public Collection<Employee> employeeList() {
        return employeeServiceimpl.employeeList();
    }

    @GetMapping(path = "add")
    public Employee addEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                @RequestParam(value = "lastName", required = false) String lastName,
                                @RequestParam(value = "department", required = false) int department,
                                @RequestParam(value = "salary", required = false) int salary) throws Exception {

        Employee employee = new Employee(firstName, lastName, department, salary);
        try {
            employeeServiceimpl.addEmployee(employee);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request", e);
        }

        return employee;
    }


    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                   @RequestParam(value = "lastName", required = false) String lastName,
                                   @RequestParam(value = "department", required = false) int department,
                                   @RequestParam(value = "salary", required = false) int salary) throws Exception {
        Employee employee = new Employee(firstName, lastName, department, salary);
        try {
            employeeServiceimpl.removeEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName", required = false) String lastName,
                                 @RequestParam(value = "department", required = false) int department,
                                 @RequestParam(value = "salary", required = false) int salary) throws Exception {
        Employee employee = new Employee(firstName, lastName, department, salary);
        try {
            employeeServiceimpl.findEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

}
