package InputOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ErrorOutput implements Output{

    Random rand = new Random();
    String path = "/Users/nidhitholar/college_work/cmpe202/ind_project/individual-project-nidhi-tholar/output_files";

    public void writeToCSV(String errorMessage) throws IOException {
        System.out.println("\nAn error occurred! Check the file in folder 'output_files' for more information!");
        FileWriter fileWriter = new FileWriter(path + "/error_" + rand.nextInt()  + "_.csv");
        fileWriter.write("Error\n");
        fileWriter.append(errorMessage);
        fileWriter.close();
    }


}
