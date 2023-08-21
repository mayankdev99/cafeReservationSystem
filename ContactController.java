package cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cafe.entity.ContactUs;
import cafe.service.ContactService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    // Create
    @PostMapping
    public ContactUs createContact(@RequestBody ContactUs contact) {
        return contactService.createContact(contact);
    }
}
