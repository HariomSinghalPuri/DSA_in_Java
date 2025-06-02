package File_Handling;
import java.io.File;
public class T4_DeletingFile {
    public static void main(String[] args)
    {
        File Obj = new File("myfile2.txt");
        if (Obj.delete()) {
            System.out.println("The deleted file is : " + Obj.getName());
        }
        else {
            System.out.println("Failed in deleting the file.");
        }
    }
}
