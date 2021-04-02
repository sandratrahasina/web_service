import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AppelSimulationPageRoutingModule } from './appel-simulation-routing.module';

import { AppelSimulationPage } from './appel-simulation.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AppelSimulationPageRoutingModule
  ],
  declarations: [AppelSimulationPage]
})
export class AppelSimulationPageModule {}
