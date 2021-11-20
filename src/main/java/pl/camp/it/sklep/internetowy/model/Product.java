package pl.camp.it.sklep.internetowy.model;

public class Product {
    private String prodCode;
    private String brand;
    private String name;
    private int quantity;
    //private boolean adultOnly; //to do


    public Product(String prodCode, String brand, String name, int quantity){
        this.prodCode = prodCode;
        this.brand = brand;
        this.name = name;
        this.quantity = quantity;
    }
    public String getProdCode(){
        return prodCode;
    }
    public String getBrand(){
        return brand;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public boolean isAvailable(){
        return this.quantity > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kod produktu: ")
                .append(this.getProdCode())
                .append(" Marka: ")
                .append(this.getBrand())
                .append(" Nazwa: ")
                .append(this.getName())
                .append(" Ilość sztuk: ")
                .append(this.getQuantity());



        return sb.toString();
    }
}
