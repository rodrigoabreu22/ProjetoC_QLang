package QlangClasses2;

import java.util.Scanner;

public interface QuestionInterface {
    public Fraction execute(Scanner sc);
    public QuestionInterface getInstance();
    public Fraction run(Scanner sc);
    public String getID();
    public String getAnswer();
    public String getSolution();
}