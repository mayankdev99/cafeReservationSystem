import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public loginForm!: FormGroup;
  url = 'http://localhost:11000/user';
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private userService: UserService // Inject the UserService
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      emailid: ['', [Validators.required, Validators.email]],
      mobileno: ['', Validators.required]
    });
  }

  onSubmit() {
    this.submitted = true;
    this.login();
  }

  login() {
    const email = this.loginForm.value.emailid;
    const mobileno = this.loginForm.value.mobileno;

    this.http.get<any[]>(this.url).subscribe(
      (res) => {
        const log = res.find((user: any) => {
          return user.emailid === email && user.mobileno === mobileno;
        });
        if (log) {
          this.userService.setUserId(log.userId);
          console.log('User ID set:', log.userId);
// Store the user's email
          alert('Login Success, Click Ok to continue!!');
          this.loginForm.reset();
          this.router.navigate(['userhome']);
        } else {
          alert('Try Again!!');
        }
      },
      (err) => {
        alert('Something Went Wrong!!');
        this.loginForm.reset();
      }
    );
  }
}
