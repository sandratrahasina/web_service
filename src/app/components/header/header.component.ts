import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Output() ChooseMenuHeadEvent = new EventEmitter<any[]>();
  constructor() { }
	
  ngOnInit(): void {
  }
  chooseMenuHead($menuHead){
		this.ChooseMenuHeadEvent.emit($menuHead);
   }
}
