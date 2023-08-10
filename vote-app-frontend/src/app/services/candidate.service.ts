import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CandidatePayload } from '../classes/CandidatePayload';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CandidateService {
  constructor(private http: HttpClient) {}

  getAllCandidates(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/candidates/all');
  }
}
