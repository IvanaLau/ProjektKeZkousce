public class Pojisteny {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telefon;


    protected Pojisteny(String jmeno, String prijmeni, int vek, int telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }

    protected String getJmeno() {
        return jmeno;
    }

    protected String getPrijmeni() {
        return prijmeni;
    }

    protected int getVek() {
        // static LocalDate dnes = LocalDate.now();
        // datumNarozeni.until(Datum.dnes).getYears();
        return vek;
    }

    protected void setVek(int vek) {
        this.vek = vek;
    }

    protected int getTelefon() {
        return telefon;
    }

    protected void setTelefon(int telefon) {
        this.telefon = telefon;
    }


    @Override
    public String toString() {
        return jmeno + " " + prijmeni;
    }
}


