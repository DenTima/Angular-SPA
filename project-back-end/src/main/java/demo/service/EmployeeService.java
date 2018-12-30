package demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


import demo.dao.EmployeeRepository;

import demo.dto.EmployeeDTO;

import demo.entity.Employee;

@Component
public class EmployeeService {

    private static final int PAGE_SIZE_DEFAULT = 10;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            employeeDTOList.add(convertToDTO(employee));
        }

        return employeeDTOList;
    }


    public void create(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpActive(employeeDTO.getEmpActive());
        employee.setEmpDepartment(employeeDTO.getEmpDepartment());


        employeeRepository.save(employee);
    }


    public void update(int empID, EmployeeDTO employeeUpdate) {

        Employee employeeDB = employeeRepository.findById(empID).get();
        employeeDB.setEmpName(employeeUpdate.getEmpName());
        employeeDB.setEmpActive(employeeUpdate.getEmpActive());
        employeeDB.setEmpDepartment(employeeUpdate.getEmpDepartment());

      /*  DepartmentDTO departmentDTO = employeeUpdate.getEmpDepartment();
        Department departmentDB = departmentRepository.findById(departmentDTO.getDepID()).get();
        employeeDB.setEmpDepartment(departmentDB);*/

        employeeRepository.save(employeeDB);
    }

    public void delete(int empID) {
        employeeRepository.deleteById(empID);
    }

    private EmployeeDTO convertToDTO(Employee employee) {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmpID(employee.getEmpID());
        employeeDTO.setEmpName(employee.getEmpName());
        employeeDTO.setEmpActive(employee.getEmpActive());
        employeeDTO.setEmpDepartment(employee.getEmpDepartment());

        return employeeDTO;
    }

    public EmployeeDTO findById(int id) {
        return convertToDTO(employeeRepository.findById(id).get());
    }

    public List<EmployeeDTO> findByName(String name) {

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeRepository.findByEmpNameStartingWith(name)) {
            employeeDTOList.add(convertToDTO(employee));
        }

        return employeeDTOList;
    }

}
