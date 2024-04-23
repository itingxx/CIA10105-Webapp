package com.ren.authorityfunction.dao;

import com.ren.authorityfunction.model.AuthorityFunctionVO;

import java.util.List;

public interface AuthorityFunctionDAO_interface {
    // 新增
    public void insert(AuthorityFunctionVO authorityFunctionVO);
    // 查詢單項
    public AuthorityFunctionVO findByPrimaryKey(Integer authFuncNo);
    // 查詢所有
    public List<AuthorityFunctionVO> getAll();
    // 修改
    public void update(AuthorityFunctionVO authorityFunctionVO);
    // 刪除
    public void delete(Integer authFuncNo);

}
