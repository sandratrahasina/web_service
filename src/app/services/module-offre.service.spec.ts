import { TestBed } from '@angular/core/testing';

import { ModuleOffreService } from './module-offre.service';

describe('ModuleOffreService', () => {
  let service: ModuleOffreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModuleOffreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
