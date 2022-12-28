import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule} from '@angular/common/http';
import { CreateEmployeeComponent } from './employee/create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './employee/update-employee/update-employee.component';
import { EmployeeService } from './service/employee.service';
import { EmployeesListComponent } from './employee/employees-list/employees-list.component';
import { CreateTacheComponent } from './tache/create-tache/create-tache.component';
import { UpdateTacheComponent } from './tache/update-tache/update-tache.component';
import { TachesListComponent } from './tache/taches-list/taches-list.component';
import { TacheService } from './service/tache.service';


@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    UpdateEmployeeComponent,
    EmployeesListComponent,
    CreateTacheComponent,
    UpdateTacheComponent,
    TachesListComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  
  providers: [TacheService, EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
