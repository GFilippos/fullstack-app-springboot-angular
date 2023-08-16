import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CountryService } from 'src/app/services/country.service';
import { Language } from 'src/app/common/language';

@Component({
  selector: 'app-language-list',
  templateUrl: './language-list.component.html',
  styleUrls: ['./language-list.component.css'],
})
export class LanguageListComponent {
  currentCountryId: number = 1;
  languages: Language[] = [];

  constructor(
    private countryService: CountryService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listLanguages();
    });
  }

  listLanguages() {
    const hasCountryId: boolean = this.route.snapshot.paramMap.has('id');
    if (hasCountryId) {
      this.currentCountryId = +this.route.snapshot.paramMap.get('id')!;
    }
    this.countryService
      .getLanguageList(this.currentCountryId)
      .subscribe((data) => {
        this.languages = data;
      });
  }
}
