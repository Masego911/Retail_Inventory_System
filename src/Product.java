public class Product {


    private int productID;      // unique identifier
    private String name;        // product name
    private String brand;       // brand (NEW)
    private String category;    // category
    private double price;       // price
    private int quantity;       // stock

    // UPDATED constructor (matches dataset)
    public Product(int productID, String name, String brand, String category, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return String.format(
                "Product ID: %d\nName: %s\nBrand: %s\nCategory: %s\nPrice: R%.2f\nQuantity: %d\n----------------------------------------",
                productID,
                name,
                brand,
                category,
                price,
                quantity
        );
    }
}
