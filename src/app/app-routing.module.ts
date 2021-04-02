import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListeOffreComponent } from './components/liste-offre/liste-offre.component';
import { FormOffreComponent } from './components/form-offre/form-offre.component';
import { ListeValidationComponent } from './components/liste-validation/liste-validation.component';
import {GrapheStatComponent} from './components/graphe-stat/graphe-stat.component';

const routes: Routes = [
  //{ path: '', component: ListeOffreComponent }, //vers listeOffre
  {path: 'offreStat', component: GrapheStatComponent },//vers stat des offres
  
  {path: 'listeOffre', component:  ListeOffreComponent },//liste des offres(avec modif et supp)
  {path: 'formOffre', component: FormOffreComponent},//inserer un offre
  
  {path: 'validDepot', component: ListeValidationComponent }//vers valider un depot
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
