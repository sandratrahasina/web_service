import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormDetailsOffreComponent } from './form-details-offre.component';

describe('FormDetailsOffreComponent', () => {
  let component: FormDetailsOffreComponent;
  let fixture: ComponentFixture<FormDetailsOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormDetailsOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormDetailsOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
