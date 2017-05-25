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

/**
 *
 * @author kibra
 */
public class Reporter {
    private String firstName, middleName, surname, idnumber, address, phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
   

    public void save(Reporter reporter) {
        try {
            //JDBC_DRIVER
            Class.forName(DB.JDBC_DRIVER);
            System.out.println("Connecting to FHMSDB...");
            try (Connection conn = DriverManager.getConnection(DB.DB_URL, DB.DATABASEUSER, DB.DATABASEPASS)) {
                String query = "INSERT INTO reporter (FIRSTNAME, MIDDLENAME,SURNAME,IDNUMBER, PHONE, ADDRESS)"
                        + "VALUES (?,?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, reporter.firstName);
                preparedStatement.setString(2, reporter.middleName);
                preparedStatement.setString(3, reporter.surname);
                preparedStatement.setString(4, reporter.idnumber);
                preparedStatement.setString(6, reporter.address);
                preparedStatement.setString(5, reporter.phone);
                
                
                preparedStatement.execute();
                
                preparedStatement.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
     public Boolean exists(String id) {
        boolean doesExist = false;
        try {
            //JDBC_DRIVER
            Class.forName(DB.JDBC_DRIVER);
            System.out.println("Connecting to FHMSDB...");
             try (Connection conn = DriverManager.getConnection(DB.DB_URL, DB.DATABASEUSER, DB.DATABASEPASS)) {
              String sql = "Select 1 from REPORTER where IDNUMBER = ?";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                doesExist = rs.next();
             }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return doesExist;
}

}

