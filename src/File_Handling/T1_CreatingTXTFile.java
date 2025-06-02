package File_Handling;

import java.io.File;
import java.io.IOException;

public class T1_CreatingTXTFile {
        public static void main(String[] args ) {
            File myfile = new File("myfile.txt");

            try {
                myfile.createNewFile();
                System.out.println("File Created!");
            }catch (IOException e) {
                System.out.println("Unable to Create The file");
            }
        }

}
