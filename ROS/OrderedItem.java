public class OrderedItem extends Item implements Actor{
    private int orderNumber;
    private int cookTime;
    private int timeToFinish;
    private int startTime;
    private int endTime;
    private boolean isCooking;
    private boolean isCooked;
    
    public OrderedItem(Item item, int orderNumber){
        super(item);
        this.orderNumber = orderNumber;
        startTime = 0;
        endTime = 0;
        cookTime = item.getCookTime();
        timeToFinish = cookTime;
        isCooking = false;
        isCooked = false;
    }
    
    public void startCooking(){
        isCooking = true;
    }
    
    public void act(){
        if(isCooking){
            timeToFinish--;
            if(timeToFinish <= 0){
                isCooked = true;
            }
        }
    }
    
    public int getCookTime(){
        return cookTime;
    }
    
    public int getTimeLeft(){
        return timeToFinish;
    }
    
    public boolean getIsCooked(){
        return isCooked;
    }
        
}