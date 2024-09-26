import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.*;
import QlangClasses2.*;

public class QLangJavanized {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Result result = new Result();

      String v1;
      Integer v2;
      v1 = readPrompt(scanner, "Nome: ");
      v2 = Integer.parseInt(readPrompt(scanner, "ID: "));
      result.name = v1;
      result.id = v2;
      System.out.println("Nome: " + v1 + ", id: " + String.valueOf(v2));
      CodeManager c1 = new CodeManager("PIL");
      Code c2 = new Code("PIL.Example1");
      c1.addCode(c2);
      Function <Code, Void> c2Build = (Code code) -> {
         code.addComponent(new Code.StringWrapper("["+"\n"+
         "   -- PIL code from here"+"\n"+
         "   n := integer(read);"+"\n"+
         "   i := 1;"+"\n"+
         "   loop until i = n do"+"\n"+
         "      if i % 2 = 0 then"+"\n"+
         "         write i"+"\n"+
         "      end;"+"\n"+
         "      i := i + 1"+"\n"+
         "   end"+"\n"+
         "   -- PIL code to here"+"\n"+
         "]\"") ) ;

         return null;
      };
      c2.buildCode(c2Build)
      ;
      QuestionManager q1 = new QuestionManager("Algorithm");
      MultiChoiceQuestion q2 = new MultiChoiceQuestion(result, "Algorithm.Cond1");
      q1.addQuestion(q2);
      BiFunction<MultiChoiceQuestion, Scanner, Void> q2Execute = (MultiChoiceQuestion question, Scanner sc) -> {
         question.useCode(c2);
         System.out.println(c2);
         question.setSolution(question.getCode().execute(new String[] {"10"}));
         question.addChoice("123456789\n");
         question.addChoice("246810", Fraction.parseFraction("2/10"));
         question.addChoice("2468");

         return null;
      };
      q2.setExecute(q2Execute);
      CodeManager c3 = new CodeManager("PIL");
      Code c4 = new Code("PIL.Example2");
      c3.addCode(c4);
      Function <Code, Void> c4Build = (Code code) -> {
         code.addComponent(new Code.StringWrapper("{"+"\n"+
         "   n := integer(\"Number: \"); -- read [<prompt>]"+"\n"+
         "   write \"Number \",n, \" is \";"+"\n"+
         "   if }\"") ) ;
         ;
         code.addComponent(new Code.Alias("l1", "n % 2 = 0") ) ;
         code.addComponent(new Code.StringWrapper("{ then"+"\n"+
         "      writeln \"even\""+"\n"+
         "   }\"") ) ;
         ;
         code.addComponent(new Code.Alias("l2", "else") ) ;
         code.addComponent(new Code.StringWrapper("{"+"\n"+
         "      writeln \"odd\""+"\n"+
         "   end;"+"\n"+
         "}\"") ) ;

         return null;
      };
      c4.buildCode(c4Build)
      ;
      QuestionManager q3 = new QuestionManager("Algorithm");
      CodeHoleQuestion q4 = new CodeHoleQuestion(result, "Algorithm.Code1");
      q3.addQuestion(q4);
      BiFunction<CodeHoleQuestion, Scanner, Void> q4Execute = (CodeHoleQuestion question, Scanner sc) -> {
         System.out.println("Complete o seguinte código.");
         question.useCode(c4);
         question.addHoleAlias("l1", "10");
         question.addHoleAlias("l2", "5");

         return null;
      };
      q4.setExecute(q4Execute);
      QuestionManager q5 = new QuestionManager("Question");
      HoleQuestion q6 = new HoleQuestion(result, "Question.q1");
      q5.addQuestion(q6);
      BiFunction<HoleQuestion, Scanner, Void> q6Execute = (HoleQuestion question, Scanner sc) -> {
         System.out.println("A atribuição de valor em PIL usa o operador " + question.addHole("ans", ":=", "1") + ".");

         return null;
      };
      q6.setExecute(q6Execute);
      QuestionManager q7 = new QuestionManager("Algorithm");
      CodeHoleQuestion q8 = new CodeHoleQuestion(result, "Algorithm.Code2");
      q7.addQuestion(q8);
      BiFunction<CodeHoleQuestion, Scanner, Void> q8Execute = (CodeHoleQuestion question, Scanner sc) -> {
         System.out.println("Complete o seguinte código.");
         Code code = new Code("code");
         code.addComponent(new Code.StringWrapper("-- Procedural Imperative Language -- conditional\n" + "n := integer(read \"Number: \"); -- type conversion: type(expression)\n" + "write \"Number \",n, \" is \";\n" + "if n % 2 = 0 then -- = is the comparison operator (as in math)\n" + "   writeln \"even\"\n" + "else\n" + "   writeln \"odd\"\n" + "end;\n" + "-- The language must accept boolean expressions:\n" + "--   relational operators:  =   /=   >   <   >=   <=\n" + "--   boolean operators:  and   or   and then   or else   xor   implies\n" + "--   aritmetic operators:  *  :  %  +  - (division with : and %)\n" + "-- Operators (and then) and (or else) are non-strict logical operators.\n" + "-- Unlike related strict operators (and, or), this operators only evaluated the right operand if the first\n" + "-- one does not dictate the boolean expression result (meaning that the right operand may be undefined).\n" + "-- Example:  den /= 0 and then num:den > limit\n") );
         question.useCode(code);
         question.addHole("1", "(1)", "n % 2 = 0", "10", 1);
         question.addHole("1", "(2)", "else", "5", 2);

         return null;
      };
      q8.setExecute(q8Execute);
      Code c7 = new Code("Example3");
      Function <Code, Void> c7Build = (Code code) -> {
         code.addComponent(new Code.StringWrapper("<"+"\n"+
         "  name := read \"Nome: \";"+"\n"+
         "  writeln name"+"\n"+
         ">\"") ) ;

         return null;
      };
      c7.buildCode(c7Build)
      ;
      Code v3;
      v3 = c7.getInstance();
      String v4;
      v4 = v3.execute(scanner);
      v4 = v3.execute(new String[] {"10"});
      v3.execute(scanner);
      Composed q9 = new Composed(result, "Q1");
      BiFunction<Composed, Scanner, Void> q9Execute = (Composed question, Scanner sc) -> {
            question.run(Fraction.parseFraction("1/2"), q7, scanner);
            question.run(Fraction.parseFraction("1/4"), q7, scanner);
            question.run(Fraction.parseFraction("1/4"), q7, scanner);

         return null;
      };
      q9.setExecute(q9Execute);
      QuestionInterface v5;
      v5 = q9.getInstance();
      Fraction v6;
      v6 = v5.execute(scanner);
      Composed q10 = new Composed(result, "Q2");
      BiFunction<Composed, Scanner, Void> q10Execute = (Composed question, Scanner sc) -> {
         Fraction v7;
         v7 =    question.run(Fraction.parseFraction("1"), q7, scanner);
            if (v7.equals(Fraction.parseFraction("1"))) {
                  question.run(Fraction.parseFraction("10"), q9, scanner);

            }    else if (v7.compareTo(Fraction.parseFraction("50")) > 0) {
                  question.run(Fraction.parseFraction("1"), q7, scanner);

            }  else {
               question.run(Fraction.parseFraction("10"), q10, scanner);

         };

         return null;
      };
      q10.setExecute(q10Execute);
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
         result.exportToFile(writer);
      } catch (IOException e) {
         e.printStackTrace(); //erro personalizado?
      }

      scanner.close();
   }

   public static String readPrompt(Scanner scanner, String prompt) {
      System.out.print(prompt);
      return scanner.nextLine();
   }
}