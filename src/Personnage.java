public class Personnage {

    private String nom;
    private int degats;
    private int pointDeVie;

    public Personnage() {}

    public Personnage(String nom, int degats, int pointDeVie) {
        this.nom = nom;
        this.degats = degats;
        this.pointDeVie = pointDeVie;
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
}
