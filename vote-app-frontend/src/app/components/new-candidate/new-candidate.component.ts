import { Component } from '@angular/core';
import { CandidatePayload } from 'src/app/classes/CandidatePayload';
import { CandidateService } from 'src/app/services/candidate.service';

@Component({
  selector: 'app-new-candidate',
  templateUrl: './new-candidate.component.html',
  styleUrls: ['./new-candidate.component.scss'],
})
export class NewCandidateComponent {
  newCandidateName: string = '';

  constructor(private candidateService: CandidateService) {}

  createCandidate(): void {
    if (this.newCandidateName) {
      console.log(this.newCandidateName);

      const candidatePayload = new CandidatePayload(0, this.newCandidateName);
      this.candidateService.addNewCandidate(candidatePayload).subscribe(
        (response) => {
          console.log('Candidate created:', response);
        },
        (error) => {}
      );
    }
  }
}
