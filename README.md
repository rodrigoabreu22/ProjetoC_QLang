# Tema **QLang**, grupo **qlang-q06**
-----

## Como correr o programa:

1. Dirigir-se à pasta qlang_interpreter e inserir o comando antlr4-build
2. Colocar a package "package qlang_interpreter" em todos os ficheiros java gerados
3. Inserir o comando javac *.java
4. Dirigir-se à pasta qlang_compiler e inserir o comando antlr4-build
5. Inserir o comando java QlangMain [ficheiro pretendido]
6. Mover o output (QLangJavanized.java) para a pasta src
7. Dirigir-se à pasta src
8. Inserir o comando javac QlangClasses2/*.java
9. Inserir o ocmando javac QLangJavanized.java
10. Inserir o comando java QlangJavanized

Os exemplos estão quase todos incorretos, principalmente no ficheiro p2.q, portanto aconselha-se caução
Não conseguimos juntar tudo num ficheiro .jar apesar de termos tentado durante largas horas.

## Constituição dos grupos e participação individual global

| NMec | Nome | Participação |
|:---:|:---|:---:|
| 103070 | EDUARDO LUÍS PINHAL LOPES | 20.0% |
| 113402 | HUGO SANTOS RIBEIRO | 20.0% |
| 113482 | JOÃO RICARDO LOPES NETO | 20.0% |
| 115243 | RICARDO ALEXANDRE ANTUNES | 20.0% |
| 113626 | RODRIGO GABRIEL ALMEIDA NOGUEIRA DE ABREU | 20.0% |

## Estrutura do Repositório

  * src - código fonte do projeto.
  * doc - documentação adicional a este README.
  * examples - exemplos ilustrativos das linguagens criadas.

## Relatório

  * Requesitos Minimos Alcançados (p1.q, p2.q, p1.pil, p2.pil e p3.pil):
    * Instrução para definir perguntas dos tipos: hole, open, code−open, code−hole.
    * Instrução para definir código (em linha ou importado de um ficheiro externo).
    * Os tipo de de dados inteiro, texto, e fração. Este último corresponde a uma fração inteira.
    * Aceitar expressões aritméticas padrão para os tipos de dados numéricos.
    * Aceitar a operação de concatenação de texto.
    * Instrução de escrita no standard output (com e sem mudança de linha no fim).
    * Instrução de leitura de texto a partir do standard input.
    * Operadores de conversão entre tipos de dados.
    * Instrução para executar código ou perguntas.
    * Instrução para exportar resultados do questionário.
    * Verificação semântica do sistema de tipos.
    * A definição de expressões booleanas contendo relações de ordem e operadores booleanos.
    * Instrução condicional.
    * Instrução de iteração (loop).


  * Requesitos Desejáveis Alcançados (p3.q e p4.pil):
    * Permitir a definição de expressões booleanas contendo relações de ordem e operadores booleanos.
    * Incluir a instrução condicional (operando sobre expressões booleanas).
    * Incluir a instrução iterativa (operando sobre expressões booleanas).

    
    * Perguntas dos tipos: multi-choice 
    * A definição de buracos em código definido em linha (ver p3.q).
    * Definição de pergunta composta (que pode incluir a execução de uma ou mais perguntas).
  

  * Requesitos Avançados Alcançados:
    Não realizamos requisitos avançados.


## Contribuições

-Gramática Principal (QLANG): Ricardo, Rodrigo

-Analisador Semântico (QLANG): Ricardo, Hugo, João, Rodrigo

-Analisador Léxico (QLANG): Ricardo, Rodrigo, Hugo, João, Eduardo

-Traduções: Ricardo, Rodrigo, Hugo, João, Eduardo

-Gramática Secundária (PIL): Eduardo, Hugo

-Analisador Semântico (PIL): Eduardo, Ricardo

-Analisador Léxico(PIL): Eduardo, Ricardo

-README.md: Hugo

-REPORT.md: Hugo


### Nota
14
