import { Injectable } from '@angular/core';
import { Compte } from 'src/interface/compte';

@Injectable({
    providedIn:"root"
})
export class ToolsService{
    constructor(){}

    isvalidNumber(number:string):boolean{
      const re = /^\d+$/;
      return re.test(number);
    }

    isvalidInputLogin(user:Compte):boolean{
        // console.log(this.isvalidNumber(user.number) + "email validation");
        if(this.isvalidNumber(user.number) && user.mdp!=null && user.number!=null){
            return true;
        }else{
            return false;
        }
    }

    isvalidInputDSignUp(user:Compte):boolean{
        if(this.isvalidNumber(user.number) && this.isNoEmpty(user)){
            return true;
        }else{
            return false
        }
    }

    isNoEmpty(user:Compte):boolean{
        if(user.name!=null && user.number!=null && user.mdp!=null && user.date_inscription!=null && user.solde!=null){
            return true;
        }else{
            return false
        }
    }

}
