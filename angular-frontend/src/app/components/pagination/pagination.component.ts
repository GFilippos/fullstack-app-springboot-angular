import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css'],
})
export class PaginationComponent {
  @Input() currentPage: number = 1;
  @Input() itemsPerPage: number = 20;
  @Input() totalItems: number = 250;

  @Output() pageChange = new EventEmitter<number>();

  totalPages: number = 50;

  ngOnChanges() {
    this.totalPages = Math.ceil(this.totalItems / this.itemsPerPage);
  }

  goToPage(pageNumber: number) {
    if (pageNumber >= 1 && pageNumber <= this.totalPages) {
      this.pageChange.emit(pageNumber);
    }
  }

  prevPage() {
    this.goToPage(this.currentPage - 1);
  }

  nextPage() {
    this.goToPage(this.currentPage + 1);
  }
}
