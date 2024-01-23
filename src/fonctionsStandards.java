public class fonctionsStandards extends symbole
{
    // Les variables
    private int code;
    // Le constructeur
    public fonctionsStandards(String nom ,int code){
        super(nom);
        this.code = code;
    }
    // Getters
    public int getCode() {
        return code;
    }
}
