import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Groupe extends AbstractCombattant{

    private List<ICombattant> combattants = new ArrayList<>();
    private Random random = new Random();

    public Groupe() {}

    public Groupe(List<ICombattant> combattants) {
        this.combattants = combattants;
    }

    /**
     * Cette méthode ajoute un combattant à la liste des combattants
     * @param combattant
     */
    public void addCombattant(ICombattant combattant) {
        this.combattants.add(combattant);
    }

    /**
     * Cette méthode parcours la liste des combattants et vérifie si ils sont morts
     * Si au moins un combattant est vivant : retourne "false"
     * Si tous les combattants sont morts : retourne "true"
     * @return
     */
    public boolean estMort() {
        boolean estMort = true;
        for( ICombattant combattant : combattants) {
            if(combattant.getPointDeVie() > 0) {
                estMort = false;
                break;
            }
        }
        return estMort;
    }

    /**
     * Cette méthode choisie un combattant vivant aléatoire
     * Ce combattant va attaquer un adversaire vivant aléatoire
     * @param adversaires
     */
    public void attaquer(Groupe adversaires) {
        //Choisir un combattant vivant aléatoire qui va taper
        ICombattant combattant = getAliveCombattants().get(random.nextInt(getAliveCombattants().size()));
        //Choisir un adversaire vivant aléatoire
        ICombattant adversaire = adversaires.getAliveCombattants().get(random.nextInt(adversaires.getAliveCombattants().size()));
        //Si le combattant est un personnage, utiliser la méthode attaquer de personnages
        //Sinon utiliser la méthode attaquer de AbstractCombattant
        if(combattant instanceof Personnage) {
            Personnage personnage = (Personnage) combattant;
            personnage.attaquer(adversaire);
        } else {
            combattant.attaquer(adversaire);
        }
    }

    /**
     * Parcours la liste des combattants du groupe
     * Renvoie une liste de tous ceux qui sont vivants
     * @return
     */
    public List<ICombattant> getAliveCombattants() {
        List<ICombattant> aliveCombattants = new ArrayList<>();
        // Pour chaque combattant vivant, l'ajouter à une liste de combattants vivants
        for (ICombattant combattant : this.combattants) {
            if(!combattant.estMort()) {
                aliveCombattants.add(combattant);
            }
        }
        return aliveCombattants;
    }

    public ICombattant getCombattant(int index) {
        return this.combattants.get(index);
    }

    public List<ICombattant> getCombattants() {
        return combattants;
    }

    public void setCombattants(List<ICombattant> combattants) {
        this.combattants = combattants;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "combattants=" + combattants +
                '}';
    }
}
