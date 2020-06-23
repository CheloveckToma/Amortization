package POJO;

import DAO.AmortizationDAO;
import main.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class AmortizationTest {

    private Amortization actualAmortization;

    @Test
    public void CRUID() {
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getSession();
        actualAmortization = createAmortization();
        Assert.assertTrue(save(session));
        Assert.assertTrue(update(session));
        Assert.assertTrue(delete(session));
        session.close();
       HibernateUtil.shutdown();
    }

    private Amortization createAmortization() {
        Amortization amortization = new Amortization();
        amortization.setEquipmentName("Станок №32");
        amortization.setEquipmentPrice(76200L);
        amortization.setEquipmentUsefulLife(7L);
        return amortization;
    }

    private boolean save(Session session) {
        AmortizationDAO amortizationDAO = new AmortizationDAO(session);

        amortizationDAO.save(actualAmortization);

        Amortization expectedAmortization = amortizationDAO.findById(actualAmortization.getID());

        return actualAmortization.equals(expectedAmortization);
    }

    private boolean update(Session session) {
        AmortizationDAO amortizationDAO = new AmortizationDAO(session);

        actualAmortization.setEquipmentName("Перфаратор Cell380");
        actualAmortization.setEquipmentPrice(15600L);
        actualAmortization.setEquipmentUsefulLife(5L);

        amortizationDAO.update(actualAmortization);

        Amortization expectedAmortization = amortizationDAO.findById(actualAmortization.getID());

        return actualAmortization.equals(expectedAmortization);
    }

    private boolean delete(Session session) {
        AmortizationDAO amortizationDAO = new AmortizationDAO(session);

        amortizationDAO.delete(actualAmortization);

        Amortization amortization = amortizationDAO.findById(actualAmortization.getID());

        return amortization == null;
    }

}