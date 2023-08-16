import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Country } from '../common/country';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Language } from '../common/language';

@Injectable({
  providedIn: 'root',
})
export class CountryService {
  constructor(private httpClient: HttpClient) {}
  private baseUrl = 'http://localhost:8080/qualco';

  getCountryList(): Observable<Country[]> {
    return this.httpClient
      .get<GetResponseCountry>(`${this.baseUrl}/countries`)
      .pipe(map((response) => response._embedded.countries));
  }

  getLanguageList(countryId: number): Observable<Language[]> {
    const searchUrl = `${this.baseUrl}/country/${countryId}/languages`;
    return this.httpClient.get<Language[]>(searchUrl);
  }

  getCountryListPaginate(
    page: number,
    pageSize: number,
    countryId: number
  ): Observable<GetResponseCountry> {
    const searchUrl = `${this.baseUrl}/countries?id=${countryId}&page=${page}&size=${pageSize}`;
    return this.httpClient.get<GetResponseCountry>(searchUrl);
  }
}

interface GetResponseCountry {
  _embedded: {
    countries: Country[];
  };
  page: {
    size: number;
    totalElements: number;
    totalPages: number;
    number: number;
  };
}
