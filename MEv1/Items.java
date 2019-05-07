
/**
 * Write a description of class Items here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Items
{
    String itemName;
    String itemDesc;
    int itemPrice;
    
    public Items()
    {
        itemName = "Omlette";
        itemDesc = "First item added to database";
        itemPrice = 9;
        //System.out.println("abc");  
    }
    
    public Items(String newItemName, String newItemDesc,int newItemPrice)
    {
        itemName = newItemName;
        itemDesc = newItemDesc;
        itemPrice = newItemPrice;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    
    public String getItemDesc()
    {
        return itemName;
    }
    
    public int getItemPrice()
    {
        return itemPrice    ;
    }
    
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
    
    public void setItemDesc(String itemDesc)
    {
        this.itemDesc = itemDesc;
    }
    
    public void setItemNPrice(int itemPrice)
    {
        this.itemPrice = itemPrice;
    }
    
    
}
