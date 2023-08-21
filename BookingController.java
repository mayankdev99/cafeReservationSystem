package cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cafe.entity.BookingEntity;
import cafe.service.BookingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public ResponseEntity<String> createBooking(@RequestBody BookingEntity bookingEntity) {
        if (bookingEntity.getBookingDate().toLocalDateTime() == null) {
            return ResponseEntity.badRequest().body("Booking date and time are required.");
        }

        BookingEntity savedBooking = bookingService.saveBooking(bookingEntity);
        return ResponseEntity.ok("Booking data stored successfully with ID: " + savedBooking.getId());
    }

    @GetMapping("/bookingslist")
    public ResponseEntity<List<BookingEntity>> getAllBookings() {
        List<BookingEntity> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/confirm-booking/{bookingId}")
    public ResponseEntity<String> confirmBooking(@PathVariable int bookingId) {
        ResponseEntity<String> response = bookingService.confirmBooking(bookingId);
        return response;
    }

    @PostMapping("/cancel-booking/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
        ResponseEntity<String> response = bookingService.cancelBooking(bookingId);
        return response;
    }
}

