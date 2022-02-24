/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Klijent;
import domain.StavkaTermina;
import domain.Termin;
import domain.Usluga;
import domain.Zubar;
import java.util.ArrayList;
import so.AbstractSO;
import so.klijent.SOAddKlijent;
import so.klijent.SODeleteKlijent;
import so.klijent.SOUpdateKlijent;
import so.klijent.SOGetAllKlijent;
import so.stavkaTermina.SOAddStavkaTermina;
import so.stavkaTermina.SODeleteStavkaTermina;
import so.stavkaTermina.SOGetAllStavkaTermina;
import so.termin.SOAddTermin;
import so.termin.SODeleteTermin;
import so.termin.SOGetAllTermin;
import so.termin.SOUpdateTermin;
import so.usluga.SOGetAllUsluga;
import so.zubar.SOGetAllZubar;

/**
 *
 * @author PC
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public void addKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SOAddKlijent();
        aso.templateExecute(klijent);
    }

    public void addTermin(Termin termin) throws Exception {
        AbstractSO aso = new SOAddTermin();
        aso.templateExecute(termin);
    }

    public void addStavkaTermina(StavkaTermina stavkaTermina) throws Exception {
        AbstractSO aso = new SOAddStavkaTermina();
        aso.templateExecute(stavkaTermina);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SODeleteKlijent();
        aso.templateExecute(klijent);
    }

    public void deleteTermin(Termin termin) throws Exception {
        AbstractSO aso = new SODeleteTermin();
        aso.templateExecute(termin);
    }

    public void deleteStavkaTermina(StavkaTermina stavkaTermina) throws Exception {
        AbstractSO aso = new SODeleteStavkaTermina();
        aso.templateExecute(stavkaTermina);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SOUpdateKlijent();
        aso.templateExecute(klijent);
    }

    public void updateTermin(Termin termin) throws Exception {
        AbstractSO aso = new SOUpdateTermin();
        aso.templateExecute(termin);
    }

    public ArrayList<Zubar> getAllZubar() throws Exception {
        SOGetAllZubar so = new SOGetAllZubar();
        so.templateExecute(new Zubar());
        return so.getLista();
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        SOGetAllKlijent so = new SOGetAllKlijent();
        so.templateExecute(new Klijent());
        return so.getLista();
    }

    public ArrayList<Termin> getAllTermin() throws Exception {
        SOGetAllTermin so = new SOGetAllTermin();
        so.templateExecute(new Termin());
        return so.getLista();
    }

    public ArrayList<StavkaTermina> getAllStavkaTermina(Termin t) throws Exception {
        SOGetAllStavkaTermina so = new SOGetAllStavkaTermina();
        
        StavkaTermina st = new StavkaTermina();
        st.setTermin(t);
        
        so.templateExecute(st);
        return so.getLista();
    }

    public ArrayList<Usluga> getAllUsluga() throws Exception {
        SOGetAllUsluga so = new SOGetAllUsluga();
        so.templateExecute(new Usluga());
        return so.getLista();
    }

}
