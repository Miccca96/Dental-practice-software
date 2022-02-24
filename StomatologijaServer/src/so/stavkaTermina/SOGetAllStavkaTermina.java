/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavkaTermina;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaTermina;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOGetAllStavkaTermina extends AbstractSO {

    private ArrayList<StavkaTermina> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof StavkaTermina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaTermina!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> stavkeTermina = DBBroker.getInstance().select(ado);
        lista = (ArrayList<StavkaTermina>) (ArrayList<?>) stavkeTermina;
    }

    public ArrayList<StavkaTermina> getLista() {
        return lista;
    }

}
