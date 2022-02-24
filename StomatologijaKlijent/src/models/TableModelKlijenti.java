/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Klijent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class TableModelKlijenti extends AbstractTableModel implements Runnable {

    private ArrayList<Klijent> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Kontakt telefon", "El. posta"};
    private String parametar = "";

    public TableModelKlijenti() {
        try {
            lista = ClientController.getInstance().getAllKlijent();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKlijenti.class.getName()).log(Level.SEVERE, null, ex);
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
        Klijent k = lista.get(row);

        switch (column) {
            case 0:
                return k.getKlijentID();
            case 1:
                return k.getImeKlijenta();
            case 2:
                return k.getPrezimeKlijenta();
            case 3:
                return k.getKontakt();
            case 4:
                return k.getEmail();

            default:
                return null;
        }
    }

    public Klijent getSelectedKlijent(int row) {
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
            Logger.getLogger(TableModelKlijenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllKlijent();
            if (!parametar.equals("")) {
                ArrayList<Klijent> novaLista = new ArrayList<>();
                for (Klijent k : lista) {
                    if (k.getImeKlijenta().toLowerCase().contains(parametar.toLowerCase())
                            || k.getPrezimeKlijenta().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(k);
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
