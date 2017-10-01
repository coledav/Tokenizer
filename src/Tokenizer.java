import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tokenizer {

    private static BufferedReader reader;
    private static Queue<String> tokens;
    private static char curr;

    private static final List<Character> SYMBOLS = Arrays.asList(';', ',', '=',
            '!', '[', ']', '&', '|', '(', ')', '+', '-', '*', '<', '>');

    private static final List<Character> WHITE_SPACE = Arrays.asList(' ', '\n',
            '\r', '\t');

    public Tokenizer(BufferedReader reader) throws Exception {
        Tokenizer.reader = reader;
        Tokenizer.tokens = new LinkedList<String>();
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
            } else if (WHITE_SPACE.contains(curr)) {
                continue;
            }
        }
        tokens.add("EOF");
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
                                    tokens.add("program");
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
                            tokens.add("begin");
                            valid = true;
                        }
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
    }

    private static void readEnd() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 'd') {
            c = reader.read();
            if (WHITE_SPACE.contains((char) c) || c == -1) {
                tokens.add("end");
                valid = true;
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
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
                    tokens.add("else");
                    valid = true;
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
    }

    private static void readInt() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (curr == 't') {
            c = reader.read();
            if (WHITE_SPACE.contains((char) c) || c == -1) {
                tokens.add("int");
                valid = true;
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
    }

    private static void readIf() throws Exception {
        boolean valid = false;
        int c = reader.read();
        curr = (char) c;
        if (WHITE_SPACE.contains(curr) || c == -1) {
            tokens.add("if");
            valid = true;
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
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
                        tokens.add("then");
                        valid = true;
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
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
                        tokens.add("while");
                        valid = true;
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
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
                        tokens.add("write");
                        valid = true;
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
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
                        tokens.add("loop");
                        valid = true;
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
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
                        tokens.add("read");
                        valid = true;
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
    }

    //Returns string value of current token
    public String getToken() {
        return tokens.peek();
    }

    //skips current token
    public void skipToken() {
        tokens.remove();
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
