import java.util.Random;

public class BasicAttaque implements IAttaque{

    private String nom;
    private String description;
    private int degats;
    private double chanceToucher;

    public BasicAttaque() {
    }

    public BasicAttaque(String nom, String description, int degats, double chanceToucher) {
        this.nom = nom;
        this.description = description;
        this.degats = degats;
        this.chanceToucher = chanceToucher;
    }

    /**
     * Cette méthode génère un nombre aléatoire entre 0 et 100
     * Si ce nombre est inférieur à la chance de toucher, retourne les degats
     * Sinon affiche une erreur et retourn 0
     * @return
     */
    public int lancerAttaque() {
        Random random = new Random();
        if(random.nextDouble() * 100 < getChanceToucher()) {
            return getDegats();
        } else {
            System.out.println("L'attaque a échoué");
        }

        return 0;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getDegats() {
        return degats;
    }

    @Override
    public void setDegats(int degats) {
        this.degats = degats;
    }

    @Override
    public double getChanceToucher() {
        return chanceToucher;
    }

    @Override
    public void setChanceToucher(double chanceToucher) {
        if(chanceToucher >= 0 && chanceToucher <= 100) {
            this.chanceToucher = chanceToucher;
        } else {
            System.out.println("La chance de toucher doit être comprise entre 0 et 100");
        }
    }

    @Override
    public String toString() {
        return "BasicAttaque{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", degats=" + degats +
                ", chanceToucher=" + chanceToucher +
                '}';
    }
}
