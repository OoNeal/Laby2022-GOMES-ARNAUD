import src.ActionInconnueException;
import java.util.Scanner;
import java.io.IOException;

public class MainLaby {
    public static void main(String[] args) {
        boolean end = false;
        String nomFichier = "";
        String action = "";
        Labyrinthe laby = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans le jeu du labyrinthe !");
        System.out.println("Quel est le nom du fichier contenant le labyrinthe ?");
        nomFichier = sc.nextLine();
        try {
            laby = Labyrinthe.chargerLabyrinthe(nomFichier);
        }
        catch (FichierIncorrectException e2) {
            System.out.println("Le fichier n'existe pas ");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement du labyrinthe");
            System.exit(1);
        }
        while (!end) {
            System.out.println(laby.toString());
            System.out.println("Veuillez entrer une action :");
            action = sc.nextLine();
            if (action.equals("exit")) {
                end = true;
            } else {
                try {
                    laby.deplacerPerso(action);
                }
                catch (ActionInconnueException e) {
                    System.out.println("Action inconnue");
                    System.out.println("Veuillez entrer une action :");
                    action = sc.nextLine();
                }
            }
            if(laby.etreFini()){
                System.out.println("Vous avez reussi a finir le labyrinthe");
                end = true;
            }
        }
    }
}