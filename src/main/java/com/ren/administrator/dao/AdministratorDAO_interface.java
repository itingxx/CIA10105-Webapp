package com.ren.administrator.dao;

import com.ren.administrator.model.AdministratorVO;
import com.ren.product.model.ProductVO;

import java.util.List;

public interface AdministratorDAO_interface {
    // 新增
    public void insert(AdministratorVO administratorVO);
    // 查詢單項by編號
    public AdministratorVO findByPrimaryKey(Integer admNo);
    // 查詢單項by管理員名稱 or 信箱
    public List<String> findExistData(String admName, String admEmail);
    // 查詢所有
    public List<AdministratorVO> getAll();
    // 修改
    public void update(AdministratorVO administratorVO);
    // 刪除
    public void delete(Integer admNo);
    // 上傳大頭貼
    public void upload(Integer admNo, byte[] admPhoto);
    // 顯示大頭貼
    public byte[] photoSticker(Integer admNo);
    // 修改大頭貼
    public void ChangePhoto(Integer admNo, byte[] admPhoto);

}
