public class ExpressionMathematique {
    private variable variable;
    private Operateurs opp;
    private Double constante;
    private Parentheses paren;
    private Fonctions fonction;
    public ExpressionMathematique () {};
    public ExpressionMathematique(variable variable,Operateurs opp,Double constante,Parentheses paren,Fonctions fonction){
        this.constante=constante;
        this.fonction=fonction;
        this.opp=opp;
        this.paren=paren;
        this.variable=variable;
    }
    public void setVariable(variable variable){
        this.variable=variable;
    };
    public void setConstante(Double constante){
        this.constante=constante;
    };
    public void setParen(Parentheses paren){
        this.paren=paren;
    };
    public void setOpp(Operateurs opp){
        this.opp=opp;
    };
}


