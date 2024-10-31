package org.example.spring_data_jpa.employee.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.spring_data_jpa.employee.domain.Employee;
import org.example.spring_data_jpa.employee.service.EmpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
@RequiredArgsConstructor
public class EmpController {
    private final EmpService empService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return empService.saveEmp(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return empService.getAllEmp();
    }

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable("empId") String empId) {
        return empService.getOneEmp(empId).get();
    }

    @PutMapping("/{empId}")
    public Employee updateEmployee(
            @PathVariable("empId") String empId,
            @RequestBody Employee employee) {
        return empService.updateEmp(employee);
    }

    @DeleteMapping("/{empId}")
    public void deleteEmployee(@PathVariable("empId") String empId){
        empService.deleteEmp(empId);
    }

    @GetMapping("/name/{empName}")
    public List<Employee> getEmployeeByName(@PathVariable("empName") String empName) {
        return empService.getEmpByLastName(empName);
    }
}