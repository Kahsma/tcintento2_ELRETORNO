import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.antlr.v4.runtime.*;

import org.antlr.v4.runtime.tree.*;

public class ExpresionApp

{

    public static void main(String[] args) throws IOException {

        // 1. Lee entrada crea un flujo de caracteres

        BufferedReader in =

                new BufferedReader(new InputStreamReader(System.in));

        CharStream inputStream = CharStreams.fromReader(in);

        // 2. Hace el analisis lexico del flujo y revisa errores

        // System.out.println("Analisis Lexico: ");

        ExprLexer lexer = new ExprLexer(inputStream);

        lexer.addErrorListener(new BaseErrorListener() {

            @Override

            public void syntaxError(Recognizer<?, ?> r, Object o, int l, int c,

                    String msg, RecognitionException e) {

                throw new RuntimeException(e);

            }

        });

        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);

        // 3. analiza (parsea) el flujo de tokens generado por el lexer

        ExprParser parser = new ExprParser(commonTokenStream);

        // System.out.println("Analisis Sintactico: ");

        parser.setErrorHandler(new BailErrorStrategy());

        ParseTree tree = parser.expr();

        // System.out.println("Crea Arbol: ");

        // 4. Evalua el arbol generado

        EvalExprVisitor evaluator = new EvalExprVisitor();

        Integer result = evaluator.visit(tree);

        // 5. imprime el resultado

        System.out.print("El resultado es: ");

        System.out.println(result);

    }

}
