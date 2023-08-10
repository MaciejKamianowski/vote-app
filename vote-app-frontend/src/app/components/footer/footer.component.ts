import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { voterPayload } from 'src/app/classes/VoterPayload';
import { CandidatePayload } from 'src/app/classes/CandidatePayload';
import { ElectionVoteService } from 'src/app/services/election-vote.service';
import { CandidateService } from 'src/app/services/candidate.service';
import { VoterService } from 'src/app/services/voter.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent implements OnInit {
  selectedIam: voterPayload | any;
  selectedVoteFor: CandidatePayload | any; // Default candidate ID
  selectedVoterName: string = '';
  selectedCandidateName: string = '';
  candidates: CandidatePayload[] = [];
  voters: voterPayload[] = [];

  constructor(
    private http: HttpClient,
    private candidateService: CandidateService,
    private electionVoteService: ElectionVoteService,
    private voterService: VoterService
  ) {}
  ngOnInit(): void {
    this.candidateService.getAllCandidates().subscribe(
      (data) => {
        this.candidates = data;
      },
      (error) => {
        console.error('Error fetching candidates:', error);
      }
    );

    this.voterService.getAllVoters().subscribe(
      (data) => {
        this.voters = data;
      },
      (error) => {
        console.error('Error fetching voters:', error);
      }
    );
  }

  performPostRequest(): void {
    let voter = this.voters.find((i) => i.name === this.selectedVoterName);
    let candidate = this.candidates.find(
      (c) => c.name === this.selectedCandidateName
    );

    const formData = {
      voterPayload: voter,
      candidatePayload: candidate,
    };
    console.log('Formdata:', formData);
    this.electionVoteService.vote(formData);
  }
}
