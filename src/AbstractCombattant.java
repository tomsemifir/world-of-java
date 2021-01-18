public abstract class AbstractCombattant implements ICombattant {

    private String nom;
    private int degats;
    private int pointDeVie;

    public AbstractCombattant() {
    }

    public AbstractCombattant(String nom, int degats, int pointDeVie) {
        this.nom = nom;
        this.degats = degats;
        this.pointDeVie = pointDeVie;
    }

    public void attaquer(ICombattant adversaire) {
        System.out.println(this.getNom() + " attaque " + adversaire.getNom() + " et lui inflige " + this.getDegats() + " points de dégats");
        adversaire.defendre(this.getDegats());
        System.out.println("Il reste à " + adversaire.getNom() + " : " + adversaire.getPointDeVie() + " pdv");
    }

    public void defendre(int degats) {
        this.setPointDeVie(this.getPointDeVie() - degats);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    @Override
    public String toString() {
        return "AbstractCombattant{" +
                "nom='" + nom + '\'' +
                ", degats=" + degats +
                ", pointDeVie=" + pointDeVie +
                '}';
    }
}
