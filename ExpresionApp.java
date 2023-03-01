import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class ExpresionApp {
    public static void main(String[] args) throws IOException {
        // Leer entrada desde un archivo
        CharStream inputStream = CharStreams.fromFileName("expresiones.txt");

        // Hacer el análisis léxico del flujo y revisar errores
        ExprLexer lexer = new ExprLexer(inputStream);
        lexer.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> r, Object o, int line, int charPositionInLine,
                    String msg, RecognitionException e) {
                throw new RuntimeException(e);
            }
        });
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);

        // Analizar (parsear) el flujo de tokens generado por el lexer
        ExprParser parser = new ExprParser(commonTokenStream);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree tree = parser.expr();

        // Evaluar el árbol generado
        EvalExprVisitor evaluator = new EvalExprVisitor();
        Integer result = evaluator.visit(tree);

        // Imprimir el resultado
        System.out.print("El resultado es: ");
        System.out.println(result);
    }
}
