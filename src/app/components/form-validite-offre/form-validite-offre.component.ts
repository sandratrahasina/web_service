import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-validite-offre',
  templateUrl: './form-validite-offre.component.html',
  styleUrls: ['./form-validite-offre.component.css']
})
export class FormValiditeOffreComponent implements OnInit {

  heureDeb : string = '';
  heureFin : string = '';
  constructor() { }

  ngOnInit(): void {
  }

}
