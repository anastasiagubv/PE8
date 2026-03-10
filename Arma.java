public class Arma {
    private String nom;
    private String tipus;
    private boolean magica;
    private double dany;

    public Arma() {

    }

    public Arma(String nom, String tipus, boolean magica, double dany) {
        setNom(nom);
        setTipus(tipus);
        setMagica(magica);
        setDany(dany);
    }

    // Nom
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Tipus
    public String getTipus() {
        return this.tipus;
    }
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    // Màgica
    public boolean isMagica() {
        return this.magica;
    }
    public void setMagica(boolean magica) {
        this.magica = magica;
    }

    // Dany
    public double getDany() {
        return this.dany;
    }
    public void setDany(double dany) {
        this.dany = Math.max(1, Math.min(100, dany)); // entre 1 i 100
    }

    @Override
    public String toString() {
        return nom + " | Tipus: " + tipus + 
               " | Dany: " + dany + 
               " | Màgica: " + (magica ? "Sí" : "No");
    }
}
