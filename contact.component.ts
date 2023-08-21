import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  private backendBaseUrl = 'http://localhost:11000'; // Update with your Spring Boot backend URL
  userMessage: string = '';
  confirmationText: string = '';

  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  sendConfirmationToBackend() {
      const messageData = { message: this.userMessage }; // Create a message object

      this.http.post(`${this.backendBaseUrl}/api/contacts`, messageData)
          .subscribe(
              () => {
                  this.confirmationText = 'Message sent successfully';
              },
              (error) => {
                  console.error('Error sending message:', error);
                  this.confirmationText = 'Error sending message';
              }
          );
  }
}





