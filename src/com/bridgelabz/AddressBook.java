package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private static final List<Contact> contacts = new ArrayList<>();

    public void createContact(Contact contact) {
        contacts.add(contact);
    }
}
