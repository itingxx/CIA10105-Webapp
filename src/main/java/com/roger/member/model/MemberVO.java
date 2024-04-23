package com.roger.member.model;



import com.chihyun.mycoupon.model.MyCouponVO;
import com.chihyun.servicerecord.model.ServiceRecordVO;
import com.firesnoopy.studioorder.model.StudioOrderVO;
import com.howard.rentalmytrack.model.RentalMyTrackVO;
import com.howard.rentalorder.model.RentalOrderVO;
import com.iting.cart.model.CartVO;
import com.iting.productmyfavorite.model.ProductMyFavoriteVO;
import com.iting.productorder.model.ProductOrderVO;
import com.roger.articlecollection.model.ArticleCollectionVO;
import com.roger.clicklike.model.ClickLikeVO;
import com.roger.columnreply.model.ColumnReplyVO;
import com.roger.notice.model.NoticeVO;
import com.roger.report.model.ReportVO;
import com.yu.rentalmyfavorite.model.RentalMyFavoriteVO;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity // 這個注釋標記 Member 類為一個 JPA 實體（entity）。這意味著這個類將映射到數據庫中的一個表，並表示該類的每個對象（實例）對應於數據庫表中的一行。使用此注釋可以讓 JPA 框架自動管理該類的持久化、查詢、更新和刪除操作。
@Table(name = "member")
public class MemberVO implements java.io.Serializable {
    @Id // 主鍵
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 設置自動增長鍵
    @Column(name = "memNo") // 映射到資料庫中的column的memNo
    private Integer memNo;
    @Column(name = "mName")
    private String mName;
    @Column(name = "memAcc", unique = true) //`unique` 屬性設置為 `true`，表示該列應該具有唯一性約束。這意味著數據庫中的每一個 `memAcc` 值都必須是唯一的，不能有重複的值。
    private String memAcc;
    @Column(name = "memPwd")
    private String memPwd;
    @Column(name = "memMob", unique = true)
    private String memMob;
    @Column(name = "mGender")
    private Byte mGender;
    @Column(name = "memMail", unique = true)
    private String memMail;
    @Column(name = "memAdd")
    private String memAdd;
    @Column(name = "memBd")
    private Date memBd;
    @Column(name = "memCard")
    private String memCard;
    @Column(name = "provider")
    private Byte provider;
    @Column(name = "clientID")
    private String clientID;
    @Column(name = "displayName")
    private String displayName;
    @Column(name = "accessToken")
    private String accessToken;
    @Column(name = "refreshToken")
    private String refreshToken;
    @Column(name = "tknExpireTime")
    private Timestamp tknExpireTime;
    @Column(name = "creationTime")
    private Timestamp creationTime;
    @Column(name = "memberJoinTime")
    private Timestamp memberJoinTime;
    @Column(name = "memStat")
    private Byte memStat;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<NoticeVO> notices;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<MyCouponVO> myCoupons;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<ProductOrderVO> productOrders;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<ProductMyFavoriteVO> productMyFavorites;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<CartVO> carts;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<ClickLikeVO> clickLikes;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<ArticleCollectionVO> articleCollections;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<ReportVO> reports;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<ColumnReplyVO> columnReplies;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<RentalOrderVO> rentalOrders;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<RentalMyTrackVO> rentalMyTracks;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<RentalMyFavoriteVO> rentalMyFavorites;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<StudioOrderVO> studioOrders;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<ServiceRecordVO> serviceRecords;

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getMemAcc() {
        return memAcc;
    }

    public void setMemAcc(String memAcc) {
        this.memAcc = memAcc;
    }

    public String getMemPwd() {
        return memPwd;
    }

    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd;
    }

    public String getMemMob() {
        return memMob;
    }

    public void setMemMob(String memMob) {
        this.memMob = memMob;
    }

    public Byte getmGender() {
        return mGender;
    }

    public void setmGender(Byte mGender) {
        this.mGender = mGender;
    }

    public String getMemMail() {
        return memMail;
    }

    public void setMemMail(String memMail) {
        this.memMail = memMail;
    }

    public String getMemAdd() {
        return memAdd;
    }

    public void setMemAdd(String memAdd) {
        this.memAdd = memAdd;
    }

    public Date getMemBd() {
        return memBd;
    }

    public void setMemBd(Date memBd) {
        this.memBd = memBd;
    }

    public String getMemCard() {
        return memCard;
    }

    public void setMemCard(String memCard) {
        this.memCard = memCard;
    }

    public Byte getProvider() {
        return provider;
    }

    public void setProvider(Byte provider) {
        this.provider = provider;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Timestamp getTknExpireTime() {
        return tknExpireTime;
    }

    public void setTknExpireTime(Timestamp tknExpireTime) {
        this.tknExpireTime = tknExpireTime;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getMemberJoinTime() {
        return memberJoinTime;
    }

    public void setMemberJoinTime(Timestamp memberJoinTime) {
        this.memberJoinTime = memberJoinTime;
    }

    public Byte getMemStat() {
        return memStat;
    }

    public void setMemStat(Byte memStat) {
        this.memStat = memStat;
    }

    public Set<NoticeVO> getNotices() {
        return notices;
    }

    public void setNotices(Set<NoticeVO> notices) {
        this.notices = notices;
    }

    public Set<MyCouponVO> getMyCoupons() {
        return myCoupons;
    }

    public void setMyCoupons(Set<MyCouponVO> myCoupons) {
        this.myCoupons = myCoupons;
    }

    public Set<ProductOrderVO> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(Set<ProductOrderVO> productOrders) {
        this.productOrders = productOrders;
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

    public Set<ClickLikeVO> getClickLikes() {
        return clickLikes;
    }

    public void setClickLikes(Set<ClickLikeVO> clickLikes) {
        this.clickLikes = clickLikes;
    }

    public Set<ArticleCollectionVO> getArticleCollections() {
        return articleCollections;
    }

    public void setArticleCollections(Set<ArticleCollectionVO> articleCollections) {
        this.articleCollections = articleCollections;
    }

    public Set<ReportVO> getReports() {
        return reports;
    }

    public void setReports(Set<ReportVO> reports) {
        this.reports = reports;
    }

    public Set<ColumnReplyVO> getColumnReplies() {
        return columnReplies;
    }

    public void setColumnReplies(Set<ColumnReplyVO> columnReplies) {
        this.columnReplies = columnReplies;
    }

    public Set<RentalOrderVO> getRentalOrders() {
        return rentalOrders;
    }

    public void setRentalOrders(Set<RentalOrderVO> rentalOrders) {
        this.rentalOrders = rentalOrders;
    }

    public Set<RentalMyTrackVO> getRentalMyTracks() {
        return rentalMyTracks;
    }

    public void setRentalMyTracks(Set<RentalMyTrackVO> rentalMyTracks) {
        this.rentalMyTracks = rentalMyTracks;
    }

    public Set<RentalMyFavoriteVO> getRentalMyFavorites() {
        return rentalMyFavorites;
    }

    public void setRentalMyFavorites(Set<RentalMyFavoriteVO> rentalMyFavorites) {
        this.rentalMyFavorites = rentalMyFavorites;
    }

    public Set<StudioOrderVO> getStudioOrders() {
        return studioOrders;
    }

    public void setStudioOrders(Set<StudioOrderVO> studioOrders) {
        this.studioOrders = studioOrders;
    }

    public Set<ServiceRecordVO> getServiceRecords() {
        return serviceRecords;
    }

    public void setServiceRecords(Set<ServiceRecordVO> serviceRecords) {
        this.serviceRecords = serviceRecords;
    }
}