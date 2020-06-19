package DAO;

import POJO.Amortization;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AmortizationDAO {

    private Session session;

    public AmortizationDAO(Session session){
        this.session = session;
    }

    public Amortization findById(int id) {
        return session.get(Amortization.class, id);
    }

    public List<Amortization> findAll() {
        return (List<Amortization>) session.createQuery("FROM Amortization ").list();
    }

    public void save(Amortization amortization) {
        Transaction tr = session.beginTransaction();
        session.save(amortization);
        tr.commit();
    }

    public void update(Amortization amortization) {
        Transaction tr = session.beginTransaction();
        session.update(amortization);
        tr.commit();
    }

    public void delete(Amortization amortization) {
        Transaction tr = session.beginTransaction();
        session.delete(amortization);
        tr.commit();
    }
}
