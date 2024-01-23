public class variable extends symbole
{
    private Double valeur;

    public variable () { };
    public variable(Double valeur, String nom)
    {
        super(nom);
        this.valeur=valeur;
    };
    public Double getValeur()
    {
        return valeur;
    };
    public void setValeur(double val)
    {
        this.valeur = val;
    };
    public void afficherInfo()
    {
        super.afficherInfo();
        System.out.println("La valeur est : "+this.valeur);
    };
}
