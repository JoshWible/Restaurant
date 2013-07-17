import java.util.ArrayList;

public class Order
{
    private ArrayList<Item> orderedItems;

    /**
     * Constructor for objects of class Order
     */
    public Order(int tableNumber)
    {
        orderedItems = new ArrayList<Item>();
    }
    
    public void add(Item item)
    {
        orderedItems.add(item);
        System.out.println(item + "added to Order");
    }
    
}
