package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class gui extends JFrame {


    private JTextField textField1;
    private JButton searchButton;
    private JTable table1;
    private JPanel panel;
    private jdbc dao;


    public gui() {
        super("Inventory");


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        getContentPane().add(panel);
        setVisible(true);

        dao = new jdbc();
        dao.jdbc();


        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get last name from the text field

                // Call DAO and get employees for the last name

                // If last name is empty, then get all employees

                // Print out employees

                try {
                    String lastName = textField1.getText();

                    List<products> productss = null;

                    if (lastName != null && lastName.trim().length() > 0) {
                        productss = dao.searchproducts(lastName);
                    } else {
                        productss = dao.getAllproducts();
                    }

                    // create the model and update the "table"
                    tablemodel model = new tablemodel(productss);

                    table1.setModel(model);

                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(gui.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });


    }


    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gui frame = new gui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

}