public class InventorySystem {

    Product[] inventoryIndex = new Product[150]; // array storage
    int size = 0; // number of actual products

    public void addProduct(Product product)
    {
        if (size == inventoryIndex.length)
        {
            resizeArray(); // expand capacity
        }

        inventoryIndex[size] = product; // insert product
        size++; // update count
    }

    private void resizeArray()
    {
        Product[] newInventoryIndex = new Product[inventoryIndex.length * 2]; // double capacity

        // copy only actual elements
        for (int i = 0; i < size; i++)
        {
            newInventoryIndex[i] = inventoryIndex[i];
        }

        inventoryIndex = newInventoryIndex; // replace old array
    }

    public Product getProduct(int index)
    {
        // correct boundary check
        if (index < 0 || index >= size)
        {
            return null;
        }

        return inventoryIndex[index];
    }

    public void displayInventoryList()
    {
        // loop through actual stored products only
        for (int i = 0; i < size; i++)
        {
            System.out.println(inventoryIndex[i]);
        }
    }

    public void reduceStock(int productID, int quantitySold)
    {
        for (int i = 0; i < size; i++)
        {
            if (inventoryIndex[i].getProductID() == productID)
            {
                int currQuantity = inventoryIndex[i].getQuantity();

                if (currQuantity >= quantitySold)
                {
                    inventoryIndex[i].setQuantity(currQuantity - quantitySold);
                }
                else
                {
                    System.out.println("Not enough stock for product: "
                            + inventoryIndex[i].getName()
                            + " (Remaining: " + currQuantity + ")");
                }

                return;
            }
        }

        System.out.println("Product not found");
    }
}