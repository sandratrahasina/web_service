import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuController } from '@ionic/angular';
import { Compte } from 'src/interface/compte';
import { CompteService } from 'src/providers/compte.service';
import { AlertService } from 'src/providers/alert.service';
import { message_server } from '../app.module';
import { message_err_login } from './../app.module';



@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  user:Compte;
  message="";
  confirm:string;

  constructor(
    private userService:CompteService,
    private router:Router,
    // private alert:AlertService,
    private menuCtrl:MenuController)
    {
    this.user = {} as Compte;
    this.confirm="";
  }

  ngOnInit() {
  }

  login(){
    const OnSucces= (response : any) => {
      console.log(response);
       if(response["status"]=='succes'){
            this.router.navigateByUrl('home');
            this.menuCtrl.enable(true);
        }else if(response["status"]=='not confirmed'){
            this.message="votre compte n'est pas encore confimer,verifer votre email!"
            // this.alert.showAlertMessage(this.message);
        }else{
          this.message=message_err_login;
          // this.alert.showAlertMessage(this.message);
        }
    }
    const OnError= (response : any) => {
      if(response["status"]!=200){
        this.message=message_server + response["status"];
        // this.alert.showAlertMessage(this.message);
      }
    }
    try
    {
        this.userService.sendHttpLogin(this.user).subscribe(OnSucces,OnError);
    }catch(err)
    {
      this.message=err;
      // this.alert.showAlertMessage(this.message);
    }
  }
  toSignup()
  {
    this.router.navigateByUrl('sign-in');
  }

}
