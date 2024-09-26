package QlangClasses2;

import java.util.Scanner;
import java.util.function.*;

public class OpenQuestion extends Question {
    private String answer;
    private BiFunction<OpenQuestion, Scanner, Void> f;

    public OpenQuestion(Result result, String id) {
        super(result, id);
        this.answer="";
    }

    public void setExecute(BiFunction<OpenQuestion, Scanner, Void> f) {
        this.f = f;
    }

    @Override
    public Fraction execute(Scanner scanner) {
        Fraction res = this.run(scanner);
        this.getResult().updateGrade(null, this.getID(), "Undefined", this.answer);
        return res;
    }

    @Override
    public OpenQuestion getInstance() {
        OpenQuestion clone = new OpenQuestion(super.getResult(), this.getID());
        clone.setExecute(this.f);
        return clone;
    }

    @Override
    public Fraction run(Scanner scanner) {
        f.apply(this, scanner);
        System.out.println("Digite 'SUBMETER' numa nova linha quando tiver terminado a sua resposta.");
        while (true) {
            System.out.print("Resposta: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("SUBMETER")) {
                break;
            }

            this.answer+=input;
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
        return "Undefined";
    }
}