package work03;

public class MyUtil {
    public static double calculateBMI(double weight, double height)
    {
        return(weight / Math.pow(height, 2));
    }
    
    public static double average(int v1, int v2, int v3)
    {
        return(((v1 + v2 + v3) / 3));
    }
}
