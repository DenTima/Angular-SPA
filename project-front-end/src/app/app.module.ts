import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CreateEmployeesContainer } from './create-employees/create-employees.container';
import { EmployeesDetailsContainer } from './employees-details/employees-details.container';
import { EmployeesListContainer } from './employees-list/employees-list.container';
import { SearchEmployeesContainer } from './search-employees/search-employees.container';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatMenuModule,
  MatButtonModule,
  MatListModule,
  MatCheckboxModule,
  MatToolbarModule,
  MatIconModule,
  MatInputModule,
  MatProgressSpinnerModule,
  MatTableModule,
  MatPaginatorModule, MatSelectModule, MatSortModule
} from '@angular/material';
import {EmployeesTableComponent} from "./employees-list/employees-table/employees-table.component";

@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeesContainer,
    EmployeesDetailsContainer,
    EmployeesListContainer,
    SearchEmployeesContainer,
    EmployeesTableComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatListModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatTableModule,
    MatPaginatorModule,
    MatSelectModule,
    MatPaginatorModule,
    MatSortModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
