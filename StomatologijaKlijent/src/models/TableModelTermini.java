/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Termin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class TableModelTermini extends AbstractTableModel implements Runnable {

    private ArrayList<Termin> lista;
    private String[] kolone = {"ID", "Klijent", "Zubar", "Datum i vreme pocetka",
                        "Datum i vreme kraja", "Cena termina"};
    private String parametar = "";

    public TableModelTermini() {
        try {
            lista = ClientController.getInstance().getAllTermin();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTermini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Termin t = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        
        switch (column) {
            case 0:
                return t.getTerminID();
            case 1:
                return t.getKlijent();
            case 2:
                return t.getZubar();
            case 3:
                return sdf.format(t.getDatumVremeOd());
            case 4:
                return sdf.format(t.getDatumVremeDo());
            case 5:
                return t.getCenaTermina() + "din";

            default:
                return null;
        }
    }

    public Termin getSelectedTermin(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelTermini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllTermin();
            if (!parametar.equals("")) {
                ArrayList<Termin> novaLista = new ArrayList<>();
                for (Termin t : lista) {
                    if (t.getKlijent().getImeKlijenta().toLowerCase().contains(parametar.toLowerCase())
                            || t.getKlijent().getPrezimeKlijenta().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(t);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
