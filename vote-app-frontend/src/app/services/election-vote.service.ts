import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ElectionVoteService {
  constructor(private http: HttpClient) {}

  vote(formData: any): void {
    this.http.post('http://localhost:8080/elections/vote', formData).subscribe(
      (response) => {
        console.log('Vote submitted:', response);
      },
      (error) => {
        console.error('Error submitting vote:', error);
      }
    );
  }
}
