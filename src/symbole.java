public abstract class symbole {
    protected String name;
    public symbole () {};
    public symbole(String name)
    {
        this.name=name;
    };
    public String getName()
    {
        return name;
    };
    public void setName(String n)
    {
        this.name = n;
    }
    public void afficherInfo()
    {
        System.out.println("Le nom de la variable est : "+this.name);
    };
}

