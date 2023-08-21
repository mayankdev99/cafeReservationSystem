import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  constructor(private router: Router) {}

  ngOnInit(): void {
    // You can call the navigateToReservation method here or directly from your HTML template
  }

  navigateToReservation() {
    this.router.navigate(['/reservation']); // Replace '/reservation' with the actual route path of the Reservation component
  }

  navigateToMenutable() {
    this.router.navigate(['/menu-table']); // Replace '/reservation' with the actual route path of the Reservation component
  }

  navigateToMenucard() {
    this.router.navigate(['/menu-card']); // Replace '/reservation' with the actual route path of the Reservation component
  }

  navigateToCreateadmin() {
    this.router.navigate(['/create-admin']); // Replace '/reservation' with the actual route path of the Reservation component
  }


}
