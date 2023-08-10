import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { NewCandidateComponent } from './components/new-candidate/new-candidate.component';
import { NewVoterComponent } from './components/new-voter/new-voter.component';

const routes: Routes = [
  { path: 'main', component: MainComponent },
  { path: 'new-candidate', component: NewCandidateComponent },
  { path: 'new-voter', component: NewVoterComponent },
  { path: '', redirectTo: '/main', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
