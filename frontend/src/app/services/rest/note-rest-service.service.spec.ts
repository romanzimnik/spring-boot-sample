import { TestBed } from '@angular/core/testing';

import { NoteRestServiceService } from './note-rest-service.service';

describe('NoteRestServiceService', () => {
  let service: NoteRestServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NoteRestServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
