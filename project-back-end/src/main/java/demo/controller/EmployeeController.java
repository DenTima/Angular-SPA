package demo.controller;

import demo.dto.EmployeeDTO;

import demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO>  getEmployees() {
        List<EmployeeDTO> employeeList;
        employeeList = employeeService.getAllEmployees();
        return employeeList;
    }

    @GetMapping("/employees/{empID}")
    public EmployeeDTO getEmployeesByID(@PathVariable("empID") int empID) {
        return employeeService.findById(empID);
    }

    @PostMapping(value = "/employees/create")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.create(employeeDTO);
        return employeeDTO;
    }

    @PutMapping("/employees/{empID}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO updateEmployee(@PathVariable("empID") int empID, @RequestBody EmployeeDTO employeeUpdate) {
        employeeService.update(empID ,employeeUpdate);
        return employeeUpdate;
    }

    @DeleteMapping("/employees/{empID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int empID) {
        employeeService.delete(empID);
    }

    @GetMapping(value = "employees/name/{empName}")
    public List<EmployeeDTO> getEmployeesByName(@PathVariable String empName) {
        List<EmployeeDTO> employees = employeeService.findByName(empName);
        return employees;
    }

}