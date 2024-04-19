package ProductOrder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "productorder")
public class ProductOrderVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pOrdNo", updatable = false)
    private Integer pOrdNo;
    @Column(name = "memNo")
    private Integer memNo;
    @Column(name = "pByrName")
    private String pByrName;
    @Column(name = "pByrPhone")
    private Integer pByrPhone;
    @Column(name = "pByrEmail")
    private String pByrEmail;
    @Column(name = "pRcvName")
    private String pRcvName;
    @Column(name = "pRcvPhone")
    private String pRcvPhone;
    @Column(name = "pTakeMethod")
    private Byte pTakeMethod;
    @Column(name = "pAddr")
    private String pAddr;
    @Column(name = "pPayMethod")
    private Byte pPayMethod;
    @Column(name = "pAllPrice")
    private BigDecimal pAllPrice;
    @Column(name = "coupNo")
    private Integer coupNo;
    @Column(name = "pDisc")
    private BigDecimal pDisc;
    @Column(name = "pRealPrice")
    private BigDecimal pRealPrice;
    @Column(name = "pOrdTime")
    private Timestamp pOrdTime;
    @Column(name = "pOrdStat")
    private Byte pOrdStat;
    @Column(name = "pStat")
    private Byte pStat;

    public ProductOrderVO() {
        super();
    }

    public ProductOrderVO(Integer pOrdNo, Integer memNo, String pByrName, Integer pByrPhone, String pByrEmail, String pRcvName, String pRcvPhone, Byte pTakeMethod, String pAddr, Byte pPayMethod, BigDecimal pAllPrice, Integer coupNo, BigDecimal pDisc, BigDecimal pRealPrice, Timestamp pOrdTime, Byte pOrdStat, Byte pStat) {
        super();
        this.pOrdNo = pOrdNo;
        this.memNo = memNo;
        this.pByrName = pByrName;
        this.pByrPhone = pByrPhone;
        this.pByrEmail = pByrEmail;
        this.pRcvName = pRcvName;
        this.pRcvPhone = pRcvPhone;
        this.pTakeMethod = pTakeMethod;
        this.pAddr = pAddr;
        this.pPayMethod = pPayMethod;
        this.pAllPrice = pAllPrice;
        this.coupNo = coupNo;
        this.pDisc = pDisc;
        this.pRealPrice = pRealPrice;
        this.pOrdTime = pOrdTime;
        this.pOrdStat = pOrdStat;
        this.pStat = pStat;
    }




    public Integer getpOrdNo() {
        return pOrdNo;
    }

    public void setpOrdNo(Integer pOrdNo) {
        this.pOrdNo = pOrdNo;
    }

    public Integer getmemNo() {
        return memNo;
    }

    public void setmemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public String getpByrName() {
        return pByrName;
    }

    public void setpByrName(String pByrName) {
        this.pByrName = pByrName;
    }

    public Integer getpByrPhone() {
        return pByrPhone;
    }

    public void setpByrPhone(Integer pByrPhone) {
        this.pByrPhone = pByrPhone;
    }

    public String getpByrEmail() {
        return pByrEmail;
    }

    public void setpByrEmail(String pByrEmail) {
        this.pByrEmail = pByrEmail;
    }

    public String getpRcvName() {
        return pRcvName;
    }

    public void setpRcvName(String pRcvName) {
        this.pRcvName = pRcvName;
    }

    public String getpRcvPhone() {
        return pRcvPhone;
    }

    public void setpRcvPhone(String pRcvPhone) {
        this.pRcvPhone = pRcvPhone;
    }

    public Byte getpTakeMethod() {
        return pTakeMethod;
    }

    public void setpTakeMethod(Byte pTakeMethod) {
        this.pTakeMethod = pTakeMethod;
    }

    public String getpAddr() {
        return pAddr;
    }

    public void setpAddr(String pAddr) {
        this.pAddr = pAddr;
    }

    public Byte getpPayMethod() {
        return pPayMethod;
    }

    public void setpPayMethod(Byte pPayMethod) {
        this.pPayMethod = pPayMethod;
    }

    public BigDecimal getpAllPrice() {
        return pAllPrice;
    }

    public void setpAllPrice(BigDecimal pAllPrice) {
        this.pAllPrice = pAllPrice;
    }

    public Integer getcoupNo() {
        return coupNo;
    }

    public void setcoupNo(Integer coupNo) {
        this.coupNo = coupNo;
    }

    public BigDecimal getpDisc() {
        return pDisc;
    }

    public void setpDisc(BigDecimal pDisc) {
        this.pDisc = pDisc;
    }

    public BigDecimal getpRealPrice() {
        return pRealPrice;
    }

    public void setpRealPrice(BigDecimal pRealPrice) {
        this.pRealPrice = pRealPrice;
    }

    public Timestamp getpOrdTime() {
        return pOrdTime;
    }

    public void setpOrdTime(Timestamp pOrdTime) {
        this.pOrdTime = pOrdTime;
    }

    public Byte getpOrdStat() {
        return pOrdStat;
    }

    public void setpOrdStat(Byte pOrdStat) {
        this.pOrdStat = pOrdStat;
    }

    public Byte getpStat() {
        return pStat;
    }

    public void setpStat(Byte pStat) {
        this.pStat = pStat;
    }


}
