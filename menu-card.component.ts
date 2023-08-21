import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Menu } from './menu';

@Component({
  selector: 'app-menu-card',
  templateUrl: './menu-card.component.html',
  styleUrls: ['./menu-card.component.css']
})
export class MenuCardComponent implements OnInit {

  menus: Menu[] = [];
  categories: string[] = [];
  selectedCategory: string = 'all';
  filteredMenus: Menu[] = [];


  private backendBaseUrl = 'http://localhost:11000';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchMenuData();
  }

  fetchMenuData() {
    this.http.get<Menu[]>(`${this.backendBaseUrl}/api/menu`).subscribe((menus: Menu[]) => {
      this.menus = menus;
      this.categories = Array.from(new Set(this.menus.map(menu => menu.category)));
      this.setImagesForCategories();
      this.filterByCategory();
    });
  }

  setImagesForCategories() {
    this.menus.forEach(menu => {
      if (menu.category === 'Breakfast') {
        menu.imagesource = 'assets/0efc6c9d-b24d-4d21-beca-62838d3890a6.png';
      } else if (menu.category === 'Lunch') {
        menu.imagesource = 'assets/2d63ecca-0b9d-4b91-9ad4-446e57b439be.png'; 
      } else if (menu.category === 'Dinner') {
        menu.imagesource = 'assets/a676d074-9408-4387-90cd-40c90e935994.png'; 
      } else if (menu.category === 'Dessert') {
        menu.imagesource = 'assets/3e3e6644-e15a-460c-9ff4-c450e31cadc7.png';
      }
    });
  }

  filterByCategory() {
    if (this.selectedCategory === 'all') {
      this.filteredMenus = this.menus;
    } else {
      this.filteredMenus = this.menus.filter(menu => menu.category === this.selectedCategory);
    }
  }
}
