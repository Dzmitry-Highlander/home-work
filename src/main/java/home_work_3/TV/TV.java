package home_work_3.TV;

import java.util.Objects;

public class TV {
    private final String brand;
    private final String model;
    private final int modelYear;
    private final double diagonal;
    private final double price;

    public TV(String brand, String model, int modelYear, int diagonal, int price) {
        this.brand = brand;
        this.model = model;
        this.modelYear = modelYear;
        this.diagonal = diagonal;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return modelYear == tv.modelYear && diagonal == tv.diagonal && price == tv.price
                && Objects.equals(brand, tv.brand) && Objects.equals(model, tv.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, modelYear, diagonal, price);
    }
}
