package ru.mirea.tereshkin.httpurlconnection;

public class User {
    public String ip;
    public String city;
    public String country;
    public String region;

    public User(String ip, String city, String country, String region) {
        this.ip = ip;
        this.city = city;
        this.country = country;
        this.region = region;
    }
}
