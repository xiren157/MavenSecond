package org.xiren.model;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public class Infromation {
    private Integer id;
    private String user_name;
    private String ip;
    private String name;
    private String time;

    public Infromation() {
    }

    public Infromation(Integer id, String user_name, String ip, String name, String time) {
        this.id = id;
        this.user_name = user_name;
        this.ip = ip;
        this.name = name;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Infromation{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
