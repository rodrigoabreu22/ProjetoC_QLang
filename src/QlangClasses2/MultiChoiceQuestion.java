package QlangClasses2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.*;


public class MultiChoiceQuestion extends Question{
    private HashMap<String, Fraction> choices;
    private String solution = null;
    private String answer = "";
    private BiFunction<MultiChoiceQuestion, Scanner, Void> execute;
    private Code code;

    public MultiChoiceQuestion(Result result, String id){
        super(result,id);
        this.choices = new HashMap<>();
        this.solution = null;
    }

    public void setExecute(BiFunction<MultiChoiceQuestion, Scanner, Void> execute){
        this.execute = execute;
    }

    public void addChoice(String choice, Fraction weight){
        this.choices.put(choice, weight);
    }

    public void addChoice(String choice) {
        this.choices.put(choice, null);
    }

    public void setSolution(String solution){
        this.solution = solution;
    }

    public void listChoices(){
        String output = "";
        for (int i=0; i<choices.size(); i++){
            output+=String.format("%d) - %s\n", i+1, choices.keySet().toArray()[i]);
        }
        System.out.println(output);
    }


    @Override
    public Question getInstance() {
        MultiChoiceQuestion clone = new MultiChoiceQuestion(super.getResult(), this.getID());
        clone.setExecute(this.execute);
        return clone;
    }

    @Override
    public Fraction execute(Scanner scanner){
        Fraction res = this.run(scanner);
        this.getResult().updateGrade(res, this.getID(), this.getSolution(), this.getAnswer());
        return res;
    }

    public Fraction run(Scanner scanner){
        Fraction res = new Fraction(0,0);
        execute.apply(this, scanner);
        String answer;
        listChoices();
        while (true){
            System.out.print("Resposta: ");
            answer = scanner.nextLine().trim();

            if (checkValidAnswer(answer)){
                int id = Integer.parseInt(answer);
                answer = (String) choices.keySet().toArray()[id-1];
                setAnswer(answer);

                if (solution == null) return null;
                res = choices.get(answer);
                if (res == null){
                    res = (answer.equals(this.getSolution())) ? new Fraction(1,1) : new Fraction(0,1);

                }
                break;
            }
            System.out.println("Resposta inválida.");
        }
        return res;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    private boolean checkValidAnswer(String answer) {
        try{
            int id = Integer.parseInt(answer);
            if (id>=1 && id <= this.choices.size()) {
                return true;
            }         
            return false;
        }
        catch (Exception e){
            System.err.println("Resposta inválida.");
            return false;
        }
    }


    public String getSolution() {
        return this.solution;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void useCode(Code code){
        this.code = code;
    }
    public Code getCode(){
        return this.code;
    }

}