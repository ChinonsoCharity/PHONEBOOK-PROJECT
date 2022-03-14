package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBook.dto.request.AddContactRequest;
import africa.semicolon.phoneBook.dto.response.ContactResponse;
import africa.semicolon.phoneBook.dto.response.FindContactResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
    ContactRepository contactRepository;

    @BeforeEach
    public void setup() {
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    public void contactCanBeAddedTest() {
        ContactService contactService = new ContactServiceImpl();
        AddContactRequest request = new AddContactRequest();
        request.setFirstName("ven");
        request.setLastName("adams");
        request.setMiddleName("james");
        request.setOffice("NNPC");
        request.setMobile("23456");
        ContactResponse response = contactService.saveContact(request);

        assertEquals(1, contactService.getRepository().count());
        assertEquals("Contact Saved",response.getMessage());
    }

    @Test
    public void findContactByNameTest() {
        ContactService contactService = new ContactServiceImpl();
        AddContactRequest request = new AddContactRequest();
        request.setFirstName("ven");
        request.setLastName("adams");
        request.setMiddleName("james");
        request.setOffice("NNPC");
        request.setMobile("23456");
        contactService.saveContact(request);

        AddContactRequest request2 = new AddContactRequest();
        request2.setFirstName("vin");
        request2.setLastName("joel");
        request2.setMiddleName("john");
        request2.setOffice("CBN");
        request2.setMobile("56879");
        contactService.saveContact(request2);

        AddContactRequest request3 = new AddContactRequest();
        request3.setFirstName("van");
        request3.setLastName("steve");
        request3.setMiddleName("peter");
        request3.setOffice("UBA");
        request3.setMobile("98765 ");
        contactService.saveContact(request3);

        FindContactResponse response = contactService.findContactByName("joel");

        assertEquals("vin", response.getFirstName());
        assertEquals("CBN", response.getOffice());



    }

    @Test
    public void deleteContactTest() {
        ContactService contactService = new ContactServiceImpl();
        AddContactRequest request = new AddContactRequest();
        request.setFirstName("ven");
        request.setLastName("adams");
        request.setMiddleName("james");
        request.setOffice("NNPC");
        request.setMobile("23456");
        contactService.saveContact(request);

        AddContactRequest request2 = new AddContactRequest();
        request2.setFirstName("vin");
        request2.setLastName("joel");
        request2.setMiddleName("john");
        request2.setOffice("CBN");
        request2.setMobile("56879");
        contactService.saveContact(request2);

        AddContactRequest request3 = new AddContactRequest();
        request3.setFirstName("van");
        request3.setLastName("steve");
        request3.setMiddleName("peter");
        request3.setOffice("UBA");
        request3.setMobile("98765 ");
        contactService.saveContact(request3);
        assertEquals(3,contactService.getRepository().count());


        ContactResponse response = contactService.deleteContact("joel", "56879");
        assertEquals(2,contactService.getRepository().count());
        assertEquals("Contact Deleted",response.getMessage());



    }
}