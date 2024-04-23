package com.yu.rental.model;


import com.howard.rentalorderdetails.model.RentalOrderDetailsVO;
import com.yu.rentalcategory.model.RentalCategoryVO;
import com.yu.rentalmyfavorite.model.RentalMyFavoriteVO;
import com.yu.rentalpic.model.RentalPicVO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


@Entity  //標示類別為"永續類別"
@Table(name = "Rental")  //此"永續類別"對應到的表格
public class RentalVO{

    @Id //標示為PK
    @Column(name="rNo")
    private Integer rNo;
    @ManyToOne
    @JoinColumn(name = "rCatNo", referencedColumnName = "rCatNo") //對應rental的rCatNo
    private RentalCategoryVO rentalCategory;
    @Column(name="rName", length=40)
    private String rName;
    @Column(name="rPrice",columnDefinition="BigDecimal")
    private BigDecimal rPrice;
    @Column(name="rSize")
    private Integer rSize;
    @Column(name="rColor", length=10)
    private String rColor;
    @Column(name="rInfo", length=1000)
    private String rInfo;
    @Column(name="rStat",columnDefinition = "TINYINT")
    private Byte rStat;
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private Set<RentalOrderDetailsVO> rentalOrderDetails;
    @OneToMany(mappedBy = "rental",cascade = CascadeType.ALL)
    private Set<RentalMyFavoriteVO> rentalMyFavorites;
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private Set<RentalPicVO> rentalPics;

    public Integer getrNo() {
        return rNo;
    }

    public void setrNo(Integer rNo) {
        this.rNo = rNo;
    }

    public RentalCategoryVO getRentalCategory() {
        return rentalCategory;
    }

    public void setRentalCategory(RentalCategoryVO rentalCategory) {
        this.rentalCategory = rentalCategory;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public BigDecimal getrPrice() {
        return rPrice;
    }

    public void setrPrice(BigDecimal rPrice) {
        this.rPrice = rPrice;
    }

    public Integer getrSize() {
        return rSize;
    }

    public void setrSize(Integer rSize) {
        this.rSize = rSize;
    }

    public String getrColor() {
        return rColor;
    }

    public void setrColor(String rColor) {
        this.rColor = rColor;
    }

    public String getrInfo() {
        return rInfo;
    }

    public void setrInfo(String rInfo) {
        this.rInfo = rInfo;
    }

    public Byte getrStat() {
        return rStat;
    }

    public void setrStat(Byte rStat) {
        this.rStat = rStat;
    }

    public Set<RentalOrderDetailsVO> getRentalOrderDetails() {
        return rentalOrderDetails;
    }

    public void setRentalOrderDetails(Set<RentalOrderDetailsVO> rentalOrderDetails) {
        this.rentalOrderDetails = rentalOrderDetails;
    }

    public Set<RentalMyFavoriteVO> getRentalMyFavorites() {
        return rentalMyFavorites;
    }

    public void setRentalMyFavorites(Set<RentalMyFavoriteVO> rentalMyFavorites) {
        this.rentalMyFavorites = rentalMyFavorites;
    }

    public Set<RentalPicVO> getRentalPics() {
        return rentalPics;
    }

    public void setRentalPics(Set<RentalPicVO> rentalPics) {
        this.rentalPics = rentalPics;
    }
}