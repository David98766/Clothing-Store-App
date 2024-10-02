/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxproject;

import DataAccess.JDBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adamm
 */

public class login {
public static String strUsername;
       public static String strPartToPrint;
       public static String strEmail;
       public static String strPassword;
       public static String strFName;
       public static String strLName;
       public static String strHouseNumber;
       public static String strStreetName;
       public static String strCity;
       public static String strCountry;
       public static String strCCNumber;
       public static String strPaymentType;
       public static String strCCDate;
       public static String strShirtSize;
       public static String strShoeSize;
       public static String strWaistSize;
       public static String strLine;
       public static String strProductName;
       public static String strMessageText;
       public static String strProductPrice;
       public static String strPartToPrintClothing;
       public static String strLineClothing;
     
public boolean validateLogin(String username, String password) throws IOException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conn = JDBConnection.getConnection();
        String query = "SELECT * FROM TBLUSER WHERE USERNAME = ? AND PASSWORD = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        rs = stmt.executeQuery();
        while (rs.next()) {

    
            if (rs.getString("USERNAME").equals(username) && rs.getString("PASSWORD").equals(password)) {
                // user exists in database and password is correct
                getUSERNAMEFromDatabase(username);
                getFNAMEFromDatabase(username);
                getLNAMEFromDatabase(username);
                getEMAILFromDatabase(username);
                getPASSWORDFromDatabase(username);
                getHOUSENUMBERFromDatabase(username);
                getCITYFromDatabase(username);
                getCOUNTRYFromDatabase(username);
                getCARDTYPEFromDatabase(username);
                getSHIRTSIZEFromDatabase(username);
                getCARDNUMBERFromDatabase(username);
                getWAISTSIZEFromDatabase(username);
                getEXPIRYDATEFromDatabase(username);
                getSTREETNAMEFromDatabase(username);
                getSHOESIZEFromDatabase(username);
                return true;
              
            }
        }
        // user does not exist in database or password is incorrect
        return false;
    } catch (SQLException e) {
        // handle any errors
        return false;
    } finally {
        // close all database resources
        try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
        try { if (stmt != null) stmt.close(); } catch (SQLException e) { /* ignored */ }
        try { if (conn != null) conn.close(); } catch (SQLException e) { /* ignored */ }
    }

}
/*public String getFNAMEFromDatabase() {
    String FNAME = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
           conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT FNAME FROM TBLUSER");
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            FNAME = rs1.getString("FNAME");
              System.out.println(FNAME);
        }
        rs1.close();
        stmt1.close();
        conn.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return FNAME;
  
}*/
public String getUSERNAMEFromDatabase(String username) {
    strUsername = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT USERNAME FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strUsername = rs1.getString("USERNAME");
            System.out.println(strUsername);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strUsername;
}
public String getFNAMEFromDatabase(String username) {
    strFName = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT FNAME FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strFName = rs1.getString("FNAME");
            System.out.println(strFName);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strFName;
}
public String getLNAMEFromDatabase(String username) {
    strLName = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT LNAME FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strLName = rs1.getString("LNAME");
            System.out.println(strLName);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strLName;
}
public String getSHIRTSIZEFromDatabase(String username) {
    strShirtSize = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT SHIRTSIZE FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strShirtSize = rs1.getString("SHIRTSIZE");
            System.out.println(strShirtSize);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strShirtSize;
}
public String getEMAILFromDatabase(String username) {
    strEmail = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT UEMAIL FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strEmail = rs1.getString("UEMAIL");
            System.out.println(strEmail);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strEmail;
}
public String getPASSWORDFromDatabase(String username) {
    strPassword = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT PASSWORD FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strPassword = rs1.getString("PASSWORD");
            System.out.println(strPassword);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strPassword;
}
public String getHOUSENUMBERFromDatabase(String username) {
    strHouseNumber = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT HOUSENUMBER FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strHouseNumber = rs1.getString("HOUSENUMBER");
            System.out.println(strHouseNumber);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strHouseNumber;
}
public String getCITYFromDatabase(String username) {
    strCity = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT CITY FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strCity = rs1.getString("CITY");
            System.out.println(strCity);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strCity;
}
public String getCOUNTRYFromDatabase(String username) {
    strCountry = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT COUNTRY FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strCountry = rs1.getString("COUNTRY");
            System.out.println(strCountry);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strCountry;
}
public String getCARDTYPEFromDatabase(String username) {
    strPaymentType = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT CARDTYPE FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strPaymentType = rs1.getString("CARDTYPE");
            System.out.println(strPaymentType);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strPaymentType;
}
public String getCARDNUMBERFromDatabase(String username) {
    strCCNumber = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT CARDNUMBER FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strCCNumber = rs1.getString("CARDNUMBER");
            System.out.println(strCCNumber);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strCCNumber;
}
public String getWAISTSIZEFromDatabase(String username) {
    strWaistSize = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT WAISTSIZE FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strWaistSize = rs1.getString("WAISTSIZE");
            System.out.println(strWaistSize);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strWaistSize;
}
public String getEXPIRYDATEFromDatabase(String username) {
    strCCDate = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT EXPIRYDATE FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strCCDate = rs1.getString("EXPIRYDATE");
            System.out.println(strCCDate);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strCCDate;
}
public String getSTREETNAMEFromDatabase(String username) {
    strStreetName = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT STREETNAME FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strStreetName = rs1.getString("STREETNAME");
            System.out.println(strStreetName);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strStreetName;
}
public String getSHOESIZEFromDatabase(String username) {
    strShoeSize = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT SHOESIZE FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strShoeSize = rs1.getString("SHOESIZE");
            System.out.println(strShoeSize);
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strShoeSize;
}
}
