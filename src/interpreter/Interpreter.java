package interpreter;

import java.io.FileReader;
import java.io.PushbackReader;

import parsetreenodes.Program;

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

        System.out.println("Program name = " + programFilename);

        fileReader = new FileReader(programFilename);
        PushbackReader pbReader = new PushbackReader(fileReader);

        //Load up Tokenizer 
        Tokenizer.loadTokenizer(pbReader);
        
        Program prog = new Program();
        
        prog.parseProgram();
        prog.printProgram();
        prog.execProgram();


//        tokenValue = Tokenizer.getToken();
//        while (tokenValue != Tokenizer.tokenNumbers.get("EOF")) {
//            System.out.println(tokenValue);
//            Tokenizer.skipToken();
//            tokenValue = Tokenizer.getToken();
//        }
//        System.out.println(tokenValue);

    }

}
