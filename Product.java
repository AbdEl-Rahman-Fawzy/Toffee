public class Product {
    private final int code;
    private final String name;
    private final float unitPrice;

    public Product(int code, String name, float unitPrice) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }
}
