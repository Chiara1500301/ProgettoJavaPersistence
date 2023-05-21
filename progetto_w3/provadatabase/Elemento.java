package provadatabase;

class Elemento {
    
    private String codice_isbn;
    private String titolo;
    private int anno_pubblicazione;
    private int numero_pagine;

    Elemento(String codice_isbn, String titolo, int anno_pubblicazione, int numero_pagine) {
        this.codice_isbn = codice_isbn;
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    public String getCodice_isbn() {
        return codice_isbn;
    }

    public void setCodice_isbn(String codice_isbn) {
        this.codice_isbn = codice_isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(int anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    @Override
    public String toString() {
        return "Elemento{" + "codice_isbn=" + codice_isbn + ", titolo=" + titolo + ", anno_pubblicazione=" + anno_pubblicazione + ", numero_pagine=" + numero_pagine + '}';
    }
    
}
