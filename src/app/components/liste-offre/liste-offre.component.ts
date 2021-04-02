import { Component, OnInit, SimpleChanges } from '@angular/core';
import { ModuleOffreService } from 'src/app/services/module-offre.service';

@Component({
  selector: 'app-liste-offre',
  templateUrl: './liste-offre.component.html',
  styleUrls: ['./liste-offre.component.css']
})
export class ListeOffreComponent implements OnInit {

  constructor( private offreService:  ModuleOffreService ) { }
  listOffre : any[] = [];
  
  message: string = '';
  
  ngOnInit(): void {
	 this.setListOffre();
  }
  
  setListOffre(){
	const onSuccess = response => {
      if (response['status'] == 200) {
        this.listOffre = response['datas'];
      } else {
        this.message = 'Erreur requete';
      }
    }
    const onError = response => {
      this.message = 'Erreur interne';
    }

    this.offreService.get().subscribe(onSuccess, onError);
  }
  
}
