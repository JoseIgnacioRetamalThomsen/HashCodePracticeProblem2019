import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Printer
{

    public static void printCutToFile(List<Slice> l1,String fileName) throws FileNotFoundException, UnsupportedEncodingException {
        
        try (PrintWriter output = new PrintWriter(fileName, "UTF-8")) {
            output.println(l1.size());
            for (Slice slice : l1){
                output.println(slice);
            }
        }
    }
}
