import jdk.jshell.EvalException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class miniInterpreteur {
    public static void main( String [] args ) throws CommandeNameException, AffecterVariableException,VariableFonctionException,VaribaleCommandeException,VariableExisteException,VariableNonExisteException,Exception,ValeurException,ValeurException01
    {

        DecouperLinge ligne = new DecouperLinge();
        Scanner sc = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("| Entrer vos commandes. Tapez end pour terminer votre programme .|");
        System.out.println("| Une commande doit etre de la forme :                           |");
        System.out.println("| let <variable> = <expression>                                  |");
        System.out.println("| OU                                                             |");
        System.out.println("| print <expression>                                             |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.print(">  ");
        String str = sc.nextLine();
        while (! str.equals("end")) {
            try {
                ligne.decouper(str);
            } catch (CommandeNameException e) {
                System.out.println("Erreur : La commande doit etre print ou bien let !");
            } catch (AffecterVariableException e1) {
                System.out.println("Erreur : La commande LET doit contenir une affection ! ");
            } catch (VariableFonctionException e2) {
                System.out.println("Erreur : Le nom de la variable doit etre different de nom de fonctions standards !");
            } catch (VaribaleCommandeException e3) {
                System.out.println("Erreur : Le nom de la variable doit etre different de nom des commandes !");
            } catch (VariableExisteException e4) {
                System.out.println("Erreur : Vous avez deja declarer cette variable !");
            } catch (VariableNonExisteException e5) {
                System.out.println("Erreur : Variable non declarée !");
            } catch (expressionErroneeException e6) {
                System.out.println("Erreur : Expression erronée !");
            } catch (ValeurException e7) {
                System.out.println("Erreur : Vous devez affecter une valeur a la variable !");
            } catch (ValeurException01 e8) {
                System.out.println("Erreur : Vous devez declarer une variable ! ");
            } catch (ArrayIndexOutOfBoundsException e7) {
                System.out.println("Erreur : Parenthése manquante");
            }
            System.out.print(">  ");
            str = sc.nextLine();
        }
        System.out.println("Fin du programme.");


    }
}
