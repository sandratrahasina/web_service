import { Component, OnInit } from '@angular/core';
import { ModuleMoneyService } from 'src/app/services/module-money.service';

@Component({
  selector: 'app-liste-validation',
  templateUrl: './liste-validation.component.html',
  styleUrls: ['./liste-validation.component.css']
})
export class ListeValidationComponent implements OnInit {

	listValidation : any[] = [];
	//[{"utilisateur":"Sandra","num":"0000000000","somme":"500"}];
	
	message: string ='';
	
	constructor( private moneyService:  ModuleMoneyService ) { }

	ngOnInit(): void {
		this.setListValidation();
	}
  
	setListValidation(){
	const onSuccess = response => {
		if (response['status'] == 200) {
			this.listValidation = response['datas'];	
		} else {
			this.message = 'Erreur requete';
		}
	}

	const onError = response => {
		this.message = 'Erreur interne';
	}

	this.moneyService.get().subscribe(onSuccess, onError);
  }

}
