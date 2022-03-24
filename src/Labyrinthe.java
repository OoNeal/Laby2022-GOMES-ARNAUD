class ActionInconnueException extends Exception{ }

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
        if(this.murs[x][y]){
            case = MUR;
        }else if((x==this.personnage.getX()) && (y==this.personnage.getY())){
            case = PJ;
        }else if((x==this.sortie.getX()) && (y==this.sortie.getY())){
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
        }else if(action==DROITE){
            coordonnees[0] = x;
            coordonnees[1] = y+1;
        }else{
            throw new ActionInconnueException(action);
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
        boolean fini;
        if((this.personnage.getX()==this.sortie.getX()) && (this.personnage.getY()==this.sortie.getY())){
            fini = true;
        }else{
            fini = false;
        }
        return fini;
    }

    public static Labyrinthe chargerLabyrinthe(String nom) {
        throw new Error("TODO");
    }

}
