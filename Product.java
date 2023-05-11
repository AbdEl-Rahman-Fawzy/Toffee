public class Product {
    private String code;
    private String name;
    private float unitPrice;

    public Product(String code, String name, float unitPrice) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }
}
