import java.util.Scanner;
import java.io.IOException;

public class MainLaby {
    public static void main(String[] args) {
        boolean end = false;
        String action = "";
        Labyrinthe laby = new Labyrinthe();
        while (!end) {
            try {
                laby.chargerLabyrinthe(args[0]);
            }
            catch (FichierIncorrectException e2) {
                System.out.println("Le fichier n'existe pas ");
                System.exit(0);
            }
            catch (IOException e) {
                System.out.println("Erreur lors du chargement du labyrinthe");
                System.exit(1);
            }
            System.out.println(laby.toString());
            System.out.println("Veuillez entrer une action :");
            Scanner sc = new Scanner(System.in);
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
                    e.printStackTrace();
                }
            }
            if(laby.etreFini()){
                System.out.println("Vous avez réussi à finir le labyrinthe");
                end = true;
            }
        }
    }
}