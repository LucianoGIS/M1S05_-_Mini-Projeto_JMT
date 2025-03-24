package models;

public class Localizacao {
    private int id;
    private double latitude;
    private double longitude;
    private int areaVerdeId;

    public Localizacao() {
    }

    public Localizacao(int id, double latitude, double longitude, int areaVerdeId) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.areaVerdeId = areaVerdeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getAreaVerdeId() {
        return areaVerdeId;
    }

    public void setAreaVerdeId(int areaVerdeId) {
        this.areaVerdeId = areaVerdeId;
    }

    @Override
    public String toString() {
        return "Localização [Latitude: " + latitude + ", Longitude: " + longitude + "]";
    }
}