/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kibra
 */
package DB;

import java.sql.*;

/**
 *
 * @author kibra
 */
public class Kin {

    private String firstName, middleName, surname, idnumber, phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void save(Kin kin) {
        try {
            //JDBC_DRIVER
            Class.forName(DB.JDBC_DRIVER);
            System.out.println("Connecting to FHMSDB...");
            try (Connection conn = DriverManager.getConnection(DB.DB_URL, DB.DATABASEUSER, DB.DATABASEPASS)) {
                String query = "INSERT INTO kin (FIRSTNAME, MIDDLENAME,SURNAME,IDNUMBER, PHONE)"
                        + "VALUES (?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, kin.firstName);
                preparedStatement.setString(2, kin.middleName);
                preparedStatement.setString(3, kin.surname);
                preparedStatement.setString(4, kin.idnumber);
                preparedStatement.setString(5, kin.phone);

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
              String sql = "Select 1 from KIN where IDNUMBER= ?";

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
