import { TestBed } from '@angular/core/testing';

import { ModuleStatistiqueService } from './module-statistique.service';

describe('ModuleStatistiqueService', () => {
  let service: ModuleStatistiqueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModuleStatistiqueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
