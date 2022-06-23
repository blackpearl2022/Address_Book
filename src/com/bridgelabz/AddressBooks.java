package com.bridgelabz;

import java.util.*;

public class AddressBooks {

    private final HashMap<String, AddressBook> addressBooks = new HashMap<>();

    public void createAddressBook(String addressBookName) {
        addressBooks.put(addressBookName, new AddressBook());
        System.out.println("Added Address book with name : " + addressBookName);
    }

    public void displayAddressBooks() {
        System.out.println("List of address books available :");
        Set<String> addressBooksKey = addressBooks.keySet();
        if (addressBooksKey.isEmpty()){
            System.out.println("No address book present Please create one !!");
        }
        addressBooksKey.forEach(address -> System.out.println("* " + address));
    }

    public boolean isAddressBookExists(String bookName) {
        return addressBooks.containsKey(bookName);
    }

    public void manageContactsIn(String bookName) {
        AddressBook addressBook = addressBooks.get(bookName);

        while (true) {
            addressBook.takingChoice();
            switch (addressBook.operationChoice) {

                case AddressBook.ADD_CONTACTS:
                    addContacts(addressBook);
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

    private void addContacts(AddressBook addressBook) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of people you want to add to Address book");
        int numberOfPeople = scanner.nextInt();

        for (int i = 0; i < numberOfPeople; i++) {

            System.out.println("Enter the first name: ");
            String first_name = scanner.next();

            System.out.println("Enter the last name: ");
            String last_name = scanner.next();

            System.out.println("Enter the address: ");
            String address = scanner.next();

            System.out.println("Enter the city name: ");
            String city = scanner.next();

            System.out.println("Enter the state's name: ");
            String state = scanner.next();

            System.out.println("Enter the zip: ");
            String zip = scanner.next();

            System.out.println("Enter the phone number: ");
            String phone_num = scanner.next();

            System.out.println("Enter the email ID: ");
            String email = scanner.next();

            Contact contact = new Contact(first_name, last_name, address, city, state, zip, phone_num, email);
            contacts.add(contact);
        }
        addressBook.createContact(contacts);
    }
}
