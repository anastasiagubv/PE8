public class Arma {

    // Atributs
    private String nom;
    private TipusArma tipus;
    private boolean magica;
    private double dany;

    public Arma() {

    }

    public Arma(String nom, TipusArma tipus, boolean magica, double dany) {
        setNom(nom);
        setTipus(tipus);
        setMagica(magica);
        setDany(dany);
    }

    // Getters i setters
    // Nom
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Tipus
    public TipusArma getTipus() {
        return this.tipus;
    }

    public void setTipus(TipusArma tipus) {
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
        String tipusMagia;
        if (isMagica()) {
            tipusMagia = "Sí";
        } else {
            tipusMagia = "No";
        }

        return nom + " | Tipus: " + tipus +
                " | Dany: " + dany +
                " | Màgica: " + tipusMagia;
    }
}
