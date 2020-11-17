public class ParameterMystery {
    public static void main(String[] args) {
        String air = "fire";
        String fire = "water";
        String water = "earth";
        String earth = "air";
        
        recipe(water, air, fire);
        recipe(air, fire, water);
        recipe(fire, "earth", earth);
        recipe(air, water, "fire");
    }
    
    public static void recipe(String water, String air, String fire) {
        System.out.println("make " + air + " from " + fire + " and " + water);
    }
}