import java.util.ArrayList;

public class Databaze {

    private ArrayList<Pojisteny> pojisteneOsoby;

    protected Databaze() {
        pojisteneOsoby = new ArrayList<>();
    }

    protected ArrayList<Pojisteny> vypisPojistene() {

        return pojisteneOsoby;
    }

    protected boolean pridejPojisteneho(String jmeno, String prijmeni, int vek, int telefon)  {
        boolean pridano = pojisteneOsoby.add(new Pojisteny(jmeno, prijmeni, vek, telefon));
        return pridano;}
    protected ArrayList<Pojisteny> najdiPojisteneho(String jmeno, String prijmeni) {
        ArrayList<Pojisteny> nalezeni = new ArrayList<>();
        for (Pojisteny pojisteny : pojisteneOsoby) {
            if (pojisteny.getJmeno().toLowerCase().equals(jmeno.toLowerCase()) && pojisteny.getPrijmeni().toLowerCase().equals(prijmeni.toLowerCase())) {
                nalezeni.add(pojisteny);
            }
        }
        return nalezeni;
    }
    protected boolean odstranPojisteneho(ArrayList<Pojisteny> nalezeno) {
         return pojisteneOsoby.removeAll(nalezeno);
    }
}
