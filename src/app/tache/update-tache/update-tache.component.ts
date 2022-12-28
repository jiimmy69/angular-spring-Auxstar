import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { apiResponse } from 'src/app/model/api.response';
import { Tache } from 'src/app/model/tache.model';
import { TacheService } from 'src/app/service/tache.service';

@Component({
  selector: 'app-update-tache',
  templateUrl: './update-tache.component.html',
  styleUrls: ['./update-tache.component.css']
})
export class UpdateTacheComponent implements OnInit {

  id!: number;
  tache: Tache = new Tache();
  ApiResponse!: apiResponse;
  submitted = false;

  constructor(private route: ActivatedRoute,private router: Router,
    private tacheService: TacheService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.tacheService.getTacheById(this.id)
      .subscribe((data) => {
        this.tache = data;
        console.log(data);
      }, (error) => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.tacheService.updateTache(this.id, this.tache)
      .subscribe((data) => console.log(data), 
      (error) => console.log(error));
    alert("Tache updated") ,
    this.router.navigate(['updatee/`${this.id}`']);
    }

  list(){
    this.router.navigate(['updatee/`${this.id}`']);
  }
  
}