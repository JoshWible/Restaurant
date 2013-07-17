import java.util.ArrayList;

public class Order{
    private static int numberOfOrders = 0;  //keeps track of how many orders have been processed
    private int orderNumber;            //prioritizes when orders are sent out
    private int tableNumber;
    private ArrayList<OrderedItem> orderedItems;
    private boolean orderComplete;
    private boolean orderCooked;
    
    public Order(int tableNumber){
        this.tableNumber = tableNumber;
        orderNumber = numberOfOrders;
        numberOfOrders++;
        orderedItems = new ArrayList<OrderedItem>();
        orderComplete = false;
        orderCooked = false;
    }
    
    public void addItem(Item item){
        OrderedItem orderedItem = new OrderedItem(item, orderNumber);
        orderedItems.add(orderedItem);
    }
    
    public void removeItem(OrderedItem orderedItem){
        orderedItems.remove(orderedItem);
    }
    
    public ArrayList<OrderedItem> getOrder(){
        return orderedItems;
    }
    
    public int getOrderNumber(){
        return orderNumber;
    }
    
    public int getTableNumber(){
        return tableNumber;
    }
    
    public void completeOrder(){
        orderComplete = true;
    }
    
    public void cookOrder(){
        orderCooked = true;
    }
}