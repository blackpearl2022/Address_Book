package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program.");

        Scanner sc1 = new Scanner(System.in);
        AddressBooks addressBooks = new AddressBooks();
        while (true) {
            System.out.println("1. Add Address Book");
            System.out.println("2. Display Address Books");
            System.out.println("3. Manage Contacts");
            int choice = sc1.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of ADDRESS BOOK to add : ");
                    String addressBookName = sc1.next();
                    addressBooks.createAddressBook(addressBookName);
                    break;
                case 2:
                    addressBooks.displayAddressBooks();
                    break;
                case 3:
                    System.out.println("Enter address book name to add contacts : ");
                    String bookName = sc1.next();
                    boolean addressBookExists = addressBooks.isAddressBookExists(bookName);
                    if (addressBookExists) {
                        addressBooks.manageContactsIn(bookName);
                    }
                    break;
            }
        }
    }
}
