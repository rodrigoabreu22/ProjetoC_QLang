import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.xml.sax.ext.LexicalHandler;
import org.stringtemplate.v4.*;
import java.io.File;
import java.io.FileWriter;


public class QlangMain {
   public static void main(String[] args) {
      try {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromFileName(args[0]);
         // create a lexer that feeds off of input CharStream:
         QlangLexer lexer = new QlangLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         QlangParser parser = new QlangParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at statList rule:
         ParseTree tree = parser.statList();
         //SemanticAnalyser visitor0 = new SemanticAnalyser();
         //Boolean passed = visitor0.visit(tree);
         String finalTemplate = "";
         if (parser.getNumberOfSyntaxErrors() == 0 /*&& passed*/) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            STBuilder visitor1 = new STBuilder();
            visitor1.visit(tree);
            finalTemplate = visitor1.finalTemplate.render();
         }
         
         File file = new File("QLangJavanized.java");
         FileWriter writer = new FileWriter(file);
         writer.write(finalTemplate);
         writer.close();
         
         System.out.println("Output written to QLangJavanized.java");
         System.out.println("Output:");
         System.out.println(finalTemplate);
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}
