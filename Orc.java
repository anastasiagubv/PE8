public class Orc extends Personatge{

    // Manual
    public Orc(String nom, int edat, int força, int destresa, int constitucio, int intelligencia, int saviesa, int carisma) {
        super(nom, edat, força, destresa, constitucio, intelligencia, saviesa, carisma);
        aplicarModificadors();
    }

    //Automàtic
    public Orc(String nom, int edat) {
        super(nom, edat);
        aplicarModificadors();
    }

    public void aplicarModificadors() {
        setForça(getForça() + 3);
        setConstitucio(getConstitucio() + 1);
    }

    @Override
    public void equiparArma(int i) {
        Arma arma = getInventari().get(i);

        if (arma.isMagica()) {
            System.out.println("Els orcs no poden equipar armes màgiques!");
        } else {
            super.equiparArma(i);
            System.out.println("Arma equipada correctament!");
        }
    }

    @Override
    public double atacar(Personatge enemic) {
        double dany = 0;

        if (getArmaEquipada() == null) {
            dany = getForça() * 1.10;
        } else if (!getArmaEquipada().isMagica()) {
            dany = getForça() * (1 + getArmaEquipada().getDany() / 100) * 1.10;
        } else {
            dany = getArmaEquipada().getDany() * getIntelligencia() / 100 * 1.10;
        }

        enemic.rebreDanyAtac(dany);
        return dany;
    }
}
