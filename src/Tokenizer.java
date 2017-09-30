import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tokenizer {

    private String inputStream;
    private ArrayList<String> tokens;
    private char curr;
    private final List<Character> SYMBOLS = Arrays.asList(';', ',', '=', '!',
            '[', ']', '&', '|', '(', ')', '+', '-', '*', '<', '>');

    public Tokenizer(String input) {
        this.inputStream = input;
        this.tokens = new ArrayList<String>();
    }

    private void tokenize() {
        for (int i = 0; i < this.inputStream.length(); i++) {
            this.curr = this.inputStream.charAt(i);

        }
    }

    //Returns "id" if current token is an ID and returns "int" if token is an int
    public String getToken() {
        return "";

    }

    //skips current token
    public void skipToken() {

    }

    //returns value of int token
    public int intVal() {
        return 0;

    }

    //returns value of ID token
    public String idName() {
        return "";

    }
}
