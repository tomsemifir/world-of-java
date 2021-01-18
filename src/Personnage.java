public class Personnage extends AbstractCombattant{

    public Personnage() {
        super();
    }

    public Personnage(String nom, int degats, int pointDeVie) {
        super(nom, degats, pointDeVie);
        // Equivalant à :
        // new AbstractCombattant(nom, degats, pointDeVie);
    }
}