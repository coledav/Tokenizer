import java.io.PushbackReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Tokenizer {

    private static PushbackReader reader;
    private static Queue<Integer> tokens;
    private static char curr;

    private static final List<Character> SYMBOLS = Arrays.asList(';', ',', '=',
            '!', '[', ']', '&', '|', '(', ')', '+', '-', '*', '<', '>');

    private static final List<Character> WHITE_SPACE = Arrays.asList(' ', '\n',
            '\r', '\t');

    //Stores mapping of token strings to their identification numbers
    public static Map<String, Integer> tokenNumbers = new HashMap<>();

    //Stores every identifier that is tokenized so it can be recalled later
    private static Queue<String> identifiers = new LinkedList<String>();
    
    //Stores every integer value that is tokenized so it can be recalled later
    private static Queue<Integer> integers = new LinkedList<Integer>();

    public Tokenizer(PushbackReader reader) throws Exception {
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
                readID();
            } else if ((curr >= 48 && curr <= 57)) {//if current character is a number 0-9
                readInteger();
            }else if (curr == ';') {
                tokens.add(tokenNumbers.get(";"));
            }else if (curr == ',') {
                tokens.add(tokenNumbers.get(","));
            }else if (curr == '!') {
                tokens.add(tokenNumbers.get("!"));
            }else if (curr == '[') {
                tokens.add(tokenNumbers.get("["));
            }else if (curr == ']') {
                tokens.add(tokenNumbers.get("]"));
            }else if (curr == '(') {
                tokens.add(tokenNumbers.get("("));
            }else if (curr == ')') {
                tokens.add(tokenNumbers.get(")"));
            }else if (curr == '+') {
                tokens.add(tokenNumbers.get("+"));
            }else if (curr == '-') {
                tokens.add(tokenNumbers.get("-"));
            }else if (curr == '*') {
                tokens.add(tokenNumbers.get("*"));
            }else if (curr == '=') {
            	curr = (char) reader.read();
            	if(curr == '='){
            		tokens.add(tokenNumbers.get("=="));
            	}else{
            		tokens.add(tokenNumbers.get("="));
            		reader.unread(curr);
            	}
            }else if (curr == '&') {
            	curr = (char) reader.read();
            	if(curr == '&'){
            		tokens.add(tokenNumbers.get("&&"));
            	}else{
            		throw new Exception("Illegal symbol");
            	}
            }else if (curr == '|') {
            	curr = (char) reader.read();
            	if(curr == '|'){
            		tokens.add(tokenNumbers.get("||"));
            	}else{
            		throw new Exception("Illegal symbol");
            	}
            }else if (curr == '!') {
            	curr = (char) reader.read();
            	if(curr == '='){
            		tokens.add(tokenNumbers.get("!="));
            	}else{
            		throw new Exception("Illegal symbol");
            	}
            }else if (curr == '<') {
            	curr = (char) reader.read();
            	if(curr == '='){
            		tokens.add(tokenNumbers.get("<="));
            	}else{
            		tokens.add(tokenNumbers.get("<"));
            		reader.unread(curr);
            	}
            }else if (curr == '>') {
            	curr = (char) reader.read();
            	if(curr == '='){
            		tokens.add(tokenNumbers.get(">="));
            	}else{
            		tokens.add(tokenNumbers.get(">"));
            		reader.unread(curr);
            	}
            }

            else if (WHITE_SPACE.contains(curr)) {
                continue;
            }
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
                                if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
                                    tokens.add(tokenNumbers.get("program"));
                                    valid = true;
                                    reader.unread((char) c);
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
                        if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
                            tokens.add(tokenNumbers.get("begin"));
                            valid = true;
                            reader.unread((char) c);
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
            if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
                tokens.add(tokenNumbers.get("end"));
                valid = true;
                reader.unread((char) c);
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
                if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
                    tokens.add(tokenNumbers.get("else"));
                    valid = true;
                    reader.unread((char) c);
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
            if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
                tokens.add(tokenNumbers.get("int"));
                valid = true;
                reader.unread((char) c);
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
        if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
            tokens.add(tokenNumbers.get("if"));
            valid = true;
            reader.unread((char) c);
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
                    if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
                        tokens.add(tokenNumbers.get("then"));
                        valid = true;
                        reader.unread((char) c);
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
                    if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
                        tokens.add(tokenNumbers.get("while"));
                        valid = true;
                        reader.unread((char) c);
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
                    if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
                        tokens.add(tokenNumbers.get("write"));
                        valid = true;
                        reader.unread((char) c);
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
                    if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
                        tokens.add(tokenNumbers.get("loop"));
                        valid = true;
                        reader.unread((char) c);
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
                    if (WHITE_SPACE.contains((char) c) || SYMBOLS.contains((char) c )|| c == -1) {
                        tokens.add(tokenNumbers.get("read"));
                        valid = true;
                        reader.unread((char) c);
                    }
                }
            }
        }
        if (!valid) {
            throw new Exception("String not valid");
        }
    }

    public static void readID() throws Exception {
        boolean valid = true;
        int c;
        String ID = "";
        ID += curr;
        while ((c = reader.read()) != -1 && c >= 65 && c <= 90) {
            ID += (char) c;
        }
        reader.unread((char) c);
        while ((c = reader.read()) != -1 && c >= 48 && c <= 57) {
            ID += (char) c;
        }

        if (!valid) {
            throw new Exception("String not valid");
        }

        tokens.add(tokenNumbers.get("id"));
        identifiers.add(ID);
        reader.unread((char) c);
    }

    public static void readInteger() throws Exception {
        boolean valid = true;
        int c;
        int intValue = 0;
        intValue *= 10;
        intValue += curr - 48;
        while ((c = reader.read()) != -1 && c >= 48 && c <= 57) {
            intValue *= 10;
            intValue += c - 48;
        }
        if (c >= 65 && c <= 90) {
            valid = false;
        }

        if (!valid) {
            throw new Exception("String not valid");
        }

        tokens.add(tokenNumbers.get("integer"));
        integers.add(intValue);
        reader.unread((char) c);
    }

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
        return integers.remove();

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
