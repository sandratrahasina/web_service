import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormValiditeOffreComponent } from './form-validite-offre.component';

describe('FormValiditeOffreComponent', () => {
  let component: FormValiditeOffreComponent;
  let fixture: ComponentFixture<FormValiditeOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormValiditeOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormValiditeOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
