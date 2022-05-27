package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program.");

        Scanner sc1 = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        addContacts(sc1, addressBook);

        addressBook.displayContacts();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter contact name to edit");
        String firstName = scanner.next();

        addressBook.editContact(firstName);

        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Enter contact name to delete");
        firstName = scanner.next();

        addressBook.deleteContact(firstName);

        addressBook.displayContacts();
    }

    private static void addContacts(Scanner sc1, AddressBook addressBook) {
        ArrayList<Contact> contacts = new ArrayList<>();
        System.out.println("Enter number of people you want to add to Address book");
        int numberOfPeople = sc1.nextInt();

        for (int i = 0; i < numberOfPeople; i++) {

            System.out.println("Enter the first name: ");
            String first_name = sc1.next();

            System.out.println("Enter the last name: ");
            String last_name = sc1.next();

            System.out.println("Enter the address: ");
            String address = sc1.next();

            System.out.println("Enter the city name: ");
            String city = sc1.next();

            System.out.println("Enter the state's name: ");
            String state = sc1.next();

            System.out.println("Enter the zip: ");
            String zip = sc1.next();

            System.out.println("Enter the phone number: ");
            String phone_num = sc1.next();

            System.out.println("Enter the email ID: ");
            String email = sc1.next();

            Contact contact = new Contact(first_name, last_name, address, city, state, zip, phone_num, email);
            contacts.add(contact);

        }
        addressBook.createContact(contacts);
    }

}
