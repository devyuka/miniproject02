import java.util.Objects;

public class Contact {
    private String contactName;
    private String contactPhone;
    private String contactWork;
    private String contactHome;
    private String contactCity;
    private static int count;
    private int id;

    public Contact(String contactName, String contactPhone) {
        this(contactName, contactPhone, "", "", "");
    }

    public Contact(String contactName, String contactPhone, String contactWork) {
        this(contactName, contactPhone, contactWork, "", "");
    }

    public Contact(String contactName, String contactPhone, String contactWork, String contactHome) {
        this(contactName, contactPhone, contactWork, contactHome, "");
    }

    public Contact(String contactName, String contactPhone, String contactWork, String contactHome, String contactCity) {
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactWork = contactWork;
        this.contactHome = contactHome;
        this.contactCity = contactCity;
        this.id = count;
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactName, contact.contactName) &&
                Objects.equals(contactPhone, contact.contactPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactName, contactPhone);
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactWork() {
        return contactWork;
    }

    public void setContactWork(String contactWork) {
        this.contactWork = contactWork;
    }

    public String getContactHome() {
        return contactHome;
    }

    public void setContactHome(String contactHome) {
        this.contactHome = contactHome;
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String contactCity) {
        this.contactCity = contactCity;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public static void setCount(int count) {
        Contact.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }
}