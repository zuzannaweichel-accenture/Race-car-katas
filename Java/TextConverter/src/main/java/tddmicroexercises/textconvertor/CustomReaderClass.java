package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CustomReaderClass {
    private BufferedReader buffer;
    private FileReader reader;

    public CustomReaderClass(String filePath) throws FileNotFoundException {
        reader = new FileReader(filePath);
        buffer = new BufferedReader(reader);
    }

    public String readLine() throws IOException {
        return buffer.readLine();
    }
    public void close() throws IOException {
        buffer.close();
    }
    public long skip(long number) throws IOException {
        return buffer.skip(number);
    }
}
