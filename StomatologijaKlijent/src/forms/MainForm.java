/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import FormKlijent.FormDetaljiKlijenta;
import FormKlijent.FormNoviKlijent;
import FormKlijent.FormPretragaKlijenta;
import FormTermin.FormPretragaTermina;
import controller.ClientController;
import domain.Klijent;
import domain.StavkaTermina;
import domain.Termin;
import domain.Usluga;
import domain.Zubar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import models.TableModelStavkeTermina;
import session.Session;

/**
 *
 * @author PC
 */
public class MainForm extends javax.swing.JFrame {

    private Zubar z;
    private int trajanje;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.z = Session.getInstance().getUlogovani();
        lblUlogovani.setText("Ulogovani zubar: " + z);
        setTitle("Glavna forma");
        popuniKlijente();
        popuniZubare();
        popuniUsluge();
        txtCenaTermina.setEnabled(false);
        txtCenaUsluge.setEnabled(false);
        txtCenaTermina.setText("0.00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        txtDatumVremeOd.setText(sdf.format(System.currentTimeMillis()));
        tblStavkeTermina.setModel(new TableModelStavkeTermina());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUlogovani = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbKlijent = new javax.swing.JComboBox();
        txtDatumVremeOd = new javax.swing.JFormattedTextField();
        txtCenaTermina = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbUsluga = new javax.swing.JComboBox();
        txtCenaUsluge = new javax.swing.JFormattedTextField();
        btnObrisi = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavkeTermina = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cmbPopust = new javax.swing.JComboBox<>();
        btnSacuvaj = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbZubar = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        miPretragaKlijenta = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        miPretragaTermina = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        miPretragaTermina1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setText("Ulogovani");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos termina"));

        jLabel1.setText("Klijent:");

        jLabel2.setText("Datum i vreme termina:");

        jLabel3.setText("Cena termina:");

        cmbKlijent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDatumVremeOd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
        txtDatumVremeOd.setText("15.03.2022 14:00");
        txtDatumVremeOd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumVremeOdActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos stavki termina"));

        jLabel4.setText("Usluga:");

        jLabel5.setText("Cena usluge:");

        cmbUsluga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbUsluga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUslugaItemStateChanged(evt);
            }
        });

        txtCenaUsluge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        btnObrisi.setText("Obrisi stavku termina");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnDodaj.setText("Dodaj stavku termina");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        tblStavkeTermina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavkeTermina);

        jLabel6.setText("Popust:");

        cmbPopust.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bez popusta", "10%", "20%" }));
        cmbPopust.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPopustItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbUsluga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPopust, 0, 327, Short.MAX_VALUE)
                            .addComponent(txtCenaUsluge, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbUsluga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCenaUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSacuvaj.setText("Sacuvaj termin");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel7.setText("Zubar:");

        cmbZubar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDatumVremeOd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(68, 68, 68)
                        .addComponent(txtCenaTermina))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(108, 108, 108)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbZubar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbKlijent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbZubar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumVremeOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCenaTermina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu6.setText("Klijent");

        jMenuItem9.setText(" Novi klijent");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        miPretragaKlijenta.setText("Pretraga klijenta");
        miPretragaKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaKlijentaActionPerformed(evt);
            }
        });
        jMenu6.add(miPretragaKlijenta);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Termin");

        miPretragaTermina.setText("Pretraga termina");
        miPretragaTermina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaTerminaActionPerformed(evt);
            }
        });
        jMenu7.add(miPretragaTermina);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Nalog");

        miPretragaTermina1.setText("Izloguj se");
        miPretragaTermina1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaTermina1ActionPerformed(evt);
            }
        });
        jMenu8.add(miPretragaTermina1);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUlogovani)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new FormNoviKlijent(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void miPretragaKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaKlijentaActionPerformed
        new FormPretragaKlijenta(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaKlijentaActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        Usluga u = (Usluga) cmbUsluga.getSelectedItem();

        TableModelStavkeTermina tm = (TableModelStavkeTermina) tblStavkeTermina.getModel();

        if (!(u.getNazivUsluge().equals("Vadjenje zuba"))
                && !(u.getNazivUsluge().equals("Keramicke plombe"))) {
            if (tm.postojiUsluga(u)) {
                JOptionPane.showMessageDialog(this, "Samo vadjenje zuba i stavljanje keramickih "
                        + "plombi se moze uneti vise puta!");
                return;
            }
        }

        String popustString = (String) cmbPopust.getSelectedItem();

        if (popustString.equals("Bez popusta")) {
            txtCenaUsluge.setText(String.valueOf(u.getCena()));
        }
        if (popustString.equals("10%")) {
            txtCenaUsluge.setText(String.valueOf(u.getCena() * 0.9));
        }
        if (popustString.equals("20%")) {
            txtCenaUsluge.setText(String.valueOf(u.getCena() * 0.8));
        }

        double cenaUsluge = Double.parseDouble(txtCenaUsluge.getText());

        StavkaTermina st = new StavkaTermina(null, -1, cenaUsluge, u);

        tm.dodajStavku(st);

        double cenaTermina = Double.parseDouble(txtCenaTermina.getText());

        cenaTermina += st.getCenaStavke();

        txtCenaTermina.setText(String.valueOf(cenaTermina));

        trajanje += u.getTrajanje();

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int row = tblStavkeTermina.getSelectedRow();

        if (row >= 0) {
            TableModelStavkeTermina tm = (TableModelStavkeTermina) tblStavkeTermina.getModel();

            StavkaTermina st = tm.getStavka(row);

            double cenaTermina = Double.parseDouble(txtCenaTermina.getText());

            cenaTermina -= st.getCenaStavke();

            txtCenaTermina.setText(String.valueOf(cenaTermina));

            trajanje -= st.getUsluga().getTrajanje();

            tm.obrisiStavku(row);
        }


    }//GEN-LAST:event_btnObrisiActionPerformed

    private void cmbUslugaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUslugaItemStateChanged

        if (cmbUsluga.getSelectedItem() != null
                && cmbPopust.getSelectedItem() != null) {

            Usluga u = (Usluga) cmbUsluga.getSelectedItem();

            String popustString = (String) cmbPopust.getSelectedItem();

            if (popustString.equals("Bez popusta")) {
                txtCenaUsluge.setText(String.valueOf(u.getCena()));
            }
            if (popustString.equals("10%")) {
                txtCenaUsluge.setText(String.valueOf(u.getCena() * 0.9));
            }
            if (popustString.equals("20%")) {
                txtCenaUsluge.setText(String.valueOf(u.getCena() * 0.8));
            }

        }

    }//GEN-LAST:event_cmbUslugaItemStateChanged

    private void cmbPopustItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPopustItemStateChanged

        if (cmbUsluga.getSelectedItem() != null
                && cmbPopust.getSelectedItem() != null) {

            Usluga u = (Usluga) cmbUsluga.getSelectedItem();

            double popust = 0;
            String popustString = (String) cmbPopust.getSelectedItem();

            if (popustString.equals("Bez popusta")) {
                txtCenaUsluge.setText(String.valueOf(u.getCena()));
            }
            if (popustString.equals("10%")) {
                txtCenaUsluge.setText(String.valueOf(u.getCena() * 0.9));
            }
            if (popustString.equals("20%")) {
                txtCenaUsluge.setText(String.valueOf(u.getCena() * 0.8));
            }

        }

    }//GEN-LAST:event_cmbPopustItemStateChanged

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            if (txtDatumVremeOd.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti datum i vreme termina!");
                return;
            }

            Zubar zubar = (Zubar) cmbZubar.getSelectedItem();
            Klijent klijent = (Klijent) cmbKlijent.getSelectedItem();
            double cenaTermina = Double.parseDouble(txtCenaTermina.getText());

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

            Date datumVremeOd = sdf.parse(txtDatumVremeOd.getText());

            Calendar calVremeDo = Calendar.getInstance();

            calVremeDo.setTime(datumVremeOd);

            calVremeDo.add(Calendar.MINUTE, trajanje);

            Date datumVremeDo = calVremeDo.getTime();

            TableModelStavkeTermina tm = (TableModelStavkeTermina) tblStavkeTermina.getModel();

            if(tm.getLista().isEmpty()){
                JOptionPane.showMessageDialog(this, "Morate uneti barem jednu stavku za ovaj termin!");
                return;
            }
            
            Termin t = new Termin(null, datumVremeOd, datumVremeDo, cenaTermina,
                    klijent, zubar, tm.getLista());
            
            int result = JOptionPane.showConfirmDialog(this,
                    "Termin za klijenta: " + klijent + "\n\n"
                    + "Zubar koji vrsi usluge: " + zubar + "\n\n"
                    + "Datum i vreme pocetka: " + sdf.format(datumVremeOd) + "\n\n"
                    + "Datum i vreme kraja: " + sdf.format(datumVremeDo) + "\n\n"
                    + "Ukupna cena termina: " + cenaTermina + "din\n\n"
                    + "Da li ste sigurni da zelite da zakazete ovaj termin?",
                    "Konfirmacija", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.NO_OPTION) {
                return;
            }

            if (result == JOptionPane.YES_OPTION) {
                ClientController.getInstance().addTermin(t);
                srediFormu();
                JOptionPane.showMessageDialog(this, "Uspesno zakazan termin.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void miPretragaTerminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaTerminaActionPerformed
        new FormPretragaTermina(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaTerminaActionPerformed

    private void miPretragaTermina1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaTermina1ActionPerformed
        
        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "izlogujete?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_miPretragaTermina1ActionPerformed

    private void txtDatumVremeOdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumVremeOdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumVremeOdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbKlijent;
    private javax.swing.JComboBox<String> cmbPopust;
    private javax.swing.JComboBox cmbUsluga;
    private javax.swing.JComboBox cmbZubar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JMenuItem miPretragaKlijenta;
    private javax.swing.JMenuItem miPretragaTermina;
    private javax.swing.JMenuItem miPretragaTermina1;
    private javax.swing.JTable tblStavkeTermina;
    private javax.swing.JTextField txtCenaTermina;
    private javax.swing.JFormattedTextField txtCenaUsluge;
    private javax.swing.JFormattedTextField txtDatumVremeOd;
    // End of variables declaration//GEN-END:variables

    public void popuniKlijente() {
        try {
            ArrayList<Klijent> klijenti = ClientController.getInstance().getAllKlijent();

            cmbKlijent.removeAllItems();

            for (Klijent klijent : klijenti) {
                cmbKlijent.addItem(klijent);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniUsluge() {
        try {
            ArrayList<Usluga> usluge = ClientController.getInstance().getAllUsluga();

            cmbUsluga.removeAllItems();

            for (Usluga usluga : usluge) {
                cmbUsluga.addItem(usluga);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniZubare() {
        try {
            ArrayList<Zubar> zubari = ClientController.getInstance().getAllZubar();

            cmbZubar.removeAllItems();

            for (Zubar zubar : zubari) {
                cmbZubar.addItem(zubar);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void srediFormu() {
        txtDatumVremeOd.setText("");
        txtCenaTermina.setText("0.00");
        txtCenaUsluge.setText("0.00");
        TableModelStavkeTermina tm = (TableModelStavkeTermina) tblStavkeTermina.getModel();
        tm.isprazniTabelu();
    }

}