//package com.ren.productcategory.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Set;
//
//import com.ren.product.model.ProductVO;
//import com.ren.productcategory.model.ProductCategoryVO;
//
//public class ProductCategoryJDBCDAOImpl implements ProductCategoryDAO_interface {
//    String driver = "com.mysql.cj.jdbc.Driver";
//    String url = "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei";
//    String userid = "root";
//    String passwd = "SaiKou97607";
//
//    private static final String INSERT_STMT =
//            "INSERT INTO productcategory (pCatName) VALUES (?)";
//    private static final String GET_ALL_STMT =
//            "SELECT pCatNo,pCatName FROM productcategory";
//    private static final String GET_ONE_STMT =
//            "SELECT pCatNo,pCatName FROM productcategory where pCatNo = ?";
//    private static final String GET_Products_BypCatNo_STMT =
//            "SELECT pNo,pCatNo,pName,pInfo,pSize,pColor,pPrice,pStat,pSalQty,pComPeople,pComScore FROM product where pCatNo = ? order by pNo";
//    private static final String UPDATE_STMT =
//            "UPDATE productcategory set pCatName = ? where pCatNo = ?";
//    // 刪除所有參照商品的表格
//    // 刪除商品訂單明細
//    private static final String DELETE_PRODUCTORDERDETAILS_STMT =
//            "DELETE FROM ProductOrderDetail WHERE pNo = ?";
//    // 刪除商品我的最愛
//    private static final String DELETE_PRODUCTMYFAVORITE_STMT =
//            "DELETE FROM ProductMyFavorite WHERE pNo = ?";
//    // 刪除商品購物車清單
//    private static final String DELETE_CART_STMT =
//            "DELETE FROM cart WHERE pNo = ?";
//    // 刪除商品照片
//    private static final String DELETE_PRODUCTPICTURE_STMT =
//            "DELETE FROM ProductPicture WHERE pNo = ?";
//    // 刪除商品
//    private static final String DELETE_PRODUCT_STMT =
//            "DELETE FROM product WHERE pCatNo = ?";
//    // 刪完商品才可以刪商品類別
//    private static final String DELETE_ProductCategory_STMT =
//            "DELETE FROM productcategory where pCatNo = ?";
//
//    @Override
//    public void insert(ProductCategoryVO productCategoryVO) {
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(INSERT_STMT);
//
//            pstmt.setString(1, productCategoryVO.getpCatName());
//
//            pstmt.executeUpdate("set auto_increment_offset=1000;");
//            pstmt.executeUpdate("set auto_increment_increment=200;");
//            pstmt.executeUpdate();
//
//            // Handle any driver errors
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. " + se.getMessage());
//            // Clean up JDBC resources
//        } finally {
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//
//    }
//
//    @Override
//    public ProductCategoryVO findByPrimaryKey(Integer pCatNo) {
//
//        ProductCategoryVO productCategoryVO = null;
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(GET_ONE_STMT);
//
//            pstmt.setInt(1, pCatNo);
//
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                // deptVO 也稱為 Domain objects
//                productCategoryVO = new ProductCategoryVO();
//                productCategoryVO.setpCatNo(rs.getInt("pCatNo"));
//                productCategoryVO.setpCatName(rs.getString("pCatName"));
//            }
//
//            // Handle any driver errors
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. " + se.getMessage());
//            // Clean up JDBC resources
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//        return productCategoryVO;
//    }
//
//    @Override
//    public List<ProductCategoryVO> getAll() {
//        List<ProductCategoryVO> list = new ArrayList<ProductCategoryVO>();
//        ProductCategoryVO productCategoryVO = null;
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(GET_ALL_STMT);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                productCategoryVO = new ProductCategoryVO();
//                productCategoryVO.setpCatNo(rs.getInt("pCatNo"));
//                productCategoryVO.setpCatName(rs.getString("pCatName"));
//                list.add(productCategoryVO); // Store the row in the list
//            }
//
//            // Handle any driver errors
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. " + se.getMessage());
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//        return list;
//    }
//
//    @Override
//    public Set<ProductVO> getProductsBypCatNo(Integer pCatNo) {
//        Set<ProductVO> set = new LinkedHashSet<>();
//        ProductVO productVO = null;
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(GET_Products_BypCatNo_STMT);
//            pstmt.setInt(1, pCatNo);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                productVO = new ProductVO();
//                productVO.setpNo(rs.getInt("pNo"));
//                productVO.setpCatNo(rs.getInt("pCatNo"));
//                productVO.setpName(rs.getString("pName"));
//                productVO.setpInfo(rs.getString("pInfo"));
//                productVO.setpSize(rs.getInt("pSize"));
//                productVO.setpColor(rs.getString("pColor"));
//                productVO.setpPrice(rs.getBigDecimal("pPrice"));
//                productVO.setpStat(rs.getByte("pStat"));
//                productVO.setpSalQty(rs.getInt("pSalQty"));
//                productVO.setpComPeople(rs.getInt("pComPeople"));
//                productVO.setpComScore(rs.getInt("pComScore"));
//                set.add(productVO); // Store the row in the vector
//            }
//
//            // Handle any driver errors
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. " + se.getMessage());
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//        return set;
//    }
//
//    @Override
//    public void update(ProductCategoryVO productCategoryVO) {
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(UPDATE_STMT);
//
//            pstmt.setString(1, productCategoryVO.getpCatName());
//            pstmt.setInt(2, productCategoryVO.getpCatNo());
//
//            pstmt.executeUpdate();
//
//            // Handle any driver errors
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. " + se.getMessage());
//            // Clean up JDBC resources
//        } finally {
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//
//    }
//
//    @Override
//    public void delete(Integer pCatNo) {
//        int updateCount_EMPs = 0;
//
//        Connection con = null;
//        PreparedStatement ps = null;
//
//        try {
//            // 載入Driver介面的實作類別.class檔來註冊JDBC
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            // 設定於 pstmt.executeUpdate()之前
//            con.setAutoCommit(false);
//            // 刪除商品訂單明細
//            ps = con.prepareStatement(DELETE_PRODUCTORDERDETAILS_STMT);
//            ps.setInt(1, pCatNo);
//            ps.executeUpdate();
//            // 刪除商品我的最愛
//            ps = con.prepareStatement(DELETE_PRODUCTMYFAVORITE_STMT);
//            ps.setInt(1, pCatNo);
//            ps.executeUpdate();
//            // 刪除商品購物車清單
//            ps = con.prepareStatement(DELETE_CART_STMT);
//            ps.setInt(1, pCatNo);
//            ps.executeUpdate();
//            // 刪除商品照片
//            ps = con.prepareStatement(DELETE_PRODUCTPICTURE_STMT);
//            ps.setInt(1, pCatNo);
//            ps.executeUpdate();
//            // 終於可以刪商品了
//            ps = con.prepareStatement(DELETE_PRODUCT_STMT);
//            ps.setInt(1, pCatNo);
//            ps.executeUpdate();
//            // 再刪除商品類別
//            ps = con.prepareStatement(DELETE_ProductCategory_STMT);
//            ps.setInt(1, pCatNo);
//            ps.executeUpdate();
//
//            // 設定於 ps.executeUpdate()之後
//            con.commit();
//            con.setAutoCommit(true);
//            System.out.println("刪除部門編號" + pCatNo + "時,共有員工" + updateCount_EMPs + "人同時被刪除");
//
//            // Handle any driver errors
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            if (con != null) {
//                try {
//                    // 設定於當有exception發生時之catch區塊內
//                    con.rollback();
//                } catch (SQLException excep) {
//                    throw new RuntimeException("rollback error occured. " + excep.getMessage());
//                }
//            }
//            throw new RuntimeException("A database error occured. " + se.getMessage());
//        } finally {
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//        ProductCategoryJDBCDAOImpl dao = new ProductCategoryJDBCDAOImpl();
//
//        // 新增
////		ProductCategoryVO productCategoryVO1 = new ProductCategoryVO();
////		productCategoryVO1.setDname("襯衫");
////		dao.insert(productCategoryVO1);
//
//        // 修改
////		ProductCategoryVO productCategoryVO2 = new ProductCategoryVO();
////		productCategoryVO2.setpCatNo(1000);
////		productCategoryVO2.setpCatName("吊嘎");
////		dao.update(deptVO2);
//
//        // 刪除
////		dao.delete(30);
//
//        // 查詢
//        ProductCategoryVO productCategoryVO3 = dao.findByPrimaryKey(1000);
//        System.out.print(productCategoryVO3.getpCatNo() + ",");
//        System.out.print(productCategoryVO3.getpCatName() + ",");
//        System.out.println("---------------------");
//
//        // 查詢部門
//        List<ProductCategoryVO> list = dao.getAll();
//        for (ProductCategoryVO aProductCategory : list) {
//            System.out.print(aProductCategory.getpCatNo() + ",");
//            System.out.print(aProductCategory.getpCatName());
//            System.out.println();
//        }
//
//        // 查詢某部門的員工
//        Set<ProductVO> set = dao.getProductsBypCatNo(10);
//        for (ProductVO aProduct : set) {
//            System.out.print(aProduct.getpNo() + ",");
//            System.out.print(aProduct.getpCatNo() + ",");
//            System.out.print(aProduct.getpName() + ",");
//            System.out.print(aProduct.getpInfo() + ",");
//            System.out.print(aProduct.getpSize() + ",");
//            System.out.print(aProduct.getpColor() + ",");
//            System.out.print(aProduct.getpPrice() + ",");
//            System.out.print(aProduct.getpStat() + ",");
//            System.out.print(aProduct.getpSalQty() + ",");
//            System.out.print(aProduct.getpComPeople() + ",");
//            System.out.print(aProduct.getpComScore());
//            System.out.println();
//        }
//    }
//}
