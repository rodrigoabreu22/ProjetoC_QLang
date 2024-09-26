
grammar Qlang;

statList: statementComposition EOF;

statementWithBreak: (statement ';');

statementComposition: statementWithBreak* (statement | statementWithBreak);

commandWithBreak: (command ';');

commandComposition: commandWithBreak* (command | commandWithBreak);

idset : ID                      #IDSetTerminal
        | ID '.' idset          #IDSetComposition
        ;         

statement: 
        newQuestion             #StatementQuestion
        | declaration           #StatementDeclaration
        | assignment            #StatemtentAssignment
        | execution             #StatementExecution
        | export                #StatementExport
        | code                  #StatementCode
        | command               #StatementCommand
        | ifLineSentence        #StatementIfLineSentence
        ;



newQuestion: 
        QUESTIONTYPES idset 'is' commandComposition 'end'
        ;

declaration:
        idset ':' (VARIABLETYPES | 'code')
        ;

code:
        'code' idset 'is' (PIL assignment?)+ 'end'
        ;

assignment:
        idset ':=' expr #IDAssignment
        | idset ':=' NEW idset #NewAssignment
        | idset '->' expr  #HoleQuestionAssignment
        ;

execution returns [Type eType]:
        'execute' (expr',')? NEW? idset
        ;


export:
        'export' idset 'to' expr
        ;

command :  
        'print' (assignment | expr)+ #PrintSentence
        | 'println' ((assignment | expr) (prog='|program')?)+ #PrintLineSentence
        | 'uses code from' TEXT codeholeComposition? 'end' #UsesCodeSentence
        | 'uses code' idset codeholeComposition? 'end' #UsesCodeDefined
        | 'choice' (expr',')? TEXT 'end' #ChoiceCommand
        | execution #ExecutionCommand
        | ifLineSentence #IfLineSentenceCommand
        | assignment #AssignmentCommand
        | declaration #DeclarationCommand
        ;

codeholeComposition: codeholeWithBreak* (codehole | codeholeWithBreak);

codeholeWithBreak: (codehole ';');

codehole: (grade=Integer ',')? (matchcount=Integer ',')? (TEXT | idset) ('line' line=Integer)?;

expr returns [Type eType, String varName]:
        '(' expr ')'                                                                            #ParenthesisExpr  
        | expr '|' execution                                                                    #StdoutExpr
        | op=('-' | '+' | 'not') expr                                                           #UnaryExpr
        | expr op=('*' | ':' | '%') expr                                                        #ExprMultDivMod
        | expr op=('+' | '-') expr                                                              #ExprAddMinus
        | expr op=('=' | '>=' | '<=' | '>' | '<' | '/=') expr                                   #ExprBinaryRelational
        | expr op=('and' | 'or' | 'xor' | 'implies' | ANDTHEN | ORELSE ) expr                   #ExprBinaryLogical
        | Integer(('/'Integer)?)                                                                #ValueExpr
        | idset                                                                                 #IDExpr 
        | TEXT                                                                                  #TextExpr                         
        | VARIABLETYPES '(' expr ')'                                                            #TypeExpr
        | 'read' TEXT                                                                           #ReadExpr 
        | execution                                                                             #ExecutionExpr
        ;


ifLineSentence :
    ifBlock elseifBlock* elseBlock? 'end'
    ;

ifBlock : 
    'if' expr 'then' statementComposition
    ;

elseifBlock :
    'elseif' expr 'then' statementComposition
    ;

elseBlock: 
    'else' statementComposition
    ;
    
NEW : 'new';
QUESTIONTYPES : 'multi-choice' | 'hole' | 'open' | 'code-hole' | 'code-open' | 'code-output' | 'composed';
VARIABLETYPES : 'integer' | 'real' | 'text' | 'question' | 'fraction' ;
ANDTHEN: 'and then';
ORELSE: 'or else';
OPEN_BRACKETS: '{' | '[' | '(' | '<' ;
CLOSE_BRACKETS: '}' | ']' | ')' | '>' ;
VERBATIMOPEN : OPEN_BRACKETS;
VERBATIMCLOSE : CLOSE_BRACKETS;
PIL : '"' VERBATIMOPEN .*? VERBATIMCLOSE '"' | '\'' VERBATIMOPEN .*? VERBATIMCLOSE '\'';
TEXT : '"' .*?  '"' | '\'' .*? '\'';
ID : [a-zA-Z_][a-zA-Z0-9_]* ;
Integer : [0-9]+ ;
SKIPPING : [ \n\t]+ -> skip ;
NEWLINE:'\r'? '\n' ;
BLOCKCOMMENT: '#//' .*? '//#' -> skip ;
SINGLECOMMENT: '#' .*? ('\n' | EOF) -> skip ;

ERROR: . ;