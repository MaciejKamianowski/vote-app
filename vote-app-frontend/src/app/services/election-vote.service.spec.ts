import { TestBed } from '@angular/core/testing';

import { ElectionVoteService } from './election-vote.service';

describe('ElectionVoteService', () => {
  let service: ElectionVoteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ElectionVoteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
