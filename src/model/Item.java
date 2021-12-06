package model;

public class Item {

    private String category;
    private int availableQuantity;
    private double price;

    public Item(String category, int availableQuantity, double price){
        this.category = category;
        this.availableQuantity = availableQuantity;
        this.price = price;
    }

    public String getCategory(){
        return this.category;
    }

    public double getPrice(){
        return this.price;
    }

    public Integer getAvailableQuantity() {return this.availableQuantity;}

    public void updateAvailableQuantity(Integer orderedQ){
        this.availableQuantity = this.availableQuantity - orderedQ;
    }

    @Override
    public String toString() {
        return (category + ' ' + availableQuantity + ' ' +  price);
    }

}

