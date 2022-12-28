import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { apiResponse } from 'src/app/model/api.response';
import { Employee } from 'src/app/model/employee.model';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {
  employees!: Observable<apiResponse>;
  emp : Employee[] = [];
  employee: Employee = new Employee();
  id!: number;

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: EmployeeService) { }

  ngOnInit(): void {
      this.employeeService.getEmployees()
    .subscribe(data => {
      this.emp = data});
  }

  deleteEmployee(id:number){
    
    this.employeeService.deleteEmployee(id)
    .subscribe(
    ()=>{ 
       
    },
      error => console.error(error));

      this.employeeService.getEmployees()
      .subscribe(data => {
        this.emp = data});
  }

  getEmployeeById(id:number){
    this.employee = new Employee();

    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
}

  

  updateEmployee(id:number){
    this.router.navigate([`/employe/update/${id}`]);
  }

}
