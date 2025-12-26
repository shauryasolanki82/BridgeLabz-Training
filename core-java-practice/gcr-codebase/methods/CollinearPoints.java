
import java.util.*;

public class CollinearPoints {
	
	public static boolean isCollinear(int x1, int y1, int x2, int y2, int x3, int y3) {
		int val1 = (y2 - y1) * (x3 - x2);
        int val2 = (y3 - y2) * (x2 - x1);
        if(val1 == val2) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean areaOfTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
		if(area == 0.0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x1 = input.nextInt();
		int y1 = input.nextInt();
		int x2 = input.nextInt();
		int y2 = input.nextInt();
		int x3 = input.nextInt();
		int y3 = input.nextInt();
		if(isCollinear(x1, y1, x2, y2, x3, y3)) {
			System.out.println("Points are Collinear using Slope method");
		}else {
			System.out.println("Points are not Collinear using Slope method");
		}
		if(areaOfTriangle(x1, y1, x2, y2, x3, y3)) {
			System.out.println("Points are Collinear using Area of triangle method");
		}else {
			System.out.println("Points are not Collinear using Area of triangle method");
		}
		input.close();
	}
}