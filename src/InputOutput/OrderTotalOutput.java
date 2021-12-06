package InputOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class OrderTotalOutput implements Output{

    Random rand = new Random();

    public void writeToCSV(String orderTotal, String path) throws IOException {

        Path path_ = Paths.get(path);

        System.out.println("\nOrder Processed! Check the file in folder 'output_files' for Order Total!");
        FileWriter fileWriter = new FileWriter(path_.getParent() + "/orderTotal_" + rand.nextInt() + "_.csv");
        fileWriter.write("Amt Paid\n");
        fileWriter.append(String.valueOf(orderTotal));
        fileWriter.close();
    }

}
