package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program.");

        Scanner sc1 = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        while (true) {
            addressBook.takingChoice();
            switch (addressBook.operationChoice) {
                case AddressBook.ADD_CONTACTS:
                    addressBook.addContacts(addressBook);
                    break;
                case AddressBook.PRINT_CONTACTS:
                    addressBook.displayContacts();
                    break;
                case AddressBook.EDIT_CONTACT:
                    addressBook.editContact();
                    break;
                case AddressBook.DELETE_CONTACT:
                    addressBook.deleteContact();
                    break;
                case AddressBook.EXIT:
                    System.out.println("Program ENDs");
                    return;
                default:
                    System.out.println("Please Enter correct input !");
                    break;
            }
        }
    }
}

