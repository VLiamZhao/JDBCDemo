package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;

public class Test4 {
    public static void main(String[] args) {
        try (Connection conn = JDBCUtil.getConnection();) {
            String sql = "{call saveuser(?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, "bob");
            cs.setInt(2, 11);
            cs.execute();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
//USE `test`;
//        DROP procedure IF EXISTS `usersave`;
//
//        DELIMITER $$
//        USE `test`$$
//        CREATE PROCEDURE `usersave` (IN p_name varchar(20), IN p_age int)
//        BEGIN
//        insert into sample (name, age) values (p_name, p_age);
//        END$$
//
//        DELIMITER ;