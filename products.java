package com.company;

public class products {
    private int id;
    private String ProductName;
    private String PartNumber;
    private String ProductLabel;
    private int InventoryShipped;
    private int MinimumRequired;

    public products (int id,String ProductName,String PartNumber,String ProductLabel,int InventoryShipped,int MinimumRequired)
    {
        super();
    this.id=id;
    this.PartNumber=PartNumber;
    this.ProductLabel=ProductLabel;
    this.InventoryShipped=InventoryShipped;
    this.ProductName=ProductName;
    this.MinimumRequired=MinimumRequired;


    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String ProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getPartNumber() {
        return PartNumber;
    }

    public void setPartNumber(String PartNumber) {
        this.PartNumber = PartNumber;
    }

    public String getProductLabel() {
        return ProductLabel;
    }

    public void setProductLabel(String ProductLabel) {
        this.ProductLabel = ProductLabel;
    }

    public int  InventoryShipped() {
        return InventoryShipped;
    }

    public void setInventoryShipped(int InventoryShipped) {
        this.InventoryShipped=InventoryShipped;
    }

    public int  MinimumRequired() {
        return MinimumRequired;
    }

    public void setMinimumRequired(int MinimumRequired) {
        this.MinimumRequired=MinimumRequired;
    }

    @Override
    public String toString() {
        return String
                .format("Employee [id=%s, ProductName=%s, PartNumber=%s, ProductLabel=%s, InventoryShipped=%s, MinimumRequired=%s]",
                        id, ProductName, PartNumber, ProductLabel, InventoryShipped, MinimumRequired);
    }

}
