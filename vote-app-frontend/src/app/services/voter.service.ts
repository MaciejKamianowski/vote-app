import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { voterPayload } from '../classes/VoterPayload';

@Injectable({
  providedIn: 'root',
})
export class VoterService {
  constructor(private http: HttpClient) {}

  getAllVoters(): voterPayload[] {
    let voters: voterPayload[] = [];
    this.http.get<any[]>('http://localhost:8080/voters/all').subscribe(
      (data) => {
        voters = data;
      },
      (error) => {
        console.error('Error fetching voters:', error);
      }
    );
    return voters;
  }
}
