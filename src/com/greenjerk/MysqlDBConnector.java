package com.greenjerk;

import java.sql.*;

/**
 * Created by greenjerk on 23.11.14
 */
public class MysqlDBConnector {
    static final String DB_URL = "jdbc:mysql://localhost/graphic_editor";
    static final String USER = "root";
    static final String PASS = "";

    public Integer getDefaultTab() {
        Connection conn = null;
        Statement stmt = null;
        int defaultTab = 0;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select tab_number from tab where is_default = true");
            while (rs.next()) {
                defaultTab = rs.getInt("tab_number");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            } try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return defaultTab;
    }

    public void setDefaultTab(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt.executeUpdate("update tab set is_default = false");
            stmt.executeUpdate("update tab set is_default = true where tab_number = " + id);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            } try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
