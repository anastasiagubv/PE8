import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Joc {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Personatge> personatges = new ArrayList<>();

    public static void main(String[] args) {
        Joc p = new Joc();
        p.principal();
    }

    public void principal() {
        menu();
    }

    public void menu() {
        int option = 0;

        do {
            System.out.println("1. Crear personatge");
            System.out.println("2. Jugar combat simple (1 vs 1)");
            System.out.println("3. Sortir");
            option = readInteger("Introdueix opció: ");

            switch (option) {
                case 1:
                    crearPersonatge();
                    break;

                case 2:
                    jugarCombat();
                    break;

                case 3:
                    System.out.println("Programa finalitzat.");
                    break;

                default:
                    System.out.println("Introdueix una opció.");
                    break;
            }
        } while (option != 3);
    }

    public int readInteger(String prompt) {
        boolean validInput = false;
        int input = 0;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = sc.nextInt();
                validInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Error. Entrada de dada incorrecte.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error desconegut. " + e.getMessage());
            }
        }

        sc.nextLine();
        return input;
    }

    public double readDouble(String prompt) {
        boolean validInput = false;
        double input = 0;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = sc.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error. Ha de ser un nombre amb decimals.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error desconegut. " + e.getMessage());
                sc.nextLine();
            }
        }

        sc.nextLine();
        return input;
    }

    public String readString(String prompt) {
        boolean validInput = false;
        String input = "";

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = sc.next();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error. Ha de ser una paraula.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error desconegut. " + e.getMessage());
                sc.nextLine();
            }
        }

        sc.nextLine();
        return input;
    }

    public int readIntegerInRange(String message, int min, int max) {
        int value = 0;
        boolean validNumber = false;
        do {
            value = readInteger(message);
            if (value >= min && value <= max) {
                validNumber = true;
            } else {
                System.out.println("Error. El numero ha de ser entre " + min + " i " + max + ".");
            }
        } while (!validNumber);
        return value;
    }

    // Crear personatge
    public void crearPersonatge() {
        System.out.println("--- Creació de personatge ---");
        System.out.println("=============================");
        char option = 's';
        while (personatges.size() < 2 && option != 'n') {
            String nom = readString("Introdueix el nom: ");
            int edat = readInteger("Introdueix l'edat: ");
            System.out.println();

            System.out.print("Vols crear el personatge de forma automàtica? (s/n): ");
            char automatic = sc.next().charAt(0);

            Personatge personatge = null;
            if (automatic == 's') {
                personatge = menuRaça(nom, edat, 0, 0, 0, 0, 0, 0, true);
            } else {
                int suma = 0;
                int forca = 0, destresa = 0, constitucio = 0, intelligencia = 0, saviesa = 0, carisma = 0;
                do {
                    forca = readIntegerInRange("Introdueix força (5-20): ", 5, 20);
                    destresa = readIntegerInRange("Introdueix destresa (5-20): ", 5, 20);
                    constitucio = readIntegerInRange("Introdueix constitució (5-20): ", 5, 20);
                    intelligencia = readIntegerInRange("Introdueix intel·ligència (5-20): ", 5, 20);
                    saviesa = readIntegerInRange("Introdueix saviesa (5-20): ", 5, 20);
                    carisma = readIntegerInRange("Introdueix carisma (5-20): ", 5, 20);
                    
                    suma = forca + destresa + constitucio + intelligencia + saviesa + carisma;

                    if (suma != 60) {
                        System.out.println("La suma de tots els stats ha de ser 60.");
                    }
                } while (suma != 60);
                personatge = menuRaça(nom, edat, forca, destresa, constitucio, intelligencia, saviesa, carisma, false);
            }

            personatges.add(personatge);
            System.out.println("Personatge creat correctament!");
            System.out.println(personatge);
            personatge.afegirArma(new Arma("Espasa", TipusArma.ESPASA, false, 50));
            personatge.afegirArma(new Arma("Basto Magic", TipusArma.BASTO, true, 80));

            if (personatges.size() < 2) {
                System.out.print("Vols crear un altre personatge? (s/n): ");
                option = sc.next().charAt(0);
            }
        }
    }

    public Personatge menuRaça(String nom, int edat, int forca, int destresa, int constitucio, int intelligencia, 
        int saviesa, int carisma, boolean automatic) {
        int option = 0;

        System.out.println("1. Humà");
        System.out.println("2. Elf");
        System.out.println("3. Orc");
        System.out.println("4. Nan");
        option = readIntegerInRange("Introdueix raça (1-4): ", 1, 4);

        Personatge personatge = null;
        if (automatic) {
            switch (option) {
                case 1:
                    personatge = new Huma(nom, edat); break;
                case 2:
                    personatge = new Elf(nom, edat); break;
                case 3:
                    personatge = new Orc(nom, edat); break;
                case 4:
                    personatge = new Nan(nom, edat); break;
                default:
                    System.out.println("Introdueix una opció."); break;
            }
        } else {
            switch (option) {
                case 1:
                    personatge = new Huma(nom, edat, forca, destresa, constitucio, intelligencia, saviesa, carisma); break;
                case 2:
                    personatge = new Elf(nom, edat, forca, destresa, constitucio, intelligencia, saviesa, carisma); break;
                case 3:
                    personatge = new Orc(nom, edat, forca, destresa, constitucio, intelligencia, saviesa, carisma); break;
                case 4:
                    personatge = new Nan(nom, edat, forca, destresa, constitucio, intelligencia, saviesa, carisma); break;
                default:
                    System.out.println("Introdueix una opció.");
                    break;
            }   
        }
        return personatge;
    }

    // Combat
    public void jugarCombat() {
        System.out.println("--- Combat 1 VS 1 ---");
        System.out.println("=====================");

        if (personatges.size() < 2) {
            System.out.println("Cal crear almenys 2 personatges!");
            return;
        }

        for (int i = 0; i < personatges.size(); i++) {
            System.out.println(i + ". " + personatges.get(i).getNom());
        }

        int option1 = readIntegerInRange("Jugador 1, tria personatge: ", 0, personatges.size() - 1);

        int option2;
        do {
            option2 = readIntegerInRange("Jugador 2, tria personatge: ", 0, personatges.size() - 1);
            if (option1 == option2) {
                System.out.println("Aquest personatge ja està triat!");
            }
        } while (option2 == option1);

        Personatge p1 = personatges.get(option1);
        Personatge p2 = personatges.get(option2);

        // Bucle combat
        while (p1.estaViu() && p2.estaViu()) {
            System.out.println("\n=== TORN ===");
            System.out.println(p1.getNom() + " - Salut: " + p1.getSalut());
            System.out.println(p2.getNom() + " - Salut: " + p2.getSalut());

            // Torn p1
            System.out.println("\n--- Torn de " + p1.getNom() + " ---");
            if (!p1.getInventari().isEmpty()) {
                System.out.print("Vols canviar d'arma? (s/n): ");
                char canviar = sc.next().charAt(0);
                if (canviar == 's') {
                    for (int i = 0; i < p1.getInventari().size(); i++) {
                        System.out.println(i + ". " + p1.getInventari().get(i).getNom());
                    }
                    int indexArma = readIntegerInRange("Tria arma: ", 0, p1.getInventari().size() - 1);
                    p1.equiparArma(indexArma);
                }
            }

            System.out.print("Vols atacar o defensar? (a/d): ");
            char accio = sc.next().charAt(0);
            if (accio == 'a') {
                p1.atacar(p2);
            } else {
                p1.defensar();
            }
            p1.regenarVida();
            p1.regenarMana();

            // Torn p2 (només si segueix viu)
            if (p2.estaViu()) {
                System.out.println("\n--- Torn de " + p2.getNom() + " ---");
                if (!p2.getInventari().isEmpty()) {
                    System.out.print("Vols canviar d'arma? (s/n): ");
                    char canviar = sc.next().charAt(0);
                    if (canviar == 's') {
                        for (int i = 0; i < p2.getInventari().size(); i++) {
                            System.out.println(i + ". " + p2.getInventari().get(i).getNom());
                        }
                        int indexArma = readIntegerInRange("Tria arma: ", 0, p2.getInventari().size() - 1);
                        p2.equiparArma(indexArma);
                    }
                }

                System.out.print("Vols atacar o defensar? (a/d): ");
                accio = sc.next().charAt(0);
                if (accio == 'a') {
                    p2.atacar(p1);
                } else {
                    p2.defensar();
                }
                p2.regenarVida();
                p2.regenarMana();
            }

            // Resetar defensant al final del torn
            p1.setDefensant(false);
            p2.setDefensant(false);
        }

        // Fi del combat
        System.out.println("\n=== FI DEL COMBAT ===");
        if (p1.estaViu()) {
            System.out.println(p1.getNom() + " ha guanyat!");
            p1.guanyarExp(100);
        } else {
            System.out.println(p2.getNom() + " ha guanyat!");
            p2.guanyarExp(100);
        }
    }
}