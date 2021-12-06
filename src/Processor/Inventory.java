package Processor;
import InputOutput.InputOutput;

import database.StaticDB;
import model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Inventory {

    InputOutput file = new InputOutput();
    StaticDB staticDb = StaticDB.getInstance();

    public void createInventory(String path) throws IOException {
        this.file.readInputCsv(path);
        storeInventoryDataInDB();
        addCapToCategory();
    }

    private void storeInventoryDataInDB() {
        ArrayList<String> fileData = new ArrayList<String>();
        fileData = this.file.getFileData();
        String splitBy = ",";

        for (int i = 0; i < fileData.size(); i++) {
            String cur_line = fileData.get(i);
            String[] line_data = cur_line.split(splitBy);
            //cat, item, qua, price
            staticDb.getInventoryItemsDict().put(line_data[1], new Item(line_data[0], Integer.parseInt(line_data[2]), Double.parseDouble(line_data[3])));
            staticDb.getCategory().add(line_data[0]);
        }
    }

    public void printInventory(){
        System.out.println("=======================");
        for (Map.Entry entry : staticDb.getInventoryItemsDict().entrySet())
        {System.out.println("key: " + entry.getKey() + "; value: " + (Item) entry.getValue() );}
        System.out.println("=======================");
    }

    private void addCapToCategory() {
        //adding cap to category, 3,5,6
        Random random = new Random();
        for (String category : staticDb.getCategory()) {
            if (category.equalsIgnoreCase("luxury")) {
                staticDb.getCategoryCap().put(category, 3);
            }
            else if(category.equalsIgnoreCase("essential")) {
                staticDb.getCategoryCap().put(category, 5);
            }
            else if(category.equalsIgnoreCase("misc")) {
                staticDb.getCategoryCap().put(category, 6);
            }
            else {
                System.out.println("Unknown Category in Inventory File!! Accepted ones are: (Luxury,Essential,Misc) Please correct and Re-Run the program");
                System.exit(0);
            }
        }
    }
}