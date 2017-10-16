import java.io.FileReader;
import java.io.PushbackReader;

/*
 * This class opens a file which is given in a command line argument and 
 * creates a tokenizer object to turn the text of the file into Core tokens.
 * Finally the token numbers are printed to standard output
 */
public class Interpreter {

    private static FileReader fileReader;
    private String program;
    private static String tokenType;
    private static int tokenValue;
    private static String idValue;
    private static int intValue;

    public static void main(String[] args) throws Exception {
        String programFilename = args[0];
        String inputFilename = args[1];

        fileReader = new FileReader(programFilename);
        PushbackReader pbReader = new PushbackReader(fileReader);

        //Produces tokenizer which contains list of all tokens in program stored at path programFilename
        Tokenizer tokenizer = new Tokenizer(pbReader);

        
//        //loop through all tokens and prints each tokens' corresponding number
//        tokenValue = tokenizer.getToken();
//        while (tokenValue != Tokenizer.tokenNumbers.get("EOF")) {
//        	System.out.println(tokenValue);
//          tokenizer.skipToken();
//          tokenValue = tokenizer.getToken();
//        }
//        System.out.println(tokenValue);
        
        //insert code here which builds parse tree and does all the printing/executing
        

    }

}



