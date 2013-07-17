import java.util.ArrayList;

public class Menu
{
    private ArrayList<Item> menuItems;
    
    public Menu()
    {
        menuItems = new ArrayList<Item>();
        populate();
    }

    public ArrayList<Item> getMenu()
    {return menuItems;}
    
    private void populate()
    {
        String[] itemNames = {"Meat","Fish","Chips","Dip","Salad","Soup",
            "Pasta","Water","Beverage","Soda","Appetizer","Bread"};
            
            for (String s : itemNames){
                menuItems.add(new Item(s));
            }
    }
    
    public Item get(int index)
    {
        return menuItems.get(index);
    }
    
    public int getMenuSize()
    {
        return menuItems.size();
    }
        

}
