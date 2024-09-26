**QLANG GRUPO 6**

Neste documento, iremos entrar mais em detalhes nos requisitos implementados nas linguagens QLANG e PIL.

Foram utilizados os exemplos fornecidos (entre outros testes temporarios) para mostrar as capacidades tanto da geração de código como da análise semântica tanto para o QLANG como para o PIL, que se encontram na pasta examples.

No total foram implementados todos os requesitos mínimos e todos os requesitos desejáveis, estando a documentação de cada um destes presente abaixo.

Nenhum requesitos avançado foi implementado.

## Requisitos Minimos

    
**Instrução para definir perguntas dos tipos: hole, open, code−open, code−hole.**
    
    É possível definir perguntas do tipo hole, com avaliação automática, por exemplo:
   
    hole Question.q1 is
      println "A atribuição de valor em PIL usa o operador " ans->":=" "."
    end;
    
    FORMATO----------------------------------------------------------------------------------FORMATO
    hole {Question.q1} is
      println "{Pergunta aqui}" ans->"{Resposta esperada}" "."
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO


    perguntas do tipo open, com avaliação manual, por exemplo:

    FORMATO----------------------------------------------------------------------------------FORMATO
    open {OpenQuestion} is
      println "{Pergunta aqui}"
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO
    
    open OpenQuestion is
      println "Defina a estrutura de dados lista ligada."
    end;

    
    perguntas do tipo code-open, com avaliação automática, por exemplo:

    code-open Question.Code1 is
       uses code from "even-odd.pil" end;
       println "Implemente um programa que, pedindo um número inteiro do utilizador com o texto 'Number: ', escreva na consola se este é par (even) ou ímpar (odd).";
    end; 

    FORMATO----------------------------------------------------------------------------------FORMATO
    code-open {Question.Code1} is
      uses code from "{Arquivo de código}" end;
      println "{Descrição da tarefa aqui}";
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO

    perguntas do tipo code-hole, com avaliação automática e pesada, por exemplo:
    
    code-hole Algorithm.Code1 is
       println "Complete o seguinte código.";
       uses code PIL.Example1
          10,"n % 2 = 0"; 
          5,"else" line 2
       end;
    end;

    FORMATO----------------------------------------------------------------------------------FORMATO
    code-hole {Algorithm.Code1} is
      println "Complete o seguinte código.";
      uses code {PIL.Example1}
         {Peso1},"{Código1}"; 
         {Peso2},"{Código2}" line {Linha}
      end;
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO


**Instrução para definir código (em linha ou importado de um ficheiro externo).**

    É possível definir código do tipo code, em linha, por exemplo:

    code PIL.Example1 is 
    "[
       -- PIL code from here
       n := integer(read);
       i := 1;
       loop until i = n do
          if i % 2 = 0 then
             write i
          end;
          i := i + 1
       end
       -- PIL code to here
    ]"
    end;

    FORMATO----------------------------------------------------------------------------------FORMATO
    code {PIL.Example1} is 
    "[
       -- PIL code from here
       {Código aqui}
       -- PIL code to here
    ]"
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO
    

    código do tipo code, importado de um ficheiro externo, por exemplo:

    code PIL.Example1 is
     import ficheiro.pil
    end;

    FORMATO----------------------------------------------------------------------------------FORMATO
    code {PIL.Example1} is
     import {ficheiro.pil}
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO
    

**Os tipo de de dados inteiro, texto, e fração. Este último corresponde a uma fração inteira.**

    É possível definir variaveis do tipo de de dados "fraction", por exemplo:

    g: fraction;

    FORMATO----------------------------------------------------------------------------------FORMATO
    {g}: fraction;
    FORMATO----------------------------------------------------------------------------------FORMATO
    

    do tipo de dados "integer", por exemplo:
    
    id: integer;

    FORMATO----------------------------------------------------------------------------------FORMATO
    {id}: integer;
    FORMATO----------------------------------------------------------------------------------FORMATO

    do tipo de dados "text", por exemplo:

    name: text;

    FORMATO----------------------------------------------------------------------------------FORMATO
    {name}: text;
    FORMATO----------------------------------------------------------------------------------FORMATO


**Aceitar expressões aritméticas padrão para os tipos de dados numéricos.**

    É possível aceitar variaveis do tipo de de dados "integer", através de uma expressão aritmética, por exemplo:
        
    id: integer;
    id := 5*12+3;

    FORMATO----------------------------------------------------------------------------------FORMATO
    {id}: integer;
    {id} := {Expressão aritmética};
    FORMATO----------------------------------------------------------------------------------FORMATO


**Aceitar a operação de concatenação de texto.**

    É possível aceitar variaveis do tipo de de dados "text", através de concatenação de strings, por exemplo:

    name: text;
    name := "Dada a entrada " "10"|program ";

    FORMATO----------------------------------------------------------------------------------FORMATO
    {name}: text;
    {name} := "{String1}" "{String2}"|{variável};
    FORMATO----------------------------------------------------------------------------------FORMATO


**Instrução de escrita no standard output (com e sem mudança de linha no fim).**

    É possível escrever no standard output, com mudança de linha, por exemplo:

    println "Complete o seguinte código.";

    FORMATO----------------------------------------------------------------------------------FORMATO
    println "{Texto a ser impresso}";
    FORMATO----------------------------------------------------------------------------------FORMATO

    É possível escrever no standard output, sem mudança de linha, por exemplo:

    print "Complete o seguinte código.";

    FORMATO----------------------------------------------------------------------------------FORMATO
    print "{Texto a ser impresso}";
    FORMATO----------------------------------------------------------------------------------FORMATO
    
    
**Instrução de leitura de texto a partir do standard input.**

    É possível ler texto a partir do standard input, por exemplo:

    res := "10" | execute c1;

    FORMATO----------------------------------------------------------------------------------FORMATO
    {res} := "{Prompt}" | execute {c1};
    FORMATO----------------------------------------------------------------------------------FORMATO


**Operadores de conversão entre tipos de dados.**

    É possível converter entre tipos de dados, por exemplo:

    println "Nome: " name ", id: " text(id);

    FORMATO----------------------------------------------------------------------------------FORMATO
    println "Nome: " {name} ", id: " text({id});
    FORMATO----------------------------------------------------------------------------------FORMATO

    
**Instrução para executar código ou perguntas.**

    É possível executar perguntas, por exemplo:

    code-hole Algorithm.Code1 is
       println "Complete o seguinte código.";
       uses code PIL.Example1
          10,"n % 2 = 0";
          5,"else" line 2   
       end;
    end; 
    
    execute new Algorithm.Code1;

    FORMATO----------------------------------------------------------------------------------FORMATO
    code-hole {Algorithm.Code1} is
      println "Complete o seguinte código.";
      uses code {PIL.Example1}
         {Peso1},"{Código1}";
         {Peso2},"{Código2}" line {Linha}   
      end;
    end; 
    execute new {Algorithm.Code1};
    FORMATO----------------------------------------------------------------------------------FORMATO

    executar código, por exemplo:

    c: code;
    c := new PIL.Example1;
    res: text;
    res := execute c1;
    res := "10" | execute c1;
    execute c1; 

    FORMATO----------------------------------------------------------------------------------FORMATO
    {c}: code;
    {c} := new {PIL.Example1};
    {res}: text;
    {res} := execute {c1};
    {res} := "{Valor}" | execute {c1};
    execute {c1};
    FORMATO----------------------------------------------------------------------------------FORMATO

    
**Instrução para exportar resultados do questionário.**

    É possível exportar os resultados do questionário, por exemplo:

    export result to "result-p2.txt";

    FORMATO----------------------------------------------------------------------------------FORMATO
    export result to "{arquivo.txt}";
    FORMATO----------------------------------------------------------------------------------FORMATO

    
**Verificação semântica do sistema de tipos.**

    Continuar a ler relatorio.

**A definição de expressões booleanas contendo relações de ordem e operadores booleanos.**

    É possível definir expressões booleanas contendo relações de ordem e operadores booleanos, por exemplo:

    n := integer(read "Number: ");
    is_prime := n = 2 or n % 2 /= 0;

    FORMATO----------------------------------------------------------------------------------FORMATO
    {n} := integer(read "{Prompt}");
    {is_prime} := {Expressão booleana};
    FORMATO----------------------------------------------------------------------------------FORMATO

    
**Instrução condicional.**

    É possível definir Instruções condicionais, por exemplo:

    if is_prime then
       writeln "Number ",n," is prime"
    else
       writeln "Number ",n," is not prime"
    end;

    FORMATO----------------------------------------------------------------------------------FORMATO
    if {condição} then
       writeln "{Texto verdadeiro}"
    else
       writeln "{Texto falso}"
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO


**Instrução de iteração (loop).**

    É possível definir Instruções de iteração, por exemplo:

    loop until not is_prime or d * d >= n do 
       is_prime := n % d /= 0
    end;

    FORMATO----------------------------------------------------------------------------------FORMATO
    loop until {condição} do 
       {ação}
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO

    
## Requisitos Desejáveis


**Permitir a definição de expressões booleanas contendo relações de ordem e operadores booleanos.**

    É possível definir expressões booleanas contendo relações de ordem e operadores booleanos, por exemplo:

    id: integer;
    id := 5 * 12 + 3;
    is_even := id % 2 = 0;
    is_large := id > 50;
    is_valid := is_even and is_large;

    FORMATO----------------------------------------------------------------------------------FORMATO
    {var1}: {integer};
    {var1} := {expression};
    {boolean_var1} := {var1} {operator} {value};
    {boolean_var2} := {var1} {relational_operator} {value};
    {result_boolean_var} := {boolean_var1} {boolean_operator} {boolean_var2};
    FORMATO----------------------------------------------------------------------------------FORMATO


**Incluir a instrução condicional (operando sobre expressões booleanas).**

    É possível definir Instruções condicionais, por exemplo:

    is_prime := true;
    n: integer;
    n := 5;
    
    if is_prime then
       println "Number ", n, " is prime"
    else
       println "Number ", n, " is not prime"
    end;

    FORMATO----------------------------------------------------------------------------------FORMATO
    {condition_var} := {boolean_expression};
    {var}: {integer};
    {var} := {value};
    
    if {condition_var} then
       println "{true_message}", {var}, "{true_suffix}"
    else
       println "{false_message}", {var}, "{false_suffix}"
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO



**Incluir a instrução iterativa (operando sobre expressões booleanas).**

    É possível definir Instruções de iteração, por exemplo:

    n: integer;
    n := 10;
    i: integer;
    i := 1;
    sum: integer;
    sum := 0;
    
    loop until i > n do
       sum := sum + i;
       i := i + 1
    end;
    
    println "The sum of first ", n, " numbers is ", sum;

    FORMATO----------------------------------------------------------------------------------FORMATO
    {var1}: {integer};
    {var1} := {initial_value};
    {var2}: {integer};
    {var2} := {initial_value};
    {result_var}: {integer};
    {result_var} := {initial_value};
    
    loop until {var2} {relational_operator} {var1} do
       {result_var} := {result_var} {operator} {var2};
       {var2} := {var2} + {increment_value}
    end;
    
    println "{message}", {var1}, "{suffix}", {result_var};
    FORMATO----------------------------------------------------------------------------------FORMATO


**Perguntas dos tipos: multi-choice**

    É possível definir perguntas do tipo multi-choice, com avaliação automática e ponderada, por exemplo:

    multi-choice Algorithm.Cond1 is 
      uses code PIL.Example1 end;
      println PIL.Example1;
      println "Dada a entrada " "10"|program ", este programa vai escrever no standard output:"; 
      choice "123456789\n" end;
      choice 2/10,'246810' end; 
      choice "2468" end
    end; 

    FORMATO----------------------------------------------------------------------------------FORMATO
    multi-choice {Algorithm.Cond1} is 
      uses code {PIL.Example1} end;
      println "{Pergunta aqui}";
      choice {Peso},"{Opção1}" end;
      choice {Peso},"{Opção2}" end; 
      choice {Peso},"{Opção3}" end
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO


**A definição de buracos em código definido em linha (ver p3.q).**

    É possível definir código com buracos definidos em linha, com avaliação automática, por exemplo:

    code PIL.Example2 is
    "{
       n := integer("Number: "); -- read [<prompt>]
       write "Number ",n, " is ";
       if }" l1->"n % 2 = 0" "{ then
          writeln "even"
       }" l2->"else" "{
          writeln "odd"
       end;
    }"
    end;

    FORMATO----------------------------------------------------------------------------------FORMATO
    code {PIL.Example2} is
    "{
       {Código inicial}
       if }" l1->"{Condição}" "{ então
          {Ação se verdadeiro}
       }" l2->"{else}" "{
          {Ação se falso}
       end;
    }"
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO


**Definição de pergunta composta (que pode incluir a execução de uma ou mais perguntas).**

    É possível definir perguntas do tipo composed, com avaliação automática, por exemplo:

    composed Q1 is 
       execute 1/2,Algorithm; 
       execute 1/4,Algorithm;
       execute 1/4,Algorithm
    end;

    FORMATO----------------------------------------------------------------------------------FORMATO
    composed {Q1} is 
       execute {Peso1},{Algoritmo1}; 
       execute {Peso2},{Algoritmo2};
       execute {Peso3},{Algoritmo3}
    end;
    FORMATO----------------------------------------------------------------------------------FORMATO


## Análise semântica

Sendo o maior objetivo deste trabalho simular um questionario, foi desenvolvida uma análise semântica que garante que as perguntas e os codes são feitas entre tipos de dados compatíveis, e que as expressoes resultantes de operações aritméticas são as corretas.

**No QLANG**

Verificar se a variável não é inicializada mais de uma vez.

Verificar se o nome de uma variável já foi utilizado.

Na função write/print, a variável passada já deve existir.

Verificar se o conjunto de IDs não contém elementos duplicados.

Verificar se a variável 'result' não é declarada novamente.

Garantir que a expressão em um comando de exportação seja do tipo text.

Verificar se as classes de questão e código não são declaradas repetidamente.

Verificar se a variável foi declarada antes de ser atribuída.

Verificar se a expressão em um comando de impressão é do tipo text.

Verificar se o tipo de uma expressão corresponde ao tipo esperado.

    boolean para expressões lógicas.
    
    tipos numéricos para operadores aritméticos.
    
Verificar se a expressão de condição em uma sentença if/elseif é do tipo boolean.

Verificar se a atribuição é feita entre tipos compatíveis.

Verificar se as operações unárias são aplicadas a tipos compatíveis.

Verificar se o nome da variável não é uma palavra reservada.

Verificar se a expressão passada para um código é do tipo text.

**No PIL**

Verificar se a condição do if é do tipo boolean.

Verificar se a condição do loop é do tipo boolean.

Verificar o tipo de expressão para assignment.

Verificar se a expressão de prompt é do tipo text.

Verificar se os operadores lógicos são aplicados a operandos booleanos.

Verificar se os operadores unários são aplicados a operandos booleanos ou numéricos.

Verificar se operadores aritméticos são aplicados a operandos numéricos.

Verificar se operadores relacionais são aplicados a operandos válidos.

Verificar se o nome da variável não é uma palavra reservada.

Verificar a conformidade de tipos em expressões numéricas e lógicas.

## Traducoes

Na fase de geração do código, o código QLANG é traduzido para código JAVA, escolhemos java porque ser a linguagem que usamos nas aulas e estamos familiarizados.

Esta fase foi dividida em 2 partes: - A criação de um String Template Group File, qlang.stg, que contém os templates para a tradução do código QLANG para código JAVA. - A criação de um visitor que visita o código QLANG e o traduz para o código JAVA, STBuilder.java.

Após a conclusão da análise semântica com sucesso, o visior Lexico é chamado e a tradução começa. O visitor visita o código QLANG e o traduz para código JAVA, utilizando os templates definidos no arquivo qlang.stg.

## Error Handling

Error Handling é um recurso que facilita o rastreamento de quaisquer erros encontrados tanto no analisador semântico quanto no analisador léxico. Este recurso também permite-nos gerar mensagens personalizadas para cada tipo distinto de erro.


Exemplo de uso:

    ErrorHandling.registerError();
    ErrorHandling.printError(ctx, idset + " was already declared - and it's not a class of type Code.");

## Sistema de Tipos Orientado a Objetos.

Para a análise sintática e análise semântica/léxica, organizamos nossos tipos em classes orientadas a objetos. Isso foi feito para reduzir a complexidade da implementação e facilitar a manutenção do código.

**No QLANG**

abstract class Type;

class TextType extends Type;

class RealType extends Type;

class QuestionType extends Type;

class IntegerType extends Type;

class FractionType extends Type;

class BooleanType extends Type;

class CodeType extends Type;


interface QuestionInterface;

interface CodeInterface;

class Result;

class QuestionManager implements QuestionInterface;

abstract class Question implements CodeInterface;

class CodeManager implements CodeInterface;

class OpenQuestion extends Question;

class MultiChoiceQuestion extends Question;

class HoleQuestion extends Question;

class Fraction implements Comparable<Fraction>;

class Composed extends Question;

class CodeOpenQuestion extends Question;

**No PIL**


abstract class Type;

class TextType extends Type;

class RealType extends Type;

class IntegerType extends Type;

class BooleanType extends Type;


abstract class Value;

class TextValue extends Value;

class RealValue extends Value;

class IntegerValue extends Value;

class BooleanValue extends Value;