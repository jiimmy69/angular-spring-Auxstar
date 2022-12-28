import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmployeeComponent } from './employee/create-employee/create-employee.component';
import { EmployeesListComponent } from './employee/employees-list/employees-list.component';
import { UpdateEmployeeComponent } from './employee/update-employee/update-employee.component';
import { CreateTacheComponent } from './tache/create-tache/create-tache.component';
import { TachesListComponent } from './tache/taches-list/taches-list.component';
import { UpdateTacheComponent } from './tache/update-tache/update-tache.component';


const routes: Routes = [
  {path:'',redirectTo:'employe',pathMatch:'full'},
  {path:'employe/add',component:CreateEmployeeComponent},
  {path:'employe',component:EmployeesListComponent},
  {path:'employe/update/:id',component:UpdateEmployeeComponent},
  {path:'',redirectTo:'tache',pathMatch:'full'},
  {path:'tache/add',component:CreateTacheComponent},
  {path:'tache',component:TachesListComponent},
  {path:'tache/update/:id',component:UpdateTacheComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
