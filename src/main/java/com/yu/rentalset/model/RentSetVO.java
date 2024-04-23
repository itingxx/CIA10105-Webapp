package com.yu.rentalset.model;

import javax.persistence.*;

@Entity  //標示類別為"永續類別"
@Table(name = "RentSet")  //此"永續類別"對應到的表格
public class RentSetVO {

    @Id //標示為PK
    @Column(name = "rOrdNo")
    private Integer rOrdNo;

    @Column(name = "rSetName", length = 20)
    private String rSetName;

    @Column(name = "rSetDays", columnDefinition = "TINYINT")
    private Byte rSetDays;

    public Integer getrOrdNo() {
        return rOrdNo;
    }

    public void setrOrdNo(Integer rOrdNo) {
        this.rOrdNo = rOrdNo;
    }

    public String getrSetName() {
        return rSetName;
    }

    public void setrSetName(String rSetName) {
        this.rSetName = rSetName;
    }

    public Byte getrSetDays() {
        return rSetDays;
    }

    public void setrSetDays(Byte rSetDays) {
        this.rSetDays = rSetDays;
    }

    @Override
    public String toString() {
        return "RentalCategory [rOrdNo=" + rOrdNo + ", rSetName=" + rSetName + "," + " rSetDays=" + rSetDays + "]";
    }

}

