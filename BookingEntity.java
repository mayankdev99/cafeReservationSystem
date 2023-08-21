package cafe.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;



import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "table_booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "booking_date", nullable = false)
    private Timestamp bookingDate; // Change to Timestamp
    
  

	@Column(name = "number_of_people", nullable = false)
    private int numberOfPeople;

    @Column(name = "message")
    private String message;
   

	@Column(name = "tableChoice")
    private String tableChoice;

    @Column(name = "status", nullable = false)
    private String status = "Pending";
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	  public Timestamp getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(Timestamp bookingDate) {
			this.bookingDate = bookingDate;
		}
		

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	  public String getTableChoice() {
			return tableChoice;
		}

		public void setTableChoice(String tableChoice) {
			this.tableChoice = tableChoice;
		}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

   

	