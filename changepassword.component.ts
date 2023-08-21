import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {
  public changePasswordForm!: FormGroup;
  url = 'http://localhost:11000/user';

  constructor(private formBuilder: FormBuilder, private http: HttpClient) {}

  ngOnInit(): void {
    this.changePasswordForm = this.formBuilder.group({
      oldPassword: ['', Validators.required],
      newPassword: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.changePasswordForm.valid) {
      const userId = localStorage.getItem('loggedInUserId'); // Get the user's ID
      const oldPassword = this.changePasswordForm.value.oldPassword;
      const newPassword = this.changePasswordForm.value.newPassword;

      const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + localStorage.getItem('token') //  token for authentication
      });

      const requestBody = {
        userId: userId,
        oldPassword: oldPassword,
        newPassword: newPassword
      };

      this.http.put<any>(this.url + '/changepassword', requestBody, { headers: headers }).subscribe(
        (response) => {
          if (response.message === 'Password changed successfully') {
            alert('Password changed successfully');
            this.changePasswordForm.reset();
          } else {
            alert('Password change failed. Please try again.');
          }
        },
        (error) => {
          alert('Password change failed. Please try again.');
        }
      );
    }
  }
}
