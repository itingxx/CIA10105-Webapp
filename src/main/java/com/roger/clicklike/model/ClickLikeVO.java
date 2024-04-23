package com.roger.clicklike.model;

import com.roger.columnarticle.model.ColumnArticleVO;
import com.roger.member.model.MemberVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "clickLike")
public class ClickLikeVO implements java.io.Serializable {

    @EmbeddedId
    private CompositeClickLike compositeClickLike;

    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo", insertable = false, updatable = false)
    private MemberVO member;

    // private Integer memNo;

    @ManyToOne
    @JoinColumn(name = "artNo", referencedColumnName = "artNo", insertable = false, updatable = false)
    private ColumnArticleVO columnArticle;

    // private Integer artNo;


    public CompositeClickLike getCompositeClickLike() {
        return compositeClickLike;
    }

    public void setCompositeClickLike(CompositeClickLike compositeClickLike) {
        this.compositeClickLike = compositeClickLike;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public ColumnArticleVO getColumnArticle() {
        return columnArticle;
    }

    public void setColumnArticle(ColumnArticleVO columnArticle) {
        this.columnArticle = columnArticle;
    }

    @Embeddable
    public static class CompositeClickLike implements Serializable {

        private static final long serialVersionUID = 1L;

        @Column(name = "memNo")
        private Integer memNo;

        @Column(name = "artNo")
        private Integer artNo;

        public CompositeClickLike() {
        }

        public CompositeClickLike(Integer memNo, Integer artNo) {
            this.memNo = memNo;
            this.artNo = artNo;
        }

        public Integer getMemNo() {
            return memNo;
        }

        public void setMemNo(Integer memNo) {
            this.memNo = memNo;
        }

        public Integer getArtNo() {
            return artNo;
        }

        public void setArtNo(Integer artNo) {
            this.artNo = artNo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CompositeClickLike that)) return false;
            return Objects.equals(getMemNo(), that.getMemNo()) && Objects.equals(getArtNo(), that.getArtNo());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getMemNo(), getArtNo());
        }
    }

}
