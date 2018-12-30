import { Component, OnInit } from '@angular/core';

import { Employees } from '../employees';
import { EmployeesService } from '../employees.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'create-employee',
  templateUrl: './create-employees.container.html',
})
export class CreateEmployeesContainer implements OnInit {
  submitted = false;
  form = new FormGroup({
    empName: new FormControl('', Validators.required),
    empActive: new FormControl(true),
    empDepartment: new FormControl('', Validators.required)
  });

  constructor(
    private employeeService: EmployeesService,
    private router: Router
    ) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.form.reset()
  }

  save() {
    this.employeeService.createEmployee(this.form.value)
      .subscribe(data => {
        this.submitted = true;
      });
  }

  cancel() {
    this.router.navigate(['employees'])
  }
}
