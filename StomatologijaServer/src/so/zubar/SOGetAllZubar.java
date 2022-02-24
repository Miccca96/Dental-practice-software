/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zubar;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Zubar;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOGetAllZubar extends AbstractSO {

    private ArrayList<Zubar> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Zubar)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zubar!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> zubari = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Zubar>) (ArrayList<?>) zubari;
    }
    
    public ArrayList<Zubar> getLista() {
        return lista;
    }

}
