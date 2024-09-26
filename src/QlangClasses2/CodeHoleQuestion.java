package QlangClasses2;

import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.function.*;
import java.util.ArrayList;


public class CodeHoleQuestion extends Question {
    private LinkedHashMap<String, String[]> holes;
    private BiFunction<CodeHoleQuestion, Scanner, Void> f;
    private ArrayList<String> answers;
    private ArrayList<String> solutions;
    private Code code_solution;
    private Boolean hole;

    public CodeHoleQuestion(Result result, String id) {
        super(result, id);
        this.holes = new LinkedHashMap<>();
        this.answers = new ArrayList<>();
        this.solutions = new ArrayList<>();
        this.hole = false;
    }

    public String addHole(String matchCount, String alias, String solution, String weight, int line){
        String[] hole = {solution, weight};
        this.holes.put(alias, hole);
        this.solutions.add(solution);
        this.code_solution.insertAlias(alias, solution, Integer.parseInt(matchCount), line);
        return "__" + alias + "__";
    }

    public String addHoleAlias(String alias, String weight) {
        String res = code_solution.getAlias(alias);
        if (res != null) this.solutions.add(res);  
        String[] hole = {res, weight};
        this.holes.put(alias, hole); 
        this.hole = true;     
        return "__" + alias + "__";
    }

    public void setExecute(BiFunction<CodeHoleQuestion, Scanner, Void> f) {
        this.f = f;
    }

    public void useCode(Code code){
        this.code_solution=code;
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
    public CodeHoleQuestion getInstance() {
        CodeHoleQuestion clone = new CodeHoleQuestion(super.getResult(), this.getID());
        clone.setExecute(this.f);
        return clone;
    }

    @Override
    public Fraction run(Scanner scanner) {
        Fraction res = new Fraction(0, 0);
        f.apply(this, scanner);
        if(this.hole){
            System.out.println(this.code_solution.getCodeWithHoles());
        }
        else{
            System.out.println(this.code_solution.getCodeWithHolesWithoutRemoving());
        }
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
        return res;
    }

}