package com.ren.admauthority.service;

import com.ren.admauthority.model.AdmAuthorityVO;

import java.util.List;

public interface AdmAuthorityService_interface {
    // 新增(將前端request值放入VO由DAO執行SQL語法，並返回VO由Controller轉給View)
    public AdmAuthorityVO addAdmAuthority(Integer titleNo, Integer authFuncNo);
    // 查詢單筆資料
    public AdmAuthorityVO getOneAdmAuthority(Integer titleNo);
    // 查詢所有資料
    public List<AdmAuthorityVO> getAll();
    // 修改(返回值由Controller轉給View)
    public AdmAuthorityVO updateAdmAuthority(Integer titleNo, Integer authFuncNo);
    // 刪除
    public void deleteAdmAuthority(Integer titleNo);

}
