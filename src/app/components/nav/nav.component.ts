import { Component, OnInit, SimpleChanges, Input} from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  @Input() menuNav ="Statistique"; 
  menuNavList : any[]=  [{"name":"offre", "route":"offreStat"},{"name":"client", "route":"clientStat"},{"name":"mobile money","route":"moneyStat"}];
  constructor() { }

  ngOnInit(): void {
	//this.SetMenuNav();
  }
  ngOnChanges(changes: SimpleChanges): void {
	this.SetMenuNav();
  }
  SetMenuNav(){
	  if(this.menuNav == "Statistique"){
		this.menuNavList = [{"name":"offre", "route":"offreStat"},{"name":"client", "route":"clientStat"},{"name":"mobile money","route":"moneyStat"}];
	  }
	  if(this.menuNav == "Argent"){
		this.menuNavList = [{"name":"valider depot","route":"validDepot"}];
	  }
	  if(this.menuNav == "Offre")
	  {
		this.menuNavList = [{"name":"liste","route":"listeOffre"},{"name":"inserer","route":"formOffre"}];
	  }
  }

}
