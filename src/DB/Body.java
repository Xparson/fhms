/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;

/**
 *
 * @author kibra
 */
public class Body {

    private String firstName, middleName, surname, homeAddress, residentialArea, checkInDate, sex, kin, reporter;

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getKin() {
        return kin;
    }

    public void setKin(String kin) {
        this.kin = kin;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

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

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getResidentialArea() {
        return residentialArea;
    }

    public void setResidentialArea(String residentialArea) {
        this.residentialArea = residentialArea;
    }

    public String getcheckInDate() {
        return checkInDate;
    }

    public void setcheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void save(Body body) {
        try {
            //JDBC_DRIVER
            Class.forName(DB.JDBC_DRIVER);
            System.out.println("Connecting to FHMSDB...");
            try (Connection conn = DriverManager.getConnection(DB.DB_URL, DB.DATABASEUSER, DB.DATABASEPASS)) {
                String query = "INSERT INTO body (FIRSTNAME, MIDDLENAME,SURNAME,HOMEADDRESS, RESIDENTIALAREA, CHECKINDATE, SEX, KIN, REPORTER)"
                        + "VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, body.firstName);
                preparedStatement.setString(2, body.middleName);
                preparedStatement.setString(3, body.surname);
                preparedStatement.setString(4, body.homeAddress);
                preparedStatement.setString(5, body.residentialArea);
                preparedStatement.setString(6, body.checkInDate);
                preparedStatement.setString(7, body.sex);
                preparedStatement.setString(8, body.kin);
                preparedStatement.setString(9, body.reporter);
                preparedStatement.execute();
                
                preparedStatement.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
