import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { base_url } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ModuleMoneyService {

  constructor(private http : HttpClient) {}
  
  get(){
	 return this.http.get(base_url+'argent/all_argent');
  }
  
}
