import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CountryService } from './services/country.service';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { LandingPageComponent } from './pages/landing-page/landing-page.component';
import { LanguageListComponent } from './components/language-list/language-list.component';
import { CountryListComponent } from './components/country-list/country-list.component';
import { PaginationComponent } from './components/pagination/pagination.component';
import { CountryStatsComponent } from './components/country-stats/country-stats.component';
import { SearchComponent } from './components/search/search.component';

const routes: Routes = [
  { path: 'countries/languages/:id', component: LanguageListComponent },
  { path: 'countries', component: CountryListComponent },
  { path: 'country-stats', component: CountryStatsComponent },
  { path: 'search', component: SearchComponent },
  { path: '', component: LandingPageComponent, pathMatch: 'full' },
  {
    path: '**',
    component: PageNotFoundComponent,
  },
];

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    LandingPageComponent,
    LanguageListComponent,
    CountryListComponent,
    PaginationComponent,
    CountryStatsComponent,
    SearchComponent,
  ],
  imports: [BrowserModule, HttpClientModule, RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [CountryService],
  bootstrap: [AppComponent],
})
export class AppModule {}
