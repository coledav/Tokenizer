import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class InputParser {

    private static FileReader fileReader;
    private String program;
    private static String tokenType;
    private static String idValue;
    private static int intValue;

    private static Map<String, Integer> tokenNumbers = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String filename = args[0];
        loadTokenMap();
        System.out.println(filename);

        fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Tokenizer tokenizer = new Tokenizer(bufferedReader);

        //loop through all tokens, looking at their values and prints each tokens' corresponding number
        idValue = tokenizer.getToken();
        while (!idValue.equals("EOF")) {
            System.out.println(tokenNumbers.get(idValue));
            tokenizer.skipToken();
            idValue = tokenizer.getToken();
        }
    }

    private static void loadTokenMap() {
        tokenNumbers.put("program", 1);
        tokenNumbers.put("begin", 2);
        tokenNumbers.put("end", 3);
        tokenNumbers.put("int", 4);
        tokenNumbers.put("if", 5);
        tokenNumbers.put("then", 6);
        tokenNumbers.put("else", 7);
        tokenNumbers.put("while", 8);
        tokenNumbers.put("loop", 9);
        tokenNumbers.put("read", 10);
        tokenNumbers.put("write", 11);
        tokenNumbers.put(";", 12);
        tokenNumbers.put(",", 13);
        tokenNumbers.put("=", 14);
        tokenNumbers.put("!", 15);
        tokenNumbers.put("[", 16);
        tokenNumbers.put("]", 17);
        tokenNumbers.put("&&", 18);
        tokenNumbers.put("||", 19);
        tokenNumbers.put("(", 20);
        tokenNumbers.put(")", 21);
        tokenNumbers.put("+", 22);
        tokenNumbers.put("-", 23);
        tokenNumbers.put("*", 24);
        tokenNumbers.put("!=", 25);
        tokenNumbers.put("==", 26);
        tokenNumbers.put("<", 27);
        tokenNumbers.put(">", 28);
        tokenNumbers.put("<=", 29);
        tokenNumbers.put(">=", 30);
        tokenNumbers.put("integer", 31);
        tokenNumbers.put("id", 32);
        tokenNumbers.put("EOF", 33);
    }

}
