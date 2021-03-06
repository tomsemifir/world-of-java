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
        System.out.print(this.getNom() + " attaque " + adversaire.getNom());
        adversaire.defendre(this.classe.getAttaque().lancerAttaque());
        if(adversaire.estMort()) {
            System.out.println(adversaire.getNom() + " est mort !");
        }else {
            System.out.println("Il reste à " + adversaire.getNom() + " : " + adversaire.getPointDeVie() + " pdv");
        }
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + this.getNom() + '\'' +
                ", degats=" + this.getDegats() +
                ", pointDeVie=" + this.getPointDeVie() +
                ", classe=" + classe +
                '}';
    }
}