package ra.model;

public class Product {
    private int id;
    private  String name;
    private Catalog catalog;
    private double price;
    private int stock;
    private boolean status = true;

    public Product() {
    }

    public Product(int id, String name, Catalog catalog, double price, int stock, boolean status) {
        this.id = id;
        this.name = name;
        this.catalog = catalog;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Id : "+id + "|Name : "+name + "| price : "+price + "| Catalog :" +catalog.getName() +"| Stock : "+stock+"|Status : "+ status;
    }
}
