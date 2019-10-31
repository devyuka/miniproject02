import java.util.ArrayList;

public class ContactList {
    private ArrayList < Contact > contacts;
    private boolean isDuplicate = false;

    public ContactList() {
        contacts = new ArrayList < Contact > ();
    }

    public void addContact(Contact newContact) {
        for (Contact contact: getAllContacts()) {
            if (contact.equals(newContact)) {
                System.out.println("\n" + contact.getContactName() + " (" + contact.getContactPhone() + ") is already registered.");
                Contact.setCount((Contact.getCount()) - 1);
                isDuplicate = true;
                return;
            }
        }
        contacts.add(newContact);
        isDuplicate = false;
    }

    public void showAllContacts() {
        if (!getAllContacts().isEmpty()) {
            System.out.print("\n");
            for (Contact contact: getAllContacts()) {
                System.out.println(contact.getId() + ". " + "<" + contact.getContactName() + "> " +
                        "(mobile= " + contact.getContactPhone() +
                        ((!contact.getContactWork().isEmpty()) ? ", work= " + contact.getContactWork() : "") +
                        ((!contact.getContactHome().isEmpty()) ? ", home= " + contact.getContactHome() : "") +
                        ((!contact.getContactCity().isEmpty()) ? ", city= " + contact.getContactCity() : "") + ")");
            }
            System.out.print("\n");
        } else {
            System.out.println("\nSorry, there is no contact...\n");
        }
    }

    public void showIndividualContact(int contactIndex) {
        Contact contact = this.getAllContacts().get(contactIndex);
        System.out.print("\n" + "<name>" + contact.getContactName() + "\n");
        System.out.print("<phone>" + contact.getContactPhone() + "\n");
        System.out.print(((!contact.getContactWork().isEmpty()) ? "<work>" + contact.getContactWork() + "\n" : ""));
        System.out.print(((!contact.getContactHome().isEmpty()) ? "<home>" + contact.getContactHome() + "\n" : ""));
        System.out.print(((!contact.getContactCity().isEmpty()) ? "<city>" + contact.getContactCity() + "\n" : "") + "\n");
    }

    public void removeContact(int contactIndex) {
        this.getAllContacts().remove(contactIndex);
        System.out.println("Index [" + contactIndex + "] was removed.");
        for (Contact contact: this.getAllContacts()) {
            if (contact.getId() > contactIndex) {
                contact.setId(contact.getId() - 1);
            }
        }
        Contact.setCount((Contact.getCount()) - 1);
    }

    public void updateContact(int contactIndex, String contactName, String contactPhone, String contactWork, String contactHome, String contactCity) {
        Contact contact = this.getAllContacts().get(contactIndex);
        contact.setContactName(contactName);
        contact.setContactPhone(contactPhone);
        contact.setContactWork(contactWork);
        contact.setContactHome(contactHome);
        contact.setContactCity(contactCity);
    }

    public ArrayList < Contact > getAllContacts() {
        return contacts;
    };

    public void setContacts(ArrayList < Contact > contacts) {
        this.contacts = contacts;
    }

    public boolean isDuplicate() {
        return isDuplicate;
    }

    public void setDuplicate(boolean duplicate) {
        isDuplicate = duplicate;
    }
}