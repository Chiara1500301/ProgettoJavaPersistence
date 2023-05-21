package provadatabase;

class Libro extends Elemento{
    private String autore;
    private String genere;
    
    public Libro(String codice_isbn, String titolo, int anno_pubblicazione, int numero_pagine, String autore, String genere) {
        super(codice_isbn, titolo, anno_pubblicazione, numero_pagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return super.toString() + "{Autore: " + this.autore + "}";
    }
}
