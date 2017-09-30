import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputParser {

    private static FileReader fileReader;
    private String program;

    public static void main(String[] args) {
        String filename = args[0];
        System.out.println(filename);

        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //loop through the tokens and print them all out
    }

}
