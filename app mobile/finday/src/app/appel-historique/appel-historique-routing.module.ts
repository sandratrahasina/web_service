import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppelHistoriquePage } from './appel-historique.page';

const routes: Routes = [
  {
    path: '',
    component: AppelHistoriquePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AppelHistoriquePageRoutingModule {}
