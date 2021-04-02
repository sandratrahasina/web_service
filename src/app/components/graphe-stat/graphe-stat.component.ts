import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-graphe-stat',
  templateUrl: './graphe-stat.component.html',
  styleUrls: ['./graphe-stat.component.css']
})
export class GrapheStatComponent implements OnInit {

  constructor() { }

  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  
  public barChartLabels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012']; //suivant x //legend si pie
 
  public barChartType = 'bar';//type du diagramme
 
  public barChartLegend = true; 
  
  public barChartData = [
    {data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A'},//serie A et B legende si bar
    {data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B'}
  ]; //donne suivant y //donnee vu en survole si pie
  
  ngOnInit(): void {
  }

}
