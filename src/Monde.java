import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Monde {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Cette méthode fait combattre à tour de rôle le personnage et le monstre
     * @param personnage
     * @param monstre
     */
    public static void combat(ICombattant personnage, ICombattant monstre) {
        int tour = 1;
        boolean isTurn = true;

        while (personnage.getPointDeVie() > 0 && monstre.getPointDeVie() > 0) {
            System.out.println("------- TOUR " + tour + " -------");
            if (isTurn) {
                personnage.attaquer(monstre);
            } else {
                monstre.attaquer(personnage);
            }
            isTurn = !isTurn;
            tour++;
            scanner.nextLine();
        }

        quiGagne(personnage, monstre);
    }

    /**
     * Méthode qui affiche le résultat du combat
     * @param personnage
     * @param monstre
     */
    public static void quiGagne(ICombattant personnage, ICombattant monstre) {
        if (personnage.getPointDeVie() > 0) {
            System.out.println(personnage.getNom() + " a gagné !");
        } else {
            System.out.println(monstre.getNom() + " a gagné !");
        }
    }

    /**
     * Cette méthode créer et retourne un personnage
     * @return
     */
    public static Personnage PersonnageFactory() {
        //Nouveau Personnage
        Personnage p = new Personnage("", 0, 0, classeFactory());
        System.out.println("Création d'un personnage ---------");

        // Vérifie que le nom n'est pas égal à rien
        while(p.getNom().equals("")) {
            System.out.println("Saisir un nom :");
            p.setNom(scanner.next());
        }
        // Vérifie que les degats ne sont pas égaux à 0
        while(p.getDegats() == 0) {
            System.out.println("Saisir les dégats :");
            p.setDegats(scanner.nextInt());
        }
        // Vérifie que les points de vie ne sont pas égaux à 0
        while(p.getPointDeVie() == 0) {
            System.out.println("Saisir les points de vie :");
            p.setPointDeVie(scanner.nextInt());
        }
        return p;
    }

    /**
     * Cette méthode créer et retourne un monstre
     * @return
     */
    public static Monstre MonstreFactory() {
        Monstre m = new Monstre(genererNom(), 5, 50);
        return m;
    }

    /**
     * Cette méthode créer et retourne une BasicAttaque
     * @return
     */
    public static BasicAttaque basicAttaqueFactory() {
        System.out.println("Création d'un attaque ---------");
        BasicAttaque a = new BasicAttaque("", "Ceci est une attaque", 10, 50);
        System.out.println("Nom :");
        a.setNom(scanner.next());
        return a;
    }

    /**
     * Cette méthode créer et retourne une classe
     * @return
     */
    public static Classe classeFactory() {
        System.out.println("Création d'une classe ----------");
        Classe c = new Classe();
        System.out.println("Nom :");
        c.setNom(scanner.next());

        // Création d'une liste d'attaque pour la classe
        List<IAttaque> attaques = new ArrayList<>();
        attaques.add(basicAttaqueFactory());
        attaques.add(basicAttaqueFactory());

        c.setAttaques(attaques);

        return c;
    }

    /**
     * Cette méthode génère un nom aléatoire
     * @return
     */
    public static String genererNom() {
        //Tableaux de noms
        String[] debutNom = new String[]{"chat","chien","chaton"};
        String[] finNom = new String[]{" mechant"," de feu"," de la mort"};

        //Construction du nom assemblé
        Random random = new Random();
        String debut = debutNom[random.nextInt(debutNom.length)];
        String fin = finNom[random.nextInt(finNom.length)];
        String str = debut + fin;
        return str;
    }

    /**
     * Cette méthode affiche les informations du monde
     */
    public static void afficherInformations()
    {
        // TODO
    }

}
