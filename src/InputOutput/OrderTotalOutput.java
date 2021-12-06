package InputOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class OrderTotalOutput implements Output{

    Random rand = new Random();
    String path = "/Users/nidhitholar/college_work/cmpe202/ind_project/individual-project-nidhi-tholar/output_files";

    public void writeToCSV(String orderTotal) throws IOException {
        System.out.println("\nOrder Processed! Check the file in folder 'output_files' for Order Total!");
        FileWriter fileWriter = new FileWriter(path + "/orderTotal_" + rand.nextInt() + "_.csv");
        fileWriter.write("Amt Paid\n");
        fileWriter.append(String.valueOf(orderTotal));
        fileWriter.close();
    }

}
