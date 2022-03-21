/** 
 * Squelette de classe labyrinthe
 */
class Labyrinthe{

    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char SORTIE = 'S';
    public static final char VIDE = '.';

    public static final String HAUT = 'haut';
    public static final String BAS = 'bas';
    public static final String GAUCHE = 'gauche';
    public static final String DROITE = 'droite';

    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;

    char getChar(int x, int y) {
        char case;
        if(murs[x][y]){
            case = MUR;
        }else if((x==personnage.getX()) && (y==personnage.getY())){
            case = PJ;
        }else if((x==sortie.getX()) && (y==sortie.getY())){
            case = SORTIE;
        }else{
            case = VIDE;
        }
        return case;
    }


    static int[] getSuivant(int x, int y, String action) {
        int[] coordonnees = new int[2];
        if(action==HAUT){
            coordonnees[0] = x-1;
            coordonnees[1] = y;
        }else if(action==BAS){
            coordonnees[0] = x+1;
            coordonnees[1] = y;
        }else if(action==GAUCHE){
            coordonnees[0] = x;
            coordonnees[1] = y-1;
        }else{
            coordonnees[0] = x;
            coordonnees[1] = y+1;
        }
        return coordonnees;
    }


    void deplacerPerso(String action) throws ActionInconnueException {
        throw new Error("TODO");
    }


    public String toString() {
        throw new Error("TODO");
    }


    public boolean etreFini() {
        throw new Error("TODO");
    }

    public static Labyrinthe chargerLabyrinthe(String nom) {
        throw new Error("TODO");
    }

}
