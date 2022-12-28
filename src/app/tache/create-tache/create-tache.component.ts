import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Tache } from 'src/app/model/tache.model';
import { TacheService } from 'src/app/service/tache.service';

@Component({
  selector: 'app-create-tache',
  templateUrl: './create-tache.component.html',
  styleUrls: ['./create-tache.component.css']
})
export class CreateTacheComponent implements OnInit {


  tache: Tache = new Tache();
  submitted = false;

  constructor(private tacheService: TacheService,
    private router: Router) { }

  ngOnInit() {
  }


  onSubmit() {
    this.submitted = true;
    this.tacheService.createTache(this.tache)
    .subscribe(data => console.log(data), error => console.log(error));
    this.tache = new Tache();
    alert("Tache created ")
    this.router.navigate(['/tache']);
  }
}
