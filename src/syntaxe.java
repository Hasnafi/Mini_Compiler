//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class syntaxe {

    private final Pattern nombre = Pattern.compile("\\d+(\\.\\d+)?");
    private final Pattern fonction = Pattern.compile("log|cos|sin|sqrt|abs");
    private int pos;
    private double value;
    private String fct;
    private String s;


    public syntaxe(String str) {
        this.s = str;
        this.pos = 0;
        this.value = 0.0D;
    }

    public String getFonction() {
        return this.fct;
    }

    public double getVal() {
        return this.value;
    }

    public char prochain_symbole() throws expressionErroneeException {

        if (this.pos == this.s.length()) {
            return '#';
        } else {
            Matcher entM = this.nombre.matcher(this.s.substring(this.pos));
            if (entM.lookingAt()) {
                this.value = Double.parseDouble(entM.group());
                this.pos += entM.group().length();
                return 'i';
            } else {
                Matcher fonct = this.fonction.matcher(this.s.substring(this.pos));
                if (fonct.lookingAt()) {
                    this.fct = fonct.group();
                    this.pos += fonct.group().length();
                    return '?';
                } else {
                    char c = this.s.charAt(this.pos++);
                    if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
                        throw new expressionErroneeException();
                    } else {
                        return c;
                    }
                }
            }
        }
    }



}
