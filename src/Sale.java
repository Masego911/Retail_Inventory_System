import java.util.ArrayList;

public class Sale {
    ArrayList<Product> item =new ArrayList<>();



    public Sale()
    {
        item =new ArrayList<>();
    }

    public void addItem(Product product)
    {
        item.add(product);
    }


    public double calculateTotal()
    {
        double total=0;
        for (Product product: item)
        {
            total+=product.getPrice();
        }
        return total;
    }


    public ArrayList<Product> getItems()
    {
        return item;
    }
    public void displaySale()
    {


        for (Product p : item) {
            System.out.println(p.getName() + " - R" + p.getPrice());
        }

        System.out.println("Total: R" + calculateTotal());
    }

}


