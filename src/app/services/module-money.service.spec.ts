import { TestBed } from '@angular/core/testing';

import { ModuleMoneyService } from './module-money.service';

describe('ModuleMoneyService', () => {
  let service: ModuleMoneyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModuleMoneyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
