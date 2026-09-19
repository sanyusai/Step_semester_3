class TrafficLightData {

    private String color;
    private final String id;

    public TrafficLightData(String id) {

        this.id = id;
        this.color = "RED";
    }

    public void next() {

        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }
}

public class TrafficLight {

    public static void main(String[] args) {

        TrafficLightData t = new TrafficLightData("TL-9");

        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());
    }
}

