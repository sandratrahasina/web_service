import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrapheStatComponent } from './graphe-stat.component';

describe('GrapheStatComponent', () => {
  let component: GrapheStatComponent;
  let fixture: ComponentFixture<GrapheStatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrapheStatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrapheStatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
