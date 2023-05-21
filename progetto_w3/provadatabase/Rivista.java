package provadatabase;

class Rivista extends Elemento {
    
    private Periodicita periodicita; 
    public Rivista(String codice_isbn, String titolo, int anno_pubblicazione, int numero_pagine, Periodicita periodicita) {
        super(codice_isbn, titolo, anno_pubblicazione, numero_pagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "DA MODIFICARE";
    }
    
}
