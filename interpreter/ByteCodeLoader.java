
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the initialization function.
     */
    public Program loadCodes(){

        Program program = new Program();
        ArrayList<String> argumentsList = new ArrayList<>();

        try {
            String line;

            while ((line = byteSource.readLine()) != null) {

                StringTokenizer token = new StringTokenizer(line);
                line = token.nextToken();
                String classname = CodeTable.getClassName(line);
                Class<?> c = (Class.forName("interpreter.bytecode." + classname));
                ByteCode bytecode = (ByteCode) c.getDeclaredConstructor().newInstance();
                while (token.hasMoreTokens()) {
                    argumentsList.add(token.nextToken());
                }
                bytecode.initialization(argumentsList);
                program.addCode(bytecode);
                argumentsList.clear();
            }
        }
        catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException |
               IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
        program.resolveAddress();
        return program;
        }
    }