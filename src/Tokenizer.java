import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Tokenizer {

    private static BufferedReader reader;
    private static Queue<Integer> tokens;
    private static char curr;
    private static boolean readID = false;

    private static final List<Character> SYMBOLS = Arrays.asList(';', ',', '=',
            '!', '[', ']', '&', '|', '(', ')', '+', '-', '*', '<', '>');

    private static final List<Character> WHITE_SPACE = Arrays.asList(' ', '\n',
            '\r', '\t');

    public static Map<String, Integer> tokenNumbers = new HashMap<>();

    private static Queue<String> identifiers = new LinkedList<String>();

    public Tokenizer(BufferedReader reader) throws Exception {
        Tokenizer.reader = reader;
        Tokenizer.tokens = new LinkedList<Integer>();
        loadTokenMap();
        tokenize();
    }

    private static void tokenize() throws Exception {
        int c;

        while ((c = reader.read()) != -1) {
            curr = (char) c;
            if (curr == 'p') {
                readProgram();
            } else if (curr == 'b') {
                readBegin();
            } else if (curr == 'e') {
                curr = (char) reader.read();
                if (curr == 'l') {
                    readElse();
                } else if (curr == 'n') {
                    readEnd();
                } else {
                    throw new Exception("Invalid token");
                }
            } else if (curr == 'i') {
                curr = (char) reader.read();
                if (curr == 'n') {
                    readInt();
                } else if (curr == 'f') {
                    readIf();
                } else {
                    throw new Exception("Invalid token");
                }
            } else if (curr == 'w') {
                curr = (char) reader.read();
                if (curr == 'h') {
                    readWhile();
                } else if (curr == 'r') {
                    readWrite();
                } else {
                    throw new Exception("Invalid token");
                }
            } else if (curr == 't') {
                readThen();
            } else if (curr == 'l') {
                readLoop();
            } else if (curr == 'r') {
                readRead();
            } else if ((curr >= 65 && curr <= 90)) { //if current character is uppercase
                //readID();
            } else if (WHITE_SPACE.contains(curr)) {
                //readID = false;
                continue;
            }
            //if (!readID) {
            //if i didn't just read an ID, then get a new character; otherwise
            //readID() will have already read the next character
            //    c = reader.read();
            //} else {
            //     c = curr;
            //}
        }
        tokens.add(tokenNumbers.get("EOF"));
    }

    private static void readProgram() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 'r') {
            curr = (char) reader.read();
            if (curr == 'o') {
                curr = (char) reader.read();
                if (curr == 'g') {
                    curr = (char) reader.read();
                    if (curr == 'r') {
                        curr = (char) reader.read();
                        if (curr == 'a') {
                            curr = (char) reader.read();
                            if (curr == 'm') {
                                c = reader.read();
                                if (WHITE_SPACE.contains((char) c) || c == -1) {
                                    tokens.add(tokenNumbers.get("program"));
                                    valid = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    private static void readBegin() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 'e') {
            curr = (char) reader.read();
            if (curr == 'g') {
                curr = (char) reader.read();
                if (curr == 'i') {
                    curr = (char) reader.read();
                    if (curr == 'n') {
                        c = reader.read();
                        if (WHITE_SPACE.contains((char) c) || c == -1) {
                            tokens.add(tokenNumbers.get("begin"));
                            valid = true;
                        }
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    private static void readEnd() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 'd') {
            c = reader.read();
            if (WHITE_SPACE.contains((char) c) || c == -1) {
                tokens.add(tokenNumbers.get("end"));
                valid = true;
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    private static void readElse() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 's') {
            curr = (char) reader.read();
            if (curr == 'e') {
                c = reader.read();
                if (WHITE_SPACE.contains((char) c) || c == -1) {
                    tokens.add(tokenNumbers.get("else"));
                    valid = true;
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    private static void readInt() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 't') {
            c = reader.read();
            if (WHITE_SPACE.contains((char) c) || c == -1) {
                tokens.add(tokenNumbers.get("int"));
                valid = true;
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    private static void readIf() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (WHITE_SPACE.contains(curr) || c == -1) {
            tokens.add(tokenNumbers.get("if"));
            valid = true;
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    private static void readThen() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 'h') {
            curr = (char) reader.read();
            if (curr == 'e') {
                curr = (char) reader.read();
                if (curr == 'n') {
                    c = reader.read();
                    if (WHITE_SPACE.contains((char) c) || c == -1) {
                        tokens.add(tokenNumbers.get("then"));
                        valid = true;
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    private static void readWhile() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 'i') {
            curr = (char) reader.read();
            if (curr == 'l') {
                curr = (char) reader.read();
                if (curr == 'e') {
                    c = reader.read();
                    if (WHITE_SPACE.contains((char) c) || c == -1) {
                        tokens.add(tokenNumbers.get("while"));
                        valid = true;
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    private static void readWrite() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 'i') {
            curr = (char) reader.read();
            if (curr == 't') {
                curr = (char) reader.read();
                if (curr == 'e') {
                    c = reader.read();
                    if (WHITE_SPACE.contains((char) c) || c == -1) {
                        tokens.add(tokenNumbers.get("write"));
                        valid = true;
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    private static void readLoop() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 'o') {
            curr = (char) reader.read();
            if (curr == 'o') {
                curr = (char) reader.read();
                if (curr == 'p') {
                    c = reader.read();
                    if (WHITE_SPACE.contains((char) c) || c == -1) {
                        tokens.add(tokenNumbers.get("loop"));
                        valid = true;
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    private static void readRead() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 'e') {
            curr = (char) reader.read();
            if (curr == 'a') {
                curr = (char) reader.read();
                if (curr == 'd') {
                    c = reader.read();
                    if (WHITE_SPACE.contains((char) c) || c == -1) {
                        tokens.add(tokenNumbers.get("read"));
                        valid = true;
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
        readID = false;
    }

    /*
     * public static void readID() throws Exception { boolean valid = true; int
     * c; String ID = ""; ID += curr; while ((c = reader.read()) != -1 && c >=
     * 65 && c <= 90) { ID += (char) c; } while ((c = reader.read()) != -1 && c
     * >= 48 && c <= 57) { ID += (char) c; }
     *
     * if (!valid) { throw new Exception("String not valid"); }
     *
     * tokens.add(tokenNumbers.get("id")); identifiers.add(ID); readID = true; }
     */
    //Returns integer value of current token
    public Integer getToken() {
        return tokens.peek();
    }

    //skips current token
    public void skipToken() {
        tokens.remove();
    }

    //returns value of int token
    public int intVal() {
        return tokens.peek();

    }

    //returns value of ID token
    public String idName() {
        return identifiers.remove();

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
