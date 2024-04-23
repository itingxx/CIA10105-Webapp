package com.yu.rentalpic.model;
import com.yu.rental.model.RentalVO;

import javax.persistence.*;

    @Entity  //標示類別為"永續類別"
    @Table(name = "RentalPic")  //此"永續類別"對應到的表格
    public class RentalPicVO{

        @Id //標示為PK
        @Column(name="rPicNo", nullable=false)
        private Integer rPicNo;

        @Column(name="rPic", columnDefinition = "LongBLOB")
        private byte[] rPic;

        @ManyToOne
        @JoinColumn(name="rNo", referencedColumnName="rNo")
        private RentalVO rental;

        public Integer getrPicNo() {
            return rPicNo;
        }

        public void setrPicNo(Integer rPicNo) {
            this.rPicNo = rPicNo;
        }

        public byte[] getrPic() {
            return rPic;
        }

        public void setrPic(byte[] rPic) {
            this.rPic = rPic;
        }

        public RentalVO getRental() {
            return rental;
        }

        public void setRental(RentalVO rental) {
            this.rental = rental;
        }
    }
