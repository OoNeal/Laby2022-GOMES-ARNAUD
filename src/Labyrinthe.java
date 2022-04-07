import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe{

    public static final char MUR = 'X'; 
    public static final char PJ = 'P';
    public static final char SORTIE = 'S';
    public static final char VIDE = '.';

    public static final String HAUT = "haut";
    public static final String BAS = "bas";
    public static final String GAUCHE = "gauche";
    public static final String DROITE = "droite";

    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;

    public Labyrinthe(boolean[][] m,Personnage p, Sortie s){
        this.murs = m;
        this.personnage = p;
        this.sortie = s;
    }

    public char getChar(int x, int y) {
        char cases;
        if(this.murs[x][y]){
            cases = MUR;
        }else if((x==this.personnage.getX()) && (y==this.personnage.getY())){
            cases = PJ;
        }else if((x==this.sortie.getX()) && (y==this.sortie.getY())){
            cases = SORTIE;
        }else{
            cases = VIDE;
        }
        return cases;
    }


    public static int[] getSuivant(int x, int y, String action) throws ActionInconnueException{
        int[] coordonnees = new int[2];
        switch (action) {
            case HAUT -> {
                coordonnees[0] = x - 1;
                coordonnees[1] = y;
            }
            case BAS -> {
                coordonnees[0] = x + 1;
                coordonnees[1] = y;
            }
            case GAUCHE -> {
                coordonnees[0] = x;
                coordonnees[1] = y - 1;
            }
            case DROITE -> {
                coordonnees[0] = x;
                coordonnees[1] = y + 1;
            }
            default -> throw new ActionInconnueException(action);
        }
        return coordonnees;
    }


    public void deplacerPerso(String action) throws ActionInconnueException{
        int[] pos;
        pos = getSuivant(this.personnage.getX(),this.personnage.getY(),action);
        while(!this.murs[pos[0]][pos[1]]){
            this.personnage.setX(pos[0]);
            this.personnage.setY(pos[1]);
            pos = getSuivant(this.personnage.getX(), this.personnage.getY(), action);
        }
    }


    public String toString() {
        String laby = "";
        for(int i=0;i<this.murs.length;i++){
            for(int j=0;j<this.murs[i].length;j++){
                laby += getChar(i,j);
            }
            laby += "\n";
        }
        return laby;
    }

    public boolean etreFini() {
        return ((this.personnage.getX()==this.sortie.getX()) && (this.personnage.getY()==this.sortie.getY()));
    }

    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException,FichierIncorrectException {
        BufferedReader br = new BufferedReader(new FileReader(nom));
        int nbLigne = Integer.parseInt(br.readLine());
        int nbColonne = Integer.parseInt(br.readLine());
        boolean[][] m = new boolean[nbLigne][nbColonne];
        String ligne = "";
        Sortie s = new Sortie(-1,-1);
        Personnage p = new Personnage(-1,-1);
        for(int i=0;i<nbLigne;i++){
            ligne = br.readLine();
            for(int j=0;j<nbColonne;j++){
                char element = ligne.charAt(j);
                if(element=='X'){
                    m[i][j] = true;
                }else if(element=='.'){
                    m[i][j] = false;
                }else if(element=='S'){
                    s = new Sortie(i,j);
                }else if(element=='P'){
                    p = new Personnage(i,j);
                }

            }
        }
        Labyrinthe laby = new Labyrinthe(m,p,s);
        br.close();
        return laby;
    }

}
