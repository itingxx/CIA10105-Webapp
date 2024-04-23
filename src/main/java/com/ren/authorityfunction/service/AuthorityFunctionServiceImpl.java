package com.ren.authorityfunction.service;

import com.ren.admauthority.model.AdmAuthorityVO;
import com.ren.authorityfunction.dao.AuthorityFunctionDAO_interface;
import com.ren.authorityfunction.dao.AuthorityFunctionJDBCDAOImpl;
import com.ren.authorityfunction.model.AuthorityFunctionVO;

import java.util.List;

public class AuthorityFunctionServiceImpl implements AuthorityFunctionService_interface {

    private AuthorityFunctionDAO_interface dao;
    // DI
    public AuthorityFunctionServiceImpl() {
        dao = new AuthorityFunctionJDBCDAOImpl();
    }

    @Override
    public AuthorityFunctionVO addAuthorityFunction(String authFuncInfo) {
        AuthorityFunctionVO authorityFunctionVO = new AuthorityFunctionVO();
        // 將傳入參數放入VO
        authorityFunctionVO.setAuthFuncInfo(authFuncInfo);
        // 將VO放入dao定義的方法內，使其執行資料庫操作
        dao.insert(authorityFunctionVO);
        // 返回值作為呈現在View上使用
        return authorityFunctionVO;
    }

    @Override
    public AuthorityFunctionVO getOneAuthorityFunction(Integer authFuncNo) {
        return dao.findByPrimaryKey(authFuncNo);
    }

    @Override
    public List<AuthorityFunctionVO> getAll() {
        return dao.getAll();
    }

    @Override
    public AuthorityFunctionVO updateAuthorityFunction(Integer authFuncNo, String authFuncInfo) {
        AuthorityFunctionVO authorityFunctionVO = new AuthorityFunctionVO();
        // 將傳入參數放入VO
        authorityFunctionVO.setAuthFuncNo(authFuncNo);
        authorityFunctionVO.setAuthFuncInfo(authFuncInfo);
        // 將VO放入dao定義的方法內，使其執行資料庫操作
        dao.update(authorityFunctionVO);
        // 返回值作為呈現在View上使用
        return authorityFunctionVO;
    }

    @Override
    public void deleteAuthorityFunction(Integer authFuncNo) {
        dao.delete(authFuncNo);
    }
}
