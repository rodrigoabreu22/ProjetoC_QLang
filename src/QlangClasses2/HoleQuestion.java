package QlangClasses2;

import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.function.*;
import java.util.ArrayList;

public class HoleQuestion extends Question {
    private LinkedHashMap<String, String[]> holes;
    private BiFunction<HoleQuestion, Scanner, Void> f;
    private ArrayList<String> answers;
    private ArrayList<String> solutions;

    public HoleQuestion(Result result, String id) {
        super(result, id);
        this.holes = new LinkedHashMap<>();
        this.answers = new ArrayList<>();
        this.solutions = new ArrayList<>();
    }

    public String addHole(String alias, String solution, String weight){
        String[] hole = {solution, weight};
        this.holes.put(alias, hole);
        this.solutions.add(solution);
        return "__" + alias + "__";
    }

    public void setExecute(BiFunction<HoleQuestion, Scanner, Void> f) {
        this.f = f;
    }

    @Override
    public String getSolution() {
        return String.join("; ", solutions);
    }

    @Override
    public String getAnswer() {
        return String.join("; ", answers);
    }

    @Override
    public Fraction execute(Scanner scanner) {
        Fraction res = this.run(scanner);
        this.getResult().updateGrade(res, this.getID(), this.getSolution(), this.getAnswer());
        return res;
    }

    @Override
    public HoleQuestion getInstance() {
        HoleQuestion clone = new HoleQuestion(super.getResult(), this.getID());
        clone.setExecute(this.f);
        return clone;
    }

    @Override
    public Fraction run(Scanner scanner) {
        System.out.println();
        Fraction res = new Fraction(0, 0);
        f.apply(this, scanner);
        for (String key : holes.keySet()) {
            System.out.println(key + ": ");
            String answer = scanner.nextLine();
            answers.add(answer);
            String solution = holes.get(key)[0];
            String weight = holes.get(key)[1];
            res.setDenominator(res.getDenominator() + Integer.parseInt(weight));
            if (answer.equals(solution)) {
                res.setNumerator(res.getNumerator() + Integer.parseInt(weight));
            }
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");
        return res;
    }

}