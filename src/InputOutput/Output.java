package InputOutput;

import java.io.IOException;

public interface Output {

    abstract void writeToCSV(String message) throws IOException;
}
