import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { formatDate } from '@angular/common';


@Component({
  selector: 'app-bookatable',
  templateUrl: './bookatable.component.html',
  styleUrls: ['./bookatable.component.css']
})
export class BookatableComponent implements OnInit {

  booking: BookingEntity = {
    name: '',
    email: '',
    phoneNumber: '',
    bookingDate: new Date(), // Initialize with a Date object
    numberOfPeople: '',
    tableChoice: '',
    message: ''
  };

  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  ngOnInit(): void {
  }

  submitForm(): void {
    const formattedDate = this.datePipe.transform(this.booking.bookingDate, 'yyyy-MM-ddTHH:mm:00.000Z');

    if (formattedDate) {
      this.booking.bookingDate = new Date(formattedDate);
    } else {
      // Handle the case where formattedDate is null, e.g., provide a default value or show an error message
      console.error('Date is not in the correct format.');
    }
    
    this.http.post('http://localhost:11000/api/booking', this.booking, { responseType: 'text' })
      .subscribe(
        (response) => {
          console.log('Booking created:', response);
          // Clear the form or perform other actions after successful submission
          this.clearForm();
          // Display a success alert
          window.alert('Booking done');
        },
        (error) => {
          console.error('Error creating booking:', error.error);
          // Display an error alert
          window.alert('Booking failed');
        }
      );
  }

  private clearForm(): void {
    this.booking = {
      name: '',
      email: '',
      phoneNumber: '',
      bookingDate: new Date(), // Initialize with a Date object
      numberOfPeople: '',
      tableChoice: '',
      message: ''
    };
  }
}

interface BookingEntity {
  name: string;
  email: string;
  phoneNumber: string;
  bookingDate: Date; // Change type to Date
  numberOfPeople: string;
  tableChoice: string;
  message: string;
}
