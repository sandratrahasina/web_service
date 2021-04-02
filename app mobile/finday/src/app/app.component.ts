import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent
{
  public logo="Olla";
  public site="www.olla.com";
  public appPages =
  [
    { title: 'Mobile Money', url: 'home/mmoney', icon: 'phone-portrait',},
    { title: 'Services', url: 'home/service', icon: 'settings' },
    { title: 'Mon Compte', url: 'home/compte', icon: 'person'},
  ];
  constructor(private router:Router) {}
}
