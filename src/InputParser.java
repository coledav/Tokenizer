import java.io.FileReader;
import java.io.PushbackReader;

public class InputParser {

    private static FileReader fileReader;
    private String program;
    private static String tokenType;
    private static int tokenValue;
    private static String idValue;
    private static int intValue;

    public static void main(String[] args) throws Exception {
        String filename = args[0];
        System.out.println(filename);

        fileReader = new FileReader(filename);
        PushbackReader pbReader = new PushbackReader(fileReader);

        Tokenizer tokenizer = new Tokenizer(pbReader);

        //loop through all tokens, looking at their values and prints each tokens' corresponding number
        tokenValue = tokenizer.getToken();
        while (tokenValue != Tokenizer.tokenNumbers.get("EOF")) {
            if (tokenValue == Tokenizer.tokenNumbers.get("id")) {
                System.out.println(tokenValue + " " + tokenizer.idName());
            } else if (tokenValue == Tokenizer.tokenNumbers.get("integer")) {
                System.out.println(tokenValue + " " + tokenizer.intVal());

            } else {
                System.out.println(tokenValue);
            }

            tokenizer.skipToken();
            tokenValue = tokenizer.getToken();
        }
    }

}
