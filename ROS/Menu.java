import java.util.ArrayList;

public class Menu{
    private ArrayList<Item> menuItems;
    private ArrayList<Item> results; //search results from searchMenu method
    
    public Menu(){
        menuItems = new ArrayList<Item>();
        results = new ArrayList<Item>();
    }
    
    public Menu(ArrayList<Item> existingMenu){
        for(Item item : existingMenu){
            menuItems.add(item);
        }
        results = new ArrayList<Item>();
    }
    
    public void addItem(Item item){
        menuItems.add(item);
    }
    
    public void removeItem(String name){
        for(Item item : menuItems){
            if(name.equals(item.getName())){
                System.out.println(item.getName() + " has been removed from the menu.");
                menuItems.remove(item);
                break;
            }
        }
        System.out.println("No item found");
    }
    
    public Item getItem(String name){
        for(Item item : menuItems){
            if(name.equals(item.getName())){
                return item;
            }
        }
        return null;
    }
    
    public ArrayList<Item> searchMenu(String str){
        results.clear();
        for(Item item : menuItems){
            if(item.getInfo().contains(str)){
                results.add(item);
            }
        }
        return results;
    }
    
    public ArrayList<Item> getMenu(){
        return menuItems;
    }
    
    public int getMenuSize(){
        return menuItems.size();
    }
}