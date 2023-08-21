import { Component, ChangeDetectorRef, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../service/user.service'; // Import the UserService

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  userData: any = {}; // Initialize an empty object to store user data
  userId: number = -1;

  constructor(
    private http: HttpClient,
    private cdr: ChangeDetectorRef,
    private userService: UserService // Inject the UserService
  ) {}

  ngOnInit() {
    // Retrieve the user's email from the shared service
    this.userId = this.userService.getUserId();

    // Fetch the user's data based on the retrieved email
    this.fetchUserData();
  }
  fetchUserData() {
    console.log('Fetching user data for userId:', this.userId);
  
    this.http.get<any>(`http://localhost:11000/user/${this.userId}`).subscribe(
      data => {
        console.log('Fetched user data:', data);
        this.userData = data;
        this.cdr.detectChanges(); // Trigger change detection
      },
      error => {
        console.error(error);
        alert('Failed to fetch user data.');
      }
    );
  }
  
  updateUserProfile() {
    // Send the updated user data to the backend using an API call
    // Replace 'http://localhost:11000/user' with the actual endpoint
    this.http.put(`http://localhost:11000/user/${this.userData.userId}`, this.userData).subscribe(
      response => {
        console.log(response);
        alert('Profile updated successfully!');
        // Optionally, you can update the local user data with the response data
        this.userData = response;
      },
      error => {
        console.error(error);
        alert('Failed to update profile.');
      }
    );
  }
}
