package com.howard.rentalmytrack.model;

import com.roger.member.model.MemberVO;
import com.yu.rental.model.RentalVO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.*;
import java.util.Objects;

@Entity
@Table(name = "rentalmytrack")
@IdClass(RentalMyTrackVO.CompositeTrack.class)
public class RentalMyTrackVO implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "rNo", referencedColumnName = "rNo")
    private RentalVO rental;
    @Id
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private  MemberVO member;
	@Column(name = "rTrackTime")
    private Timestamp rTrackTime;
	@Column(name = "expRentalDate")
    private Date expRentalDate;

    public RentalVO getRental() {
        return rental;
    }

    public void setRental(RentalVO rental) {
        this.rental = rental;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public Timestamp getrTrackTime() {
        return rTrackTime;
    }

    public void setrTrackTime(Timestamp rTrackTime) {
        this.rTrackTime = rTrackTime;
    }

    public Date getExpRentalDate() {
        return expRentalDate;
    }

    public void setExpRentalDate(Date expRentalDate) {
        this.expRentalDate = expRentalDate;
    }

    static class CompositeTrack implements Serializable {

        private RentalVO rental;
        private MemberVO member;

        public CompositeTrack() {

        }

        public CompositeTrack(RentalVO rental, MemberVO member) {
            this.rental = rental;
            this.member = member;
        }

        public RentalVO getRental() {
            return rental;
        }

        public void setRental(RentalVO rental) {
            this.rental = rental;
        }

        public MemberVO getMember() {
            return member;
        }

        public void setMember(MemberVO member) {
            this.member = member;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CompositeTrack that)) return false;
            return Objects.equals(getRental(), that.getRental()) && Objects.equals(getMember(), that.getMember());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getRental(), getMember());
        }

    }

    @Override
    public String toString() {
        return "RentalMyTrackVO{" +
                "rental=" + rental +
                ", member=" + member +
                ", rTrackTime=" + rTrackTime +
                ", expRentalDate=" + expRentalDate +
                '}';
    }

    public RentalMyTrackVO() {

    }

}
