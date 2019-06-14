
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public ArrayList<String> read(String file) throws FileNotFoundException {
        File f = new File(file);
        Scanner s = new Scanner(f);
        ArrayList<String> toRead = new ArrayList<String>();
        while(s.hasNextLine()) {
            toRead.add(s.nextLine());
        }
        return toRead;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, ArrayList<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file);
        for(String s : texts) {
            writer.write(s + "\n");
        }
        writer.close();
    }
}
