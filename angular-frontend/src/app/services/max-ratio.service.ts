import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Country } from '../common/country';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Language } from '../common/language';
import { Ratio } from '../common/ratio';

@Injectable({
  providedIn: 'root',
})
export class MaxRatioService {
  constructor(private httpClient: HttpClient) {}
  private searchUrl = 'http://localhost:8080/qualco/max-ratios';

  getMaxRatios(): Observable<Ratio[]> {
    return this.httpClient.get<Ratio[]>(this.searchUrl);
  }
}
