import org.stringtemplate.v4.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

import org.antlr.v4.runtime.tree.ParseTree;

@SuppressWarnings("CheckReturnValue")
public class STBuilder extends QlangBaseVisitor<ST> {
   private STGroup stg = new STGroupFile("qlang.stg");
   private int varCount = 0;
   private int codeCount = 0;
   private int questionCount = 0;
   public ST finalTemplate;

   //HashMap<String, String> variables = new HashMap<>();
   HashMap<String, String> variables_types = new HashMap<>();
   HashMap<String, String> variables_names = new HashMap<>();

   @Override public ST visitStatList(QlangParser.StatListContext ctx) {
      ST res = stg.getInstanceOf("module");
      res.add("name", "QLangJavanized");
      res.add("stat", visit(ctx.statementComposition()));
      finalTemplate = res;
      return res;
   }

   @Override public ST visitStatementWithBreak(QlangParser.StatementWithBreakContext ctx) {
      ST res = visit(ctx.statement());
      return res;
      //return res;
   }

   @Override public ST visitStatementComposition(QlangParser.StatementCompositionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for (QlangParser.StatementWithBreakContext statementWithBreak : ctx.statementWithBreak()) {
         res.add("stat", visit(statementWithBreak).render());
      }
      if (ctx.statement() != null) {
         res.add("stat", visit(ctx.statement()).render());
      }
      
      return res;
      //return res;
   }

   @Override public ST visitCommandWithBreak(QlangParser.CommandWithBreakContext ctx) {
      ST res = visit(ctx.command());
      return res;
      //return res;
   }

   @Override public ST visitCommandComposition(QlangParser.CommandCompositionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for (QlangParser.CommandWithBreakContext commandWithBreak : ctx.commandWithBreak()) {
         res.add("stat", visit(commandWithBreak));
      }
      if (ctx.command() != null) {
         res.add("stat", visit(ctx.command()));
      }
      res.add("stat", "");
      return res;
      //return res;
   }

   @Override public ST visitIDSetTerminal(QlangParser.IDSetTerminalContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat", variables_names.get(ctx.getText()));
      return res;
      //return res;
   }

   @Override public ST visitIDSetComposition(QlangParser.IDSetCompositionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      String variableName = variables_names.get(ctx.getText());
      switch (ctx.getText()) {
         case "result.name":
            variableName = "result.name";
            break;
         case "result.id":
            variableName = "result.id";
            break;
         case "result.grade":
            variableName = "result.grade";
            break;
      }
      res.add("stat", variableName);
      return res;
      //return res;
   }

   @Override public ST visitStatementQuestion(QlangParser.StatementQuestionContext ctx) {
      ST res = null;
      return visit(ctx.newQuestion());
      //return res;
   }

   @Override public ST visitStatementDeclaration(QlangParser.StatementDeclarationContext ctx) {
      ST res = null;
      return visit(ctx.declaration());
      //return res;
   }

   @Override public ST visitStatemtentAssignment(QlangParser.StatemtentAssignmentContext ctx) {
      ST res = null;
      return visit(ctx.assignment());
      //return res;
   }

   @Override public ST visitStatementExecution(QlangParser.StatementExecutionContext ctx) {
      ST res = null;
      return visit(ctx.execution());
      //return res;
   }

   @Override public ST visitStatementExport(QlangParser.StatementExportContext ctx) {
      ST res = null;
      return visit(ctx.export());
      //return res;
   }

   @Override public ST visitStatementCode(QlangParser.StatementCodeContext ctx) {
      ST res = null;
      return visit(ctx.code());
      //return res;
   }

   @Override public ST visitStatementCommand(QlangParser.StatementCommandContext ctx) {
      ST res = null;
      return visit(ctx.command());
      //return res;
   }      //return res;

   @Override public ST visitStatementIfLineSentence(QlangParser.StatementIfLineSentenceContext ctx) {
      ST res = null;
      return visit(ctx.ifLineSentence());
      //return res;
   }

   private String curQuestion = "";
   private boolean inQuestion = false;
   @Override public ST visitNewQuestion(QlangParser.NewQuestionContext ctx) {
      this.counter = 1;
      ST res = stg.getInstanceOf("stats");
      ST question = stg.getInstanceOf("NewQuestion");
      String question_type = ctx.QUESTIONTYPES().getText();
      String id = ctx.idset().getText();
      String[] idSplit = id.split("\\.");
      String questionName;
      String categoryName;
      ST[] managers = new ST[idSplit.length - 1];
      ST[] addManagers = new ST[idSplit.length - 1];

      if (idSplit.length > 1) {
         idSplit[0] = idSplit[0].trim();
         if (!variables_names.containsKey(idSplit[0])) {
            questionName = newQuestionName();
            categoryName = idSplit[0];
            managers[0] = stg.getInstanceOf("NewManager");
            managers[0].add("id", questionName);
            managers[0].add("category", "\"" + categoryName + "\"");
            variables_names.put(categoryName, questionName);
            variables_types.put(categoryName, "question");
            res.add("stat", managers[0].render());
         }

      }


      for (int i = 1; i < idSplit.length - 1; i++) {
         idSplit[i] = idSplit[i].trim();
         if (!variables_names.containsKey(idSplit[i])) {
            questionName = newQuestionName();
            categoryName = String.join(".", Arrays.copyOfRange(idSplit, 0, i + 1));
            managers[i] = stg.getInstanceOf("NewManager");
            managers[i].add("id", questionName);
            managers[i].add("category", categoryName);
            variables_names.put(categoryName, questionName);
            variables_types.put(categoryName, "question");
            res.add("stat", managers[i].render());
            addManagers[i - 1] = stg.getInstanceOf("ManagerAddQuestion");
            addManagers[i - 1].add("question", variables_names.get(categoryName));
            addManagers[i - 1].add("Manager", variables_names.get(String.join(".", Arrays.copyOfRange(idSplit, 0, i))));
            res.add("stat", addManagers[i - 1].render());
         }
      }

      idSplit[idSplit.length - 1] = idSplit[idSplit.length - 1].trim();
      questionName = newQuestionName();
      this.curQuestion = questionName;
      categoryName = String.join(".", idSplit);
      question.add("type", ctx.QUESTIONTYPES().getText());
      question.add("var", questionName);
      question.add("id", categoryName);
      variables_names.put(categoryName, questionName);
      variables_types.put(categoryName, "question");
      res.add("stat", question.render()); 
      if (idSplit.length > 1) {
         addManagers[idSplit.length - 2] = stg.getInstanceOf("ManagerAddQuestion");  
         addManagers[idSplit.length - 2].add("question", variables_names.get(categoryName));
         addManagers[idSplit.length - 2].add("Manager", variables_names.get(String.join(".", Arrays.copyOfRange(idSplit, 0, idSplit.length - 1))));
         res.add("stat", addManagers[idSplit.length - 2].render()); 
      }
      ST execute = stg.getInstanceOf("newExecute");
      execute.add("id", questionName);
      execute.add("type", question_type);
      this.inQuestion = true;
      this.curQuestion = questionName;
      execute.add("stat", visit(ctx.commandComposition()).render());
      this.inQuestion = false;
      this.curQuestion = "";
      res.add("stat", execute.render());
      return res;
   }

   @Override public ST visitDeclaration(QlangParser.DeclarationContext ctx) {
      String id = ctx.idset().getText();
      String var_name = newVarName();
      variables_names.put(id, var_name);
      String type = "code";
      if (ctx.VARIABLETYPES() != null) type = ctx.VARIABLETYPES().getText();
      variables_types.put(id, type);

      ST res = stg.getInstanceOf("declaration");
      res.add("type", type);
      res.add("var", var_name);
      return res;
   }

   boolean isCode = false;
   @Override public ST visitCode(QlangParser.CodeContext ctx) {
      String id = ctx.idset().getText();
      String code_name = "";
      ST res = stg.getInstanceOf("stats");
      ST newCode = stg.getInstanceOf("NewCode");

      ///////////////
      String[] idSplit = id.split("\\.");
      System.out.println("TESTE");
      for (String idString : idSplit) {
         System.out.println(idString);
      }
      String name = idSplit[idSplit.length-1];
      System.out.println("TESTE");
      String codeName = "";
      String categoryName;
      ST[] managers = new ST[idSplit.length - 1];
      ST[] addManagers = new ST[idSplit.length - 1];

      if (idSplit.length > 1) {
         idSplit[0] = idSplit[0].trim();
         if (!variables_names.containsKey(idSplit[0])){
            codeName = newCodeName();
            categoryName = idSplit[0];
            managers[0] = stg.getInstanceOf("NewManager");
            managers[0].add("id", codeName);
            managers[0].add("category", "\"" + categoryName + "\"");
            managers[0].add("type", "Code");
            variables_names.put(categoryName, codeName);
            variables_types.put(categoryName, "code");
            res.add("stat", managers[0].render());
         }

      }

      for (int i = 1; i < idSplit.length - 1; i++) {
         idSplit[i] = idSplit[i].trim();
         if (!variables_names.containsKey(idSplit[0])) {
            codeName = name;
            categoryName = String.join(".", Arrays.copyOfRange(idSplit, 0, i + 1));
            managers[i] = stg.getInstanceOf("NewManager");
            managers[i].add("id", codeName);
            managers[i].add("category", categoryName);
            managers[i].add("type", "Code");
            variables_names.put(categoryName, codeName);
            variables_types.put(categoryName, "code");
            res.add("stat", managers[i].render());
            addManagers[i - 1] = stg.getInstanceOf("ManagerAddQuestion");
            addManagers[i - 1].add("question", variables_names.get(categoryName));
            addManagers[i - 1].add("Manager", variables_names.get(String.join(".", Arrays.copyOfRange(idSplit, 0, i))));
            addManagers[i - 1].add("type", "Code");
            res.add("stat", addManagers[i - 1].render());
         }
      }

      codeName = newCodeName();
      categoryName = id;
      newCode.add("id", codeName);
      newCode.add("code", categoryName);
      variables_names.put(categoryName, codeName);
      variables_types.put(categoryName, "code");

      res.add("stat", newCode.render());
      
      if (idSplit.length > 1) {
         addManagers[idSplit.length - 2] = stg.getInstanceOf("ManagerAddQuestion");  
         addManagers[idSplit.length - 2].add("question", variables_names.get(categoryName));
         addManagers[idSplit.length - 2].add("Manager", variables_names.get(String.join(".", Arrays.copyOfRange(idSplit, 0, idSplit.length - 1))));
         addManagers[idSplit.length - 2].add("type", "Code");
         res.add("stat", addManagers[idSplit.length - 2].render()); 
      } 

      ST codeBody = stg.getInstanceOf("codeBody");
      codeBody.add("id", codeName);
      //adicionar texto ao code que já foi definido acima
      for (int i = 0; i < ctx.PIL().size(); i++) {
         ST addComponent = stg.getInstanceOf("addComponent");
         addComponent.add("code", code_name);
         ST pil = stg.getInstanceOf("addTextCode");
         Scanner analiseText = new Scanner(ctx.PIL(i).getText());
         String result = "";
         int count = 0;
         while(analiseText.hasNextLine()){
            String text = analiseText.nextLine();
            if(count ==0){
               String add = text.substring(1,text.length());
               add = add.replace("\"","\\\"");
               result += "\"" + add + "\"+\"\\n\"+\n";
            }
            else{
               String add = text.replace("\"","\\\"");
               result += "\"" + add + "\"+\"\\n\"+\n";
            }
            count++;
         }
         result = result.substring(0,result.length()-7);
         analiseText.close();
         //String sanitizedText = ctx.PIL(i).getText().replace("\\n", "\n").replace("\\\"", "\"").replace("\\\\", "\\");
         pil.add("text", result);
         addComponent.add("component", pil.render());
         //pil.add("id", code_name);
         codeBody.add("stat", addComponent.render());
         codeBody.add("stat","");
         if (ctx.assignment(i) != null) {
            ST addAnotherComponent = stg.getInstanceOf("addComponent");
            code_name = newCodeName();
            addAnotherComponent.add("code", code_name);
            this.isCode = true;
            System.out.println(ctx.assignment(i).getText() + " " + ctx.assignment(i).getClass().getName());
            pil = visit(ctx.assignment(i));
            isCode = false;
            System.out.println("PIL: " + pil.render());
            addAnotherComponent.add("component", pil.render());
            pil.add("id", code_name);
            codeBody.add("stat", addAnotherComponent.render());
         }
      }
      
      

      
      res.add("stat", codeBody.render());
      return res;
   }

   @Override public ST visitIDAssignment(QlangParser.IDAssignmentContext ctx) {
      ST res = null;
      String assignee = visit(ctx.expr()).render();
      if (variables_types.containsKey(assignee) && variables_types.get(assignee).equals("question")) {
         res = stg.getInstanceOf("assignNew");
         res.add("value", visit(ctx.idset()).render());
      }
      else {
         res = stg.getInstanceOf("assignBase");
         res.add("value", assignee);
      }
      res.add("var", visit(ctx.idset()).render());
      return res;
   }

   @Override public ST visitNewAssignment(QlangParser.NewAssignmentContext ctx) {
      String id = ctx.idset(0).getText();
      ST res = stg.getInstanceOf("assignmentNew");
      String varName = variables_names.get(id);
      res.add("var", varName);
      res.add("value", visit(ctx.idset(1)).render());
      return res;
   }

   @Override public ST visitHoleQuestionAssignment(QlangParser.HoleQuestionAssignmentContext ctx) {
      ST res = null;
      if (this.inQuestion) {
         res = stg.getInstanceOf("AddHoleSane");
         res.add("alias", ctx.idset().getText());
         res.add("solution", visit(ctx.expr()).render());
         return res;
      }
      if (this.isCode) {
         System.out.println("entered here");
         res = stg.getInstanceOf("addHoleCode");
         res.add("id", ctx.idset().getText());
         res.add("hole", visit(ctx.expr()).render());
         return res;
      }
      return res;
   }

   // ver problema do var no qlang.stg
   @Override public ST visitExecution(QlangParser.ExecutionContext ctx) {
      if (inQuestion) {
         ST res = stg.getInstanceOf("runQuestion");
         if (ctx.expr() != null) {
            res.add("value", "\"" + ctx.expr().getText() + "\"");
         }
         else {
            res.add("value", "\"1\"");
         }
         res.add("question", visit(ctx.idset()).render());
         return res;
      }
      ST res = stg.getInstanceOf("executeQuestion");
      String id = ctx.idset().getText();

      String var_name = variables_names.get(id);
      System.out.println(var_name);
      System.out.println(res);
      if (var_name != null) res.add("question", var_name);
      else res.add("question", id);

      return res;
   }

   @Override public ST visitExport(QlangParser.ExportContext ctx) {
      ST res = stg.getInstanceOf("ExportResults");
      return res;
   }


   
   @Override public ST visitPrintSentence(QlangParser.PrintSentenceContext ctx) {
      ST res = stg.getInstanceOf("print");
      String text = "";
      for (int i=0; i<ctx.children.size(); i++) {
          ParseTree child = ctx.getChild(i);
          if (child instanceof QlangParser.AssignmentContext) {
              // Handle assignment
              text += visit((QlangParser.AssignmentContext) child).render();
          } else if (child instanceof QlangParser.ExprContext) {
              // Handle expression
              text += visit((QlangParser.ExprContext) child).render();
          }
      }
      res.add("value", text);
      return res;
  }

   //mexi aqui
   //VOLTAR AQUI DEPOIS
   //TODO: METER O PROGRAM A FUNCIONAR
   //Vai ter de se vir aqui por causa do println com código
   @Override public ST visitPrintLineSentence(QlangParser.PrintLineSentenceContext ctx) {
      ST res = stg.getInstanceOf("stats");
      
      if (ctx.prog != null) {
         ST res1 = stg.getInstanceOf("StdoutProgram");
         for (int i=0; i<ctx.children.size() - 1; i++) {
            ParseTree child = ctx.getChild(i);
            ParseTree nextChild = ctx.getChild(i + 1);
            if (nextChild.getText().equals("|program")) {
               res1.add("input", child.getText());
            }
         }
          
         res.add("stat", res1.render());
      }
      else {
         ST res2 = stg.getInstanceOf("println");
         String text = "";
         for (int i=0; i<ctx.children.size(); i++) {
            if (i > 1) {
               text += " + ";
            }
            ParseTree child = ctx.getChild(i);
            if (child instanceof QlangParser.AssignmentContext) {
               // Handle assignment
               text += visit((QlangParser.AssignmentContext) child).render();
            } else if (child instanceof QlangParser.ExprContext) {
               // Handle expression   
               String expr = visit((QlangParser.ExprContext) child).render();
               text += expr;
            }
         }
         res2.add("value", text);
         res.add("stat", res2.render());
         
      }  
      return res;    
   }

   //mexi aqui
   @Override public ST visitUsesCodeSentence(QlangParser.UsesCodeSentenceContext ctx) {
      ST res = stg.getInstanceOf("stats");
      File file = new File(ctx.TEXT().getText().substring(1, ctx.TEXT().getText().length() - 1));
      String code = "";
      try {
         Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
               continue;
               }
            code += "\"" + line.replace("\"", "\\\"").replace("\\n", "\\\\n") +"\\n\"";
            if (scanner.hasNextLine()) {
               code += " + ";
            }
         }
         if (code.substring(code.length() - 3, code.length()).equals(" + ")) {
            code = code.substring(0, code.length() - 3);
         }
         scanner.close();
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         return null;
      }
      System.out.println("aqui");
      System.out.println(code);
      ST usedCode = stg.getInstanceOf("UseCode");
      ST newCode = stg.getInstanceOf("NewCode");
      //o que é o NewCodePartial
      ST codeST = stg.getInstanceOf("NewCodeReady");

      newCode.add("code", "code");
      codeST.add("code", code);
      usedCode.add("code", "code");
      System.out.println(codeST.render());

      res.add("stat", newCode.render());
      res.add("stat", codeST.render());
      res.add("stat", usedCode.render());
      if (ctx.codeholeComposition() != null) {
         res.add("stat", visit(ctx.codeholeComposition()).render());
      }
      return res;
      //return res;
   }

   //mexi aqui
   @Override public ST visitUsesCodeDefined(QlangParser.UsesCodeDefinedContext ctx) {
      ST res = stg.getInstanceOf("stats");
      ST usedCode = stg.getInstanceOf("UseCode");
      
      usedCode.add("code", variables_names.get(ctx.idset().getText()));
      //pq fazes isto em baixo?
      res.add("stat", usedCode.render());
      if (ctx.codeholeComposition() != null) {
         res.add("stat", visit(ctx.codeholeComposition()).render());
      }
      return res;
   }

   //mexi aqui
   @Override public ST visitChoiceCommand(QlangParser.ChoiceCommandContext ctx) {
      ST res = stg.getInstanceOf("AddChoice");
      String option = ctx.TEXT().getText().replaceAll("\'","\"");
      res.add("option",option);
      if (ctx.expr()!=null){
         res.add("grade",visit(ctx.expr()).render());
      }
      return res;
      //return res;
   }

   //
   @Override public ST visitExecutionCommand(QlangParser.ExecutionCommandContext ctx) {
      ST res = null;
      return visit(ctx.execution());
      //return res;
   }

   @Override public ST visitIfLineSentenceCommand(QlangParser.IfLineSentenceCommandContext ctx) {
      ST res = null;
      return visit(ctx.ifLineSentence());
      //return res;
   }

   @Override public ST visitAssignmentCommand(QlangParser.AssignmentCommandContext ctx) {
      ST res = null;
      return visit(ctx.assignment());
      //return res;
   }

   @Override public ST visitDeclarationCommand(QlangParser.DeclarationCommandContext ctx) {
      ST res = null;
      return visit(ctx.declaration());
      //return res;
   }

   @Override public ST visitCodeholeComposition(QlangParser.CodeholeCompositionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for (QlangParser.CodeholeWithBreakContext codehole : ctx.codeholeWithBreak()) {
         res.add("stat", visit(codehole).render());
      }
      if (ctx.codehole() != null) {
         res.add("stat", visit(ctx.codehole()).render());
      }
      return res;
   }

   @Override public ST visitCodeholeWithBreak(QlangParser.CodeholeWithBreakContext ctx) {
      ST res = visit(ctx.codehole());
      return res;
      //return res;
   }

   public static int counter = 1;
   @Override public ST visitCodehole(QlangParser.CodeholeContext ctx) {
      ST res = stg.getInstanceOf("AddHole");

      if (ctx.grade != null) {
         res.add("grade", ctx.grade.getText());
      }
      else {
         res.add("grade", "1");
      }
      if (ctx.matchcount != null) {
         res.add("matchcount", ctx.matchcount.getText());
      }
      else {
         res.add("matchcount", "1");
      }
      if (ctx.line != null) {
         res.add("line", ctx.line.getText());
      }
      else {
         res.add("line", 1);
      }
      if (ctx.TEXT() != null) {
         res.add("solution", ctx.TEXT().getText());
         res.add("alias", "(" + counter++ + ")");
      }
      else {
         res = stg.getInstanceOf("AddHoleAlias");
         res.add("alias", ctx.idset().getText());
         res.add("weight", ctx.grade.getText());
      }
      return res;
      //return res;
   }

   @Override public ST visitValueExpr(QlangParser.ValueExprContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat", ctx.getText());
      return res;
      //return res;
   }

   @Override public ST visitIDExpr(QlangParser.IDExprContext ctx) {
      ST res = null;
      return visit(ctx.idset());
      //return res;
   }

   @Override public ST visitParenthesisExpr(QlangParser.ParenthesisExprContext ctx) {
      ST res = null;
      return visit(ctx.expr());
      //return res;
   }

   @Override public ST visitTextExpr(QlangParser.TextExprContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat", ctx.TEXT().getText());
      return res;
      //return res;
   }

   @Override public ST visitExecutionExpr(QlangParser.ExecutionExprContext ctx) {
      ST res = null;
      return visit(ctx.execution());
      //return res;
   }

   @Override public ST visitExprBinaryLogical(QlangParser.ExprBinaryLogicalContext ctx) {
      String op = ctx.op.getText();
      ST res = stg.getInstanceOf(op);
      String left = visit(ctx.expr(0)).render();
      String right = visit(ctx.expr(1)).render();
      res.add("expr1", left);
      res.add("expr2", right);
      return res;
      //return res;
   }


   //nao sei ainda o que fazer
   //TODO STDOUT
   @Override public ST visitStdoutExpr(QlangParser.StdoutExprContext ctx) {
      ST res = visit(ctx.execution());
      res.add("prompt", "new String[] {" + visit(ctx.expr()).render() + "}");
      return res;
      //return res;
   }

   @Override public ST visitTypeExpr(QlangParser.TypeExprContext ctx) {
      ST res = stg.getInstanceOf("ParseStuff");
      res.add("type", ctx.VARIABLETYPES().getText());
      res.add("value", visit(ctx.expr()).render());
      return res;
      //return res;
   }

   @Override public ST visitUnaryExpr(QlangParser.UnaryExprContext ctx) {
      ST res = stg.getInstanceOf("stats");
      String op = ctx.op.getText();
      if (op.equals("not")) op = "!";
      String value = visit(ctx.expr()).render();
      res.add("stat", op + "(" + value + ")");
      return res;
      //return res;
   }

   @Override public ST visitExprMultDivMod(QlangParser.ExprMultDivModContext ctx) {
      ST res = stg.getInstanceOf("stats");
      String op = ctx.op.getText();
      String left = visit(ctx.expr(0)).render();
      String right = visit(ctx.expr(1)).render();
      res.add("stat", left + " " + op + " " + right);
      return res;
      //return res;
   }

   @Override public ST visitReadExpr(QlangParser.ReadExprContext ctx) {
      ST res = stg.getInstanceOf("ReadInput");
      res.add("prompt", ctx.TEXT().getText());
      return res;
      //return res;
   }

   @Override public ST visitExprAddMinus(QlangParser.ExprAddMinusContext ctx) {
      ST res = stg.getInstanceOf("stats");
      String operation = ctx.op.getText();
      switch (operation) {
         case "+":
            res.add("stat", visit(ctx.expr(0)).render() + " + " + visit(ctx.expr(1)).render());
            break;
         case "-":
            res.add("stat", visit(ctx.expr(0)).render() + " - " + visit(ctx.expr(1)).render());
            break;
         case ":":
            res.add("stat", visit(ctx.expr(0)).render() + " : " + visit(ctx.expr(1)).render());
            break;
      }
      return res;
      //return res;
   }

   @Override public ST visitExprBinaryRelational(QlangParser.ExprBinaryRelationalContext ctx) {
      ST res = stg.getInstanceOf("stats");
      String operation = ctx.op.getText();
      switch (operation) {
         case "=":
            res.add("stat", variables_names.get(ctx.expr(0).getText()) + ".equals(Fraction.parseFraction(\"" + ctx.expr(1).getText() + "\"))");
            break;
         case "/=":
            res.add("stat", variables_names.get(ctx.expr(0).getText()) + ".equals(Fraction.parseFraction(\"" + ctx.expr(1).getText() + "\"))");
            break;
         case "<":
            res.add("stat", variables_names.get(ctx.expr(0).getText()) + ".compareTo(Fraction.parseFraction(\"" + ctx.expr(1).getText() + "\")) < 0");
            break;
         case ">":
            res.add("stat", variables_names.get(ctx.expr(0).getText()) + ".compareTo(Fraction.parseFraction(\"" + ctx.expr(1).getText() + "\")) > 0");
            break;
         case "<=":
            res.add("stat", variables_names.get(ctx.expr(0).getText()) + ".compareTo(Fraction.parseFraction(\"" + ctx.expr(1).getText() + "\")) <= 0");
            break;
         case ">=":
            res.add("stat", variables_names.get(ctx.expr(0).getText()) + ".compareTo(Fraction.parseFraction(\"" + ctx.expr(1).getText() + "\")) >= 0");
            break;
      }
      return res;
      //return res;
   }

   @Override public ST visitIfLineSentence(QlangParser.IfLineSentenceContext ctx) {
      ST res = visit(ctx.ifBlock());
      for (QlangParser.ElseifBlockContext elseif : ctx.elseifBlock()) {
         res.add("elseWord", visit(elseif).render());
      }
      if (ctx.elseBlock() != null) {
         res.add("elseWord", visit(ctx.elseBlock()).render());
      }
      return res;
      //return res;
   }

   @Override public ST visitIfBlock(QlangParser.IfBlockContext ctx) {
      ST res = stg.getInstanceOf("IfSentence");
      res.add("expr", visit(ctx.expr()).render());
      res.add("stat", visit(ctx.statementComposition()).render());
      res.add("stat", "");
      return res;
   }

   @Override public ST visitElseifBlock(QlangParser.ElseifBlockContext ctx) {
      ST res = stg.getInstanceOf("ElseIfSentence");
      res.add("cond", visit(ctx.expr()).render());
      res.add("stat", visit(ctx.statementComposition()).render());
      res.add("stat", "");
      return res;
      //return res;
   }

   @Override public ST visitElseBlock(QlangParser.ElseBlockContext ctx) {
      ST res = stg.getInstanceOf("ElseSentence");
      res.add("stat", visit(ctx.statementComposition()).render());
      res.add("stat", "");
      return res;
      //return res;
   }

   protected String newVarName() {
      varCount++;
      return "v"+varCount;
   }

   protected String newCodeName() {
      codeCount++;
      return "c"+codeCount;
   }

   protected String newQuestionName() {
      questionCount++;
      return "q"+questionCount;
   }
}
