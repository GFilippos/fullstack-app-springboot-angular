import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Continent } from '../common/continent';
import { Region } from '../common/region';

@Injectable({
  providedIn: 'root',
})
export class SearchService {
  constructor(private httpClient: HttpClient) {}

  private baseUrl = 'http://localhost:8080/qualco';
  getContinentsName(): Observable<Continent[]> {
    return this.httpClient
      .get<GetResponseContinent>(`${this.baseUrl}/continents`)
      .pipe(map((response) => response._embedded.continents));
  }

  getRegionsName(): Observable<Region[]> {
    return this.httpClient
      .get<GetResponseRegions>(`${this.baseUrl}/regions`)
      .pipe(map((response) => response._embedded.regions));
  }
}

interface GetResponseContinent {
  _embedded: {
    continents: Continent[];
  };
}

interface GetResponseRegions {
  _embedded: {
    regions: Region[];
  };
}
