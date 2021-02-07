import java.io.File;            // Import the File class
import java.io.FileWriter;      // Import the FileWriter class
import java.io.IOException;     // Import the IOException class to handle errors

public class Picmaker {

    public static void main(String[] args) {

        try {
            File myObj = new File("file.ppm");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            FileWriter myWriter = new FileWriter("file.ppm");
            myWriter.write("P3\n1000 1000\n255\n");
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    r = (int) (Math.random() * 256);
                    g = (int) (Math.random() * 256);
                    b = (int) (Math.random() * 256);
                    myWriter.write(r + " " + g + " " + b + "\t");
                }
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}