import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatTabsModule } from '@angular/material/tabs';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';

import { ChartsModule} from 'ng2-charts';

import {HeaderComponent} from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavComponent } from './components/nav/nav.component';

import { ListeOffreComponent } from './components/liste-offre/liste-offre.component';
import { FormOffreComponent } from './components/form-offre/form-offre.component';

import { ListeValidationComponent } from './components/liste-validation/liste-validation.component';

import {GrapheStatComponent} from './components/graphe-stat/graphe-stat.component';
import { FormDetailsOffreComponent } from './components/form-details-offre/form-details-offre.component';
import { FormValiditeOffreComponent } from './components/form-validite-offre/form-validite-offre.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    ListeOffreComponent,
    FormOffreComponent,
    ListeValidationComponent,
    GrapheStatComponent,
    FormDetailsOffreComponent,
    FormValiditeOffreComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatTabsModule,
    ChartsModule,
    FormsModule // without this ngModel is not gonna work
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
