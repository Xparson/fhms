/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

/**
 *
 * @author kibra
 */

import java.sql.*;

public class DB {
   // JDBC driver and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/fhms";

   //  Database credentials
   static final String DATABASEUSER = "root";
   static final String DATABASEPASS = "";
}