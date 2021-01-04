
/**
 * Menu Class is for storing three thpes of menu
 * Breakfast,Lunch and Dinner
 * @author (FIT5136_S19_Team31)
 * @version (v10.4)
 */
public class Menu
{
    Items item[];
    String menuCat[];

    /**
     * Constructor for Menu class
     * contains item in the construction as pre-loaded value
     */
    public Menu()
    {
        menuCat = new String[3];
        menuCat[0] = "Breakfast";
        menuCat[1] = "Lunch";
        menuCat[2] = "Dinner";

        item = new Items[63];

        item[0] = new Items("Fried chips with gravy","chips with gravy",3.0,"Lunch","Mcdonald's Clayton");
        item[1] = new Items("Fried chips with gravy","chips with gravy",3.0,"Dinner","Mcdonald's Clayton");
        item[2] = new Items("Fried chips with gravy","chips with gravy",3.0,"Breakfast","Mcdonald's Clayton");
        item[3] = new Items("Apple pie","hot apple pie",2.5,"Breakfast","Mcdonald's Clayton");
        item[4] = new Items("Apple pie","hot apple pie",2.5,"Lunch","Mcdonald's Clayton");
        item[5] = new Items("Apple pie","hot apple pie",2.5,"Dinner","Mcdonald's Clayton");
        item[6] = new Items("Hamburger","Hamburger",2.5,"Breakfast","Mcdonald's Clayton");
        item[7] = new Items("Hamburger","Hamburger",2.5,"Lunch","Mcdonald's Clayton");
        item[8] = new Items("Hamburger","Hamburger",2.5,"Dinner","Mcdonald's Clayton");
        item[9] = new Items("Red curry","hot curry",3.0,"Lunch","Autralian curry");
        item[10] = new Items("Red curry","hot curry",3.0,"Dinner","Autralian curry");
        item[11] = new Items("Red curry","hot curry",3.0,"Breakfast","Autralian curry");
        item[12] = new Items("Green curry"," mild curry",2.5,"Breakfast","Autralian curry");
        item[13] = new Items("Green curry"," mild curry",2.5,"Lunch","Autralian curry");
        item[14] = new Items("Green curry"," mild curry",2.5,"Dinner","Autralian curry");
        item[15] = new Items("Yellow curry","sweet curry",2.5,"Breakfast","Autralian curry");
        item[16] = new Items("Yellow curry","sweet curry",2.5,"Lunch","Autralian curry");
        item[17] = new Items("Yellow curry","sweet curry",2.5,"Dinner","Autralian curry");
        item[18] = new Items("Hot chocolate","chocolate",3.0,"Breakfast","Mike's Cafe");
        item[19] = new Items("Hot chocolate","chocolate",3.0,"Lunch","Mike's Cafe");
        item[20] = new Items("Hot chocolate","chocolate",3.0,"Dinner","Mike's Cafe");
        item[21] = new Items("Flat White","coffee",3.5,"Dinner","Mike's Cafe");
        item[22] = new Items("Flat White","coffee",3.5,"Breakfast","Mike's Cafe");
        item[23] = new Items("Flat White","coffee",3.5,"Lunch","Mike's Cafe");
        item[24] = new Items("Turkey Sandwich","sandwich",5.0,"Breakfast","Mike's Cafe");
        item[25] = new Items("Turkey Sandwich","sandwich",5.0,"Lunch","Mike's Cafe");
        item[26] = new Items("Turkey Sandwich","sandwich",5.0,"Dinner","Mike's Cafe");
        item[27] = new Items("Hot chocolate","chocolate",3.0,"Breakfast","Quality bakers");
        item[28] = new Items("Hot chocolate","chocolate",3.0,"Lunch","Quality bakers");
        item[29] = new Items("Hot chocolate","chocolate",3.0,"Dinner","Quality bakers");
        item[30] = new Items("Flat White","coffee",3.5,"Dinner","Quality bakers");
        item[31] = new Items("Flat White","coffee",3.5,"Breakfast","Quality bakers");
        item[32] = new Items("Flat White","coffee",3.5,"Lunch","Quality bakers");
        item[33] = new Items("Turkey Sandwich","sandwich",5.0,"Breakfast","Quality bakers");
        item[34] = new Items("Turkey Sandwich","sandwich",5.0,"Lunch","Quality bakers");
        item[35] = new Items("Turkey Sandwich","sandwich",5.0,"Dinner","Quality bakers");
        item[36] = new Items("Fried chips with gravy","chips with gravy",3.0,"Lunchh","Lava");
        item[37] = new Items("Fried chips with gravy","chips with gravy",3.0,"Dinner","Lava");
        item[38] = new Items("Fried chips with gravy","chips with gravy",3.0,"Breakfast","Lava");
        item[39] = new Items("Apple pie","hot apple pie",2.5,"Breakfast","Lava");
        item[40] = new Items("Apple pie","hot apple pie",2.5,"Lunch","Lava");
        item[41] = new Items("Apple pie","hot apple pie",2.5,"Dinner","Lava");
        item[42] = new Items("Hamburger","Hamburger",2.5,"Breakfast","Lava");
        item[43] = new Items("Hamburger","Hamburger",2.5,"Lunch","Lava");
        item[44] = new Items("Hamburger","Hamburger",2.5,"Dinner","Lava");
        item[45] = new Items("Red curry","hot curry",3.0,"Lunchh","Derby Thai");
        item[46] = new Items("Red curry","hot curry",3.0,"Dinner","Derby Thai");
        item[47] = new Items("Red curry","hot curry",3.0,"Breakfast","Derby Thai");
        item[48] = new Items("Green curry"," mild curry",2.5,"Breakfast","Derby Thai");
        item[49] = new Items("Green curry"," mild curry",2.5,"Lunch","Derby Thai");
        item[50] = new Items("Green curry"," mild curry",2.5,"Dinner","Derby Thai");
        item[51] = new Items("Yellow curry","sweet curry",2.5,"Breakfast","Derby Thai");
        item[52] = new Items("Yellow curry","sweet curry",2.5,"Lunch","Derby Thai");
        item[53] = new Items("Yellow curry","sweet curry",2.5,"Dinner","Derby Thai");
        item[54] = new Items("Flat White","coffee",3.5,"Dinner","Twosome Story");
        item[55] = new Items("Flat White","coffee",3.5,"Breakfast","Twosome Story");
        item[56] = new Items("Flat White","coffee",3.5,"Lunch","Twosome Story");
        item[57] = new Items("Turkey Sandwich","sandwich",5.0,"Breakfast","Twosome Story");
        item[58] = new Items("Turkey Sandwich","sandwich",5.0,"Lunch","Twosome Story");
        item[59] = new Items("Turkey Sandwich","sandwich",5.0,"Dinner","Twosome Story");
        item[60] = new Items("Hot chocolate","chocolate",3.0,"Breakfast","Twosome Story");
        item[61] = new Items("Hot chocolate","chocolate",3.0,"Lunch","Twosome Story");
        item[62] = new Items("Hot chocolate","chocolate",3.0,"Dinner","Twosome Story");
    }

    /**
     * getItems() is used to transfer item attributes
     * @return Items[] - arraylist
     */
    public Items[] getItems()
    {
        return item;
    }

    /**
     * displayMenu() is used to print menu category information
     */
    public void displayMenu()
    {
        System.out.println("1."+menuCat[0]);
        System.out.println("2."+menuCat[1]);
        System.out.println("3."+menuCat[2]);
    }

    /**
     * getCategory(int index) is used to transfer category index
     * @return String - category index
     */
    public String getCategory(int index)
    {
        return menuCat[index];   
    }

}
