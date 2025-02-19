package com.ric.api.product;

public class Product {
    private long id;
    private String category;
    private String productionCountry;

    public Product(long id, String category, String productionCountry) {
        setId(id);
        setCategory(category);
        setProductionCountry(productionCountry);
    }

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return String return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }


    /**
     * @return String return the productionCountry
     */
    public String getProductionCountry() {
        return productionCountry;
    }

    /**
     * @param productionCountry the productionCountry to set
     */
    public void setProductionCountry(String productionCountry) {
        this.productionCountry = productionCountry;
    }

    @Override
    public String toString(){
        return ("Product: " + getCategory() + " " + getProductionCountry());
    }

}
