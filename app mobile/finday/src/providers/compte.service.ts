import { base_url, message_err_login, message_err_signin } from './../app/app.module';
import { Injectable }  from "@angular/core";
import { Compte } from "src/interface/compte";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { ToolsService } from './tools.service';

@Injectable({
    providedIn:'root'
})
export class CompteService{
    constructor(private http:HttpClient,private tools:ToolsService){

    }

    sendHttpLogin(user:Compte){
       // console.log(this.tools.isvalidInputLogin(user));
        if(this.tools.isvalidInputLogin(user)){
           // console.log("passer");
            let data={
                "email":user.number,
                "password":user.mdp
            };
            let headers = new HttpHeaders({
                'Access-Control-Allow-Origin':'*',
                'Content-Type': 'application/json'
            });
            let options = { headers: headers };

            return this.http.post(base_url+"/Connexion",data,options);
        }else{
            throw new Error(message_err_login);
        }
    }

    sendHttpSignup(user:Compte){
        if(this.tools.isvalidInputDSignUp(user)){
            let data={
                "name":user.name,
                "number":user.number,
                "mdp":user.mdp,
                "date_inscription":user.date_inscription,
                "solde":user.solde
            };
            let headers = new HttpHeaders({
                'Access-Control-Allow-Origin':'*',
                'Content-Type': 'application/json'
            });
            let options = { headers: headers };
           // console.log(this.http.post(base_url + "Inscrption",data,options));
            return this.http.post(base_url + "scrption",data,options);
        }else{
            throw new Error(message_err_signin);
        }
    }
}
