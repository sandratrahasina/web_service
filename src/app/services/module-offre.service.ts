import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { base_url } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ModuleOffreService {

  constructor(private http : HttpClient) { }
  
  get(){
	return this.http.get(base_url+'offre/all_offre');
  }
  
  insert(input){
	return this.http.get(base_url + '', input);
  }
  
  deleteById(idOffre) {
    //return this.http.delete(base_url + 'ofrre/' + idOffre);
    //change status to no
  }
  
  updateById(idOffre, input) {
    //return this.http.update(base_url + 'ofrre/' + idOffre, input);
  }
}
