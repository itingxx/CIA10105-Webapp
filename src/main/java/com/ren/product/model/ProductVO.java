package com.ren.product.model;

import com.iting.cart.model.CartVO;
import com.iting.productmyfavorite.model.ProductMyFavoriteVO;
import com.iting.productorderdetail.model.ProductOrderDetailVO;
import com.iting.productpicture.model.ProductPictureVO;
import com.ren.productcategory.model.ProductCategoryVO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Product")
public class ProductVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pNo")
    private Integer pNo;
    @ManyToOne
    @JoinColumn(name = "pCatNo", referencedColumnName = "pCatNo")
    private ProductCategoryVO productCategory;
    @Column(name = "pName")
    private String pName;
    @Column(name = "pInfo")
    private String pInfo;
    @Column(name = "pSize")
    private Integer pSize;
    @Column(name = "pColor")
    private String pColor;
    @Column(name = "pPrice")
    private BigDecimal pPrice;
    @Column(name = "pStat")
    private Byte pStat;
    @Column(name = "pSalQty")
    private Integer pSalQty;
    @Column(name = "pComPeople")
    private Integer pComPeople;
    @Column(name = "pComScore")
    private Integer pComScore;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductOrderDetailVO> productOrderDetails;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductMyFavoriteVO> productMyFavorites;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<CartVO> carts;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductPictureVO> productPictures;

    public  ProductVO () {

    }

    // insert用建構子
    public ProductVO(ProductCategoryVO productCategory, String pName, String pInfo, Integer pSize, String pColor, BigDecimal pPrice, Byte pStat, Integer pSalQty, Integer pComPeople, Integer pComScore) {
        this.productCategory = productCategory;
        this.pName = pName;
        this.pInfo = pInfo;
        this.pSize = pSize;
        this.pColor = pColor;
        this.pPrice = pPrice;
        this.pStat = pStat;
        this.pSalQty = pSalQty;
        this.pComPeople = pComPeople;
        this.pComScore = pComScore;
    }

    // Update用建構子
    public ProductVO(Integer pNo, ProductCategoryVO productCategory, String pName, String pInfo, Integer pSize, String pColor, BigDecimal pPrice, Byte pStat, Integer pSalQty, Integer pComPeople, Integer pComScore) {
        this.pNo = pNo;
        this.productCategory = productCategory;
        this.pName = pName;
        this.pInfo = pInfo;
        this.pSize = pSize;
        this.pColor = pColor;
        this.pPrice = pPrice;
        this.pStat = pStat;
        this.pSalQty = pSalQty;
        this.pComPeople = pComPeople;
        this.pComScore = pComScore;
    }

    public Integer getpNo() {
        return pNo;
    }

    public void setpNo(Integer pNo) {
        this.pNo = pNo;
    }

    public ProductCategoryVO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryVO productCategory) {
        this.productCategory = productCategory;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo;
    }

    public Integer getpSize() {
        return pSize;
    }

    public void setpSize(Integer pSize) {
        this.pSize = pSize;
    }

    public String getpColor() {
        return pColor;
    }

    public void setpColor(String pColor) {
        this.pColor = pColor;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public Byte getpStat() {
        return pStat;
    }

    public void setpStat(Byte pStat) {
        this.pStat = pStat;
    }

    public Integer getpSalQty() {
        return pSalQty;
    }

    public void setpSalQty(Integer pSalQty) {
        this.pSalQty = pSalQty;
    }

    public Integer getpComPeople() {
        return pComPeople;
    }

    public void setpComPeople(Integer pComPeople) {
        this.pComPeople = pComPeople;
    }

    public Integer getpComScore() {
        return pComScore;
    }

    public void setpComScore(Integer pComScore) {
        this.pComScore = pComScore;
    }

    public Set<ProductOrderDetailVO> getProductOrderDetails() {
        return productOrderDetails;
    }

    public void setProductOrderDetails(Set<ProductOrderDetailVO> productOrderDetails) {
        this.productOrderDetails = productOrderDetails;
    }

    public Set<ProductMyFavoriteVO> getProductMyFavorites() {
        return productMyFavorites;
    }

    public void setProductMyFavorites(Set<ProductMyFavoriteVO> productMyFavorites) {
        this.productMyFavorites = productMyFavorites;
    }

    public Set<CartVO> getCarts() {
        return carts;
    }

    public void setCarts(Set<CartVO> carts) {
        this.carts = carts;
    }

    public Set<ProductPictureVO> getProductPictures() {
        return productPictures;
    }

    public void setProductPictures(Set<ProductPictureVO> productPictures) {
        this.productPictures = productPictures;
    }
}