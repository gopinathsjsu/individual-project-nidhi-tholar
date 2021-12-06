package InputOutput;
import java.io.*;
import java.util.ArrayList;

public class InputOutput {

    ArrayList<String> fileData = new ArrayList<>();
    Output output;

    public void readInputCsv(String path) throws IOException {
        String line;
        boolean skipHeader = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                } else {
                    this.fileData.add(line);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File Not found");
        }
    }

    public ArrayList<String> getFileData(){
        return this.fileData;
    }

    public void writeOutputCsv(String message, boolean isOrderProcessed, String path) throws IOException {
        if (isOrderProcessed){
            output = new OrderTotalOutput();
        }else {
            output = new ErrorOutput();
        }
        output.writeToCSV(message, path);
    }
}

//        List<MyDictionary> arr_of_dict = new ArrayList<>();
//        HashMap<String, HashMap> test_dict = new HashMap<String, HashMap>

//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }