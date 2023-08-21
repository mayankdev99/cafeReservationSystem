import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  reservations: BookingEntity[] = []; // This will hold the retrieved reservations

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getReservations();
  }

  getReservations(): void {
    this.http.get<BookingEntity[]>('http://localhost:11000/api/bookingslist')
      .subscribe(
        (reservations) => {
          this.reservations = reservations;
        },
        (error) => {
          console.error('Error fetching reservations:', error);
        }
      );
  }
  confirmBooking(bookingId: number): void {
    this.http.post('http://localhost:11000/api/confirm-booking/' + bookingId, {})
      .subscribe(
        () => {
          // Reload the page after successful confirmation
          window.location.reload();
        },
        (error) => {
          console.error('Error confirming booking:', error);
          window.location.reload();
        }
      );
  }
  

  cancelBooking(bookingId: number): void {
    this.http.post<any>(`http://localhost:11000/api/cancel-booking/${bookingId}`, {})
      .subscribe(
        () => {
          // Reload the page after successful cancellation
          window.location.reload();
        },
        (error) => {
          console.error('Error cancelling booking:', error);
          window.location.reload();
        }
      );
  }

}

interface BookingEntity {
  id: number;
  name: string;
  email: string;
  phoneNumber: string;
  bookingDate: Date;
  numberOfPeople: number;
  message: string;
  time: string;
  status: string;  
  tableChoice: string;                                                                                                  
  confirmBooking: string;
}


