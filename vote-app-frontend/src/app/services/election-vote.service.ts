import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class ElectionVoteService {
  constructor(
    private http: HttpClient,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  vote(formData: any): void {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigate(['./'], { relativeTo: this.route });
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
