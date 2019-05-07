
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    Items item[];
    String menuCat[];
    //String restName;
    public Menu()
    {
        menuCat = new String[3];
        menuCat[0] = "Breakfast";
        menuCat[1] = "Lunch";
        menuCat[2] = "Dinner";

        item = new Items[4];
        item[0] = new Items("Team","B",3,"Breakfast","Quality Bakers");
        item[1] = new Items("Juice","B",1,"Dinner","Quality Bakers");
        item[2] = new Items("Sweets","B",2,"Breakfast","Derby Thai");
        item[3] = new Items("Cake","B",4,"Dinner","Derby Thai");
        //item
        //menuCat[4] = restName;
        //item = new Items[3];
        //item[0] = 
    }

    public Items[] getItems()
    {
        return item;
    }

    public void displayMenu()
    {
        System.out.println("1."+menuCat[0]);
        System.out.println("2."+menuCat[1]);
        System.out.println("3."+menuCat[2]);
    }

    public String getCategory(int index)
    {
     return menuCat[index];   
    }

}
