package File_Handling;
import java.io.FileWriter;
import java.io.IOException;

public class T2_WritinginFile {
    public static void main(String[] args) {
        try {
            FileWriter myfile2 = new FileWriter("myfile2.txt");
            myfile2.write("Jisko Jo Bhi Milta Hai Besabab nhi milta");
            myfile2.close();
            System.out.println("Successfully written.");
        }catch(IOException e) {
            System.out.println("File is not cretaed"+e.getMessage());
        }
    }
}
