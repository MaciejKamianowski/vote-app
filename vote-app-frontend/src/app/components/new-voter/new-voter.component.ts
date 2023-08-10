import { Component } from '@angular/core';
import { voterPayload } from 'src/app/classes/VoterPayload';
import { VoterService } from 'src/app/services/voter.service';

@Component({
  selector: 'app-new-voter',
  templateUrl: './new-voter.component.html',
  styleUrls: ['./new-voter.component.scss'],
})
export class NewVoterComponent {
  newVoterName: string = '';

  constructor(private voterService: VoterService) {}

  createVoter(): void {
    if (this.newVoterName) {
      console.log(this.newVoterName);

      const newVoterPayload = new voterPayload(0, this.newVoterName);
      this.voterService.addNewVoter(newVoterPayload).subscribe(
        (response) => {
          console.log('Voter created:', response);
        },
        (error) => {}
      );
    }
  }
}
