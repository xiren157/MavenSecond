package org.xiren.model;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public class Property {
    private Integer property_no;
    private String property_name;
    private String property_price;
    private Integer category_no;
    private String property_import;

    public Property() {
    }

    public Property(Integer property_no, String property_name, String property_price, Integer category_no, String property_import) {
        this.property_no = property_no;
        this.property_name = property_name;
        this.property_price = property_price;
        this.category_no = category_no;
        this.property_import = property_import;
    }

    public Integer getProperty_no() {
        return property_no;
    }

    public void setProperty_no(Integer property_no) {
        this.property_no = property_no;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public String getProperty_price() {
        return property_price;
    }

    public void setProperty_price(String property_price) {
        this.property_price = property_price;
    }

    public Integer getCategory_no() {
        return category_no;
    }

    public void setCategory_no(Integer category_no) {
        this.category_no = category_no;
    }

    public String getProperty_import() {
        return property_import;
    }

    public void setProperty_import(String property_import) {
        this.property_import = property_import;
    }

    @Override
    public String toString() {
        return "Property{" +
                "property_no=" + property_no +
                ", property_name='" + property_name + '\'' +
                ", property_price='" + property_price + '\'' +
                ", category_no=" + category_no +
                ", property_import='" + property_import + '\'' +
                '}';
    }
}
