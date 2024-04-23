package com.ren.authorityfunction.model;

import com.ren.admauthority.model.AdmAuthorityVO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AuthorityFunction")
public class AuthorityFunctionVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authFuncNo")
    private Integer authFuncNo;
    @Column(name = "authFuncInfo")
    private String authFuncInfo;
    @OneToMany(mappedBy = "authorityFunction", cascade = CascadeType.ALL)
    private Set<AdmAuthorityVO> admAuthorities;

    public  AuthorityFunctionVO() {

    }

    public AuthorityFunctionVO(Integer authFuncNo, String authFuncInfo, Set<AdmAuthorityVO> admAuthorities) {
        this.authFuncNo = authFuncNo;
        this.authFuncInfo = authFuncInfo;
        this.admAuthorities = admAuthorities;
    }

    public Integer getAuthFuncNo() {
        return authFuncNo;
    }

    public void setAuthFuncNo(Integer authFuncNo) {
        this.authFuncNo = authFuncNo;
    }

    public String getAuthFuncInfo() {
        return authFuncInfo;
    }

    public void setAuthFuncInfo(String authFuncInfo) {
        this.authFuncInfo = authFuncInfo;
    }

    public Set<AdmAuthorityVO> getAdmAuthorities() {
        return admAuthorities;
    }

    public void setAdmAuthorities(Set<AdmAuthorityVO> admAuthorities) {
        this.admAuthorities = admAuthorities;
    }
}
