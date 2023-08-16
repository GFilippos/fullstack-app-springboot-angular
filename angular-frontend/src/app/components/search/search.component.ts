import { Component, OnInit } from '@angular/core';
import { Continent } from 'src/app/common/continent';
import { Region } from 'src/app/common/region';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent {
  continents: Continent[] = [];
  regions: Region[] = [];
  constructor(private searchService: SearchService) {}

  ngOnInit(): void {
    this.fetchContinentNames();
    this.fetchRegionsNames();
  }

  fetchContinentNames() {
    this.searchService.getContinentsName().subscribe(
      (data) => {
        this.continents = data;
      },
      (error) => {
        console.error('Error fetching continent data:', error);
      }
    );
  }

  fetchRegionsNames() {
    this.searchService.getRegionsName().subscribe(
      (data) => {
        this.regions = data;
      },
      (error) => {
        console.error('Error fetching region data:', error);
      }
    );
  }
}
