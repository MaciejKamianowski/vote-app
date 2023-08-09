import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-candidates',
  templateUrl: './candidates.component.html',
  styleUrls: ['./candidates.component.scss'],
})
export class CandidatesComponent implements OnInit {
  candidates: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchCandidates();
  }

  fetchCandidates(): void {
    this.http.get<any[]>('http://localhost:8080/candidates/all/info').subscribe(
      (data) => {
        this.candidates = data;
      },
      (error) => {
        console.error('Error fetching candidates:', error);
      }
    );
  }
}
