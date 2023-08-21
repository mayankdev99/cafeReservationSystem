package cafe;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import cafe.entity.ContactUs;
import cafe.repository.ContactRepository;
import cafe.service.ContactService;

@SpringBootTest
class ContactServiceTests {

    private ContactService contactService;
    private ContactRepository contactRepo;

    @BeforeEach
    void setUp() {
        contactRepo = mock(ContactRepository.class);
        contactService = new ContactService(contactRepo);
    }

    @Test
    void testCreateContact() {
        ContactUs contact = new ContactUs();
        // Set properties of the contact object
        // ...

        when(contactRepo.save(any(ContactUs.class))).thenReturn(contact);

        ContactUs createdContact = contactService.createContact(contact);

        assertNotNull(createdContact);
     
    }
    
   
}

