package cn.cjd.springboot.modal.db_use.jpaQuery.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 170096 on 2018/8/17
 */
@SuppressWarnings("unused")
@Table(name = "OM_CAR")
@Entity
public class OMCar {

    @Id
    @Column(name = "CAR_ID")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String carId;

    @Column(name = "CAR_NO")
    private String carNo;

    @Column(name = "CAR_MODEL")
    private String carModel;

    @Column(name = "CAR_COLOR")
    private String carColor;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}
