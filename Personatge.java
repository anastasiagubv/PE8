import java.util.ArrayList;

public class Personatge {

    // Atributs principals
    private String nom;
    private int edat;
    private String raça;

    // Derivats 
    private int salut;
    private int mana;

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
    public Personatge(String nom, int edat, String raça, int forca, int destresa, int constitucio,  
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
        
    }

    // Constructor automàtic
    public Personatge(String nom, int edat, String raça) {
        setNom(nom);
        setEdat(edat);
        setRaça(raça);

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
    public int  getForça() { 
        return força; 
    }
    public void setForça(int f) { 
        this.força = Math.max(5, Math.min(20, f)); 
    }

    // Destresa
    public int  getDestresa() { 
        return destresa; 
    }
    public void setDestresa(int d) { 
        this.destresa = Math.max(5, Math.min(20, d)); 
    }

    // Constitució
    public int  getConstitucio() { 
        return constitucio; 
    }
    public void setConstitucio(int c) { 
        this.constitucio = Math.max(5, Math.min(20, c)); 
    }

    // Intel·ligència
    public int  getIntelligencia() { 
        return intelligencia; 
    }
    public void setIntelligencia(int i) { 
        this.intelligencia = Math.max(5, Math.min(20, i)); 
    }

    // Saviesa
    public int  getSaviesa() { 
        return saviesa; 
    }
    public void setSaviesa(int s) { 
        this.saviesa = Math.max(5, Math.min(20, s)); 
    }

    // Carisma
    public int  getCarisma() { 
        return carisma; 
    }
    public void setCarisma(int c) { 
        this.carisma = Math.max(5, Math.min(20, c)); 
    }

    // Salut
    public int  getSalut() { 
        return salut; 
    }
    public void setSalut(int s) { 
        this.salut = Math.max(0, Math.min(0, Math.min(constitucio * 50, s))); 
    }

    // Mana
    public int  getMana() { 
        return mana; 
    }
    public void setMana(int m) { 
        this.mana = Math.max(0, Math.min(intelligencia * 30, m)); 
    }

    
}
