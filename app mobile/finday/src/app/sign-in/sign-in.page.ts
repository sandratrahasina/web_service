import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Compte } from 'src/interface/compte';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.page.html',
  styleUrls: ['./sign-in.page.scss'],
})
export class SignInPage implements OnInit {

  newAccount:{
    name: "",
    number: "",
    mdp: "",
    date_inscription: "",
    solde: 0
  };
  constructor() { }

  ngOnInit() {
  }

  logForm(form:NgForm) {
    //console.log(this.newAccount)
  }

}
