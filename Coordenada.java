class Coordenada {

    final double latitude;
    final double longitude;

    Coordenada() {
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    Coordenada(double lat, double lon) {
        if (lat < -90.0 || lat > 90.0 || lon < -180.0 || lon > 180.0)
            throw new IllegalArgumentException("Coordenadas inválidas");
        this.latitude = lat;
        this.longitude = lon;
    }

    public Coordenada norte(double c) {
        return new Coordenada (this.latitude + c, this.longitude);
    }

    public Coordenada sul(double c) {
        return new Coordenada (this.latitude - c, this.longitude);
    }

    public Coordenada leste(double c) {
        return new Coordenada (this.latitude, this.longitude + c);
    }

    public Coordenada oeste(double c) {
        return new Coordenada (this.latitude, this.longitude - c);
    }

    // consultas
    public boolean noEquador() {
        return (this.latitude == 0.0);
    }

    public boolean noMeridiano() {
        return (this.longitude == 0.0);
    }

    public boolean noSul() {
        return (this.latitude < 0.0 && this.latitude >= -90.0);
    }

    public boolean noNorte() {
        return (this.latitude > 0.0 && this.latitude <= 90.0);
    }

    public boolean noOeste() {
        return (this.longitude >= -180.0 && this.longitude < 0.0);
    }

    public boolean noLeste() {
        return (this.longitude > 0.0 && this.longitude <= 180.0);
    }

    public boolean noOriente() {
        return (this.noLeste());
    }

    public boolean noOcidente() {
        return (this.noOeste());
    }

    @Override
    public String toString() {
        String lat = String.format("%.7f°, ", this.latitude);
        String lon = String.format("%.7f°", this.longitude);       
        return lat + lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Coordenada c = (Coordenada)o;
        return (this.latitude == c.latitude && this.longitude == c.longitude);
    }

}
