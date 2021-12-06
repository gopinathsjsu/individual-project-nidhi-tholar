import Processor.CardReader;
import Processor.Inventory;
import Processor.Order;
import database.StaticDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        Main obj = new Main();
        obj.begin();
        //Inventory
        // /Users/nidhitholar/college_work/cmpe202/ind_project/individual-project-nidhi-tholar/inventory_data/Dataset - Sheet1.csv
        // Card
        // /Users/nidhitholar/college_work/cmpe202/ind_project/individual-project-nidhi-tholar/card_data/Cards - Sheet1.csv
        // Order
        // /Users/nidhitholar/college_work/cmpe202/ind_project/individual-project-nidhi-tholar/input_file_or_order_data/Input1 - Sheet1.csv
        // /Users/nidhitholar/college_work/cmpe202/ind_project/individual-project-nidhi-tholar/input_file_or_order_data/Input2 - Sheet1.csv
        // /Users/nidhitholar/college_work/cmpe202/ind_project/individual-project-nidhi-tholar/input_file_or_order_data/Input3 - Sheet1.csv
    }

    StaticDB staticDb = StaticDB.getInstance();

    public void begin() throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nPlease enter File Path of Inventory File (or Dataset file): ");
        String inventory_file_path = buffReader.readLine();
        Inventory inventory = new Inventory();
        inventory.createInventory(inventory_file_path);

        System.out.println("\nPlease enter File Path of Card data: ");
        String card_file_path = buffReader.readLine();
        CardReader cardReader = new CardReader();
        cardReader.addCardToDB(card_file_path);

        System.out.println( "\nCurrent Card Database:\n" + staticDb.getCards());

        System.out.println("\nPlease enter File Path of Order File: ");
        String order_file_path = buffReader.readLine();
        Order order = new Order();
        order.processOrder(order_file_path);

        System.out.println( "\nCurrent Card Database:\n" + staticDb.getCards());
    }
}



//        System.out.println("\nIf you want to enter Folder path containing all order files, Enter 1;\n" +
//                        "If you want to enter path of individual files, Enter 2:");
//        String option_entered = buffReader.readLine();
//        if (Integer.parseInt(option_entered) == 1) {
//            System.out.println("\nPlease enter Folder Path(Directory name) containing all Order Files: ");
//            String order_folder_path = buffReader.readLine();
//
//            File folder = new File(order_folder_path);
//            File[] listOfFiles = folder.listFiles();
//
//            for (File file : listOfFiles) {
//                if (file.isFile()) {
//                    String file_path = order_folder_path + "/" + file.getName();
//                    process_order(file_path);
//                }
//            }
//        }
//        else if (Integer.parseInt(option_entered) == 2){
//            while (true){
//            System.out.println("\nPlease enter File Path of Order File (If you done entering all files, enter 'done') : ");
//            String response = buffReader.readLine();
//            if (response.equals("done")){
//                System.out.println("Exiting...");
//                return;
//            }
//            else {
//                process_order(response);
//
//            }
//            }
//        }
