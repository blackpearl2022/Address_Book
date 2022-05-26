package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program.");

        System.out.println("Enter the first name: ");
        Scanner sc1 = new Scanner(System.in);
        String first_name = sc1.next();

        System.out.println("Enter the last name: ");
        Scanner sc2 = new Scanner(System.in);
        String last_name = sc2.next();

        System.out.println("Enter the address: ");
        Scanner sc3 = new Scanner(System.in);
        String address = sc3.next();

        System.out.println("Enter the city name: ");
        Scanner sc4 = new Scanner(System.in);
        String city = sc4.next();

        System.out.println("Enter the state's name: ");
        Scanner sc5 = new Scanner(System.in);
        String state = sc5.next();

        System.out.println("Enter the zip: ");
        Scanner sc6 = new Scanner(System.in);
        String zip = sc6.next();

        System.out.println("Enter the phone number: ");
        Scanner sc7 = new Scanner(System.in);
        String phone_num = sc7.next();

        System.out.println("Enter the email ID: ");
        Scanner sc8 = new Scanner(System.in);
        String email = sc8.next();

        AddressBook addressBook = new AddressBook();
        addressBook.createContact(
                new Contact(first_name, last_name, address, city, state,
                        zip, phone_num, email));

        addressBook.displayContacts();
    }

}
