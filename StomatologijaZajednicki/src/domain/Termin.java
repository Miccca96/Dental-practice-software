/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Termin extends AbstractDomainObject implements Serializable {

    private Long terminID;
    private Date datumVremeOd;
    private Date datumVremeDo;
    private double cenaTermina;
    private Klijent klijent;
    private Zubar zubar;
    private ArrayList<StavkaTermina> stavkeTermina;

    public Termin(Long terminID, Date datumVremeOd, Date datumVremeDo, double cenaTermina, Klijent klijent, Zubar zubar, ArrayList<StavkaTermina> stavkeTermina) {
        this.terminID = terminID;
        this.datumVremeOd = datumVremeOd;
        this.datumVremeDo = datumVremeDo;
        this.cenaTermina = cenaTermina;
        this.klijent = klijent;
        this.zubar = zubar;
        this.stavkeTermina = stavkeTermina;
    }

    public Termin() {
    }

    @Override
    public String nazivTabele() {
        return " termin ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return " JOIN klijent k ON (k.klijentid = t.klijentid) "
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
                    rs.getTimestamp("datumVremeDo"), rs.getDouble("cenaTermina"), k, z, null);

            lista.add(t);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (datumVremeOd, datumVremeDo, cenaTermina, KlijentID, ZubarID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " terminID = " + terminID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVremeOd.getTime()) + "', "
                + "'" + new Timestamp(datumVremeDo.getTime()) + "', "
                + cenaTermina + ", " + klijent.getKlijentID() + ", "
                + zubar.getZubarID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " datumVremeOd = '" + new Timestamp(datumVremeOd.getTime()) + "',"
                + " datumVremeDo = '" + new Timestamp(datumVremeDo.getTime()) + "', "
                + "cenaTermina = " + cenaTermina + ", zubarid = " + zubar.getZubarID() + " ";
    }

    @Override
    public String getByID() {
        return "";
    }

    public Long getTerminID() {
        return terminID;
    }

    public void setTerminID(Long terminID) {
        this.terminID = terminID;
    }

    public Date getDatumVremeOd() {
        return datumVremeOd;
    }

    public void setDatumVremeOd(Date datumVremeOd) {
        this.datumVremeOd = datumVremeOd;
    }

    public Date getDatumVremeDo() {
        return datumVremeDo;
    }

    public void setDatumVremeDo(Date datumVremeDo) {
        this.datumVremeDo = datumVremeDo;
    }

    public double getCenaTermina() {
        return cenaTermina;
    }

    public void setCenaTermina(double cenaTermina) {
        this.cenaTermina = cenaTermina;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Zubar getZubar() {
        return zubar;
    }

    public void setZubar(Zubar zubar) {
        this.zubar = zubar;
    }

    public ArrayList<StavkaTermina> getStavkeTermina() {
        return stavkeTermina;
    }

    public void setStavkeTermina(ArrayList<StavkaTermina> stavkeTermina) {
        this.stavkeTermina = stavkeTermina;
    }

    @Override
    public String toString() {
        return "ID termina: " + String.valueOf(terminID) + ", Zubar: " + zubar.getIme() + ", cena: " + cenaTermina; //To change body of generated methods, choose Tools | Templates.
    }
    
}
