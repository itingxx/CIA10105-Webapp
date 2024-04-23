package com.ren.title.model;

import com.ren.admauthority.model.AdmAuthorityVO;
import com.ren.administrator.model.AdministratorVO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Title")
public class TitleVO {
    @Id
    @Column(name = "titleNo")
    private Integer titleNo;
    @Column(name = "titleName")
    private String titleName;
    @OneToMany(mappedBy = "title", cascade = CascadeType.ALL)
    private Set<AdmAuthorityVO> admAuthoritys;
    @OneToMany(mappedBy = "title", cascade = CascadeType.ALL)
    private Set<AdministratorVO> administrators;

    public TitleVO() {

    }

    public TitleVO(Integer titleNo, String titleName, Set<AdmAuthorityVO> admAuthoritys, Set<AdministratorVO> administrators) {
        this.titleNo = titleNo;
        this.titleName = titleName;
        this.admAuthoritys = admAuthoritys;
        this.administrators = administrators;
    }

    public Integer getTitleNo() {
        return titleNo;
    }

    public void setTitleNo(Integer titleNo) {
        this.titleNo = titleNo;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Set<AdmAuthorityVO> getAdmAuthoritys() {
        return admAuthoritys;
    }

    public void setAdmAuthoritys(Set<AdmAuthorityVO> admAuthoritys) {
        this.admAuthoritys = admAuthoritys;
    }

    public Set<AdministratorVO> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(Set<AdministratorVO> administrators) {
        this.administrators = administrators;
    }
}
