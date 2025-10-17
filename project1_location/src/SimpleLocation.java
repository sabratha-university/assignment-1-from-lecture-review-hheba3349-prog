 public class SimpleLocation {

    private double latitude;
    private double longitude;

    //Default constructor initialize the locaton at (0,0)
    public SimpleLocation() {
        latitude = 0;
        longitude = 0;
    }
    //Overloaded constructor
    public SimpleLocation(double lat, double lon) {
        if (lat >= -90 && lat <= 90) {
            this.latitude = lat;
        } else {
            this.latitude = 0;
            System.out.println("Invalid latitude value range(-90,90) you entered: " + lat + "\nLatitude:0.0");
        }

        if (lon >= -180 && lon <= 180) {
            this.longitude = lon;
        } else {
            this.longitude = 0;
            System.out.println("Invalid longitude value range(-180,180) you entered: " + lon + "\nLongitude:0.0");
        }
    }

    //Overloading method
    public double distance(SimpleLocation other) {
        return getDistance(this.latitude, this.longitude, other.latitude, other.longitude);
    }
    //Overloading method have the same name and diffrent parameters
    public double distance(double lat, double lon) {
        return getDistance(this.latitude, this.longitude, lat, lon);
    }

    // This method uses the haversine formula to calculate the great circle distance between two points
  
    public double getDistance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }

    //Overridng method return readuble object insted of memory refrence
    @Override
    public String toString() {
        return "Location(" + this.latitude + " , " + this.longitude + ")";
    }
}
