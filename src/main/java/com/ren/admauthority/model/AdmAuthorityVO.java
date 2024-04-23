package com.ren.admauthority.model;


import com.ren.authorityfunction.model.AuthorityFunctionVO;
import com.ren.title.model.TitleVO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AdmAuthority")
public class AdmAuthorityVO {
    @EmbeddedId
    private CompositeAdmAuthority compositeAdmAuthority;
    @ManyToOne
    @JoinColumn(name = "titleNo", referencedColumnName = "titleNo", insertable = false, updatable = false)
    private TitleVO title;
    @ManyToOne
    @JoinColumn(name = "authFuncNo", referencedColumnName = "authFuncNo", insertable = false, updatable = false)
    private AuthorityFunctionVO authorityFunction;
    @Embeddable
    public static class CompositeAdmAuthority implements Serializable {
        private static final long serialVersionUID = 1L;
        @Column(name = "titleNo")
        private Integer titleNo;
        @Column(name = "authFuncNo")
        private Integer authFuncNo;

        public Integer getTitleNo() {
            return titleNo;
        }

        public void setTitleNo(Integer titleNo) {
            this.titleNo = titleNo;
        }

        public Integer getAuthFuncNo() {
            return authFuncNo;
        }

        public void setAuthFuncNo(Integer authFuncNo) {
            this.authFuncNo = authFuncNo;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((titleNo == null) ? 0 : titleNo.hashCode());
            result = prime * result + ((authFuncNo == null) ? 0 : authFuncNo.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj != null && getClass() == obj.getClass()) {
                CompositeAdmAuthority compositeAdmAuthority = (CompositeAdmAuthority) obj;
                if (titleNo.equals(compositeAdmAuthority.titleNo) && authFuncNo.equals(compositeAdmAuthority.authFuncNo)) {
                    return true;
                }
            }
            return false;
        }
    }

    public AdmAuthorityVO() {

    }

    public AdmAuthorityVO(CompositeAdmAuthority compositeAdmAuthority, TitleVO title, AuthorityFunctionVO authorityFunction) {
        this.compositeAdmAuthority = compositeAdmAuthority;
        this.title = title;
        this.authorityFunction = authorityFunction;
    }

    public CompositeAdmAuthority getCompositeAdmAuthority() {
        return compositeAdmAuthority;
    }

    public void setCompositeAdmAuthority(CompositeAdmAuthority compositeAdmAuthority) {
        this.compositeAdmAuthority = compositeAdmAuthority;
    }

    public TitleVO getTitle() {
        return title;
    }

    public void setTitle(TitleVO title) {
        this.title = title;
    }

    public AuthorityFunctionVO getAuthorityFunction() {
        return authorityFunction;
    }

    public void setAuthorityFunction(AuthorityFunctionVO authorityFunction) {
        this.authorityFunction = authorityFunction;
    }
}
