import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { apiResponse } from 'src/app/model/api.response';
import { Tache } from 'src/app/model/tache.model';
import { TacheService } from 'src/app/service/tache.service';


@Component({
  selector: 'app-taches-list',
  templateUrl: './taches-list.component.html',
  styleUrls: ['./taches-list.component.css']
})
export class TachesListComponent implements OnInit {
  taches!: Observable<apiResponse>;
  tchh : Tache[] = [];
  tache: Tache = new Tache();

  constructor(private tacheService:TacheService,private router:Router) { }

  ngOnInit(): void {
      this.tacheService.getTache()
    .subscribe(data => {
      this.tchh = data})
  }

  deleteTache(id:number){
    this.tacheService.deleteTache(id)
    .subscribe(
    ()=>{ 
    },
      error => console.error(error));
      this.tacheService.getTache()
      .subscribe(data => {
        this.tchh = data});
  }

  updateTache(id:number){
    
    this.router.navigate([`/tache/update/${id}`]);
  }

  getTacheById(id: number){
    this.tacheService.getTacheById(id).subscribe(data=> console.log(data),
    error =>console.error(error));
    
  }

  

}
