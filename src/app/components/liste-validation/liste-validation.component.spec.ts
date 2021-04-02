import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeValidationComponent } from './liste-validation.component';

describe('ListeValidationComponent', () => {
  let component: ListeValidationComponent;
  let fixture: ComponentFixture<ListeValidationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListeValidationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeValidationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
