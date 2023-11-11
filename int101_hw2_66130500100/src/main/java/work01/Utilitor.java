package work01;

public class Utilitor {
    public static String testString(String value) {
        if (value == null) throw new NullPointerException();
        if (value.trim().isBlank()) throw new IllegalArgumentException();
        return value;
    }
    
    public static double testPositive(double value) {
        if(value <= 0) throw new IllegalArgumentException();
        return value;
    }
    
    public static long computeIsbn10(long isbn10) {
        int length = 0;
        int sum = 0;
        int check = 0;
        long cal = isbn10;
        long current = isbn10;
        
        while(cal >= 1)
        {
            cal /= 10;
            length++;
        }
        
        if(length != 9) throw new IllegalArgumentException();
        
        for(int i = 2; length != 0; i++)
        {
            sum += (current % 10) * i;
            current /= 10;
            length--;
        }
        
        check = sum % 11;
        
        if(check == 0) {
            return check;
        }
        
        return 11 - check;
    }
}
