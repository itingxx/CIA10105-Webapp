package ProductPicture;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductPictureDAO implements ProductPicture_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/fallelove2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "850811";
	private static final String INSERT_STMT = "INSERT INTO ProductPicture (pNo,pPic) VALUES (?,?)";
	private static final String UPDATE = "UPDATE ProductPicture set pNo=?, pPic=? where pPicNo = ?";
	private static final String GET_ONE_STMT = "SELECT pPicNo, pNo, pPic FROM ProductPicture where pPicNo = ?";
	private static final String GET_ALL_STMT = "SELECT pPicNo, pNo, pPic FROM ProductPicture";
	private static final String DELETE_PicNo = "DELETE FROM ProductPicture where pPicNo = ?";
//private Integer pPicNo;
//private Integer pNo;
//private byte[] pPic;
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
		return productPictureVO;
	}

	@Override
	public ProductPictureVO update(ProductPictureVO productPictureVO) {

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
		return productPictureVO;
	}

	@Override
	public ProductPictureVO findByPrimaryKey(Integer pPicNo) {


        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		ProductPictureVO productPictureVO = new ProductPictureVO();
        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_STMT);
            pstmt.setInt(1, pPicNo);
            rs = pstmt.executeQuery();
            if (rs.next()) {

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
		List<ProductPictureVO> list = new ArrayList<>();
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductPictureVO productPictureVO= new ProductPictureVO();
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

	@Override
	public void delete(Integer pPicNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_PicNo);

			pstmt.setInt(1, pPicNo);

			pstmt.executeUpdate();
			// 2●設定於 pstm.executeUpdate()之後


			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

	}
