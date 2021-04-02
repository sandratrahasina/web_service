import { Component, Input, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';

@Component({
  selector: 'app-mvola-form',
  templateUrl: './mvola-form.component.html',
  styleUrls: ['./mvola-form.component.scss'],
})
export class MvolaFormComponent implements OnInit {

  @Input() action: String;
  constructor(private modalCtrl:ModalController) { }

  ngOnInit() {}

  close(){
    this.modalCtrl.dismiss();
  }
}
