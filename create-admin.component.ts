import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-create-admin',
  templateUrl: './create-admin.component.html',
  styleUrls: ['./create-admin.component.css']
})
export class CreateAdminComponent implements OnInit {
  public createAdminForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private http: HttpClient) { }

  ngOnInit(): void {
    this.createAdminForm = this.formBuilder.group({
      admin: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.createAdminForm.valid) {
      this.createAdmin();
    }
  }

  createAdmin() {
    const newAdminData = this.createAdminForm.value;
    this.http.post<any>('http://localhost:11000/admin', newAdminData).subscribe(
      (response) => {
        alert('Admin account created successfully!');
        this.createAdminForm.reset();
      },
      (error) => {
        alert('Error creating admin account. Please try again.');
      }
    );
  }
}
