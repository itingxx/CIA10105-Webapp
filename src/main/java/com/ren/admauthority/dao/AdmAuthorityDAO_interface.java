package com.ren.admauthority.dao;

import com.ren.admauthority.model.AdmAuthorityVO;

import java.util.List;

public interface AdmAuthorityDAO_interface {
    // 新增
    public void insert(AdmAuthorityVO admAuthorityVO);
    // 查詢單項
    public AdmAuthorityVO findByPrimaryKey(Integer titleNo);
    // 查詢所有
    public List<AdmAuthorityVO> getAll();
    // 修改
    public void update(AdmAuthorityVO admAuthorityVO);
    // 刪除
    public void delete(Integer titleNo);

}
