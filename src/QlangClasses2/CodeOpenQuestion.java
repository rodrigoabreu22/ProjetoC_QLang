package QlangClasses2;

import java.util.Scanner;
import java.util.function.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CodeOpenQuestion extends Question {
    private Code code;
    private String answer;
    private String inputFilePath;
    private BiFunction<CodeOpenQuestion, Scanner, Void> f;

    public CodeOpenQuestion(Result result, String id) {
        super(result, id);
        this.inputFilePath = "CodeOpenQuestionInputFile.txt";
        createInputFile();
    }

    public void useCode(Code code){
        this.code=code;
    }

    private void createInputFile() {
        try {
            File inputFile = new File(inputFilePath);
            inputFile.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred while creating the input file.");
            e.printStackTrace();
        }
    }

    public void setExecute(BiFunction<CodeOpenQuestion, Scanner, Void> f) {
        this.f = f;
    }

    @Override
    public Fraction execute(Scanner scanner) {
        Fraction res = this.run(scanner);
        this.getResult().updateGrade(res, this.getID(), this.code.getCodeNoHoles(), this.answer);
        return res;
    }

    @Override
    public CodeOpenQuestion getInstance() {
        CodeOpenQuestion clone = new CodeOpenQuestion(super.getResult(), this.getID());
        clone.setExecute(this.f);
        return clone;
    }

    @Override
    public Fraction run(Scanner scanner) {

        f.apply(this, scanner);
        System.out.println("Por favor escreva o seu código: " + inputFilePath);
        System.out.println("Quando tiver completado de escrever o código, digite 'SUBMETER'.\n");

        while (true) {
            System.out.print("Resposta: ");
            String inputLine = scanner.nextLine();
            if (inputLine.equalsIgnoreCase("SUBMETER")) {
                break;
            } else {
                System.out.println("Comando inválido. Digite 'SUBMETER' quando tiver terminado.");
            }
        }

        // Read the user's code
        try {
            String userCode = new String(Files.readAllBytes(Paths.get(inputFilePath))).strip();
            this.answer = userCode;
           
        } catch (IOException e) {
            System.out.println("Error reading the files: " + e.getMessage());
        }

        try {
            Files.deleteIfExists(Paths.get(inputFilePath));
        } catch (IOException e) {
            System.out.println("Error deleting the input file: " + e.getMessage());
        }

        System.out.println("---------------------------------------------------- \n");
        return null;

    }

    @Override
    public String getAnswer(){
        return this.answer;
    }

    @Override
    public String getSolution(){
        return this.code.getCodeNoHoles();
    }
}