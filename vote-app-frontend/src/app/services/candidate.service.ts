import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CandidatePayload } from '../classes/CandidatePayload';

@Injectable({
  providedIn: 'root',
})
export class CandidateService {
  constructor(private http: HttpClient) {}

  getAllCandidates(): CandidatePayload[] {
    let candidates: CandidatePayload[] = [];
    this.http.get<any[]>('http://localhost:8080/candidates/all').subscribe(
      (data) => {
        candidates = data;
      },
      (error) => {
        console.error('Error fetching candidates:', error);
      }
    );
    return candidates;
  }
}
