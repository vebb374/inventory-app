package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class tablemodel extends AbstractTableModel {
    private static final int id_col = 0;
    private static final int  Product_name_COL = 1;
    private static final int Part_number_COL = 2;
    private static final int Product_label_COL = 3;
    private static final int Inventory_Shipped_COL = 4;
    private static final int Minimum_Required_COL = 5;
    

    private String[] columnNames = { "ID","Product Name", "Part Number", "Product label","Inventory Shipped","Minimum Required" };
    private List<products> products;

    public tablemodel(List<products> productslist) {products= productslist;}
    
    public int getColumnCount()
    {
        return columnNames.length;
    }
    
    public int getRowCount()
    {return products.size();
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {

        products temp = products.get(row);

        switch (col) {
            case id_col:
                return temp.getId();
            case Product_name_COL:
                return temp.ProductName();
            case Product_label_COL:
                return temp.getProductLabel();
            case Part_number_COL:
                return temp.getPartNumber();
            case Inventory_Shipped_COL:
                return temp.InventoryShipped();
            case Minimum_Required_COL:
                return temp.MinimumRequired();
            default:
                return temp.ProductName();
        }
    }

   
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
}
