
/**
 * Items class stoes items in a menu.
 *
 * @author (FIT5136_S19_Team31)
 * @version (v10.4)
 */
public class Items
{
    private String itemName;
    private String itemDesc;
    private double itemPrice;
    private String resName;
    private String itemCat;

    /**
     * Constructor for Items class
     */
    public Items()
    {
        itemName = "Omlette";
        itemDesc = "First item added to database";
        itemPrice = 9;
        itemCat = "Breakfast";
        resName = "Derby Thai";
    }

    /**
     * constructor for Items
     * Items(String newItemName, String newItemDesc,double newItemPrice,String newItemCat,String newResName)
     * defines what attributes a item could have
     */
    public Items(String newItemName, String newItemDesc,double newItemPrice,String newItemCat,String newResName)
    {
        itemName = newItemName;
        itemDesc = newItemDesc;
        itemPrice = newItemPrice;
        itemCat = newItemCat;
        resName = newResName;
    }

    /**
     * getResName() is used to transfer restaurant name attributes
     * @return String
     */
    public String getResName()
    {
        return resName;
    }

    /**
     * getItemCat() is used to transfer item category attributes
     * @return String
     */
    public String getItemCat()
    {
        return itemCat;
    }

    /**
     * getItemName() is used to transfer item name attributes
     * @return String
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * getItemDesc() is used to transfer item description attributes
     * @return String
     */
    public String getItemDesc()
    {
        return itemDesc;
    }

    /**
     * getItemPrice() is used to transfer item price attributes
     * @return double
     */
    public double getItemPrice()
    {
        return itemPrice    ;
    }

    /**
     * setItemName(String itemName) is used to set item name attributes
     * @parameter - String
     */
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    /**
     * setItemDesc(String itemDesc) is used to set item description attributes
     * @parameter - String
     */
    public void setItemDesc(String itemDesc)
    {
        this.itemDesc = itemDesc;
    }

    /**
     * setItemNPrice(int itemPrice) is used to set item price attributes
     * @parameter - int
     */
    public void setItemNPrice(int itemPrice)
    {
        this.itemPrice = itemPrice;
    }

    /**
     * viewitems(String menuCat,String resName1) is used to print restaurant name and item category
     * @parameter - String
     */
    public void viewitems(String menuCat,String resName1)
    {
        int itemNumber = 1;
        if(resName1.equals(resName) && menuCat.equals(itemCat))
        {
            System.out.print(itemNumber+" "+itemName+" "+itemDesc+" "+itemPrice);
        }

    }

}
