import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-voters',
  templateUrl: './voters.component.html',
  styleUrls: ['./voters.component.scss'],
})
export class VotersComponent implements OnInit {
  voters: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchVoters();
  }

  fetchVoters(): void {
    this.http.get<any[]>('http://localhost:8080/voters/all/info').subscribe(
      (data) => {
        this.voters = data;
      },
      (error) => {
        console.error('Error fetching voters:', error);
      }
    );
  }
}
