package provadatabase;

import java.sql.*;

public class ProvaDatabase {

    public static void main(String[] args) throws SQLException {
        
        Database db = new Database();
        
        
        //Aggiungi un libro
        Libro libro = new Libro("AAAAA","Il codice da Vinci", 0, 200, "Non mi ricordo", "Non saprei");
        db.aggiungi_libro(libro);
        
        
        
        //Aggiungi una rivista
        Rivista rivista = new Rivista("BBBBB", "Vincenzo bravo", 0, 200, Periodicita.SETTIMANALE);
        db.aggiungi_rivista(rivista);
        
        
        
        //Rimuovi elemento tramite isbn
        db.rimuovi_elemento("A12345");
        
        
       
        //Ricerca per ibsn
        Elemento e = db.ricerca_per_isbn("A12345");
        System.out.println(e);
        
        
        
       // Ricerca per anno di pubblicazoine
        List<Elemento> list = db.ricerca_per_anno_pubblicazione(1954);
        System.out.println(list);
        
        
        
      // Ricerca libri per autore
        List<Libro> list = db.ricerca_per_autore("George Orwell");
        System.out.println(list);
        
        
        System.out.println(db.ricerca_prestiti_scaduti());
    }
    
}
