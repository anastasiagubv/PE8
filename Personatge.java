import java.util.ArrayList;

public class Personatge {

    // Atributs principals
    private String nom;
    private int edat;
    private String raça;

    // Derivats
    private double salut;
    private double mana;

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
            int intelligencia, int saviesa, int carisma) {
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

    public void setSalut(int s) {
        this.salut = Math.max(0, Math.min(constitucio * 50, s));
    }

    // Mana
    public double getMana() {
        return mana;
    }

    public void setMana(int m) {
        this.mana = Math.max(0, Math.min(intelligencia * 30, m));
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

    public double atacar( ) {
        double atacTotal = 0;

        if () {
            
        } else {

        }
        return atacTotal;
    }

    public void defensar(double dany) {

    }

    public void canviaArma() {

    }

    public void regenarVida() {

    }

    public void regenarMana() {

    }

    public boolean esquivar() {

    }

    public void rebreDanyAtac(double dany) {

    }
}
