package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class jdbc {
    private String user = "root";
    private String pass = "root";
    private String url = "jdbc:mysql://localhost/inventory";
    private Connection conn=null;


    public void jdbc()  {

        try {

            //conn = DriverManager.getConnection("jdbc:mysql://localhost/inventory"+ "user=root&password=root");
            conn = getConnection(url, user, pass);
            System.out.println("DB connection successful to: " + url);
        }
        catch(Exception e){
            System.out.println("not connected");
        }


    }

    public List<products> searchproducts(String ProductName) throws Exception {
        List<products> list = new ArrayList<>();

        PreparedStatement myStmt = null;
        ResultSet myRs = null;


        try {
            ProductName= ProductName+"%";

            myStmt = conn.prepareStatement("select * from inventory.products where ProductName like ?");

            myStmt.setString(1, ProductName);

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                products tempprod = convertRowToproducts(myRs);
                list.add(tempprod);
            }

            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<products> getAllproducts() throws Exception {
        List<products> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = conn.createStatement();
            myRs = myStmt.executeQuery("select * from inventory.products");

            while (myRs.next()) {
                products tempproducts = convertRowToproducts(myRs);
                list.add(tempproducts);
            }

            return list;
        }
        finally {
            close(myStmt, myRs);
        }


    }


    private products convertRowToproducts(ResultSet myRs) throws SQLException {

        int id = myRs.getInt("id");
        String ProductName = myRs.getString("ProductName");
        String ProductNumber = myRs.getString("PartNumber");
        String ProductLabel = myRs.getString("ProductLabel");
        int InventoryShipped = myRs.getInt("InventoryShipped");
        int MinimumRequired = myRs.getInt("MinimumRequired");

        products tempproducts = new products(id, ProductName, ProductNumber, ProductLabel, InventoryShipped,MinimumRequired);

        return tempproducts;
    }


    private static void close(Connection conn, Statement myStmt, ResultSet myRs)
            throws SQLException {

        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {
            myStmt.close();

        }

        if (conn != null) {
            conn.close();
        }
    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    public static void main(String args[]) throws Exception
    {
        jdbc dao =new jdbc();
        dao.jdbc();
        System.out.println(dao.searchproducts("dell"));
    }
}


