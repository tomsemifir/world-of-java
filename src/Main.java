import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nombre de combattants par groupe : ");
        int nbr = new Scanner(System.in).nextInt();

        Groupe personnages = Monde.groupePersonnageFactory(nbr);
        Groupe monstres = Monde.groupeMonstreFactory(nbr);

        Monde.combatGvsG(personnages, monstres);
    }
}
