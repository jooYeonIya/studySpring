package org.example.spring_data_jpa.employee.service;

import lombok.RequiredArgsConstructor;
import org.example.spring_data_jpa.employee.domain.Employee;
import org.example.spring_data_jpa.employee.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmpService {
    private final EmpRepository empRepository;

    @Transactional(readOnly = true)
    public Optional<Employee> getOneEmp(String empId) {
        return empRepository.findById(empId);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmp() {
        return empRepository.findAll();
    }

    public Employee saveEmp(Employee emp) {
        Employee saveEmp = empRepository.save(emp);
        return saveEmp;
    }

    public Employee updateEmp(Employee emp) {
        Employee updateEmp = empRepository.findById(emp.getEmpId()).get();
        updateEmp.setSalary(emp.getSalary());
        Employee saveEmp = empRepository.save(updateEmp);
        return saveEmp;
    }

    public void deleteEmp(String empId) {
        empRepository.deleteById(empId);
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmpByLastName(String empName) {
        return empRepository.findByEmpNameLike("%" + empName + "%");
    }
}
