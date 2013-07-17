public class Item{
    private String name;        //name of item
    private double price;       //price of item
    private String type;        //appetizer, main course, or dessert
    private String description; //description of item
    private int cookTime;       //how long it takes the standard item to cook
    
    public Item(String name, double price, String type,  String description, int cookTime){
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.cookTime = cookTime;
    }
    
    public Item(Item item){
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.cookTime = cookTime;
    }
        
    
    public String getInfo(){ //used in the menu's search method to find item based on key word
        return name + " " + price + " " + type + " " + description + " " + cookTime;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getType(){
        return type;
    }
    
    public String getDescription(){
        return description;
    }
    
    public int getCookTime(){
        return cookTime;
    }
}