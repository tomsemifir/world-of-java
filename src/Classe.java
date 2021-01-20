import java.util.List;
import java.util.Random;

public class Classe {

    private String nom;
    private List<IAttaque> attaques;

    public Classe() {
    }

    public Classe(String nom, List<IAttaque> attaques) {
        this.nom = nom;
        this.attaques = attaques;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<IAttaque> getAttaques() {
        return attaques;
    }

    /**
     * Getter qui renvoie une attaque de la liste des attaques choisie aleatoirement
     * @return
     */
    public IAttaque getAttaque() {
        Random random = new Random();
        return this.attaques.get(random.nextInt(this.attaques.size()));
    }

    public void setAttaques(List<IAttaque> attaques) {
        this.attaques = attaques;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "nom='" + nom + '\'' +
                ", attaques=" + attaques +
                '}';
    }
}
