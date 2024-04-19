public class SalesRepresentative {
    private int salesRepID;
    private ContactInformation contactInfo;

    public SalesRepresentative(int salesRepID, ContactInformation contactInfo) {
        this.salesRepID = salesRepID;
        this.contactInfo = contactInfo;
    }

    public int getSalesRepID() {
        return salesRepID;
    }

    public ContactInformation getContactInformation() {
        return contactInfo;
    }
}