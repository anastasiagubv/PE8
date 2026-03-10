import java.util.ArrayList;

public class Personatge {

    // Atributs principals
    private String nom;
    private int edat;
    private String raça;

    // Derivats
    private double salut;
    private double mana;

    // Atribut adicional
    private int nivell;
    private int experiencia;

    // Característiques
    private int força;
    private int destresa;
    private int constitucio;
    private int intelligencia;
    private int saviesa;
    private int carisma;

    // Inventari i combat
    private ArrayList<Arma> inventari = new ArrayList<>();
    private Arma armaEquipada;
    private boolean defensant;

    public Personatge() {

    }

    // Constructor manual
    public Personatge(String nom, int edat, String raça, int força, int destresa, int constitucio,
            int intelligencia, int saviesa, int carisma, int nivell, int experiencia) {
        setNom(nom);
        setEdat(edat);
        setRaça(raça);
        setForça(força);
        setDestresa(destresa);
        setConstitucio(constitucio);
        setIntelligencia(intelligencia);
        setSaviesa(saviesa);
        setCarisma(carisma);
        setSalut(carisma);
        setMana(carisma);

        // Adicionals
        this.nivell = 1;
        this.experiencia = 0;
    }

    // Constructor automàtic
    public Personatge(String nom, int edat, String raça) {
        setNom(nom);
        setEdat(edat);
        setRaça(raça);

        int[] stats = new int[6];
        for (int i = 0; i < stats.length; i++) {
            stats[i] = 5;

            int restants = 30;
            while (restants > 0) {
                int j = (int) (Math.random() * 6);
                if (stats[j] < 20) {
                    stats[j]++;
                    restants--;
                }
            }
        }

        setForça(stats[0]);
        setDestresa(stats[1]);
        setConstitucio(stats[2]);
        setIntelligencia(stats[3]);
        setSaviesa(stats[4]);
        setCarisma(stats[5]);

        setSalut(constitucio * 50);
        setMana(intelligencia * 30);
    }

    // Getters i Settes
    // Nom
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Edat
    public int getEdat() {
        return this.edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    // Raça
    public String getraça() {
        return this.raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    // Força
    public int getForça() {
        return força;
    }

    public void setForça(int f) {
        this.força = Math.max(5, Math.min(20, f));
    }

    // Destresa
    public int getDestresa() {
        return destresa;
    }

    public void setDestresa(int d) {
        this.destresa = Math.max(5, Math.min(20, d));
    }

    // Constitució
    public int getConstitucio() {
        return constitucio;
    }

    public void setConstitucio(int c) {
        this.constitucio = Math.max(5, Math.min(20, c));
    }

    // Intel·ligència
    public int getIntelligencia() {
        return intelligencia;
    }

    public void setIntelligencia(int i) {
        this.intelligencia = Math.max(5, Math.min(20, i));
    }

    // Saviesa
    public int getSaviesa() {
        return saviesa;
    }

    public void setSaviesa(int s) {
        this.saviesa = Math.max(5, Math.min(20, s));
    }

    // Carisma
    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int c) {
        this.carisma = Math.max(5, Math.min(20, c));
    }

    // Salut
    public double getSalut() {
        return salut;
    }

    public void setSalut(double s) {
        this.salut = Math.max(0, Math.min(constitucio * 50, s));
    }

    // Mana
    public double getMana() {
        return mana;
    }

    public void setMana(double m) {
        this.mana = Math.max(0, Math.min(intelligencia * 30, m));
    }

    // Defensant
    public boolean isDefensant() {
        return this.defensant;
    }

    public void setDefensant(boolean defensant) {
        this.defensant = defensant;
    }

    // Atribut adicional - Nivell
    public int getNivell() {
        return this.nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    // Atribut adicional - Experiencia
    public int getExperiencia() {
        return this.experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "==============================\n" +
                "  " + nom + " (" + raça + ", " + edat + " anys)\n" +
                "==============================\n" +
                "  Salut:          " + salut + "\n" +
                "  Maná:           " + mana + "\n" +
                "------------------------------\n" +
                "  Força:          " + força + "\n" +
                "  Destresa:       " + destresa + "\n" +
                "  Constitució:    " + constitucio + "\n" +
                "  Intel·ligència: " + intelligencia + "\n" +
                "  Saviesa:        " + saviesa + "\n" +
                "  Carisma:        " + carisma + "\n" +
                "==============================\n" +
                "  Nivell:         " + nivell + "\n" +
                "==============================";
    }

    // Accion i habilitats
    public void equiparArma(int i) {
        Arma arma = inventari.get(i);

        if (arma.isMagica()) {
            if (intelligencia < 10) {
                System.out.println("No tens intel·ligiència suficient.\nIntel·ligiència actual: " + intelligencia);
            } else {
                this.armaEquipada = arma;
                System.out.println("Arma equipada correctament!");
            }
        } else {
            this.armaEquipada = arma;
            System.out.println("Arma equipada correctament!");
        }
    }

    public double atacar(Personatge enemic) {
        double dany = 0;

        if (armaEquipada == null) {
            dany = força * (1 + 0.0 / 100);
        } else if (!armaEquipada.isMagica()) {
            dany = força * (1 + armaEquipada.getDany() / 100);
        } else {
            dany = armaEquipada.getDany() * intelligencia / 100;
        }

        enemic.rebreDanyAtac(dany);
        return dany;
    }

    public boolean esquivar() {
        boolean esquivar = false;

        double probabilitat = (destresa - 5) * 3.33;
        int numRandom = (int) (Math.random() * 100) + 1;

        if (numRandom < probabilitat) {
            esquivar = true;
        }
        return esquivar;
    }

    public void defensar() {
        this.defensant = true;
    }

    public void rebreDanyAtac(double dany) {
        if (esquivar()) {
            return;
        }
        if (this.isDefensant()) {
            dany = dany / 2;
        }   

        dany = dany * this.negociar();
        this.setSalut(this.getSalut() - dany);
    }

    public void regenarVida() {
        setSalut(salut + constitucio * 3);
    }

    public void regenarMana() {
        setMana(mana + intelligencia * 2);
    }

    // Mètodes adicionals
    // Pujar nivell
    public void guanyarExp(int punts) {
        experiencia += punts;
        pujarNivell();
    }

    public void pujarNivell() {
        if (experiencia >= nivell * 100) {
            nivell++;
            experiencia = 0;

            System.out.println("Has pujat de nivell!" + "\n" + "Nivell actual: " + nivell);
        }
    }

    // Negociar combat
    public double negociar() {
        double multiplicador = 0;

        if (carisma >= 15) {
            System.out.println("Veredicte de la negociació." + "\n" + "Rebs un 30% menys de dany.");
            multiplicador = 0.7;
        } else if (carisma >= 10) {
            System.out.println("Veredicte de la negociació." + "\n" + "Rebs un 20% menys de dany.");
            multiplicador = 0.8;
        } else if (carisma >= 5) {
            System.out.println("Veredicte de la negociació." + "\n" + "Rebs un 10% menys de dany.");
            multiplicador = 0.9;
        } else {
            System.out.println("Negociació fallida.");
            multiplicador = 1.0;
        }
        return multiplicador;
    }
}
