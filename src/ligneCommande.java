public class ligneCommande {
    private Commande cmd;
    private symbole sym;
    private ExpressionMathematique exp;
    public ligneCommande(Commande cmd,symbole sym,ExpressionMathematique exp){
        this.cmd=cmd;
        this.exp=exp;
        this.sym=sym;
    }
    public ExpressionMathematique getExpression(){return exp;}
    public Commande getCmd(){return cmd;}
}