import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public  class collectionSymboles
{
    private symbole S;
    private variable V;
    private fonctionsStandards fonction;
    private List<variable> symboles = new ArrayList<variable>();

    public collectionSymboles ()
    {

    }

    public List<variable> getSymboles() {
        return symboles;
    }

    public symbole getS() {
        return S;
    }

    public variable getV() {
        return V;
    }

    public boolean verifierSymbole (variable Sym)
    {
        boolean bool = false;
        Iterator<variable> it = symboles.iterator();
        while ((it.hasNext()) && (bool == false))
        {
            if ( (it.next().getName()).equals(Sym.getName()))
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
        }
        return bool;
    }

    public void ajouterSymbole (variable Sym)
    {
        symboles.add(Sym);
        System.out.println("Ok");
    }

    public void recupererVariable(String Sym)
    {
        boolean bool2 = false;
        int i = 0;
        while ( (i < symboles.size()) && (bool2 == false) )
        {
            if ((symboles.get(i).name).equals(Sym))
            {
                bool2 = true;
            }
            else {i++;}
        }
        symboles.get(i).afficherInfo();
    }

    public void afficherCollection()
    {
        for (symbole s:symboles)
        {
            System.out.println("Nom :" +s.getName());
        }
    }


}
