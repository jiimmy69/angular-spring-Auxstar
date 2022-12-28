import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/index";
import { apiResponse } from '../model/api.response';
import { Employee } from '../model/employee.model';
import { environment } from 'src/environments/environment';


@Injectable()
export class EmployeeService {
  putEmployees(): Observable<apiResponse> {
    throw new Error('Method not implemented.');
  }
  updateUser(): Observable<any> {
    throw new Error('Method not implemented.');
  }

  constructor(private http: HttpClient) { }
   baseUrl: string = `${environment.urlBack}users`;

  getEmployees() {
    return this.http.get<Employee[]>(this.baseUrl);
  }
  
  getEmployeeById(id: number){
    return this.http.get<Employee>(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: Employee){
    return this.http.post(this.baseUrl, employee);
  }

  updateEmployee(id: number, employee: Employee){
    return this.http.put(`${this.baseUrl}/${id}`, employee);
  }

  deleteEmployee(id: number){
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}