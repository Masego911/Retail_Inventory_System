import java.io.BufferedReader; // read files
import java.io.FileReader;     // open file
import java.lang.reflect.Method; // reflection
import java.util.ArrayList;    // dynamic list
import java.util.HashSet;      // track duplicates
import java.util.Random;       // randomness
import java.util.Scanner;

public class Main {

    InventorySystem inventorySystem = new InventorySystem();

    // ---------- LOAD PRODUCTS ----------
    public void loadProducts(String fileName)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            br.readLine(); // skip header

            HashSet<Integer> seenID = new HashSet<>();

            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(",");

                if (data.length != 6) continue;

                try
                {
                    int id = Integer.parseInt(data[0].trim());
                    if (!seenID.add(id)) continue;

                    String name = data[1].trim();
                    if (name.isEmpty()) continue;

                    String brand = data[2].trim();
                    if (brand.isEmpty()) brand = "Unknown";

                    String category = data[3].trim();
                    if (!category.isEmpty() && category.length() > 1)
                    {
                        category = category.substring(0,1).toUpperCase()
                                + category.substring(1).toLowerCase();
                    }

                    double price = Double.parseDouble(data[4].trim());
                    if (price <= 0) continue;

                    int quantity = Integer.parseInt(data[5].trim());
                    if (quantity < 0) quantity = 0;

                    Product p = new Product(id, name, brand, category, price, quantity);

                    inventorySystem.addProduct(p);
                }
                catch (Exception e)
                {
                    continue;
                }
            }

            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // ---------- LOAD CLIENTS ----------
    public ArrayList<Client> loadClients(String fileName)
    {
        ArrayList<Client> clients = new ArrayList<>();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            br.readLine(); // skip header

            HashSet<Integer> seenIDs = new HashSet<>();

            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(",");

                if (data.length != 6) continue;

                try
                {
                    int id = Integer.parseInt(data[0].trim());
                    if (!seenIDs.add(id)) continue;

                    String name = data[1].trim();
                    if (name.isEmpty()) continue;

                    String email = data[2].trim();
                    if (!email.contains("@") || !email.contains(".")) continue;

                    int age = Integer.parseInt(data[3].trim());
                    if (age < 18 || age > 100) continue;

                    String gender = data[4].trim();
                    if (gender.isEmpty()) gender = "Unknown";

                    String nationality = data[5].trim();
                    if (nationality.isEmpty()) nationality = "South African";

                    Client client = new Client(id, name, email, age, gender, nationality);

                    clients.add(client);
                }
                catch (Exception e)
                {
                    continue;
                }
            }

            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return clients;
    }

    // ---------- REFLECTION PAYMENT ----------
    public void processPayment(String paymentType, double amount)
    {
        try
        {
            Class clazz = Class.forName(paymentType);
            Object obj = clazz.newInstance();

            Method method = clazz.getMethod("processPayment", double.class);
            method.invoke(obj, amount);
        }
        catch (Exception e)
        {
            System.out.println("Payment failed");
        }
    }

    // ---------- SIMULATE TRANSACTIONS ----------
    public void simulateTransactions(ArrayList<Client> clients, int numberOfTransactions)
    {
        Random rand = new Random();

        for (int i = 0; i < numberOfTransactions; i++)
        {
            Client client = clients.get(rand.nextInt(clients.size()));

            Sale sale = new Sale();

            int numberOfItems = 1 + rand.nextInt(20);

            for (int j = 0; j < numberOfItems; j++)
            {
                int randomIndex = rand.nextInt(inventorySystem.size);

                Product product = inventorySystem.getProduct(randomIndex);

                if (product != null && product.getQuantity() > 0)
                {
                    sale.addItem(product);
                    inventorySystem.reduceStock(product.getProductID(), 1);
                }
            }

            double total = sale.calculateTotal();

            // ---------- FIX: skip empty sales ----------
            if (total == 0)
            {
                continue;
            }

            String[] paymentTypes = {"EFTPayment", "CardPayment"};
            String paymentType = paymentTypes[rand.nextInt(paymentTypes.length)];

            processPayment(paymentType, total);

            client.addSale(sale);
            int itemsBought = sale.getItems().size();

            System.out.println("Client ID: " + client.getClientID());
            System.out.println("Client Name: " + client.getName());
            System.out.println("Items Bought: " + itemsBought);
            System.out.println("Total Spent: " + CurrencyFormatter.format(total));
            System.out.println();
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args){

        Main app = new Main(); // create system
        Scanner scanner = new Scanner(System.in); // input reader

        // load data once
        app.loadProducts("products.txt");
        ArrayList<Client> clients = app.loadClients("clients.txt");

        System.out.println("System ready.");

        while (true) // menu loop
        {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Simulate Transactions");
            System.out.println("2. View Client History");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt(); // read user choice

            switch (choice)
            {
                case 1:
                    System.out.print("Enter number of transactions: ");
                    int num = scanner.nextInt();

                    app.simulateTransactions(clients, num); // run simulation
                    System.out.println("Simulation complete.");
                    break;

                case 2:
                    System.out.print("Enter client index (0 - " + (clients.size()-1) + "): ");
                    int index = scanner.nextInt();

                    if (index >= 0 && index < clients.size())
                    {
                        clients.get(index).displayHistory();
                    }
                    else
                    {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 3:
                    app.inventorySystem.displayInventoryList(); // show products
                    break;

                case 4:
                    System.out.println("Exiting system.");
                    scanner.close(); // close scanner
                    return; // exit program

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


}