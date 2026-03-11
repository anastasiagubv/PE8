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
                    System.out.println("Introdueix una opcio.");
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
            System.out.print("Vols crear el personatge de forma automàtica? (s/n): ");

            char automatic = sc.next().charAt(0);
            if (automatic == 's') {
                String nom = readString("Introdueix el nom:");
                int edat = readInteger("Introdueix l'edat: ");
                String raça = readString("Introdueix raça: ");
                int força = readIntegerInRange("Introdueix força", 5, 20);
                Personatge personatge = new Personatge(nom, edat, raça);
                personatges.add(personatge);

                System.out.println("Personatge creat correctament!");
            } else {
                String nom = readString("Introdueix el nom:");
                int edat = readInteger("Introdueix l'edat: ");
                String raça = readString("Introdueix raça: ");

            }

            
            

            Personatge personatge = new Personatge();
        }
    }

    // Combat
    public void jugarCombat() {

    }
}