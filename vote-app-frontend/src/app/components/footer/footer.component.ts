import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { voterPayload } from 'src/app/classes/VoterPayload';
import { CandidatePayload } from 'src/app/classes/CandidatePayload';
import { ElectionVoteService } from 'src/app/services/election-vote.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent {
  selectedIam: voterPayload | any;
  selectedVoteFor: CandidatePayload | any; // Default candidate ID
  selectedVoterName: string = '';
  selectedCandidateName: string = '';
  candidates: CandidatePayload[] = [];
  voters: voterPayload[] = [];

  constructor(
    private http: HttpClient,
    private electionVoteService: ElectionVoteService
  ) {
    this.http.get<any[]>('http://localhost:8080/candidates/all').subscribe(
      (data) => {
        this.candidates = data;
      },
      (error) => {
        console.error('Error fetching candidates:', error);
      }
    );

    this.http.get<any[]>('http://localhost:8080/voters/all').subscribe(
      (data) => {
        this.voters = data;
      },
      (error) => {
        console.error('Error fetching voters:', error);
      }
    );
  }

  performPostRequest(): void {
    console.log('Selected item:', this.selectedVoterName);
    console.log('Selected item:', this.selectedCandidateName);
    let voter = this.voters.find((i) => i.name === this.selectedVoterName);
    let candidate = this.candidates.find(
      (c) => c.name === this.selectedCandidateName
    );
    console.log('Selected voter:', voter);
    console.log('Selected candidate:', candidate);

    const formData = {
      voterPayload: voter,
      candidatePayload: candidate,
    };
    console.log('Formdata:', formData);
    this.electionVoteService.vote(formData);
  }
}
