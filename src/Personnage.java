public class Personnage extends AbstractCombattant{

    private Classe classe;

    public Personnage() {
        super();
    }

    public Personnage(String nom, int degats, int pointDeVie, Classe classe) {
        super(nom, degats, pointDeVie);
        // Equivalant à :
        // new AbstractCombattant(nom, degats, pointDeVie);
        this.classe = classe;
    }

    /**
     * Cette méthode utiliser la méthode lancerAttaque() pour attaquer un adversaire
     * @param adversaire
     */
    @Override
    public void attaquer(ICombattant adversaire) {
        System.out.println(this.getNom() + " attaque " + adversaire.getNom());
        adversaire.defendre(this.classe.getAttaque().lancerAttaque());
        System.out.println("Il reste à " + adversaire.getNom() + " : " + adversaire.getPointDeVie() + " pdv");
    }
}