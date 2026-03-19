public class Huma extends Personatge{
    
    // Manual
    public Huma(String nom, int edat, int força, int destresa, int constitucio, int intelligencia, int saviesa, int carisma) {
        super(nom, edat, força, destresa, constitucio, intelligencia, saviesa, carisma);
        aplicarModificadors();
    }

    // Automàtic
    public Huma(String nom, int edat) {
        super(nom, edat);
        aplicarModificadors();
    }

    public void aplicarModificadors() {
        setForça(getForça() + 1);
        setDestresa(getDestresa() + 1);
        setConstitucio(getConstitucio() + 1);
        setIntelligencia(getIntelligencia() + 1);
        setSaviesa(getSaviesa() + 1);
        setCarisma(getCarisma() + 1);
    }
}
