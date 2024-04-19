//package ProductOrder;
//
//
//
//import java.sql.*;
//
//public class ProductOrderDAO {
//    String driver = "com.mysql.cj.jdbc.Driver";
//    String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
//    String userid = "root";
//    String passwd = "850811";
//
//    private static final String INSERT = "INSERT INTO ProductOrder (pOrdNo,memNo,pByrName,pByrPhone, " +
//            "pByrEmail,pRcvName,pRcvPhone,pTakeMethod,pAddr," +
//            " pPayMethod,pAllPrice, coupNo,pDisc,pRealPrice,pOrdTime,pOrdStat,pStat)" +
//            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//    private static final String DELETE = "DELETE FROM ProductOrder where pOrdNo = ?";
//    private static final String UPDATE = "UPDATE ProductOrder SET memNo = ?, pByrName = ?, pByrPhone = ?, " +
//            "pByrEmail = ?, pRcvName = ?, pRcvPhone = ?, pTakeMethod = ?, pAddr = ?, pPayMethod = ?, " +
//            "pAllPrice = ?, coupNo = ?, pDisc = ?, pRealPrice = ?, pOrdTime = ?, pOrdStat = ?, " +
//            "pStat = ? WHERE pOrdNo = ?";
//    private static final String GET_ONE = "SELECT pOrdNo,memNo,pByrName,pByrPhone, " +
//            "pByrEmail,pRcvName,pRcvPhone,pTakeMethod,pAddr," +
//            " pPayMethod,pAllPrice, coupNo,pDisc,pRealPrice,pOrdTime,pOrdStat,pStat" +
//            "FROM ProductOrder " +
//            "WHERE rOrdNo = ?";
//    private static final String GET_ONE_ON_NAME = "SELECT  pOrdNo,memNo,pByrName,pByrPhone, " +
//            "pByrEmail,pRcvName,pRcvPhone,pTakeMethod,pAddr," +
//            " pPayMethod,pAllPrice, coupNo,pDisc,pRealPrice,pOrdTime,pOrdStat,pStat" +
//            "FROM ProductOrder " +
//            "WHERE pByrName = ?";
//    private static final String GET_ALL = "SELECT  pOrdNo,memNo,pByrName,pByrPhone, " +
//            "pByrEmail,pRcvName,pRcvPhone,pTakeMethod,pAddr," +
//            " pPayMethod,pAllPrice, coupNo,pDisc,pRealPrice,pOrdTime,pOrdStat,pStat" +
//            "FROM ProductOrder ";
//
//
//    /* 以下方法按照 增、刪、改、查 排列 */
//    Connection con = null;
//    PreparedStatement pstmt = null;
//    ResultSet rs = null;
//    @Override
//    public int insert(ProductOrderVO productOrderVO) {
//
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(INSERT);
//
//            pstmt.setInt(1,productOrderVO.          getpOrdNo());
//            pstmt.setInt(2,productOrderVO.          getmemNo());
//            pstmt.setString(3,productOrderVO.       getpByrName() );
//            pstmt.setInt(4,productOrderVO.          getpByrPhone());
//            pstmt.setString(5,productOrderVO.       getpByrEmail());
//            pstmt.setString(6,productOrderVO.       getpRcvName());
//            pstmt.setString(7,productOrderVO.       getpRcvPhone());
//            pstmt.setByte(8,productOrderVO.         getpTakeMethod());
//            pstmt.setString(9,productOrderVO.       getpAddr());
//            pstmt.setByte(10,productOrderVO.        getpPayMethod());
//            pstmt.setBigDecimal(11,productOrderVO.  getpAllPrice());
//            pstmt.setInt(12,productOrderVO.         getcoupNo());
//            pstmt.setBigDecimal(13,productOrderVO.  getpDisc());
//            pstmt.setBigDecimal(14,productOrderVO.  getpRealPrice());
//            pstmt.setTimestamp(15,productOrderVO.   getpOrdTime());
//            pstmt.setByte(16,productOrderVO.        getpOrdStat());
//            pstmt.setByte(17,productOrderVO.        getpStat());
//            pstmt.executeUpdate();
//
//            // 新增訂單後，取得自動生成的 OrdNo
//            ResultSet rs = pstmt.getGeneratedKeys();
//            if (rs.next()) {
//                int pOrdNo = rs.getInt(1);
//                return pOrdNo;
//            } else {
//                return (-1);
//            }
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. "
//                    + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
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
//    } // insert 結束
//
//    @Override
//    public void delete(Integer pOrdNo) {
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(DELETE);
//
//            pstmt.setInt(1, pOrdNo);
//            pstmt.executeUpdate();
//            // 若 driver 出問題
//        }  catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. "
//                    + e.getMessage());
//            // 若 SQL 出問題
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
//        } finally {
//
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//
//        }
//
//    } // delete 結束
//
//    @Override
//    public void update(ProductOrderVO productOrderVO) {
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(UPDATE);
//
//            pstmt.setInt(1,productOrderVO.          getpOrdNo());
//            pstmt.setInt(2,productOrderVO.          getmemNo());
//            pstmt.setString(3,productOrderVO.       getpByrName() );
//            pstmt.setInt(4,productOrderVO.          getpByrPhone());
//            pstmt.setString(5,productOrderVO.       getpByrEmail());
//            pstmt.setString(6,productOrderVO.       getpRcvName());
//            pstmt.setString(7,productOrderVO.       getpRcvPhone());
//            pstmt.setByte(8,productOrderVO.         getpTakeMethod());
//            pstmt.setString(9,productOrderVO.       getpAddr());
//            pstmt.setByte(10,productOrderVO.        getpPayMethod());
//            pstmt.setBigDecimal(11,productOrderVO.  getpAllPrice());
//            pstmt.setInt(12,productOrderVO.         getcoupNo());
//            pstmt.setBigDecimal(13,productOrderVO.  getpDisc());
//            pstmt.setBigDecimal(14,productOrderVO.  getpRealPrice());
//            pstmt.setTimestamp(15,productOrderVO.   getpOrdTime());
//            pstmt.setByte(16,productOrderVO.        getpOrdStat());
//            pstmt.setByte(17,productOrderVO.        getpStat());
//
//
//            pstmt.executeUpdate();
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. "
//                    + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
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
//    } // update 結束
//
//    @Override
//    publicProductPictureVO findByPK(Integer rOrdNo) {
//
//       ProductPictureVOproductPictureVO = null;
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(GET_ONE);
//
//            pstmt.setInt(1, rOrdNo);
//
//            rs = pstmt.executeQuery();
//
//            while(rs.next()) {
//
//               productPictureVO = newProductPictureVO();
//               productPictureVO.setrOrdNo(rs.getInt("rOrdNo"));
//               productPictureVO.setMemNo(rs.getInt("memNo"));
//               productPictureVO.setrByrName(rs.getString("rByrName"));
//               productPictureVO.setrByrPhone(rs.getString("rByrPhone"));
//               productPictureVO.setrByrEmail(rs.getString("rByrEmail"));
//               productPictureVO.setrRcvName(rs.getString("rRcvName"));
//               productPictureVO.setrRcvPhone(rs.getString("rRcvPhone"));
//               productPictureVO.setrTakeMethod(rs.getByte("rTakeMethod"));
//               productPictureVO.setrAddr(rs.getString("rAddr"));
//               productPictureVO.setrPayMethod(rs.getByte("rPayMethod"));
//               productPictureVO.setrAllPrice(rs.getBigDecimal("rAllPrice"));
//               productPictureVO.setrAllDepPrice(rs.getBigDecimal("rAllDepPrice"));
//               productPictureVO.setrOrdTime(rs.getTimestamp("rOrdTime"));
//               productPictureVO.setrDate(rs.getTimestamp("rDate"));
//               productPictureVO.setrBackDate(rs.getTimestamp("rBackDate"));
//               productPictureVO.setrRealBackDate(rs.getTimestamp("rRealBackDate"));
//               productPictureVO.setrPayStat(rs.getByte("rPayStat"));
//               productPictureVO.setrOrdStat(rs.getByte("rOrdStat"));
//               productPictureVO.setRtnStat(rs.getByte("rtnStat"));
//               productPictureVO.setRtnRemark(rs.getString("rtnRemark"));
//               productPictureVO.setRtnCompensation(rs.getBigDecimal("rtnCompensation"));
//
//            }
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. "
//                    + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
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
//
//        returnproduct PictureVO;
//
//    } // findByPK 結束
//
//    @Override
//    public List<RentalOrderVo> findByName(String rByrName) {
//
//        List<RentalOrderVo>productPictureVOList = new ArrayList<>();
//       ProductPictureVOproductPictureVO = null;
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(GET_ONE_ON_NAME);
//
//            pstmt.setString(1, rByrName);
//
//            rs = pstmt.executeQuery();
//
//            while(rs.next()) {
//
//               productPictureVO = newProductPictureVO();
//               productPictureVO.setrOrdNo(rs.getInt("rOrdNo"));
//               productPictureVO.setMemNo(rs.getInt("memNo"));
//               productPictureVO.setrByrName(rs.getString("rByrName"));
//               productPictureVO.setrByrPhone(rs.getString("rByrPhone"));
//               productPictureVO.setrByrEmail(rs.getString("rByrEmail"));
//               productPictureVO.setrRcvName(rs.getString("rRcvName"));
//               productPictureVO.setrRcvPhone(rs.getString("rRcvPhone"));
//               productPictureVO.setrTakeMethod(rs.getByte("rTakeMethod"));
//               productPictureVO.setrAddr(rs.getString("rAddr"));
//               productPictureVO.setrPayMethod(rs.getByte("rPayMethod"));
//               productPictureVO.setrAllPrice(rs.getBigDecimal("rAllPrice"));
//               productPictureVO.setrAllDepPrice(rs.getBigDecimal("rAllDepPrice"));
//               productPictureVO.setrOrdTime(rs.getTimestamp("rOrdTime"));
//               productPictureVO.setrDate(rs.getTimestamp("rDate"));
//               productPictureVO.setrBackDate(rs.getTimestamp("rBackDate"));
//               productPictureVO.setrRealBackDate(rs.getTimestamp("rRealBackDate"));
//               productPictureVO.setrPayStat(rs.getByte("rPayStat"));
//               productPictureVO.setrOrdStat(rs.getByte("rOrdStat"));
//               productPictureVO.setRtnStat(rs.getByte("rtnStat"));
//               productPictureVO.setRtnRemark(rs.getString("rtnRemark"));
//               productPictureVO.setRtnCompensation(rs.getBigDecimal("rtnCompensation"));
//
//               productPictureVOList.add(rentalOrderVo);
//
//            }
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. "
//                    + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
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
//
//        returnproductPictureVOList;
//
//    } // fingByName 結束
//
//    @Override
//    public List<RentalOrderVo> getAll() {
//
//        List<RentalOrderVo>productPictureVOList = new ArrayList<RentalOrderVo>();
//       ProductPictureVOproductPictureVO = null;
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, userid, passwd);
//            pstmt = con.prepareStatement(GET_ALL);
//            rs = pstmt.executeQuery();
//
//            while(rs.next()) {
//
//               productPictureVO = newProductPictureVO();
//               productPictureVO.setrOrdNo(rs.getInt("rOrdNo"));
//               productPictureVO.setMemNo(rs.getInt("memNo"));
//               productPictureVO.setrByrName(rs.getString("rByrName"));
//               productPictureVO.setrByrPhone(rs.getString("rByrPhone"));
//               productPictureVO.setrByrEmail(rs.getString("rByrEmail"));
//               productPictureVO.setrRcvName(rs.getString("rRcvName"));
//               productPictureVO.setrRcvPhone(rs.getString("rRcvPhone"));
//               productPictureVO.setrTakeMethod(rs.getByte("rTakeMethod"));
//               productPictureVO.setrAddr(rs.getString("rAddr"));
//               productPictureVO.setrPayMethod(rs.getByte("rPayMethod"));
//               productPictureVO.setrAllPrice(rs.getBigDecimal("rAllPrice"));
//               productPictureVO.setrAllDepPrice(rs.getBigDecimal("rAllDepPrice"));
//               productPictureVO.setrOrdTime(rs.getTimestamp("rOrdTime"));
//               productPictureVO.setrDate(rs.getTimestamp("rDate"));
//                System.out.println(rs.getTimestamp("rDate"));
//               productPictureVO.setrBackDate(rs.getTimestamp("rBackDate"));
//               productPictureVO.setrRealBackDate(rs.getTimestamp("rRealBackDate"));
//               productPictureVO.setrPayStat(rs.getByte("rPayStat"));
//               productPictureVO.setrOrdStat(rs.getByte("rOrdStat"));
//               productPictureVO.setRtnStat(rs.getByte("rtnStat"));
//               productPictureVO.setRtnRemark(rs.getString("rtnRemark"));
//               productPictureVO.setRtnCompensation(rs.getBigDecimal("rtnCompensation"));
//
//               productPictureVOList.add(rentalOrderVo);
//
//            }
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver. "
//                    + e.getMessage());
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
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
//
//        returnproductPictureVOList;
//
//    } // getAll 結束
//}
