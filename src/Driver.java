public class Driver {

    public static void main(String[] args) {
        String contactName = null;
        String contactPhone = null;
        String contactWork = null;
        String contactHome = null;
        String contactCity = null;
        int contactIndex = 0;

        String menu = "+=== [Contact App] ====+\n" +
                "| 1. List All Contacts |\n" +
                "| 2. Add New Contact   |\n" +
                "| 3. Remove Contact    |\n" +
                "| 4. Update Contact    |\n" +
                "| 5. Quit              |\n" +
                "+======================+\n";

        ContactList contactList = new ContactList();

        for (int i = 0; i < FakeContacts.NUM_OF_FAKE_CONTACTS; i++) {
            contactList.addContact(FakeContacts.FAKE_CONTACTS_LIST[i]);
        }

        while (true) {
            System.out.println(menu);
            String userOption = InputCollector.getUserInput("Enter your option: ", "optionNum", true);

            switch (userOption) {
                case "1":
                    contactList.showAllContacts();
                    break;

                case "2":
                    contactName = InputCollector.getUserInput("Enter name*: ", "string", true);
                    contactPhone = InputCollector.getUserInput("Enter phone*: ", "phoneNum", true);
                    contactWork = InputCollector.getUserInput("Enter work: ", "phoneNum", false);
                    contactHome = InputCollector.getUserInput("Enter home: ", "phoneNum", false);
                    contactCity = InputCollector.getUserInput("Enter city: ", "phoneNum", false);
                    contactList.addContact(new Contact(contactName, contactPhone, contactWork, contactHome, contactCity));
                    System.out.println((!contactList.isDuplicate()) ? "\nThe contact was successfully added!\n" : "");
                    break;

                case "3":
                    contactIndex = Integer.parseInt(InputCollector.getUserInput("Enter the index of contact you want to remove: ", "indexNum", true));
                    contactList.showIndividualContact(contactIndex);
                    String finalConfirmation = InputCollector.getUserInput("Are you sure you want to delete this contact? (Y/N): ", "yn", true);

                    if (finalConfirmation.equals("N") || finalConfirmation.equals("n")) {
                        System.out.println("\nOK! I won't delete this contact.\n");
                    } else if (finalConfirmation.equals("Y") || finalConfirmation.equals("y")) {
                        contactList.removeContact(contactIndex);
                        System.out.println("\nThe contact was successfully removed!\n");
                    }
                    break;

                case "4":
                    contactIndex = Integer.parseInt(InputCollector.getUserInput("Enter the index of contact you want to update: ", "indexNum", true));
                    contactList.showIndividualContact(contactIndex);

                    contactName = InputCollector.getUserInput("Enter name*: ", "string", true);
                    contactPhone = InputCollector.getUserInput("Enter phone*: ", "phoneNum", true);
                    contactWork = InputCollector.getUserInput("Enter work: ", "phoneNum", false);
                    contactHome = InputCollector.getUserInput("Enter home: ", "phoneNum", false);
                    contactCity = InputCollector.getUserInput("Enter city: ", "phoneNum", false);
                    contactList.updateContact(contactIndex, contactName, contactPhone, contactWork, contactHome, contactCity);
                    System.out.println("\nThe contact was successfully updated!\n");
                    contactList.showIndividualContact(contactIndex);
                    break;

                case "5":
                    System.out.println("\nBye Bye!\n");
                    return;
            }
        }
    }
}