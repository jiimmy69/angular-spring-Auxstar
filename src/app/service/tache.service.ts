import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/index";
import { apiResponse } from '../model/api.response';
import { Tache } from '../model/tache.model';
import { environment } from 'src/environments/environment';

@Injectable()
export class TacheService{
    putTaches(): Observable<apiResponse>{
        throw new Error('Method not implemented.');
    }
    updateUserr(): Observable<any> {
        throw new Error('Method not implemented.');
    }
    
      constructor(private http: HttpClient) { }
       baseUrll: string = `${environment.urlBack}taches`;
    
      getTache() {
        return this.http.get<Tache[]>(this.baseUrll);
      }
    
      getTacheById(id: number){
        return this.http.get<Tache>(`${this.baseUrll}/${id}`);
      }
    
      createTache(tache: Tache){
        return this.http.post(this.baseUrll, tache);
      }
    
      updateTache(id: number, tache: Tache){
        return this.http.put(`${this.baseUrll}/${id}`, tache);
      }
    
      deleteTache(id: number){
        return this.http.delete(`${this.baseUrll}/${id}`);
      }
}