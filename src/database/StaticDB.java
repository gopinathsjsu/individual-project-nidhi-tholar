package database;
import model.Item;
import java.util.*;

public class StaticDB {

    private static StaticDB instance;

    HashMap<String, Item> inventoryItems = new HashMap<String, Item>();
    HashSet<String> cards = new HashSet<String>();
    HashSet<String> category = new HashSet<String>();
    HashMap<String, Integer> categoryCap = new HashMap<String, Integer>();
    HashMap<String, Integer> categoryItemOrdered = new HashMap<String, Integer>();

    private StaticDB(){
    }

    public static StaticDB getInstance(){
        if (instance==null){
            instance = new StaticDB();
        }
        return instance;
    }

    public HashMap<String, Item> getInventoryItemsDict(){return inventoryItems;}

    public HashSet<String> getCards(){
        return cards;
    }

    public HashSet<String> getCategory(){return category;}

    public HashMap<String, Integer> getCategoryCap(){return categoryCap;}

    public HashMap<String, Integer> getCategoryItemOrdered(){return categoryItemOrdered;}

    public void resetCategoryItemCount(){
        for (String category : getCategory()){
            getCategoryItemOrdered().put(category, 0);
        }
    }
}