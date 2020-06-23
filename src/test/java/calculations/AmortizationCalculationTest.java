package calculations;

import exceptionsss.NegativaCostException;
import exceptionsss.ZeroCostException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AmortizationCalculationTest {

    @org.junit.Test
    public void positiveNumberTest() throws NegativaCostException, ZeroCostException {
        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();
        ArrayList<Double> arrayList = new ArrayList<>();
        Double initialCost = 5000 + (Double) (Math.random() * (50000));
        Double SPI = 1 + (Double) (Math.random() * (100));
        arrayList.add(initialCost);
        arrayList.add(SPI);
        Double result = amortizationCalculation.findMonthAmortization(SPI,initialCost);
        assertEquals((Double)((((100 / SPI) * initialCost) / 100)/12),result);
    }
    @Test(expected = NegativaCostException.class)
    public void negativeFirstNumberTest() throws NegativaCostException, ZeroCostException {
        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();
        ArrayList<Double> arrayList = new ArrayList<>();
        Double initialCost = -100 + (Double) (Math.random() * (50));
        Double SPI = 1 + (Double) (Math.random() * (100));
        arrayList.add(initialCost);
        arrayList.add(SPI);
        Double result = amortizationCalculation.findMonthAmortization(SPI,initialCost);
        assertEquals((Double)((((100 / SPI) * initialCost) / 100)/12),result);
    }

    @Test(expected = NegativaCostException.class)
    public void negativeSecondNumberTest() throws NegativaCostException, ZeroCostException {
        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();
        ArrayList<Double> arrayList = new ArrayList<>();
        Double initialCost = -100  + (Double) (Math.random() * (50));
        Double SPI = -100 + (Double) (Math.random() * (50));
        arrayList.add(initialCost);
        arrayList.add(SPI);
        Double result = amortizationCalculation.findMonthAmortization(SPI,initialCost);
        assertEquals((Double)((((100 / SPI) * initialCost) / 100)/12),result);
    }

    @Test(expected = ZeroCostException.class)
    public void zeroSecondNumberTest() throws NegativaCostException, ZeroCostException {
        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();
        ArrayList<Double> arrayList = new ArrayList<>();
        Double initialCost = 5000 + (Double) (Math.random() * (50000));
        Double SPI = new Double(0);
        arrayList.add(initialCost);
        arrayList.add(SPI);
        Double result = amortizationCalculation.findMonthAmortization(SPI,initialCost);
        assertEquals((Double)((((100 / SPI) * initialCost) / 100)/12),result);
    }

    @Test(expected = ZeroCostException.class)
    public void zeroFirstNumberTest() throws NegativaCostException, ZeroCostException {
        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();
        ArrayList<Double> arrayList = new ArrayList<>();
        Double initialCost =new Double(0);
        Double SPI = 1 + (Double) (Math.random() * (100));
        arrayList.add(initialCost);
        arrayList.add(SPI);
        Double result = amortizationCalculation.findMonthAmortization(SPI,initialCost);
        assertEquals((Double)((((100 / SPI) * initialCost) / 100)/12),result);
    }

    @org.junit.Test
    public void positiveNumberYearTest() throws NegativaCostException, ZeroCostException {
        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();
        ArrayList<Double> arrayList = new ArrayList<>();
        Double initialCost = 5000 + (Double) (Math.random() * (50000));
        Double SPI = 1 + (Double) (Math.random() * (100));
        arrayList.add(initialCost);
        arrayList.add(SPI);
        Double result = amortizationCalculation.findYearAmortization(SPI,initialCost);
        assertEquals((Double)((((100 / SPI) * initialCost) / 100)),result);
    }

    @Test(expected = NegativaCostException.class)
    public void negativeFirstNumberYearTest() throws NegativaCostException, ZeroCostException {
        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();
        ArrayList<Double> arrayList = new ArrayList<>();
        Double initialCost = -100 + (Double) (Math.random() * (50));
        Double SPI = 1 + (Double) (Math.random() * (100));
        arrayList.add(initialCost);
        arrayList.add(SPI);
        Double result = amortizationCalculation.findYearAmortization(SPI,initialCost);
        assertEquals((Double)((((100 / SPI) * initialCost) / 100)),result);
    }

    @Test(expected = NegativaCostException.class)
    public void negativeSecondNumberYearTest() throws NegativaCostException, ZeroCostException {
        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();
        ArrayList<Double> arrayList = new ArrayList<>();
        Double initialCost = -100 + (Double) (Math.random() * (50));
        Double SPI = -100 + (Double) (Math.random() * (50));
        arrayList.add(initialCost);
        arrayList.add(SPI);
        Double result = amortizationCalculation.findYearAmortization(SPI,initialCost);
        assertEquals((Double)((((100 / SPI) * initialCost) / 100)),result);
    }

    @Test(expected = ZeroCostException.class)
    public void zeroSecondNumberYearTest() throws NegativaCostException, ZeroCostException {
        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();
        ArrayList<Double> arrayList = new ArrayList<>();
        Double initialCost = 5000 + (Double) (Math.random() * (50000));
        Double SPI = new Double(0);
        arrayList.add(initialCost);
        arrayList.add(SPI);
        Double result = amortizationCalculation.findYearAmortization(SPI,initialCost);
        assertEquals((Double)((((100 / SPI) * initialCost) / 100)),result);
    }

    @Test(expected = ZeroCostException.class)
    public void zeroFirstNumberYearTest() throws NegativaCostException, ZeroCostException {
        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();
        ArrayList<Double> arrayList = new ArrayList<>();
        Double initialCost =new Double(0);
        Double SPI = 1 + (Double) (Math.random() * (100));
        arrayList.add(initialCost);
        arrayList.add(SPI);
        Double result = amortizationCalculation.findYearAmortization(SPI,initialCost);
        assertEquals((Double)((((100 / SPI) * initialCost) / 100)),result);
    }

}