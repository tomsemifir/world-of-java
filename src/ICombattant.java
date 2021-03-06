public interface ICombattant {
    /**
     * Cette méthode appelle la méthode défendre d'un adversaire pour lui infliger des dégats
     * @param adversaire
     */
    public void attaquer(ICombattant adversaire);

    /**
     * Cette méthode inflige des dégats au combattant
     * @param degats
     */
    public void defendre(int degats);

    /**
     * Cette méthode vérifie que le combattant est mort
     * Si il est vivant : retourne "false"
     * Si il est mort : retourne "true"
     * @return
     */
    public boolean estMort();

    // Getters et Setters
    public String getNom();
    public int getDegats();
    public int getPointDeVie();
    public void setNom(String nom);
    public void setDegats(int degats);
    public void setPointDeVie(int pointDeVie);
}
