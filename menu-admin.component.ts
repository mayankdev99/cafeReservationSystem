import { Component, OnInit,ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-menu-admin',
  templateUrl: './menu-admin.component.html',
  styleUrls: ['./menu-admin.component.css']
})
export class MenuAdminComponent implements OnInit {
  newMenuItem: any = {};
  private backendBaseUrl = 'http://localhost:11000';

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    const itemId = this.route.snapshot.params['id'];
    if (itemId) {
      this.http.get<any>(`${this.backendBaseUrl}/api/menu/${itemId}`).subscribe((menuItem: any) => {
        this.newMenuItem = menuItem;
      });
    }
  }

  onSubmit() {
    this.http.post(`${this.backendBaseUrl}/api/menu`, this.newMenuItem).subscribe(response => {
      console.log('Menu item added:', response);
      this.newMenuItem = {}; 
    });
  }
}

