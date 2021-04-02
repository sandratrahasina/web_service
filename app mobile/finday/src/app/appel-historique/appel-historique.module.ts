import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AppelHistoriquePageRoutingModule } from './appel-historique-routing.module';

import { AppelHistoriquePage } from './appel-historique.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AppelHistoriquePageRoutingModule
  ],
  declarations: [AppelHistoriquePage]
})
export class AppelHistoriquePageModule {}
