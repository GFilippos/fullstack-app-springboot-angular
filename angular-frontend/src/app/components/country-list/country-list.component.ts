import { Component } from '@angular/core';
import { Country } from 'src/app/common/country';
import { CountryService } from 'src/app/services/country.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css'],
})
export class CountryListComponent {
  countries: Country[] = [];
  orderedCountriesList: Country[] = [];
  countryId: number = 1;

  //pagination for countries
  currentPage = 1;
  itemsPerPage = 20;
  totalItems = 250;

  constructor(private countryService: CountryService, private router: Router) {}

  ngOnInit(): void {
    this.listCountries();
  }

  //fetching countries data and sorting them alphabetically
  listCountries() {
    this.countryService.getCountryList().subscribe(
      (data) => {
        this.countries = data;
        this.orderedCountriesList = this.countries.sort((a, b) => {
          const nameA = a.name.toLowerCase();
          const nameB = b.name.toLowerCase();
          if (nameA < nameB) {
            return -1;
          }
          if (nameA > nameB) {
            return 1;
          }
          return 0;
        });
      },
      (error) => {
        console.error('Error fetching countries:', error);
      }
    );
  }

  onPageChange(newPage: number) {
    this.currentPage = newPage;
    this.fetchData();
  }

  private fetchData() {
    this.countryService
      .getCountryListPaginate(
        this.currentPage - 1,
        this.itemsPerPage,
        this.countryId
      )
      .subscribe(
        (data) => {
          this.countries = data._embedded.countries;
          this.currentPage = data.page.number + 1;
          this.itemsPerPage = data.page.size;
          this.totalItems = data.page.totalElements;
        },
        (error) => console.log('Error fetching data:', error)
      );
  }
}
