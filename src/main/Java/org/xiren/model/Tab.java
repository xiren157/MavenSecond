package org.xiren.model;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public class Tab {
    private Integer department_no;
    private String department_name;
    private Integer up_id;

    public Tab() {
    }

    public Tab(Integer department_no, String department_name, Integer up_id) {
        this.department_no = department_no;
        this.department_name = department_name;
        this.up_id = up_id;
    }

    public Integer getDepartment_no() {
        return department_no;
    }

    public void setDepartment_no(Integer department_no) {
        this.department_no = department_no;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Integer getUp_id() {
        return up_id;
    }

    public void setUp_id(Integer up_id) {
        this.up_id = up_id;
    }

    @Override
    public String toString() {
        return "Tab{" +
                "department_no=" + department_no +
                ", department_name='" + department_name + '\'' +
                ", up_id=" + up_id +
                '}';
    }
}
