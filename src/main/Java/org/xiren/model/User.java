package org.xiren.model;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public class User {

    private Integer person_no;
    private String person_password;
    private String person_nickname;
    private Integer department_no;
    private String person_name;
    private String person_sex;
    private String person_birthday;
    private String person_phone;
    private String person_email;
    private Integer person_state;

    public User() {
    }

    public User(Integer person_no, String person_password, String person_nickname, Integer department_no, String person_name, String person_sex, String person_birthday, String person_phone, String person_email, Integer person_state) {
        this.person_no = person_no;
        this.person_password = person_password;
        this.person_nickname = person_nickname;
        this.department_no = department_no;
        this.person_name = person_name;
        this.person_sex = person_sex;
        this.person_birthday = person_birthday;
        this.person_phone = person_phone;
        this.person_email = person_email;
        this.person_state = person_state;
    }

    public Integer getPerson_no() {
        return person_no;
    }

    public void setPerson_no(Integer person_no) {
        this.person_no = person_no;
    }

    public String getPerson_password() {
        return person_password;
    }

    public void setPerson_password(String person_password) {
        this.person_password = person_password;
    }

    public String getPerson_nickname() {
        return person_nickname;
    }

    public void setPerson_nickname(String person_nickname) {
        this.person_nickname = person_nickname;
    }

    public Integer getDepartment_no() {
        return department_no;
    }

    public void setDepartment_no(Integer department_no) {
        this.department_no = department_no;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_sex() {
        return person_sex;
    }

    public void setPerson_sex(String person_sex) {
        this.person_sex = person_sex;
    }

    public String getPerson_birthday() {
        return person_birthday;
    }

    public void setPerson_birthday(String person_birthday) {
        this.person_birthday = person_birthday;
    }

    public String getPerson_phone() {
        return person_phone;
    }

    public void setPerson_phone(String person_phone) {
        this.person_phone = person_phone;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public Integer getPerson_state() {
        return person_state;
    }

    public void setPerson_state(Integer person_state) {
        this.person_state = person_state;
    }

    @Override
    public String toString() {
        return "User{" +
                "person_no=" + person_no +
                ", person_password='" + person_password + '\'' +
                ", person_nickname='" + person_nickname + '\'' +
                ", department_no=" + department_no +
                ", person_name='" + person_name + '\'' +
                ", person_sex='" + person_sex + '\'' +
                ", person_birthday='" + person_birthday + '\'' +
                ", person_phone='" + person_phone + '\'' +
                ", person_email='" + person_email + '\'' +
                ", person_state=" + person_state +
                '}';
    }
}
