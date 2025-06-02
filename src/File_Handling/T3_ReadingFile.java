package File_Handling;
import java.io.File;
import java.io.Reader;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class T3_ReadingFile {
    public static void main(String[] args) {
        try {
            File Obj = new File("myfile2.txt");
            Scanner Reader = new Scanner(Obj);

            // Traversing File Data
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
        }
        Reader.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
