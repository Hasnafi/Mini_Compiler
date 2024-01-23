import com.sun.jdi.Value;

import javax.swing.*;
import java.security.Key;
import java.util.*;
import java.util.HashMap;

public class DecouperLinge
{
    private String ligne;
    collectionSymboles table = new collectionSymboles();
    public DecouperLinge ()
    {

    }
    public void decouper(String l) throws CommandeNameException, AffecterVariableException, VariableFonctionException,VaribaleCommandeException, VariableExisteException,VariableNonExisteException,Exception,ValeurException,ValeurException01
    {
        final String SEPARATEUR = " ";
        String mots[] = l.split(SEPARATEUR);
        List<String> ligne = new ArrayList<String>();
        for (int i = 0; i < mots.length; i++)
        {
            if (mots[i].equals(""))
            { }
            else
            {
                ligne.add(mots[i]);
            }
        }
        if (!ligne.get(0).equals("let") && !ligne.get(0).equals("print") )
            throw new CommandeNameException();
        ///////////////////////// LET

        if (ligne.get(0).equals("let"))
        {
            if(ligne.size() == 1)
                throw new ValeurException01();
            if(ligne.size() == 2)
                throw new ValeurException();
            if(ligne.get(1).equals("print") || ligne.get(1).equals("let"))
                throw new VaribaleCommandeException();
            if(ligne.get(1).equals("sin") || ligne.get(1).equals("cos") || ligne.get(1).equals("tan")|| ligne.get(1).equals("abs")|| ligne.get(1).equals("sqrt")|| ligne.get(1).equals("log"))
                throw new VariableFonctionException();
            if(!ligne.get(2).equals("=") )
                throw new AffecterVariableException();



            String nameVariable = ligne.get(1);
            String expression0 = "";
            for (int i=3; i<(ligne.size());i++) {
                expression0 = expression0.concat(ligne.get(i));
            }


            compilateur comp = new compilateur();
            double valeurVariable = comp.analyseur2(expression0);

            variable var = new variable(valeurVariable,nameVariable);
            boolean bool = table.verifierSymbole(var);
            if (bool == true) {
                throw new VariableExisteException();
            }else { table.ajouterSymbole(var); }
        }


        ///////////////////////// PRINT

        if(ligne.get(0).equals("print"))
        {
            if(ligne.get(1).equals("print") || ligne.get(1).equals("let"))
                throw new VaribaleCommandeException();
            if(ligne.get(1).equals("sin") || ligne.get(1).equals("cos") || ligne.get(1).equals("tan")|| ligne.get(1).equals("abs")|| ligne.get(1).equals("sqrt")|| ligne.get(1).equals("log"))
                throw new VariableFonctionException();


            // L'EXPRESSION APRES PRINT
            String expression = "";
            for (int i=1; i<(ligne.size());i++) {
               expression = expression.concat(ligne.get(i));
            }
            // LA LIST SYMOU DES VARIABLES QUI EXISTE DEJA
            List<variable> symou = new ArrayList<variable>();
            symou = table.getSymboles();

            // PARCOUR DE LISTE DES VARIABLE

            boolean stop = false;
            String expression2="";

            Map<Double, String> wow = new HashMap<Double, String>();
            for (int e=0;e<symou.size();e++)
            {
                boolean boul = expression.contains(symou.get(e).name);
                if (boul == true)
                {
                    wow.put(symou.get(e).getValeur(),symou.get(e).name);
                    stop = true;
                }
            }

            expression2 = expression;
            if (stop == true)
            {

                for (Map.Entry<Double, String> entry : wow.entrySet()) {
                    Double key = entry.getKey();
                    String value = entry.getValue();
                    expression2 = expression2.replaceAll(value,String.valueOf(key));

                }
                compilateur comp = new compilateur();
                comp.analyseur(expression2);

            }
            else
            {
                boolean isNumeric =  expression.matches("[+-]?\\d*(\\.\\d+)?");
                boolean isFcnt =  expression.matches("log|cos|sin|sqrt|abs");
                boolean isOp = expression.contains("+");
                boolean isOp1 = expression.contains("-");
                boolean isOp2 = expression.contains("/");
                boolean isOp3 = expression.contains("*");
                boolean isOp4 = expression.contains(")");
                boolean isOp5 = expression.contains("(");
                if (isNumeric == true || isOp == true || isOp1 == true || isOp2 == true || isOp3 == true || isOp4 == true || isOp5 == true)
                {
                    compilateur comp = new compilateur();
                    comp.analyseur(expression);
                }
                else throw new VariableNonExisteException();
            }

        }
    }

}
