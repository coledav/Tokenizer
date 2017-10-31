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

    private static FileReader parseFileReader;
    private static FileReader printFileReader;
    private static FileReader execFileReader;
    private String program;
    private static String tokenType;
    private static int tokenValue;
    private static String idValue;
    private static int intValue;

    public static void main(String[] args) throws Exception {
        String programFilename = args[0];
        String inputFilename = args[1];

        System.out.println("Program name = " + programFilename);

        parseFileReader = new FileReader(programFilename);
        PushbackReader parsePbReader = new PushbackReader(parseFileReader);

        printFileReader = new FileReader(programFilename);
        PushbackReader printPbReader = new PushbackReader(printFileReader);

        execFileReader = new FileReader(programFilename);
        PushbackReader execPbReader = new PushbackReader(execFileReader);

        //Load up Tokenizer for the parsing run
        Tokenizer.loadTokenizer(parsePbReader);
        //parse program

        Tokenizer.loadTokenizer(printPbReader);
        //Print program
        Program prog = new Program();
        prog.printProgram();

        Tokenizer.loadTokenizer(execPbReader);
        //execute program

//        tokenValue = Tokenizer.getToken();
//        while (tokenValue != Tokenizer.tokenNumbers.get("EOF")) {
//            System.out.println(tokenValue);
//            Tokenizer.skipToken();
//            tokenValue = Tokenizer.getToken();
//        }
//        System.out.println(tokenValue);

    }

}
