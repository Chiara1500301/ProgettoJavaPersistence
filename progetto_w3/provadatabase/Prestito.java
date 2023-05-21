package provadatabase;

import java.sql.Date;

public class Prestito {
    private int numero_tessera;
    private String codice_isbn;
    private Date data_inizio_prestito;
    private Date data_fine_prestito;
    private Date data_fine_prestito_effettiva;

    public Prestito(int numero_tessera, String codice_isbn, Date data_inizio_prestito, Date data_fine_prestito, Date data_fine_prestito_effettiva) {
        this.numero_tessera = numero_tessera;
        this.codice_isbn = codice_isbn;
        this.data_inizio_prestito = data_inizio_prestito;
        this.data_fine_prestito = data_fine_prestito;
        this.data_fine_prestito_effettiva = data_fine_prestito_effettiva;
    }

    public int getNumero_tessera() {
        return numero_tessera;
    }

    public void setNumero_tessera(int numero_tessera) {
        this.numero_tessera = numero_tessera;
    }

    public String getCodice_isbn() {
        return codice_isbn;
    }

    public void setCodice_isbn(String codice_isbn) {
        this.codice_isbn = codice_isbn;
    }

    public Date getData_inizio_prestito() {
        return data_inizio_prestito;
    }

    public void setData_inizio_prestito(Date data_inizio_prestito) {
        this.data_inizio_prestito = data_inizio_prestito;
    }

    public Date getData_fine_prestito() {
        return data_fine_prestito;
    }

    public void setData_fine_prestito(Date data_fine_prestito) {
        this.data_fine_prestito = data_fine_prestito;
    }

    public Date getData_fine_prestito_effettiva() {
        return data_fine_prestito_effettiva;
    }

    public void setData_fine_prestito_effettiva(Date data_fine_prestito_effettiva) {
        this.data_fine_prestito_effettiva = data_fine_prestito_effettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" + "numero_tessera=" + numero_tessera + ", codice_isbn=" + codice_isbn + ", data_inizio_prestito=" + data_inizio_prestito + ", data_fine_prestito=" + data_fine_prestito + ", data_fine_prestito_effettiva=" + data_fine_prestito_effettiva + '}';
    }
    
}
