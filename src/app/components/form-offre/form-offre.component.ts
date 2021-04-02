import { Component, OnInit } from '@angular/core';
import { ModuleOffreService } from 'src/app/services/module-offre.service';

@Component({
  selector: 'app-form-offre',
  templateUrl: './form-offre.component.html',
  styleUrls: ['./form-offre.component.css']
})
export class FormOffreComponent implements OnInit {

  nom : string = '';
  prix : string = '';
  duree : string = '';
  unite : string = '';
  
  message: string = '';
  constructor( private offreService:  ModuleOffreService ) { }

  ngOnInit(): void {
  }
  insert(){
	
	 const input = {
	  nom : this.nom,
	  prix : this.prix,
	  duree : this.duree,
	  unite : this.unite
    };
	
	const onSuccess = response => {
      if (response['status'] == 200) {
        this.message = 'Ajout ok';
      } else {
        this.message = "Erreur externe";
      }
    }

    const onError = response => {
      this.message = "Erreur interne";
    }
    
	try {
      this.offreService.insert(input).subscribe(onSuccess, onError);
    } catch (err) {
      this.message = err;
    }
    
  }

}
