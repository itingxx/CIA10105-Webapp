//package com.ren.admauthority.service;
//
//import com.ren.admauthority.dao.AdmAuthorityDAO_interface;
//import com.ren.admauthority.dao.AdmAuthorityJDBCDAOImpl;
//import com.ren.admauthority.model.AdmAuthorityVO;
//
//import java.util.List;
//
//public class AdmAuthorityServiceImpl implements AdmAuthorityService_interface {
//
//    private AdmAuthorityDAO_interface dao;
//    // DI
//    public AdmAuthorityServiceImpl() {
//        dao = new AdmAuthorityJDBCDAOImpl();
//    }
//
//    @Override
//    public AdmAuthorityVO addAdmAuthority(Integer titleNo, Integer authFuncNo) {
//        AdmAuthorityVO admAuthorityVO = new AdmAuthorityVO();
//        // 將傳入參數放入VO
//        admAuthorityVO.setTitleNo(titleNo);
//        admAuthorityVO.setAuthFuncNo(authFuncNo);
//        // 將VO放入dao定義的方法內，使其執行資料庫操作
//        dao.insert(admAuthorityVO);
//        // 返回值作為呈現在View上使用
//        return admAuthorityVO;
//    }
//
//    @Override
//    public AdmAuthorityVO getOneAdmAuthority(Integer titleNo) {
//        return dao.findByPrimaryKey(titleNo);
//    }
//
//    @Override
//    public List<AdmAuthorityVO> getAll() {
//        return dao.getAll();
//    }
//
//    @Override
//    public AdmAuthorityVO updateAdmAuthority(Integer titleNo, Integer authFuncNo) {
//        AdmAuthorityVO admAuthorityVO = new AdmAuthorityVO();
//        // 將傳入參數放入VO
//        admAuthorityVO.setTitleNo(titleNo);
//        admAuthorityVO.setAuthFuncNo(authFuncNo);
//        // 將VO放入dao定義的方法內，使其執行資料庫操作
//        dao.update(admAuthorityVO);
//        // 返回值作為呈現在View上使用
//        return admAuthorityVO;
//    }
//
//    @Override
//    public void deleteAdmAuthority(Integer titleNo) {
//        dao.delete(titleNo);
//    }
//
//}
