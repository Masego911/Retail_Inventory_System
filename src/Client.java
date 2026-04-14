import java.util.ArrayList;

public class Client {

    private int clientID;
    private String name;
    private String email;
    private int age;
    private String gender;
    private String nationality;

    private ArrayList<Sale> purchaseHistory = new ArrayList<>();

    public Client(int clientID, String name, String email, int age, String gender, String nationality) {

        this.clientID = clientID;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
    }


    public void addSale(Sale sale)
    {
        purchaseHistory.add(sale);
    }

    public double getTotalSpent()
    {
        double totalSpent = 0;

        for (Sale sale : purchaseHistory)
        {
            totalSpent += sale.calculateTotal();
        }

        return totalSpent;
    }

    public int getClientID() { return clientID; }
    public void setClientID(int clientID) { this.clientID = clientID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ArrayList<Sale> getPurchaseHistory() { return purchaseHistory; }
    public void setPurchaseHistory(ArrayList<Sale> purchaseHistory) { this.purchaseHistory = purchaseHistory; }

    public void displayHistory() {

        System.out.println("Client ID: " + clientID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("------ Purchase History ------");

        for (Sale sale : purchaseHistory) {
            sale.displaySale();
            System.out.println("-----------------------------");
        }

        System.out.println("Total Spent: R" + getTotalSpent());
    }

    public int getNumberOfPurchases() {
        return purchaseHistory.size();
    }

    public void displaySummary() {
        System.out.println(name + " | Purchases: " + getNumberOfPurchases() + " | Total Spent: R" + getTotalSpent());
    }
}