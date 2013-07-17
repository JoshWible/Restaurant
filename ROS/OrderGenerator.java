import java.util.Random;
import java.util.ArrayList;

/**
 * Generates Menu index values for an order
 *  is used by the controller
 */
public class OrderGenerator implements Actor
{
    //class varibles
    private static Menu menu;
    private static Randomizer rand;
    private static Kitchen kitchen;
    private static CustomerInvoice invoice;

    /*
     * These probably shouldn't exist here 
     * 
     * Possible fixes have a loop in Simulator, while there are still orders 
     * to be generated (create a method::boolean), recieve order from order 
     * generator, then give order to both the CustomerInvoice and Kitchen
     */

    //instance variables
    private ArrayList<Item> currentMenuItems;//????
    private boolean autoOrder;

    // Constructors
    /**
     * Default constructor will use automatically generated orders
     */
    public OrderGenerator(Menu menu, Kitchen kitchen, CustomerInvoice invoice)
    {
        this(true, menu,kitchen, invoice);
    }

    /**
     * Initializes the all powerful ROS operator
     * 
     * @param autoOrder if True, class will use Randomizer to create random orders.
     */
    public OrderGenerator(boolean autoOrder, Menu menu, Kitchen kitchen, CustomerInvoice invoice)
    {
        
            this.autoOrder = autoOrder;
            this.menu = menu;
            this.kitchen = kitchen;
            this.invoice = invoice;
        
        currentMenuItems = menu.getMenu();
        rand = new Randomizer();

    }
    //Methods
    /**
     *  Acts!
     */
    public void act()
    {
            //Number of orders being placed
            int numberOfOrders = rand.getNumberOfOrders();
            for(int i = 0 ; i < numberOfOrders; i++){
                Order currentOrder = new Order(rand.getTableNumber());
                buildOrder(currentOrder);
                System.out.println("Order built");
                kitchen.recieveOrder(currentOrder);
                invoice.recieveOrder(currentOrder);
            }          
    }   

    /**
     * Uses orderGen to randomly select items from an order
     */
    private void buildOrder(Order order)
    { 
        //Number of items being added to each order
        int numberOfItems = rand.getNumberOfItems();
        for ( int j = 0 ; j < numberOfItems; j++){
            //This should created a new OrderedItem and add to Arraylist of Order
            order.add(currentMenuItems.get(rand.getItemIndex(menu.getMenuSize())));
        }
    }

    public class Randomizer

    {
        //class variable
        private Random rand;
        private static final int MAX_ORDERS = 2; //Per Simulation tick
        private static final int MAX_ITEMS = 15;
        private static final int NUMBER_OF_TABLES = 30;
        private static final long SEED = 1234567890;
        private static final boolean IS_REPEATABLE_DEFAULT = false;

        //Instance variables
        private boolean isRepeatable;

        //Constructors
        public Randomizer()
        {
            this(IS_REPEATABLE_DEFAULT);
        }

        public Randomizer(boolean isRepeatable)
        {
            if (rand == null){
                this.isRepeatable = isRepeatable;
                reset();
            }
        }

        // Methods
        /**
         * Resets the random generator
         *  If isRepeatable, remains repeatable
         *  If Random, remains random
         */
        private void reset()
        {
            if(isRepeatable)
                rand = new Random(SEED);
            else
                rand = new Random();
        }

        /**
         * Generates an integer
         * 
         * @return Returns the number of orders to be completed (<= MAX_ORDERS)
         */
        public int getNumberOfOrders()
        {
            return rand.nextInt(MAX_ORDERS);
        }

        /**
         * Generates an integer
         * 
         * 
         */
        public int getNumberOfItems()
        {
            return rand.nextInt(MAX_ITEMS);
        }

        /**
         * Returns a random index of the menu's ArrayList<Item>
         * 
         * @param menu The Menu in use
         */
        public int getItemIndex(int number)
        {
            return rand.nextInt(number);
        }

        /**
         * Returns a random table number
         * 
         */
        public int getTableNumber()
        {
            return rand.nextInt(NUMBER_OF_TABLES);
        }

    }
}