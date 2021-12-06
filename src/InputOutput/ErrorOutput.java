package InputOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class ErrorOutput implements Output{

    Random rand = new Random();

    public void writeToCSV(String errorMessage, String path) throws IOException {

        Path path_ = Paths.get(path);

        System.out.println("\nAn error occurred! Check the file in folder 'output_files' for more information!");
        FileWriter fileWriter = new FileWriter( path_.getParent() + "/error_014738776__" + rand.nextInt()  + "_.csv");
        fileWriter.write("Error\n");
        fileWriter.append(errorMessage);
        fileWriter.close();
    }


}
