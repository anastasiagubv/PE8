public class Nan extends Personatge{

    // Manual
    public Nan(String nom, int edat, int força, int destresa, int constitucio, int intelligencia, int saviesa, int carisma) {
        super(nom, edat, força, destresa, constitucio, intelligencia, saviesa, carisma);
        aplicarModificadors();
    }

    //Automàtic
    public Nan(String nom, int edat) {
        super(nom, edat);
        aplicarModificadors();
    }

    public void aplicarModificadors() {
        setConstitucio(getConstitucio() + 4);
        setDestresa(getDestresa() - 1);
    }

    @Override
    public void rebreDanyAtac(double dany) {
        if (esquivar()) {
            return;
        }
        if (this.isDefensant()) {
            dany = (dany / 2) * 0.75;
        }

        dany = dany * this.negociar();
        this.setSalut(this.getSalut() - dany);
    }

    @Override
    public void regenarVida() {
        setSalut(getSalut() + getConstitucio() * 4);
    }
}
