import java.util.Scanner;
import java.util.ArrayList;

public class Sprava {

    // Instance scanneru pro čtení vstupů z konzole
    private Scanner sc = new Scanner(System.in);
    private Databaze databaze;

    protected Sprava() {
        databaze = new Databaze();
    }

    protected void vypisUvodAMenu() {
        System.out.println("---------------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Odstranit pojištěného");
        System.out.println("5 - Konec");
    }

    protected void pridejPojistenehoDoEvidence() {
        String jmeno = zjistiJmeno();
        String prijmeni = zjistiPrijmeni();
        int vek = zjistiVek();
        int telefon = zjistiTelefon();
        boolean pridano = databaze.pridejPojisteneho(jmeno, prijmeni, vek, telefon);
        if (pridano) {
        System.out.println();
        System.out.println("Data byla uložena. Pokračujte stisknutím libovolné klávesy...\n");
        }
        else {
            System.out.println();
            System.out.println("Došlo k chybě, data nebyla uložena. Pokračujte stisknutím libovolné klávesy...\n");
            System.out.println();
            }
    }
    protected void vypisVsechnyPojistene() {
        System.out.println("Jméno\t Příjmeni\t Vek\t Telefonní číslo");
        System.out.println("--------------------------------------------");
        ArrayList<Pojisteny> vsichniPojisteni = databaze.vypisPojistene();
        for (int i = 0; i < vsichniPojisteni.size(); i++) {
            System.out.println(vsichniPojisteni.get(i).getJmeno() + "\t " + vsichniPojisteni.get(i).getPrijmeni() + "\t " + vsichniPojisteni.get(i).getVek() + "\t " + vsichniPojisteni.get(i).getTelefon());
        }
        System.out.println();
        System.out.println("Pokračujte stisknutím libovolné klávesy.\n");
    }

    protected ArrayList<Pojisteny> vyhledejPojisteneho() {
        String jmeno = zjistiJmeno();
        String prijmeni = zjistiPrijmeni();
        ArrayList<Pojisteny> nalezeni = databaze.najdiPojisteneho(jmeno, prijmeni);
        System.out.println();
        if (!nalezeni.isEmpty()) {
            System.out.println("Jméno\t Příjmeni\t Vek\t Telefonní číslo");
            System.out.println("--------------------------------------------");
            for (int i = 0; i < nalezeni.size(); i++) {
                System.out.println(nalezeni.get(i).getJmeno() + "\t " + nalezeni.get(i).getPrijmeni() + "\t " + nalezeni.get(i).getVek() + "\t " + nalezeni.get(i).getTelefon());
            }
        System.out.println();
        }
        else
        System.out.println("Pojištěný nenalezen. Pokračujte stisknutím libovolné klávesy...\n");
        return nalezeni;
    }
    protected void odstranPojisteneho() {
        ArrayList<Pojisteny> nalezeni = vyhledejPojisteneho();
        if (!nalezeni.isEmpty()) {
            System.out.println("Opravdu si přejete pojištěného odstranit z evidence? [Ano/Ne]");
            String volba = sc.nextLine().trim().toLowerCase();
            switch (volba) {
                case "ano" :
                databaze.odstranPojisteneho(nalezeni);
                System.out.println("Pojištěný byl odstraněn z evidence. Pokračujte stisknutím libovolné klávesy.\n");
                break;
                case "ne" :
                System.out.println("Pojištěný nebude odstraněn. Pokračujte stisknutím libovolné klávesy.\n");
                break;
                default :
                System.out.println("Neplatná volba. Pojištěný nebude odstraněn. Pokračujte stisknutím libovolné klávesy.\n");
                break;}
            }
   }
    private String zjistiJmeno() {
        System.out.println("Zadejte jméno pojištěného:");
        String jmeno = sc.nextLine().trim();
        return jmeno;
    }

    private String zjistiPrijmeni() {
        System.out.println("Zadejte příjmení pojištěného:");
        String prijmeni = sc.nextLine().trim();
        return prijmeni;
    }

    private int zjistiTelefon() {
        String text = "";
        int telefon = 0;
        try {
            System.out.println("Zadejte telefonní číslo bez mezer a bez předvolby:");
            text = sc.nextLine().trim();
            if ((text.length()) != 9) {
                System.out.println("Zadaný údaj má nesprávnou délku.");
                zjistiTelefon();}
            else
                telefon = Integer.parseInt(text);
        } catch (Exception ex) {
            System.out.println("Zadaný údaj není číslo.");
            zjistiTelefon();
        }
       if (text.length() != 9) {
           System.out.println("Zadaný údaj má nesprávnou délku.");
           zjistiTelefon();
       }
       return telefon;
    }
    private int zjistiVek() {
        int vek = -1;
        try {
            System.out.println("Zadejte věk:");
            vek = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception ex) {
            System.out.println("Zadaný údaj není číslo.");
            zjistiVek();
        }
        if ((vek < 0) || (vek > 130)) {
            System.out.println("Zadaný věk je příliš nízký nebo vysoký.");
            zjistiVek();
        }
        return vek;
    }}