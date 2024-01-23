//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Stack;

public class compilateur {
    private String[][] tableau = new String[][]{{null, "CB", null, null, "CB", null, "CB", "CB", null}, {"+CaB", "-CbB", null, null, null, "", null, "", ""}, {null, "ED", null, null, "ED", null, "ED", "ED", null}, {"", "", "*EcD", "/EdD", null, "", null, "", ""}, {null, "-Ee", null, null, "F", null, "F", "F", null}, {null, null, null, null, "(A)f", null, "?(A)g", "i", null}};
    private String terminaux = "+-*/()?i#";
    private Stack<Double> pileValeur;
    private Stack<String> pileFonction;

    public compilateur() {
    }

    public void analyseur(String entrée) throws expressionErroneeException
    {
        syntaxe lex = new syntaxe(entrée);
        Stack<Character> pile = new Stack();
        this.pileFonction = new Stack();
        this.pileValeur = new Stack();
        pile.push('#');
        pile.push('A');
        char tc = lex.prochain_symbole();
        char sommet = (Character)pile.peek();

        while(true) {
            while(!pile.empty()) {
                sommet = (Character)pile.peek();
                if (sommet == tc) {
                    if (tc == 'i') {
                        this.pileValeur.push(lex.getVal());
                    } else if (tc == '?') {
                        this.pileFonction.push(lex.getFonction());
                    }

                    tc = lex.prochain_symbole();
                    pile.pop();
                } else if (sommet >= 'a') {
                    pile.pop();
                    this.calculer(sommet - 97);
                } else {
                    int col = this.terminaux.indexOf(tc);
                    int lig = sommet - 65;
                    pile.pop();
                    String mdp = this.tableau[lig][col];
                    if (mdp == null) {
                        throw new expressionErroneeException();
                    }

                    for(int i = mdp.length() - 1; i >= 0; --i) {
                        pile.push(mdp.charAt(i));
                    }
                }
            }

            System.out.println("La valeur est : " + this.pileValeur.pop());
            return;
        }
    }


    public double analyseur2(String entrée) throws expressionErroneeException
    {
        syntaxe lex = new syntaxe(entrée);
        Stack<Character> pile = new Stack();
        this.pileFonction = new Stack();
        this.pileValeur = new Stack();
        pile.push('#');
        pile.push('A');
        char tc = lex.prochain_symbole();
        char sommet = (Character)pile.peek();

        while(true) {
            while(!pile.empty()) {
                sommet = (Character)pile.peek();
                if (sommet == tc) {
                    if (tc == 'i') {
                        this.pileValeur.push(lex.getVal());
                    } else if (tc == '?') {
                        this.pileFonction.push(lex.getFonction());
                    }

                    tc = lex.prochain_symbole();
                    pile.pop();
                } else if (sommet >= 'a') {
                    pile.pop();
                    this.calculer(sommet - 97);
                } else {
                    int col = this.terminaux.indexOf(tc);
                    int lig = sommet - 65;
                    pile.pop();
                    String mdp = this.tableau[lig][col];
                    if (mdp == null) {
                        throw new expressionErroneeException();
                    }

                    for(int i = mdp.length() - 1; i >= 0; --i) {
                        pile.push(mdp.charAt(i));
                    }
                }
            }
            return this.pileValeur.pop();
        }
    }

    private void calculer(int i) throws expressionErroneeException {
        double v1;
        double v2;
        switch(i) {
            case 0:
                v1 = (Double)this.pileValeur.pop();
                v2 = (Double)this.pileValeur.pop();
                this.pileValeur.push(v1 + v2);
                break;
            case 1:
                v1 = (Double)this.pileValeur.pop();
                v2 = (Double)this.pileValeur.pop();
                this.pileValeur.push(v2 - v1);
                break;
            case 2:
                v1 = (Double)this.pileValeur.pop();
                v2 = (Double)this.pileValeur.pop();
                this.pileValeur.push(v1 * v2);
                break;
            case 3:
                v1 = (Double)this.pileValeur.pop();
                v2 = (Double)this.pileValeur.pop();
                this.pileValeur.push(v2 / v1);
                break;
            case 4:
                v1 = (Double)this.pileValeur.pop();
                this.pileValeur.push(-v1);
            case 5:
            default:
                break;
            case 6:
                v1 = (Double)this.pileValeur.pop();
                this.pileValeur.push(this.fonction((String)this.pileFonction.pop(), v1));
        }

    }

    private Double fonction(String ftc, double val) throws expressionErroneeException {
        if (ftc.equalsIgnoreCase("log")) {
            return Math.log(val);
        } else if (ftc.equalsIgnoreCase("cos")) {
            return Math.cos(val);
        } else if (ftc.equalsIgnoreCase("sin")) {
            return Math.sin(val);
        } else if (ftc.equalsIgnoreCase("sqrt")) {
            return Math.sqrt(val);
        }  else if (ftc.equalsIgnoreCase("abs")) {
            return Math.abs(val);
        }  else {
            throw new expressionErroneeException();
        }
    }
}
