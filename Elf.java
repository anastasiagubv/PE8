public class Elf extends Personatge{
    
    // Manual
    public Elf(String nom, int edat, int força, int destresa, int constitucio, int intelligencia, int saviesa, int carisma) {
        super(nom, edat, força, destresa, constitucio, intelligencia, saviesa, carisma);
        aplicarModificadors();
    }

    //Automàtic
    public Elf(String nom, int edat) {
        super(nom, edat);
        aplicarModificadors();
    }

    public void aplicarModificadors() {
        setDestresa(getDestresa() + 2);
        setIntelligencia(getIntelligencia() + 2);
    }

    @Override
    public void regenarMana() {
        setMana(getMana() + getIntelligencia() * 3);
    }
}
