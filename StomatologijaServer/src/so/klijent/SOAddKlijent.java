/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Klijent;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOAddKlijent extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Klijent)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Klijent!");
        }

        Klijent k = (Klijent) ado;

        ArrayList<Klijent> klijenti = (ArrayList<Klijent>)(ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Klijent klijent : klijenti) {
            if(klijent.getEmail().equals(k.getEmail())){
                throw new Exception("Vec postoji klijent sa tom elektronskom postom!");
            }
            if(klijent.getKontakt().equals(k.getKontakt())){
                throw new Exception("Vec postoji klijent sa tim kontaktom!");
            }
        }
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
    }

}
