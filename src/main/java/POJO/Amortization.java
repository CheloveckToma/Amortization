package POJO;

import javax.persistence.*;

@Entity
@Table(name = "amortization")
public class Amortization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer ID;

    @Column
    private String equipmentName;

    @Column
    private Long equipmentPrice;

    @Column
    private Long equipmentUsefulLife;

    public Integer getID() {
        return ID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Long getEquipmentPrice() {
        return equipmentPrice;
    }

    public void setEquipmentPrice(Long equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
    }

    public Long getEquipmentUsefulLife() {
        return equipmentUsefulLife;
    }

    public void setEquipmentUsefulLife(Long equipmentUsefulLife) {
        this.equipmentUsefulLife = equipmentUsefulLife;
    }
}
