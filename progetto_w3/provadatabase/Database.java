package provadatabase;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Database {

    String url="jdbc:postgresql://localhost:5432/";
    String dbName = "archivio_libri_riviste";
    String user = "postgres";
    String pass="root";
    Connection conn;
    Statement st;

    public Database() throws SQLException {
        this.conn = DriverManager.getConnection(url+dbName,user,pass);
        this.st = conn.createStatement();
    }
    
    public void aggiungi_libro(Libro libro) {
        String aggiungi_elemento = "INSERT INTO elemento VALUES ('" + libro.getCodice_isbn() + "','" + libro.getTitolo() + "'," + libro.getAnno_pubblicazione() + "," + libro.getNumero_pagine() + ")";
        String aggiungi_libro = "INSERT INTO libro VALUES ('" + libro.getCodice_isbn() + "', '" + libro.getAutore() + "', '" + libro.getGenere() + "')";
        
        try {
            this.st.executeUpdate(aggiungi_elemento);
            this.st.executeUpdate(aggiungi_libro);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void aggiungi_rivista(Rivista rivista) {
        String aggiungi_elemento = "INSERT INTO elemento VALUES ('" + rivista.getCodice_isbn() + "','" + rivista.getTitolo() + "'," + rivista.getAnno_pubblicazione() + "," + rivista.getNumero_pagine() + ")";
        String aggiungi_rivista = "INSERT INTO rivista VALUES ('" + rivista.getPeriodicita() + "')";
        
        try {
            this.st.executeUpdate(aggiungi_elemento);
            this.st.executeUpdate(aggiungi_rivista);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void rimuovi_elemento(String codice_isbn) {
        String rimuovi_elemento = "DELETE FROM elemento WHERE codice_isbn='" + codice_isbn + "'";
        
        try {
            this.st.executeUpdate(rimuovi_elemento);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public Elemento ricerca_per_isbn(String codice_isbn) throws SQLException {
        String ricerca = "SELECT * FROM elemento WHERE codice_isbn='" + codice_isbn + "'";
        
        ResultSet rs;
        try {
            rs = this.st.executeQuery(ricerca);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

        Elemento e = null;
        while (rs.next()) {
            e = new Elemento(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
        }
        
        return e;
    }

    
    public List<Elemento> ricerca_per_anno_pubblicazione(int anno_pubblicazione) throws SQLException {
        String ricerca = "SELECT * FROM elemento WHERE anno_pubblicazione='" + anno_pubblicazione + "'";
        List<Elemento> list = new ArrayList<>();
        
        ResultSet rs;
        try {
            rs = this.st.executeQuery(ricerca);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
        while (rs.next()) {
            list.add(new Elemento(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
        }
        
        return list;
    }
    
        public List<Elemento> ricerca_per_titolo(String titolo) throws SQLException {
        String ricerca = "SELECT * FROM elemento WHERE titolo='" + titolo + "'";
        List<Elemento> list = new ArrayList<>();
        
        ResultSet rs;
        try {
            rs = this.st.executeQuery(ricerca);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
        while (rs.next()) {
            list.add(new Elemento(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
        }
        
        return list;
    }

    public List<Libro> ricerca_per_autore(String autore) throws SQLException {
        String ricerca = "SELECT elemento.codice_isbn, elemento.titolo, elemento.anno_pubblicazione, "
                + "elemento.numero_pagine, libro.autore, libro.genere FROM elemento "
                + "INNER JOIN libro ON elemento.codice_isbn = libro.codice_isbn AND libro.autore = '" + autore + "'";
        List<Libro> list = new ArrayList<>();
        
        ResultSet rs;
        try {
            rs = this.st.executeQuery(ricerca);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
        while (rs.next()) {
            list.add(new Libro(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
        }
        
        return list;
    }

    public List<Prestito> ricerca_prestiti(int numero_tessera) throws SQLException {
        String ricerca = "SELECT * FROM prestito WHERE numero_tessera = '" + numero_tessera + "'";
        List<Prestito> list = new ArrayList<>();
        
        ResultSet rs;
        try {
            rs = this.st.executeQuery(ricerca);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
        while (rs.next()) {
            list.add(new Prestito(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDate(5)));
        }
        
        return list;
    }
    
    public List<Prestito> ricerca_prestiti_scaduti() throws SQLException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        List<Prestito> list = new ArrayList<>();
        
        String ricerca = "SELECT * FROM prestito WHERE data_restituzione_prevista <= '" + dtf.format(now) + "'";
        
        ResultSet rs;
        try {
            rs = this.st.executeQuery(ricerca);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
        while (rs.next()) {
            list.add(new Prestito(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDate(5)));
        }
        
        return list;
    }

	
}