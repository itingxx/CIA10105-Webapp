package com.iting.productpicture.DAO;

import com.iting.productpicture.model.ProductPictureVO;
import com.ren.product.model.ProductVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductPictureDAO implements ProductPicture_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "850811";
	private static final String INSERT_STMT = "INSERT INTO ProductPicture (pNo,pPic) VALUES (?,?)";
	private static final String UPDATE = "UPDATE ProductPicture set pNo=?, pPic=? where pPicNo = ?";
	private static final String GET_ONE_STMT = "SELECT pPicNo, pNo, pPic FROM ProductPicture where pPicNo = ?";
	private static final String GET_ALL_STMT = "SELECT pPicNo, pNo, pPic FROM ProductPicture";
	private static final String DELETE_PicNo = "DELETE FROM ProductPicture where pPicNo = ?";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	//插入資料
	@Override
	public ProductPictureVO insert(ProductPictureVO productPictureVO) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productPictureVO.getProduct().getpNo());
			pstmt.setBytes(2, productPictureVO.getpPic());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occurred. " + se.getMessage());
		} finally {
			closeResources();
		}
		return productPictureVO;
	}

	@Override
	public ProductPictureVO update(ProductPictureVO productPictureVO) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(3, productPictureVO.getpPicNo());
			pstmt.setInt(1, productPictureVO.getProduct().getpNo());
			pstmt.setBytes(2, productPictureVO.getpPic());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occurred. " + se.getMessage());
		} finally {
			closeResources();
		}
		return productPictureVO;
	}

	@Override
	public ProductPictureVO findByPrimaryKey(Integer pPicNo) {
		ProductPictureVO productPictureVO = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, pPicNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				productPictureVO = new ProductPictureVO();
				productPictureVO.setpPicNo(rs.getInt("pPicNo"));

				ProductVO productVO = new ProductVO(); // Create a new ProductVO object
				productVO.setpNo(rs.getInt("pNo")); // Set the pNo attribute
				productPictureVO.setProduct(productVO); // Set the ProductVO object in ProductPictureVO
				productPictureVO.setpPic(rs.getBytes("pPic"));
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occurred. " + se.getMessage());
		} finally {
			closeResources();
		}
		return productPictureVO;
	}

	@Override
	public List<ProductPictureVO> getAll() {
		List<ProductPictureVO> list = new ArrayList<>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductPictureVO productPictureVO = new ProductPictureVO();
				productPictureVO.setpPicNo(rs.getInt("pPicNo"));

				ProductVO productVO = new ProductVO(); // Create a new ProductVO object
				productVO.setpNo(rs.getInt("pNo")); // Set the pNo attribute
				productPictureVO.setProduct(productVO); // Set the ProductVO object in ProductPictureVO

				productPictureVO.setpPic(rs.getBytes("pPic"));
				list.add(productPictureVO);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occurred. " + se.getMessage());
		} finally {
			closeResources();
		}
		return list;
	}

	@Override
	public void delete(Integer pPicNo) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_PicNo);
			pstmt.setInt(1, pPicNo);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occurred. " + se.getMessage());
		} finally {
			closeResources();
		}
	}

	// 關閉資源
	private void closeResources() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
}
