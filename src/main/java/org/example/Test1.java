package org.example;

import java.sql.*;

public class Test1 {

    public static void main(String[] args) throws SQLException {
        try (Connection conn = JDBCUtil.getConnection();) {
            conn.setAutoCommit(false);
            try {
                String sql = "insert into sample (name, age) values ('alice1', 221)";

                Statement st = conn.createStatement();
                int m = st.executeUpdate(sql);
                if (m==1)
                    System.out.println("inserted successfully : "+sql);
                else
                    System.out.println("insertion failed");
                sql = "insert into sample (name, age) values ('karen11', 223)";
                st = conn.createStatement();
                int n = st.executeUpdate(sql);
                if (n==1)
                    System.out.println("inserted successfully : "+sql);
                else
                    System.out.println("insertion failed");
                conn.commit();
            } catch (Exception e) {
                conn.rollback();
            }
            String sqll = "select * from sample";
            Statement stl = conn.prepareStatement(sqll);
            ResultSet rs = stl.executeQuery(sqll);
            while (rs.next()) {
                System.out.println(rs.getString("name") + "\t" + rs.getInt("age"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
