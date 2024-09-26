package QlangClasses2;

import qlang_interpreter.*;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.function.*;

public class Code implements CodeInterface {
    private ArrayList<CodeComponent> code;
    private String id;
    private Function<Code, Void> f;

    public Code(String id) {
        this.id = id;
        this.code = new ArrayList<>();
    }

    public void buildCode(Function<Code, Void> f) {
        this.f = f;
        f.apply(this);
    }

    public void addComponent(CodeComponent component) {
        this.code.add(component);
    }

    public String getAlias(String alias) {
        for (CodeComponent c : code) {
            if (c instanceof Alias) {
                Alias a = (Alias) c;
                if (a.alias().equals(alias)) return a.getText();
            } 
        }
        return null;
    }

    public void insertAlias(String alias, String text, int matchCount) {
        for (int index = 0; index < this.code.size(); index += 2) {
            if (this.code.get(index) instanceof Alias) {
                index += 1;
            }
            StringWrapper stringWrapper = (StringWrapper) this.code.get(index);
            this.code.remove(index);
            String[] split = stringWrapper.getText().split(text);
            if (split.length > 1) {
                for (int i = 0; i < split.length; i++) {
                    if (i != split.length - 1) {
                        matchCount -= 1;
                        if (matchCount == 0) {
                            this.code.add(index, new StringWrapper(split[i]));
                            this.code.add(index + 1, new Alias(alias, text));
                        } else {
                            this.code.add(index, new StringWrapper(split[i] + text));
                        }
                    } else {
                        this.code.add(index, new StringWrapper(split[i]));
                    }
                }
                return;
            }
        }
    }

    public void insertAlias(String alias, String text, int matchCount, int line) {
        for (int index = 0; index < this.code.size(); index += 1) {
            if (this.code.get(index) instanceof Alias) {
                index += 1;
            }
            StringWrapper stringWrapper = (StringWrapper) this.code.get(index);
            this.code.remove(index);
            String beforeLineString = "";
            String afterLineString = "";
            int curLine = 0;
            Scanner newScanner = new Scanner(stringWrapper.getText());
            while(newScanner.hasNextLine()){
                curLine+=1;
                if(curLine >= line){
                    afterLineString += newScanner.nextLine()+"\n";
                }
                else{
                    beforeLineString+= newScanner.nextLine()+"\n";
                }
            }
            String[] split = afterLineString.split(text);
            if (split.length > 1) {
                for (int i = 0; i < split.length; i++) {
                    if (i != split.length - 1) {
                        matchCount -= 1;
                        if (matchCount == 0) {
                            StringWrapper string = new StringWrapper(split[i]);
                            string.addTextBehind(beforeLineString);
                            this.code.add(index, string);
                            beforeLineString = "";
                            this.code.add(index + 1, new Alias(alias, text));
                            index +=2;
                        } else {
                            this.code.add(index, new StringWrapper(split[i] + text));
                            index+=1;
                        }
                    } else {
                        this.code.add(index, new StringWrapper(split[i]));
                        index+=1;
                    }
                }
                return;
            }
            else{
                this.code.add(index, stringWrapper);
            }
        }
    }

    public String getCodeNoHoles() {
        StringBuilder code = new StringBuilder();
        for (CodeComponent component : this.code) {
            code.append(component.getText());
        }
        return code.toString().substring(1, code.length() - 1);
    }

    public String getCodeWithHoles() {
        StringBuilder code = new StringBuilder();
        int count =0;
        for (CodeComponent component : this.code) {
            if (component instanceof Alias) {
                code.append(((Alias) component).getAlias());
            } else {
                code.append(component.getText());
            }
            count++;
        }
        return code.toString();
    }

    public String getCodeWithHolesWithoutRemoving() {
        StringBuilder code = new StringBuilder();
        int count =0;
        for (CodeComponent component : this.code) {
            if (component instanceof Alias) {
                code.append(((Alias) component).getAlias());
            } else {
                code.append(component.getTextWithoutRemoving());
            }
            count++;
        }
        return code.toString();
    }

    public ArrayList<CodeComponent> getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public String execute(Scanner scanner) {
        // Save the old System.out.

        File file = new File("input.pil");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(this.getCodeNoHoles());
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PrintStream capturing = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                oldOut.write(b);
                oldOut.flush();
                baos.write(b);
            }
        });

        System.setOut(capturing);

        // Execute PilMain.main and capture the output
        String[] input = new String[] { "input.pil" };
        PilMain.execute(input, scanner);

        // Restore System.out
        System.setOut(oldOut);

        // Return the captured output
        String capturedOutput = baos.toString();
        return capturedOutput;
    }

    public String execute(String[] inputs) {
        // Save the old System.out and System.in
        PrintStream oldOut = System.out;

        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream capturing = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                oldOut.write(b);
                oldOut.flush();
                baos.write(b);
            }
        });

        // Tell Java to use your special streams
        System.setOut(capturing);

        // Write the code to a file
        File file = new File("input.pil");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(this.getCodeNoHoles());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Run the program
        String[] programArgs = new String[] { "input.pil" };
        PilMain.excecuteWithInputs(programArgs, inputs);

        // Restore System.out and System.in
        System.setOut(oldOut);

        // Get the captured output
        String capturedOutput = baos.toString();
        return capturedOutput;
    }

    public Code getInstance() {
        Code c = new Code(this.id);
        c.buildCode(this.f);
        return c;
    }

    @Override
    public String toString() {
        return this.getCodeNoHoles();
    }

    public static interface CodeComponent {
        String getText();
        String getTextWithoutRemoving();
    }

    public static class StringWrapper implements CodeComponent {
        private String value;

        public StringWrapper(String value) {
            this.value = value;
        }

        public String getText() {
            // removing {}
            return value.substring(1, value.length() - 1);
        }

        public String getTextWithoutRemoving() {
            // removing {}
            return value;
        }

        public void addTextBehind(String text) {
            this.value = text + this.value;
        }
    }

    public static class Alias implements CodeComponent {
        private String alias;
        private String text;

        public Alias(String alias, String text) {
            this.alias = alias;
            this.text = text;
        }

        public String alias() {
            return alias;
        }

        public String getAlias() {
            // __ans__
            return "__" + alias + "__";
        }

        public String getText() {
            return text;
        }

        public String getTextWithoutRemoving() {
            return text;
        }
    }

}
