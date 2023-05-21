package provadatabase;

import java.sql.Date;

public class Utente {
    private String nome;
    private String cognome;
    private Date data_nascita;
    private int numero_tessera;

    public Utente(String nome, String cognome, Date data_nascita, int numero_tessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.numero_tessera = numero_tessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }

    public int getNumero_tessera() {
        return numero_tessera;
    }

    public void setNumero_tessera(int numero_tessera) {
        this.numero_tessera = numero_tessera;
    }

    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", cognome=" + cognome + ", data_nascita=" + data_nascita + ", numero_tessera=" + numero_tessera + '}';
    }
    
}
