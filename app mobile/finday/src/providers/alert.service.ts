import { Injectable } from '@angular/core';
import { AlertController, ToastController } from '@ionic/angular';

@Injectable({
    providedIn: 'root'
})
export class AlertService{
    constructor(private toastCtrl:ToastController,private alert:AlertController){

    }

    async showToastMessage(message:string){
       const toast=await this.toastCtrl.create({
           message:message,
           duration:3000
       });
       toast.present();
    }

    async showAlertMessage(message:string){
        const alert = await this.alert.create({
            header: 'Alert',
            message: message,
            buttons: ['OK']
        });
        alert.present();
    }
}
