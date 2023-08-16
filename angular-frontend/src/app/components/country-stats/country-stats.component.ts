import { Component } from '@angular/core';
import { Ratio } from 'src/app/common/ratio';
import { MaxRatioService } from 'src/app/services/max-ratio.service';

@Component({
  selector: 'app-country-stats',
  templateUrl: './country-stats.component.html',
  styleUrls: ['./country-stats.component.css'],
})
export class CountryStatsComponent {
  countryNames: Ratio[] = [];

  constructor(private ratioService: MaxRatioService) {}

  ngOnInit(): void {
    this.fetchRatio();
  }

  fetchRatio() {
    this.ratioService.getMaxRatios().subscribe((data) => {
      this.countryNames = data;
    });
  }
}
