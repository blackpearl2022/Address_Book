package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private static final List<Contact> contacts = new ArrayList<>();

    public void createContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (int i = 0; i < contacts.size(); i++) {

            Contact contact = contacts.get(i);
            System.out.println("first name="+ contact.getFirstName());
            System.out.println("Last name="+ contact.getLastName());
            System.out.println("address="+ contact.getAddress());
            System.out.println("City name="+ contact.getCity());
            System.out.println("State name="+ contact.getState());
            System.out.println("zip code="+ contact.getZip());
            System.out.println("Phone number="+ contact.getPhoneNumber());
            System.out.println("Email="+ contact.getEmail());
        }
    }

    public void editContact(String firstName) {

        Scanner sc1 = new Scanner(System.in);

        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getFirstName().equals(firstName)){

                System.out.println("Enter the name to edit First name");
                String newFirstName = sc1.next();

                System.out.println("Enter the name to edit Last name");
                String newLastName = sc1.next();

                System.out.println("Enter the name to edit Address");
                String newAddress = sc1.next();

                System.out.println("Enter the name to edit City name");
                String newCity = sc1.next();

                System.out.println("Enter the name to edit State name");
                String newState = sc1.next();

                System.out.println("Enter the name to edit Zip code");
                String newZip = sc1.next();

                System.out.println("Enter the name to edit Phone Number");
                String newPhoneNumber = sc1.next();

                System.out.println("Enter the name to edit Email");
                String newEmail = sc1.next();
            }
            else {
                System.out.println("Contact to edit not found");
            }
        }
    }
}
