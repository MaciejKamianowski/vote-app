import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { voterPayload } from '../classes/VoterPayload';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VoterService {
  constructor(private http: HttpClient) {}

  getAllVoters(): Observable<any> {
    return this.http.get<any[]>('http://localhost:8080/voters/all');
  }

  addNewVoter(voterPayload: voterPayload): Observable<any> {
    const url = 'http://localhost:8080/voters/new'; // Adjust the URL accordingly
    return this.http.post(url, voterPayload);
  }
}
