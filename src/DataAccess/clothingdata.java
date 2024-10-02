/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adamm
 */
public class clothingdata {
    public static String strPlainTShirtMessage;
    public static String strPlainTShirtPrice;
    public static String strPlainShirtMessage;
    public static String strPlainShirtPrice;
    public static String strUCCShirtMessage;
    public static String strUCCShirtPrice;
    public static String strAdidasTShirtMessage;
    public static String strAdidasTShirtPrice;
    public static String strLongSleeveMessage;
    public static String strLongSleevePrice;
    public static String strGraphicTeeMessage;
    public static String strGraphicTeePrice;
    public static String strNikeAirforcesMessage;
    public static String strNikeAirforcesPrice;
    public static String strAirJordansMessage;
    public static String strAirJordansPrice;
    public static String strAdidasGazelleMessage;
    public static String strAdidasGazellePrice;
    public static String strConverseMessage;
    public static String strConversePrice;
    public static String strDocMartinMessage;
    public static String strDocMartinPrice;
    public static String strVansMessage;
    public static String strVansPrice;
    public static String strChinosMessage;
    public static String strChinosPrice;
    public static String strSweatpantsMessage;
    public static String strSweatpantsPrice;
    public static String strAdidasJoggersMessage;
    public static String strAdidasJoggersPrice;
    public static String strNikeJoggersMessage;
    public static String strNikeJoggersPrice;
    public static String strJeansMessage;
    public static String strJeansPrice;
    public static String strCarharrtMessage;
    public static String strCarharrtPrice;
    
    public void setClothing(){
        getPLAINTSHIRTFromDatabase();
        getPLAINSHIRTFromDatabase();
        getUCCSHIRTFromDatabase();
        getADIDASTSHIRTFromDatabase();
        getLONGSLEEVEFromDatabase();
        getGRAPHICTEEFromDatabase();
        getNIKEAIRFORCESFromDatabase();
        getAIRJORDANSFromDatabase();
        getADIDASGAZELLEFromDatabase();
        getCONVERSEFromDatabase();
        getDOCMARTINFromDatabase();
        getVANSFromDatabase();
        getCHINOSFromDatabase();
        getSWEATPANTSFromDatabase();
        getADIDASJOGGERSFromDatabase();
        getNIKEJOGGERSFromDatabase();
        getJEANSFromDatabase();
        getCARHARRTFromDatabase();
    }
    public String getPLAINTSHIRTFromDatabase() {
        strPlainTShirtMessage = "";
        strPlainTShirtPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Plain T-Shirt'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strPlainTShirtMessage = rs1.getString("PRODUCTMESSAGE");
                strPlainTShirtPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strPlainTShirtMessage);
                System.out.println(strPlainTShirtPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strPlainTShirtMessage + " " + strPlainTShirtPrice;
    }
     public String getPLAINSHIRTFromDatabase() {
        strPlainShirtMessage = "";
        strPlainShirtPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Plain Shirt'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strPlainShirtMessage = rs1.getString("PRODUCTMESSAGE");
                strPlainShirtPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strPlainShirtMessage);
                System.out.println(strPlainShirtPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strPlainShirtMessage + " " + strPlainShirtPrice;
    }
     public String getUCCSHIRTFromDatabase() {
        strUCCShirtMessage = "";
        strUCCShirtPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'UCC Shirt'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strUCCShirtMessage = rs1.getString("PRODUCTMESSAGE");
                strUCCShirtPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strUCCShirtMessage);
                System.out.println(strUCCShirtPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strUCCShirtMessage + " " + strUCCShirtPrice;
    }
      public String getADIDASTSHIRTFromDatabase() {
        strAdidasTShirtMessage = "";
        strAdidasTShirtPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Adidas T-Shirt'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strAdidasTShirtMessage = rs1.getString("PRODUCTMESSAGE");
                strAdidasTShirtPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strAdidasTShirtMessage);
                System.out.println(strAdidasTShirtPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strAdidasTShirtMessage + " " + strAdidasTShirtPrice;
    }
            public String getLONGSLEEVEFromDatabase() {
        strLongSleeveMessage = "";
        strLongSleevePrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Long Sleeve Out'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strLongSleeveMessage = rs1.getString("PRODUCTMESSAGE");
                strLongSleevePrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strLongSleeveMessage);
                System.out.println(strLongSleevePrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strLongSleeveMessage + " " + strLongSleevePrice;
    }
              public String getGRAPHICTEEFromDatabase() {
        strGraphicTeeMessage = "";
        strGraphicTeePrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Graphic Tee'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strGraphicTeeMessage = rs1.getString("PRODUCTMESSAGE");
                strGraphicTeePrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strGraphicTeeMessage);
                System.out.println(strGraphicTeePrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strGraphicTeeMessage + " " + strGraphicTeePrice;
    }
               public String getNIKEAIRFORCESFromDatabase() {
        strNikeAirforcesMessage = "";
        strNikeAirforcesPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Nike Airforces'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strNikeAirforcesMessage = rs1.getString("PRODUCTMESSAGE");
                strNikeAirforcesPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strNikeAirforcesMessage);
                System.out.println(strNikeAirforcesPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strNikeAirforcesMessage + " " + strNikeAirforcesPrice;
    }
               public String getAIRJORDANSFromDatabase() {
        strAirJordansMessage = "";
        strAirJordansPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Air Jordans'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strAirJordansMessage = rs1.getString("PRODUCTMESSAGE");
                strAirJordansPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strAirJordansMessage);
                System.out.println(strAirJordansPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strAirJordansMessage + " " + strAirJordansPrice;
    }
               public String getADIDASGAZELLEFromDatabase() {
        strAdidasGazelleMessage = "";
        strAdidasGazellePrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Adidas Gazelle'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strAdidasGazelleMessage = rs1.getString("PRODUCTMESSAGE");
                strAdidasGazellePrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strAdidasGazelleMessage);
                System.out.println(strAdidasGazellePrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strAdidasGazelleMessage + " " + strAdidasGazellePrice;
    }
                public String getCONVERSEFromDatabase() {
        strConverseMessage = "";
        strConversePrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Converse'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strConverseMessage = rs1.getString("PRODUCTMESSAGE");
                strConversePrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strConverseMessage);
                System.out.println(strConversePrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strConverseMessage + " " + strConversePrice;
        }
                public String getDOCMARTINFromDatabase() {
        strDocMartinMessage = "";
        strDocMartinPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Doc Martin'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strDocMartinMessage = rs1.getString("PRODUCTMESSAGE");
                strDocMartinPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strDocMartinMessage);
                System.out.println(strDocMartinPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strDocMartinMessage + " " + strDocMartinPrice;
    }
        public String getVANSFromDatabase() {
        strVansMessage = "";
        strVansPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Vans'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strVansMessage = rs1.getString("PRODUCTMESSAGE");
                strVansPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strVansMessage);
                System.out.println(strVansPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strVansMessage + " " + strVansPrice;
    }
        public String getCHINOSFromDatabase() {
        strChinosMessage = "";
        strChinosPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Chinos'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strChinosMessage = rs1.getString("PRODUCTMESSAGE");
                strChinosPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strChinosMessage);
                System.out.println(strChinosPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strChinosMessage + " " + strChinosPrice;
    }
        public String getSWEATPANTSFromDatabase() {
        strSweatpantsMessage = "";
        strSweatpantsPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Sweatpants'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strSweatpantsMessage = rs1.getString("PRODUCTMESSAGE");
                strSweatpantsPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strSweatpantsMessage);
                System.out.println(strSweatpantsPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strSweatpantsMessage + " " + strSweatpantsPrice;
    }
        public String getADIDASJOGGERSFromDatabase() {
        strAdidasJoggersMessage = "";
        strAdidasJoggersPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Adidas Joggers'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strAdidasJoggersMessage = rs1.getString("PRODUCTMESSAGE");
                strAdidasJoggersPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strAdidasJoggersMessage);
                System.out.println(strAdidasJoggersPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strAdidasJoggersMessage + " " + strAdidasJoggersPrice;
    }
        public String getNIKEJOGGERSFromDatabase() {
        strNikeJoggersMessage = "";
        strNikeJoggersPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Nike Joggers'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strNikeJoggersMessage = rs1.getString("PRODUCTMESSAGE");
                strNikeJoggersPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strNikeJoggersMessage);
                System.out.println(strNikeJoggersPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strNikeJoggersMessage + " " + strNikeJoggersPrice;
    }
        public String getJEANSFromDatabase() {
        strJeansMessage = "";
        strJeansPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Jeans'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strJeansMessage = rs1.getString("PRODUCTMESSAGE");
                strJeansPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strJeansMessage);
                System.out.println(strJeansPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strJeansMessage + " " + strJeansPrice;
    }
        public String getCARHARRTFromDatabase() {
        strCarharrtMessage = "";
        strCarharrtPrice = "";
        Connection conn = null;
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        try {
            conn = JDBConnection.getConnection();
            stmt1 = conn.prepareStatement("SELECT PRODUCTMESSAGE, PRODUCTPRICE FROM TBLPRODUCTS WHERE PRODUCTNAME = 'Carharrt'");
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                strCarharrtMessage = rs1.getString("PRODUCTMESSAGE");
                strCarharrtPrice = rs1.getString("PRODUCTPRICE");
                System.out.println(strCarharrtMessage);
                System.out.println(strCarharrtPrice);
            }
            rs1.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strCarharrtMessage + " " + strCarharrtPrice;
    }
}
