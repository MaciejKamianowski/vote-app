import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './components/main/main.component';
import { HeaderComponent } from './components/header/header.component';
import { CandidatesComponent } from './components/candidates/candidates.component';
import { HttpClientModule } from '@angular/common/http';
import { VotersComponent } from './components/voters/voters.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HeaderComponent,
    CandidatesComponent,
    VotersComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
