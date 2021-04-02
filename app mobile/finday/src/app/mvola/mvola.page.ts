import { ModalController } from '@ionic/angular';
import { Component, OnInit } from '@angular/core';
import { MvolaFormComponent } from '../mvola-form/mvola-form.component';

@Component({
  selector: 'app-mvola',
  templateUrl: './mvola.page.html',
  styleUrls: ['./mvola.page.scss'],
})
export class MvolaPage implements OnInit {

  public menu:any=[
    {
      'label':'Depot','function':'depot','icon':'enter',
    },
    {
      'label':'Retrait','function':'retrait','icon':'exit',
    }
  ];
  constructor(private modalCtrl:ModalController) { }
  ngOnInit() {
  }


  async showModal(name:String){
    const modal= await this.modalCtrl.create({
      component:MvolaFormComponent,
      componentProps:{
        'action':name,
      }
    })
    return await modal.present();
  }
}

