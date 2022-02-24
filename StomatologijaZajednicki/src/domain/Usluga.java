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
public class Usluga extends AbstractDomainObject implements Serializable {
    
    private Long uslugaID;
    private String nazivUsluge;
    private String opis;
    private int trajanje;
    private double cena;

    @Override
    public String toString() {
        return nazivUsluge + " [Trajanje: " + trajanje + "min, Cena: " + cena + "din]";
    }

    public Usluga(Long uslugaID, String nazivUsluge, String opis, int trajanje, double cena) {
        this.uslugaID = uslugaID;
        this.nazivUsluge = nazivUsluge;
        this.opis = opis;
        this.trajanje = trajanje;
        this.cena = cena;
    }

    public Usluga() {
    }
    
    @Override
    public String nazivTabele() {
        return " usluga";
    }

    @Override
    public String alijas() {
        return " u ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Usluga u = new Usluga(rs.getLong("UslugaID"), rs.getString("nazivUsluge"), 
                    rs.getString("opis"), rs.getInt("trajanje"), rs.getDouble("cena"));
            
            lista.add(u);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " UslugaID = " + uslugaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String getByID() {
        return "";
    }

    public Long getUslugaID() {
        return uslugaID;
    }

    public void setUslugaID(Long uslugaID) {
        this.uslugaID = uslugaID;
    }

    public String getNazivUsluge() {
        return nazivUsluge;
    }

    public void setNazivUsluge(String nazivUsluge) {
        this.nazivUsluge = nazivUsluge;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
