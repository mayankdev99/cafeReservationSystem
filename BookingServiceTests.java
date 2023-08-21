package cafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import cafe.entity.BookingEntity;
import cafe.repository.BookingRepository;
import cafe.service.BookingService;

class BookingServiceTests {

    private BookingService bookingService;
    private BookingRepository bookingRepo;

    @BeforeEach
    void setUp() {
        bookingRepo = mock(BookingRepository.class);
        bookingService = new BookingService(bookingRepo);
    }

    @Test
    void testSaveBooking() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setId(1);
        when(bookingRepo.save(any(BookingEntity.class))).thenReturn(bookingEntity);

        BookingEntity savedBooking = bookingService.saveBooking(bookingEntity);

        assertNotNull(savedBooking);
        assertEquals(1, savedBooking.getId());
    }

    @Test
    void testGetAllBookings() {
        List<BookingEntity> bookings = new ArrayList<>();
        bookings.add(new BookingEntity());
        when(bookingRepo.findAll()).thenReturn(bookings);

        List<BookingEntity> retrievedBookings = bookingService.getAllBookings();

        assertNotNull(retrievedBookings);
        assertEquals(1, retrievedBookings.size());
    }

    @Test
    void testConfirmBooking() {
        int bookingId = 1;
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setId(bookingId);
        when(bookingRepo.findById(bookingId)).thenReturn(Optional.of(bookingEntity));
        when(bookingRepo.save(any(BookingEntity.class))).thenReturn(bookingEntity);

        ResponseEntity<String> response = bookingService.confirmBooking(bookingId);

        assertNotNull(response);
        assertEquals("Booking confirmed successfully.", response.getBody());
    }

    @Test
    void testCancelBooking() {
        int bookingId = 1;
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setId(bookingId);
        when(bookingRepo.findById(bookingId)).thenReturn(Optional.of(bookingEntity));
        when(bookingRepo.save(any(BookingEntity.class))).thenReturn(bookingEntity);

        ResponseEntity<String> response = bookingService.cancelBooking(bookingId);

        assertNotNull(response);
        assertEquals("Booking cancelled successfully.", response.getBody());
    }
}
