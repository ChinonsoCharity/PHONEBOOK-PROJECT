package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.dto.request.AddContactRequest;
import africa.semicolon.phoneBook.dto.response.ContactResponse;
import africa.semicolon.phoneBook.dto.response.FindContactResponse;

public interface ContactService {
    ContactResponse saveContact(AddContactRequest request);

    ContactRepository getRepository();


    FindContactResponse findContactByName(String name);
    ContactResponse deleteContact(String name, String mobile);
}
