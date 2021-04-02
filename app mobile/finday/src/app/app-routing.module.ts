import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'sign-in',
    loadChildren: () => import('./sign-in/sign-in.module').then( m => m.SignInPageModule)
  },
  {
    path: 'appel-historique',
    loadChildren: () => import('./appel-historique/appel-historique.module').then( m => m.AppelHistoriquePageModule)
  },
  {
    path: 'appel-simulation',
    loadChildren: () => import('./appel-simulation/appel-simulation.module').then( m => m.AppelSimulationPageModule)
  },
  {
    path: 'mvola',
    loadChildren: () => import('./mvola/mvola.module').then( m => m.MvolaPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
