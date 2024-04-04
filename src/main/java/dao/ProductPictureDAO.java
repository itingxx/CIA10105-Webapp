package dao;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductPictureDAO implements ProductPicture_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "850811";
	private static final String INSERT_STMT = "INSERT INTO ProductPicture (pNo,pPic) VALUES (?,?)";
	private static final String GET_ALL_STMT = "SELECT pPicNo, pNo, pPic FROM ProductPicture";
	private static final String GET_ONE_STMT = "SELECT pPicNo, pNo, pPic FROM ProductPicture where pPicNo = ?";
	private static final String UPDATE = "UPDATE ProductPicture set pNo=?, pPic=? where pPicNo = ?";

	@Override
	public void insert(ProductPictureVO productPictureVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productPictureVO.getpNo());
			pstmt.setBytes(2, productPictureVO.getpPic());

			pstmt.executeUpdate("set auto_increment_offset=1;");
			pstmt.executeUpdate("set auto_increment_increment=1;");
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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

	@Override
	public void update(ProductPictureVO productPictureVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(3, productPictureVO.getpPicNo());
			pstmt.setInt(1, productPictureVO.getpNo());
			pstmt.setBytes(2, productPictureVO.getpPic());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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

	@Override
	public ProductPictureVO findByPrimaryKey(Integer pPicNo) {

		ProductPictureVO productPictureVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, pPicNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// deptVO 也稱為 Domain objects
				productPictureVO = new ProductPictureVO();
				productPictureVO.setpPicNo(rs.getInt("pPicNo"));
				productPictureVO.setpNo(rs.getInt("pNo"));
				productPictureVO.setpPic(rs.getBytes("pPic"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		return productPictureVO;
	}

	@Override
	public List<ProductPictureVO> getAll() {
		List<ProductPictureVO> list = new ArrayList<ProductPictureVO>();
		ProductPictureVO productPictureVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productPictureVO = new ProductPictureVO();
				productPictureVO.setpPicNo(rs.getInt("pPicNo"));
				productPictureVO.setpNo(rs.getInt("pNo"));
				productPictureVO.setpPic(rs.getBytes("pPic"));
				list.add(productPictureVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
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
		return list;
	}

	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

	public static void main(String[] args) throws IOException {
		
		ProductPictureDAO dao = new ProductPictureDAO();
//新增		
//	    ProductPictureVO productPictureVO1 = new ProductPictureVO();
//	    productPictureVO1.setpNo(22);
//	    byte[] pic = getPictureByteArray("images/image.jpg");
//	    productPictureVO1.setpPic(pic);
//	    dao.insert(productPictureVO1);
// 修改
		ProductPictureVO productPictureVO2 = new ProductPictureVO();
		productPictureVO2.setpPicNo(4);
		productPictureVO2.setpNo(42);
		 byte[] pic = getPictureByteArray("images/image.jpg");
	productPictureVO2.setpPic(pic);
		dao.update(productPictureVO2);

		// 查詢
		ProductPictureVO productPictureVO3 = dao.findByPrimaryKey(10);
		System.out.print(productPictureVO3.getpPicNo() + ",");
		System.out.print(productPictureVO3.getpNo() + ",");
		System.out.println(productPictureVO3.getpPic());
		System.out.println("---------------------");

		// 查詢所有
		List<ProductPictureVO> list = dao.getAll();
		for (ProductPictureVO aProductPicture : list) {
			System.out.print(aProductPicture.getpPicNo() + ",");
			System.out.print(aProductPicture.getpNo() + ",");
			System.out.print(aProductPicture.getpPic());
			System.out.println();
		}

	}}