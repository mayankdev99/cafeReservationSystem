import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-menu-table',
  templateUrl: './menu-table.component.html',
  styleUrls: ['./menu-table.component.css']
})
export class MenuTableComponent implements OnInit {

  menuItems: any[] = [];
  private backendBaseUrl = 'http://localhost:11000';

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
    this.fetchMenuItems();
  }

  fetchMenuItems() {
    this.http.get<any[]>(`${this.backendBaseUrl}/api/menu`).subscribe((data: any[]) => {
      this.menuItems = data;
    });
  }

  onDelete(id: number) {
    if (confirm('Are you sure you want to delete this menu item?')) {
      this.http.delete(`${this.backendBaseUrl}/api/menu/${id}`).subscribe(() => {
        this.fetchMenuItems(); 
      });
    }
  }

  onEdit(menuItem: any) {
    this.router.navigate(['/menu-admin/edit', menuItem.id]);
  }

    onAddMenu() {
      this.router.navigate(['/menu-admin']);
    }
}

