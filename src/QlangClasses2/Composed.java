package QlangClasses2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.ArrayList;

public class Composed extends Question {

    Fraction totalScore;
    HashMap<String, ArrayList<String>> solutions;
    HashMap<String, ArrayList<String>> answers;
    String solution;
    String answer;
    BiFunction <Composed, Scanner, Void> f;

    public Composed(Result result2, String id) {
        super(result2, id);
        this.totalScore = new Fraction(0, 1);
        this.solutions = new HashMap<String, ArrayList<String>>();
        this.answers = new HashMap<String, ArrayList<String>>();
    }

    public void setExecute(BiFunction<Composed, Scanner, Void> f) {
        this.f = f;
    }

    public String getSolution() {
        String res="\n";
        for(String id : solutions.keySet()){
            for(String solution : solutions.get(id)){
                res += id + ":\n\tSolution:\n";
                res += "\t\t"+solution+"\n";
            }
        }
        return res;
    }

    public void addSolution(String id, String solution) {
        if(this.solutions.containsKey(id)){
            this.solutions.get(id).add(solution);
        }
        else{
            this.solutions.put(id, new ArrayList<String>());
            this.solutions.get(id).add(solution);
        }
    }

    public void addAnswer(String id, String answer) {
        if(this.answers.containsKey(id)){
            this.answers.get(id).add(answer);
        }
        else{
            this.answers.put(id, new ArrayList<String>());
            this.answers.get(id).add(answer);
        }
    }

    public String getAnswer() {
        String res="\n";
        for(String id : answers.keySet()){
            for(String answer : answers.get(id)){
                res += id + ":\n\tAnswer:\n";
                res += "\t\t"+answer+"\n";
            }
        }
        return res;
    }

    @Override
    public Composed getInstance() {
        Composed clone = new Composed(super.getResult(), super.getID());
        clone.setExecute(this.f);
        return clone;
    }

    @Override
    public Fraction execute(Scanner sc) {
        Fraction res = this.run(sc);
        this.getResult().updateGrade(res, this.getID(), this.getSolution(), this.getAnswer());
        return res;
    }

    @Override
    public Fraction run(Scanner sc) {
        this.f.apply(this, sc);
        return this.totalScore;
    }


    public Fraction run(Fraction f, QuestionInterface question, Scanner sc) {
        QuestionInterface q = question.getInstance();
        Fraction res = q.run(sc);
        this.addAnswer(q.getID(),q.getAnswer());
        this.addSolution(q.getID(),q.getSolution());
        if (res==null){
            this.totalScore = null;
        }
        else{
            this.totalScore = Fraction.addFractions(this.totalScore, Fraction.multiplyFractions(res,f));
        }
        return res;
    }
}
