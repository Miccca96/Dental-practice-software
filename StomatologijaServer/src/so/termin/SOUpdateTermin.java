/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.termin;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaTermina;
import domain.Termin;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOUpdateTermin extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Termin)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Termin!");
        }

        Termin t = (Termin) ado;

        // termin ne sme imati praznu listu stavki
        if (t.getStavkeTermina().isEmpty()) {
            throw new Exception("Morate uneti barem jednu stavku za ovaj termin!");
        }

        ArrayList<Termin> termini = (ArrayList<Termin>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        for (Termin termin : termini) {
            if (!termin.getTerminID().equals(t.getTerminID())) {
                if (t.getZubar().getZubarID().equals(termin.getZubar().getZubarID())) {

                    Date vremePocetkaPostojeceg = termin.getDatumVremeOd();
                    Date vremeKrajaPostojeceg = termin.getDatumVremeDo();

                    if ( // ako je pocetak izmedju termina
                            (t.getDatumVremeOd().equals(vremePocetkaPostojeceg)
                            || t.getDatumVremeOd().after(vremePocetkaPostojeceg))
                            && (t.getDatumVremeOd().equals(vremeKrajaPostojeceg)
                            || t.getDatumVremeOd().before(vremeKrajaPostojeceg))

                            || // ako je kraj izmedju termina
                            (t.getDatumVremeDo().equals(vremePocetkaPostojeceg)
                            || t.getDatumVremeDo().after(vremePocetkaPostojeceg))
                            && (t.getDatumVremeDo().equals(vremeKrajaPostojeceg)
                            || t.getDatumVremeDo().before(vremeKrajaPostojeceg))) {

                        throw new Exception("Zubar " + t.getZubar() + " je zauzet izmedju "
                                + sdf.format(vremePocetkaPostojeceg) + " i "
                                + sdf.format(vremeKrajaPostojeceg) + " !");

                    }
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        // prvo izmenimo termin
        DBBroker.getInstance().update(ado);

        Termin t = (Termin) ado;
        // obrisemo stare stavke
        // ovom linijom koda izvrsavamo naredbu
        // DELETE FROM STAVKATERMINA WHERE TERMINID = nekiID
        // cime brisemo sve stavke termina ODJEDNOM !!!!!!!
        DBBroker.getInstance().delete(t.getStavkeTermina().get(0));

        // dodajemo nove stavke
        for (StavkaTermina stavkaTermina : t.getStavkeTermina()) {
            DBBroker.getInstance().insert(stavkaTermina);
        }

    }

}
