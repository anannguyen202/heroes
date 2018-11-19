import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AuthGuard } from './auth/auth.guard';

import { AppComponent } from './app.component';
import { HeroesComponent } from './view/heroes/heroes.component';
import { FormsModule } from '@angular/forms';
import { HeroDetailComponent } from './view/hero-detail/hero-detail.component';
import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from './view/dashboard/dashboard.component';
import { MessageComponent } from './view/message/message.component';

import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './in-memory-data.service';
import { HeroSearchComponent } from './view/hero-search/hero-search.component';
import { SignInComponent } from './view/sign-in/sign-in.component';
import { SignUpComponent } from './view/sign-up/sign-up.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ApiProvider } from './provider/api';
import { UserProvider } from './provider/user';

@NgModule({
  declarations: [
    AppComponent,
    HeroesComponent,
    HeroDetailComponent,
    DashboardComponent,
    MessageComponent,
    HeroSearchComponent,
    SignInComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, { dataEncapsulation: false }
    )
  ],
  providers: [AuthGuard, ApiProvider, UserProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
