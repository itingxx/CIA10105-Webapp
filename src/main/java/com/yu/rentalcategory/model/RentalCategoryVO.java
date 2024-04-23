package com.yu.rentalcategory.model;

import com.yu.rental.model.RentalVO;
import java.util.Set;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity  //標示類別為"永續類別"
@Table(name = "rentalcategory")  //此"永續類別"對應到的表格
public class RentalCategoryVO {

    @Id //標示此為Pk
    @Column(name="rCatNo")
    private Integer rCatNo;

    @Column(name="rCatName", length=40)
    private String rCatName;

    @Column(name="rStockQty")
    private Integer rStockQty;

    @Column(name="rRentedQty")
    private Integer rRentedQty;

    @Column(name="rDesPrice",columnDefinition="BigDecimal")
    private BigDecimal rDesPrice;

    @OneToMany(mappedBy = "rentalCategory", cascade = CascadeType.ALL) //CascadeType.ALL把對應到的相關資料刪除
    private Set<RentalVO> rentals;

    public Integer getrCatNo() {
        return rCatNo;
    }

    public void setrCatNo(Integer rCatNo) {
        this.rCatNo = rCatNo;
    }

    public String getrCatName() {
        return rCatName;
    }

    public void setrCatName(String rCatName) {
        this.rCatName = rCatName;
    }

    public Integer getrStockQty() {
        return rStockQty;
    }

    public void setrStockQty(Integer rStockQty) {
        this.rStockQty = rStockQty;
    }

    public Integer getrRentedQty() {
        return rRentedQty;
    }

    public void setrRentedQty(Integer rRentedQty) {
        this.rRentedQty = rRentedQty;
    }

    public BigDecimal getrDesPrice() {
        return rDesPrice;
    }

    public void setrDesPrice(BigDecimal rDesPrice) {
        this.rDesPrice = rDesPrice;
    }

    public Set<RentalVO> getRentals() {
        return rentals;
    }

    public void setRentals(Set<RentalVO> rentals) {
        this.rentals = rentals;
    }
}