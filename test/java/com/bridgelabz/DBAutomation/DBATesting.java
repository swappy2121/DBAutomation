package com.bridgelabz.DBAutomation;
import org.testng.annotations.Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


    public class DBATesting extends BaseClass {
        @Test
        public void dbTest_ExecuteSelectData() throws SQLException, ClassNotFoundException {
            connection = setUp();
            System.out.println("Connection established");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from upload");

            while (resultset.next()) {
                int id = resultset.getInt(1);
                String firstName = resultset.getString(2);
                String lastName = resultset.getString(3);
                System.out.println(id + " " + firstName + " " + lastName);
            }
            System.out.println("Getting all upload data table");
        }
        @Test
        public void dbTest_InsertData() throws SQLException, ClassNotFoundException {
            connection = setUp();
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into upload values(?,?,?)");
            preparedStatement.setInt(1, 11143);
            preparedStatement.setString(2, "Rajesh");
            preparedStatement.setString(3, "Patil");
            System.out.println("Successfully inserted");
        }
        @Test
        public void dbTest_UpdateData() throws SQLException, ClassNotFoundException {
            connection = setUp();
            PreparedStatement preparedStatement = connection.prepareStatement("update upload set first_name=(?) where last_name=(?)");
            preparedStatement.setString(2, "Thomas");
            preparedStatement.setString(1, "John");
            preparedStatement.executeUpdate();
            System.out.println("Updated successfully !!");
        }
        @Test
        public void dbTest_DeleteData() throws SQLException, ClassNotFoundException {
            connection = setUp();
            System.out.println("Connection established");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from upload where first_name=(?)");
            preparedStatement.setString(1, "Mike");
            System.out.println("Getting all deleted data successfully");
        }
    }

