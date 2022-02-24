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
public class StavkaTermina extends AbstractDomainObject implements Serializable {

    private Termin termin;
    private int rbStavke;
    private double cenaStavke;
    private Usluga usluga;

    public StavkaTermina() {
    }

    public StavkaTermina(Termin termin, int rbStavke, double cenaStavke, Usluga usluga) {
        this.termin = termin;
        this.rbStavke = rbStavke;
        this.cenaStavke = cenaStavke;
        this.usluga = usluga;
    }

    @Override
    public String nazivTabele() {
        return " stavkaTermina ";
    }

    @Override
    public String alijas() {
        return " st ";
    }

    @Override
    public String join() {
        return " JOIN termin t USING (terminid) "
                + "JOIN usluga u USING (uslugaid) "
                + "JOIN klijent k ON (k.klijentid = t.klijentid) "
                + "JOIN zubar z ON (z.zubarid = t.zubarid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Zubar z = new Zubar(rs.getLong("ZubarID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));
            
            Klijent k = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("ImeKlijenta"), rs.getString("PrezimeKlijenta"),
                    rs.getString("Kontakt"), rs.getString("Email"));
            
            Termin t = new Termin(rs.getLong("terminID"), rs.getTimestamp("datumVremeOd"), 
                    rs.getTime("datumVremeDo"), rs.getDouble("cenaTermina"), k, z, null);
            
            Usluga u = new Usluga(rs.getLong("UslugaID"), rs.getString("nazivUsluge"), 
                    rs.getString("opis"), rs.getInt("trajanje"), rs.getDouble("cena"));
            
            StavkaTermina st = new StavkaTermina(t, rs.getInt("rbStavke"), 
                    rs.getDouble("cenaStavke"), u);

            lista.add(st);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (terminID, rbStavke, cenaStavke, uslugaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " terminID = " + termin.getTerminID();
    }

    @Override
    public String vrednostiZaInsert() {
        return termin.getTerminID() + ", " + rbStavke + ", "
                + cenaStavke + ", " + usluga.getUslugaID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String getByID() {
        return " WHERE T.TERMINID = " + termin.getTerminID();
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }
}
