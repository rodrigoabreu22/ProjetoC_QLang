package QlangClasses2;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;


public class QuestionManager implements QuestionInterface {
    private ArrayList<QuestionInterface> hierarchicalQuestions;
    private String category;
    private String answer;
    private String solution;

    public QuestionManager(String category) {
        this.hierarchicalQuestions = new ArrayList<>();
        this.category = category;
    }

    public QuestionInterface getInstance() {
        Random random = new Random();
        int randomIndex = random.nextInt(hierarchicalQuestions.size());
        return hierarchicalQuestions.get(randomIndex).getInstance();
    }

    public void addQuestion(QuestionInterface question) {
        this.hierarchicalQuestions.add(question);
    }

    @Override
    public String getID() {
        return this.category;
    }

    public Fraction execute(Scanner scanner) {
        QuestionInterface question = this.getInstance();
        Fraction grade = question.execute(scanner);
        this.answer = question.getAnswer();
        this.solution = question.getSolution();
        return grade;
    }

    public Fraction run(Scanner scanner) {
        QuestionInterface question = this.getInstance();
        Fraction grade = question.run(scanner);
        this.answer = question.getAnswer();
        this.solution = question.getSolution();
        return grade;
    }

    @Override
    public String getAnswer(){
        return this.answer;
    }

    @Override
    public String getSolution(){
        return this.solution;
    }
}