package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private static final List<Contact> contacts = new ArrayList<>();

    public void createContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (int i = 0; i < contacts.size(); i++) {

            System.out.println("first name="+contacts.get(i).getFirstName());
            System.out.println("Last name="+contacts.get(i).getLastName());
            System.out.println("address="+contacts.get(i).getAddress());
            System.out.println("City name="+contacts.get(i).getCity());
            System.out.println("State name="+contacts.get(i).getState());
            System.out.println("zip code="+contacts.get(i).getZip());
            System.out.println("Phone number="+contacts.get(i).getPhoneNumber());
            System.out.println("Email="+contacts.get(i).getEmail());
        }
    }
}
