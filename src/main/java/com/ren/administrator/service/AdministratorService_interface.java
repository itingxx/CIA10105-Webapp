package com.ren.administrator.service;

import com.ren.administrator.model.AdministratorVO;

import java.sql.Date;
import java.util.List;

public interface AdministratorService_interface {
    // 新增(將前端request值放入VO由DAO執行SQL語法，並返回VO由Controller轉給View)
    // 不包括圖片
    public AdministratorVO addAdministrator(String admPwd, String admName, Byte admStat, String admEmail, Integer titleNo, Date admHireDate);
    // 查詢單筆資料
    public AdministratorVO getOneAdministrator(Integer admNo);
    // 查詢所有資料
    public List<AdministratorVO> getAll();
    // 修改(返回值由Controller轉給View)
    public AdministratorVO updateAdministrator(Integer admNo, String admPwd, String admName, Byte admStat, String admEmail, Integer titleNo, Date admHireDate, byte[] admPhoto);
    // 刪除
    public void deleteAdministrator(Integer admNo);
    // 上傳圖片
    public void uploadPhoto(Integer admNo, byte[] admPhoto);
    // 顯示大頭貼
    public String photoSticker(Integer admNo);
    // 修改圖片
    public void ChangePhoto(Integer admNo, byte[] admPhoto);
    // 註冊(含驗證)
    public List<String> register(AdministratorVO administratorVO);

}
