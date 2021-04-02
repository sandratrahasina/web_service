import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-details-offre',
  templateUrl: './form-details-offre.component.html',
  styleUrls: ['./form-details-offre.component.css']
})
export class FormDetailsOffreComponent implements OnInit {

  valeur : string = '';
  uniteV :  string = '';
  type : string = '';
  constructor() { }

  ngOnInit(): void {
  }

}
