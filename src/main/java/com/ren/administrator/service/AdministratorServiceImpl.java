//package com.ren.administrator.service;
//
//import com.ren.administrator.dao.AdministratorDAO_interface;
//import com.ren.administrator.dao.AdministratorJDBCDAOImpl;
//import com.ren.administrator.model.AdministratorVO;
//
//import java.sql.Date;
//import java.time.LocalDate;
////import java.util.Base64;
//import java.util.LinkedList;
//import java.util.List;
//
//public class AdministratorServiceImpl implements AdministratorService_interface {
//
//    private AdministratorDAO_interface dao;
//
//    // DI
//    public AdministratorServiceImpl() {
//        dao = new AdministratorJDBCDAOImpl();
//    }
//
//    @Override
//    public AdministratorVO addAdministrator(String admPwd, String admName, Byte admStat, String admEmail, Integer titleNo, Date admHireDate) {
//        AdministratorVO administratorVO = new AdministratorVO();
//        // 將傳入參數放入VO
//        administratorVO.setAdmPwd(admPwd);
//        administratorVO.setAdmName(admName);
//        administratorVO.setAdmStat(admStat);
//        administratorVO.setAdmEmail(admEmail);
//        administratorVO.setTitleNo(titleNo);
//        administratorVO.setAdmHireDate(admHireDate);
//        // 將VO放入dao定義的方法內，使其執行資料庫操作
//        dao.insert(administratorVO);
//        // 返回值作為呈現在View上使用
//        return administratorVO;
//    }
//
//    @Override
//    public AdministratorVO getOneAdministrator(Integer admNo) {
//        return dao.findByPrimaryKey(admNo);
//    }
//
//    @Override
//    public List<AdministratorVO> getAll() {
//        return dao.getAll();
//    }
//
//    @Override
//    public AdministratorVO updateAdministrator(Integer admNo, String admPwd, String admName, Byte admStat, String admEmail, Integer titleNo, Date admHireDate, byte[] admPhoto) {
//        AdministratorVO administratorVO = new AdministratorVO();
//        // 將傳入參數放入VO
//        administratorVO.setAdmNo(admNo);
//        administratorVO.setAdmPwd(admPwd);
//        administratorVO.setAdmName(admName);
//        administratorVO.setAdmStat(admStat);
//        administratorVO.setAdmEmail(admEmail);
//        administratorVO.setTitleNo(titleNo);
//        administratorVO.setAdmHireDate(admHireDate);
//        // 將VO放入dao定義的方法內，使其執行資料庫操作
//        dao.update(administratorVO);
//        // 返回值作為呈現在View上使用
//        return administratorVO;
//    }
//
//    @Override
//    public void deleteAdministrator(Integer admNo) {
//        dao.delete(admNo);
//    }
//
//    @Override
//    public void uploadPhoto(Integer admNo,byte[] admPhoto) {
//        dao.upload(admNo, admPhoto);
//    }
//
//    @Override
//    public String photoSticker(Integer admNo) {
//        // 將byte[]陣列(二進制資料)轉成Base64(字串)傳到前端的src屬性即可轉成圖片顯示
//        byte[] admPhoto = dao.photoSticker(admNo);
//        String photoBase64 = null;
//        if (admPhoto != null) {
//            Base64.Encoder encoder = Base64.getEncoder();
//            photoBase64 = encoder.encodeToString(admPhoto);
//        } else {
//            photoBase64 = ""; // 或其他預設值
//        }
//        return photoBase64;
//    }
//
//    @Override
//    public void ChangePhoto(Integer admNo, byte[] admPhoto) {
//        dao.ChangePhoto(admNo, admPhoto);
//    }
//
//    @Override
//    public List<String> register(AdministratorVO administratorVO) {
//        // 放驗證錯誤訊息，在controller迭代放入errorMessage
//        List<String> existData = new LinkedList<>();
//        // 輸入名字
//        String inputName = administratorVO.getAdmName();
//        // 輸入信箱
//        String inputEmail = administratorVO.getAdmEmail();
//        // 查詢使用者名稱與信箱，檢查是否有重複
//        existData = dao.findExistData(inputName, inputEmail);
//        if (existData.size() >= 1) {
//            return existData;
//        }
//
//        return existData;
//    }
//
//}
//
