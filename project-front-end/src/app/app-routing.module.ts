import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeesListContainer } from './employees-list/employees-list.container';
import { CreateEmployeesContainer } from './create-employees/create-employees.container';
import { SearchEmployeesContainer } from './search-employees/search-employees.container';
import { EmployeesDetailsContainer } from './employees-details/employees-details.container';

const routes: Routes = [
  { path: '', redirectTo: 'employees', pathMatch: 'full' },
  { path: 'employees', component: EmployeesListContainer },
  { path: 'employee-details/:empID', component: EmployeesDetailsContainer },
  { path: 'add', component: CreateEmployeesContainer },
  { path: 'findbyname', component: SearchEmployeesContainer },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
