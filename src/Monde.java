import java.util.*;

public class Monde {


    private static Map<String, Classe> classes = initClasses();

    private static Scanner scanner = new Scanner(System.in);


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
    public static Personnage personnageFactory() {
        System.out.println("Création d'un personnage ---------");
        // Initialisation des attributs du personnage à vide
        String nom = "";
        int degats = 0;
        int pointDeVie = 0;
        Classe classe = new Classe();

        // Vérifie que le nom n'est pas égal à rien
        while(nom.equals("")) {
            System.out.println("Saisir un nom :");
            nom = scanner.next();
        }
        // Vérifie que les degats ne sont pas égaux à 0
        while(degats == 0) {
            System.out.println("Saisir les dégats :");
            degats = scanner.nextInt();
        }
        // Vérifie que les points de vie ne sont pas égaux à 0
        while(pointDeVie == 0) {
            System.out.println("Saisir les points de vie :");
            pointDeVie = scanner.nextInt();
        }
        // Demande à l'utisateur de choisir sa classe
        classe = choisirClasse();

        return new Personnage(nom, degats, pointDeVie, classe);
    }

    /**
     * Cette méthode créer et retourne un monstre
     * @return
     */
    public static Monstre monstreFactory() {
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
     * Cette méthode créer et retourne un dictionnaire de classes
     * @return
     */
    public static Map<String, Classe> initClasses() {
        Map<String, Classe> classes = new HashMap<>();
        classes.put("Mage", new Classe("Mage", initAttaques()));
        classes.put("Archer", new Classe("Archer", initAttaques()));
        classes.put("Orc", new Classe("Orc", initAttaques()));
        return classes;
    }

    /**
     * Cette méthode créer et retourne un dictionnaire d'attaques
     * @return
     */
    public static List<IAttaque> initAttaques() {
        List<IAttaque> attaques = new ArrayList<>();
        attaques.add(new BasicAttaque("Attaque Légère", "description", 10, 90));
        attaques.add(new BasicAttaque("Attaque Normale", "description", 20, 60));
        attaques.add(new BasicAttaque("Attaque Lourde", "description", 30, 30));
        return attaques;
    }

    /**
     * Cette méthode affiche toutes les classes disponibles
     * et demande à l'utilisateur d'en choisir une
     * @return
     */
    public static Classe choisirClasse() {
        System.out.println("Voici les classes disponibles : ");
        for (Map.Entry<String, Classe> classe : classes.entrySet()) {
            System.out.println(" ** " + classe.getKey());
        }

        Classe c = null;

        // Tant que la classe n'a pas été trouvée, demandez une classe à l'utilisateur
        while (c == null) {
            System.out.println("Quelle classe choisissez-vous ?");
            c = getClasse(scanner.next());
            // Si classe est toujours egale à null alors afficher erreur
            if(c == null) {
                System.out.println("Cette classe n'existe pas, recommencez");
            }
        }
        return c;
    }

    /**
     * Cette méthode retourne la classe avec le nom : "nom"
     * @param nom
     * @return
     */
    public static Classe getClasse(String nom)
    {
        return classes.get(nom);
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
