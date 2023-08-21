package cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cafe.entity.BookingEntity;
import cafe.repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepo;

    @Autowired
    public BookingService(BookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public BookingEntity saveBooking(BookingEntity bookingEntity) {
        return bookingRepo.save(bookingEntity);
    }

    public List<BookingEntity> getAllBookings() {
        return (List<BookingEntity>) bookingRepo.findAll();
    }

    public ResponseEntity<String> confirmBooking(int bookingId) {
        Optional<BookingEntity> bookingOptional = bookingRepo.findById(bookingId);

        if (bookingOptional.isPresent()) {
            BookingEntity bookingEntity = bookingOptional.get();
            bookingEntity.setStatus("Confirmed");
            bookingRepo.save(bookingEntity);

            return ResponseEntity.ok("Booking confirmed successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> cancelBooking(int bookingId) {
        Optional<BookingEntity> bookingOptional = bookingRepo.findById(bookingId);

        if (bookingOptional.isPresent()) {
            BookingEntity bookingEntity = bookingOptional.get();
            bookingEntity.setStatus("Cancelled");
            bookingRepo.save(bookingEntity);

            return ResponseEntity.ok("Booking cancelled successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



