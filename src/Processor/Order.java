package Processor;
import InputOutput.InputOutput;
import database.StaticDB;
import InputOutput.ErrorOutput;
import InputOutput.OrderTotalOutput;
import InputOutput.Output;

import java.io.IOException;
import java.util.ArrayList;


public class Order {

    InputOutput inputOutput = new InputOutput();

    StaticDB staticDb = StaticDB.getInstance();

    public void processOrder(String path) throws IOException {
        this.readOrderFile(path);
        String card=new String();

        ArrayList<String> fileData = new ArrayList<>();
        Inventory inventory = new Inventory();
        fileData = this.inputOutput.getFileData();
        String splitBy = ",";
        Double orderTotal = 0.00;
        staticDb.resetCategoryItemCount();

        for (int i = 0; i < fileData.size(); i++) {
            String cur_line = fileData.get(i);
            String[] line_data = cur_line.split(splitBy);

            String item = line_data[0];
            Integer orderQuantity = Integer.parseInt(line_data[1]);
            card = line_data[2];

            String categoryOfItem = staticDb.getInventoryItemsDict().get(item).getCategory();
            Integer availableQuantityOfItem = staticDb.getInventoryItemsDict().get(item).getAvailableQuantity();

            // Count of Item of a category ordered till now
            Integer count = staticDb.getCategoryItemOrdered().get(categoryOfItem);
            Integer catCap = staticDb.getCategoryCap().get(categoryOfItem);


            // Check if quant > cap
            if (count + orderQuantity > catCap){
                inputOutput.writeOutputCsv("Sorry! You have exceeded the cap for category "+ categoryOfItem + ". The cap is " + catCap +". Please correct quantities!!", false, path);
                return;
            }

            // check if quant > availableQ
            else if (availableQuantityOfItem <  orderQuantity){
                inputOutput.writeOutputCsv(" Please correct quantities! The required Quantity " + orderQuantity + " of " + item + " exceeded the available quantity " + availableQuantityOfItem,
                        false, path);
                return;
            }

            else {
                staticDb.getCategoryItemOrdered().put(categoryOfItem, count+orderQuantity);
                orderTotal = orderTotal + staticDb.getInventoryItemsDict().get(item).getPrice() * orderQuantity;
                staticDb.getInventoryItemsDict().get(item).updateAvailableQuantity(orderQuantity);
            }
        }
        inputOutput.writeOutputCsv(String.valueOf(orderTotal), true, path);

        //add card to DB
        staticDb.getCards().add(card);
    }

    public void readOrderFile(String path) throws IOException{
        this.inputOutput.readInputCsv(path);
    }

}
