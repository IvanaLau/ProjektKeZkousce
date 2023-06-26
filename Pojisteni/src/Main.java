import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Inicializace správy databáze pro komunikaci s uživatelem
        Sprava sprava = new Sprava();
        String volba = "";
        // Hlavní cyklus
        while (!volba.equals("5")) {
            sprava.vypisUvodAMenu();
            volba = sc.nextLine().trim();
            System.out.println();
            // Reakce podle volby
            switch (volba) {
                case "1" :
                    sprava.pridejPojistenehoDoEvidence();
                    break;
                case "2" :
                    sprava.vypisVsechnyPojistene();
                    break;
                case "3" :
                    sprava.vyhledejPojisteneho();
                    System.out.println("Pokračujte stisknutím libovolné klávesy.\n");
                    break;
                case "4" :
                    sprava.odstranPojisteneho();
                    break;
                case "5" :
                    System.out.println("Aplikace se nyní ukončí.");
                    break;
                default :
                    System.out.println("Neplatná volba, stiskněte libovolnou klávesu a opakujte volbu.\n");
                    break;
            }
                    }
    }
}