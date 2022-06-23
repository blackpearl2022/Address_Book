package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    static final int ADD_CONTACTS = 1;
    static final int PRINT_CONTACTS = 2;
    static final int EDIT_CONTACT = 3;
    static final int DELETE_CONTACT = 4;
    static final int EXIT = 5;

    Scanner sc1 = new Scanner(System.in);
    int operationChoice;


    private static final List<Contact> contacts = new ArrayList<>();

    public void createContact(ArrayList<Contact> contact) {
        contacts.addAll(contact);
    }

    public void displayContacts() {
        for (int i = 0; i < contacts.size(); i++) {

            Contact contact = contacts.get(i);
            System.out.println("first name=" + contact.getFirstName());
            System.out.println("Last name=" + contact.getLastName());
            System.out.println("address=" + contact.getAddress());
            System.out.println("City name=" + contact.getCity());
            System.out.println("State name=" + contact.getState());
            System.out.println("zip code=" + contact.getZip());
            System.out.println("Phone number=" + contact.getPhoneNumber());
            System.out.println("Email=" + contact.getEmail());
        }
    }

    public void editContact() {
        System.out.println("Enter contact name to edit");
        String firstName = sc1.next();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(firstName)) {

                System.out.println("Enter the name to edit First name");
                String newFirstName = sc1.next();
                contacts.get(i).setFirstName(newFirstName);

                System.out.println("Enter the name to edit Last name");
                String newLastName = sc1.next();
                contacts.get(i).setLastName(newLastName);

                System.out.println("Enter the name to edit Address");
                String newAddress = sc1.next();
                contacts.get(i).setAddress(newAddress);

                System.out.println("Enter the name to edit City name");
                String newCity = sc1.next();
                contacts.get(i).setCity(newCity);

                System.out.println("Enter the name to edit State name");
                String newState = sc1.next();
                contacts.get(i).setState(newState);

                System.out.println("Enter the name to edit Zip code");
                String newZip = sc1.next();
                contacts.get(i).setZip(newZip);

                System.out.println("Enter the name to edit Phone Number");
                String newPhoneNumber = sc1.next();
                contacts.get(i).setPhoneNumber(newPhoneNumber);

                System.out.println("Enter the name to edit Email");
                String newEmail = sc1.next();
                contacts.get(i).setEmail(newEmail);
            } else {
                System.out.println("Contact to edit not found");
            }
        }
    }

    public void deleteContact() {
        System.out.println("Enter contact name to delete");
        String firstName = sc1.next();

        for (int i = 0; i < contacts.size(); i++) {

            if (contacts.get(i).getFirstName().equals(firstName)) {
                contacts.remove(i);
            }
        }
    }

    public void takingChoice() {
        choicePrinting();
        System.out.println("Enter your Choice : ");
        Scanner choice = new Scanner(System.in);
        operationChoice = choice.nextInt();
    }

    private void choicePrinting() {
        System.out.println("1. Adding a new contact.");
        System.out.println("2. Displaying contact.");
        System.out.println("3. Editing a contact.");
        System.out.println("4. Deleting a contact.");
    }
}