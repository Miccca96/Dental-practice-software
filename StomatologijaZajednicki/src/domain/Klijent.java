/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Klijent extends AbstractDomainObject implements Serializable {
    
    private Long klijentID;
    private String imeKlijenta;
    private String prezimeKlijenta;
    private String kontakt;
    private String email;

    @Override
    public String toString() {
        return imeKlijenta + " " + prezimeKlijenta;
    }

    public Klijent(Long klijentID, String imeKlijenta, String prezimeKlijenta, String kontakt, String email) {
        this.klijentID = klijentID;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.kontakt = kontakt;
        this.email = email;
    }

    public Klijent() {
    }
    
    @Override
    public String nazivTabele() {
        return " klijent ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Klijent k = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("ImeKlijenta"), rs.getString("PrezimeKlijenta"),
                    rs.getString("Kontakt"), rs.getString("Email"));

            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (ImeKlijenta, PrezimeKlijenta, Kontakt, Email) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " KlijentID = " + klijentID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imeKlijenta + "', '" + prezimeKlijenta + "', "
                + "'" + kontakt + "', '" + email + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "kontakt = '" + kontakt + "', email = '" + email + "' ";
    }

    @Override
    public String getByID() {
        return "";
    }

    public Long getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Long klijentID) {
        this.klijentID = klijentID;
    }

    public String getImeKlijenta() {
        return imeKlijenta;
    }

    public void setImeKlijenta(String imeKlijenta) {
        this.imeKlijenta = imeKlijenta;
    }

    public String getPrezimeKlijenta() {
        return prezimeKlijenta;
    }

    public void setPrezimeKlijenta(String prezimeKlijenta) {
        this.prezimeKlijenta = prezimeKlijenta;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
