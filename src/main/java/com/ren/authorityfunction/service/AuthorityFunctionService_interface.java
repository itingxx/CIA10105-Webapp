package com.ren.authorityfunction.service;

import com.ren.admauthority.model.AdmAuthorityVO;
import com.ren.authorityfunction.model.AuthorityFunctionVO;

import java.util.List;

public interface AuthorityFunctionService_interface {
    // 新增(將前端request值放入VO由DAO執行SQL語法，並返回VO由Controller轉給View)
    // Auto-increment
    public AuthorityFunctionVO addAuthorityFunction(String authFuncInfo);
    // 查詢單筆資料
    public AuthorityFunctionVO getOneAuthorityFunction(Integer authFuncNo);
    // 查詢所有資料
    public List<AuthorityFunctionVO> getAll();
    // 修改(返回值由Controller轉給View)
    public AuthorityFunctionVO updateAuthorityFunction(Integer authFuncNo, String authFuncInfo);
    // 刪除
    public void deleteAuthorityFunction(Integer authFuncNo);

}
