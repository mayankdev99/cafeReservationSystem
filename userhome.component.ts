import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; // Import Router module


@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {
  loggedInUserId: number | null = null;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.loggedInUserId = parseInt(localStorage.getItem('loggedInUserId') || '0', 10);
  }

  logout() {
    this.router.navigate(['/home']); // Replace '/user' with the actual route to your user component
  }

  navigateToContact() {
    this.router.navigate(['/contact']); // Navigate to the 'contact' route
  }

  navigateToBookatable() {
    this.router.navigate(['/bookatable']); // Navigate to the 'bookatable' route
  }

  navigateToMenucard() {
    this.router.navigate(['/menu-card']);//Navigate to the 'admincard' route

  }

  navigateToChangepassword() {
    this.router.navigate(['/changepassword']);//Navigate to the 'admincard' route
    
  }

  navigateToUpdateprofile() {
    this.router.navigate(['/update-profile']);//Navigate to the 'admincard' route
    
  }

  navigateToWelcome() {
    this.router.navigate(['/welcome']);//Navigate to the 'admincard' route
    
  }




}

