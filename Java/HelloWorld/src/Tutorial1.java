import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Tutorial1 {

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
        arrays();
    }

    public static void primitives(){
        int viewCount = 123_456_789;
        long viewC = 1_123_456_789L;
        float price = 10.99F;
        char a = 'a';
        boolean check = false;

    }

    public static void referenceTypes(){
        Date now = new Date();
        System.out.println(now.getTime());

        Point point1 = new Point(1,1);
        Point point2 = point1;
        point1.x=2;
        System.out.println(point2.x); //this has changed to 2
    }


    public static void strings(){
        String message = "Hello World" + "!!";

        System.out.println(message.startsWith("!!")); //false
        System.out.println(message.length());  //13
        System.out.println(message.indexOf("e"));  //1
        System.out.println(message.indexOf("sky"));  //-1
        System.out.println(message.replace("!", "*"));  //Hello World**
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
        System.out.println(message.trim());  //removes whitespace
    }

    public static void arrays(){
        int [] numbers = new int[5];
        numbers[0]=1;
        numbers[1]=9;

        System.out.println(Arrays.toString(numbers));

        int [] other = {1,9,2,3};

        System.out.println(other.length);

        Arrays.sort(other);

        int [][] twoD = new int [2][3];  //2 rows - 3 columns

        twoD[0][0] = 1;

        System.out.println(Arrays.deepToString(twoD));

    }
    public static void constants(){
        final float PI = 3.1415F;
    }

    public static void mathOps(){
        int x = Math.round(1.1F);
        int a = (int)Math.ceil(1.1F);  //+floor
        //int b = max(1,2) ; //max, min,
        //int b = max(1,2) ; //max, min,
        double rand = Math.random() * 100;
    }

    public static void numberFormat(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format((123456.988));
        System.out.println(result);
    }

    public static void inputs(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your name: ");
        String name = scanner.next();  //until space
        System.out.println("You are: "+name);

        String fullLine = scanner.nextLine();  //full line

        String name2 = scanner.nextLine().trim();

    }

}
