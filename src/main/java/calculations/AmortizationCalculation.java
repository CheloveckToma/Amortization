package calculations;

import exceptionsss.NegativaCostException;
import exceptionsss.ZeroCostException;

public class AmortizationCalculation {

    public Double findMonthAmortization(Long usefulLife,Long equipPrice) throws NegativaCostException, ZeroCostException {
        checkData(Double.parseDouble(usefulLife.toString()),Double.parseDouble(equipPrice.toString()));
        Double NAO = findNAO(Double.parseDouble(usefulLife.toString()));
        Double CAM = findMonthCAM(Double.parseDouble(equipPrice.toString()), NAO);
        return CAM;
    }

    private void checkData(Double usefulLife,Double equipPrice) throws NegativaCostException, ZeroCostException {
        if ((equipPrice < 0) || (usefulLife < 0)) {
            throw new NegativaCostException();
        }
        if ((equipPrice == 0) || (usefulLife == 0)) {
            throw new ZeroCostException();
        }
    }

    public Double findYearAmortization(Long usefulLife,Long equipPrice) throws NegativaCostException, ZeroCostException {
        checkData(Double.parseDouble(usefulLife.toString()),Double.parseDouble(equipPrice.toString()));
        Double NAO = findNAO(Double.parseDouble(usefulLife.toString()));
        Double CAM = findYearCAM(Double.parseDouble(equipPrice.toString()), NAO);
        return CAM;
    }

    private Double findNAO(Double PSI) {
        Double NAO = 100 / (PSI);
        return NAO;
    }

    private Double findMonthCAM(Double initialCost, Double NAO) {
        Double CAM = ((initialCost) * NAO) / 100;
        return CAM / 12;
    }

    private Double findYearCAM(Double initialCost, Double NAO) {
        Double CAM = (initialCost * NAO) / 100;
        return CAM;
    }
}
