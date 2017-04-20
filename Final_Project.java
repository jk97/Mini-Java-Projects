import java.util.*;
//import java.math.*;

public class Final_Project{
	public static double pi = 0;
	
	public static void main(String[] args){
		pi = calculatePI();
		boolean continues = true;
		Scanner console = new Scanner(System.in);
		while(continues){
			printmenu();
			int x = console.nextInt();
			if ( x == 1 ) {
				calculatecos(prompt());
			} else if ( x == 2 ){
				calculatearctan(prompt());
			} else if ( x == 3 ){
				calculateex(prompt());
			} else if ( x == 4 ){
				continues = false;
			} else {
				System.out.println("invalid input\nplease try again");
			}
		}
	}
	public static void printmenu(){
		System.out.println("Enter a number from 1 to 4:\n(1) Calculate cos(x)\n(2) Calculate arctan(x)\n(3) Calculate e^x\n(4)Exit Program");
	}
	
////////////////////TYPES I , II , III ALGORITHMS /////////////////////////////////////////////////////////////
	
	public static void calculatecos(double x){

		double toRadians  = toRadian(x);			
		double results = 0;
		for ( int i = 0; i < 200; i ++){
			results += (( power(toRadians, i * 2) / factorial(i * 2)) * power( -1.0, i));
		}
		if ( x % 90 == 0 &&  (x/90.0) %2== 1){
			results = 0;
		}
		print12SigFig(results);
		
	}
	public static void calculatearctan(double x){
		boolean bool = true;
		if(x<0){
			x = -x;
			bool = false;
		}
		double oneX = 1.0/x; 
		double sum = 0;
		double pi2minusx = 0;
		if(x>1 || x<-1){
			for(int i = 0; i<10000; i++){
				sum += ((power(-1.0, i) * power(oneX, (2*i)+1))/((2*i)+1));
				pi2minusx = (pi/2.0) - sum;
			}
		} else if(x<1 && x>-1){
			for(int i = 0; i<10000; i++){
				sum += ((power(-1.0, i) * power(x, (2*i)+1))/((2*i)+1));
				pi2minusx=sum;
			}
			
		} else{
			if(x==1){
				pi2minusx = pi/4.0;
			}
			else{
				pi2minusx = -pi/4.0;
			}
		}
		pi2minusx = toDegree(pi2minusx);
		print12SigFig(pi2minusx);
		
	}

	public static void calculateex(double x ){ 	// e^x
		double results = 0;
		for ( int i = 0; i < 100; i++){
			results += power(x,i)/ factorial(i);
		}
		print12SigFig(results);
	}

///////////////////////////////HELPER METHODS/////////////////////////////////////////////////////////////////////////////////////////	
	
	public static double prompt(){
		System.out.print("x = ");
		Scanner input = new Scanner (System.in);
		return input.nextDouble();
	}
	
	public static double factorial(int x){
		double result = 1;
		for ( int i = x; i > 0; i--){
			result *= i;
		}
		return result;
	}
	
	public static double power(double x, int y){
		double result = 1;
		for ( int i = y; i > 0; i--){
			result *= x;
		}
		if( y == 0 ){
			return 1.0;
		}
		return result;
	}

	public static double toRadian(double x){
		x = x % (360);
		double toRadians = x * 2 * pi / 360;
		return toRadians;
			
	}
	public static double toDegree(double x){
		x = x % (2*pi);
		double toDegrees = x * 360 / 2 / pi;
		return toDegrees;
	}
	public static double calculatePI(){		// uses BBP formula
		double results = 0;
		for ( int i = 0; i < 100; i++){
			results +=  (  ( 1 / power(16, i)) * (4 / (8.0 * i + 1) - 2 / (8.0 * i + 4) - 1 / (8.0 * i + 5) - 1 / (8.0 * i + 6)) );
		}
		return results;
	}
	public static void print12SigFig(double x){
		/*BigDecimal y = new BigDecimal(x);
		System.out.println( String.format("%.12G", y));
		*/
		int tens = 0;
		if ( x >= 10){
			while ( x >= 10 ){
				x  = x / 10.0;
				tens++;
			}	
		} else if ( x < 1){
			while ( x < 1 ){
				x *= 10;
				tens--;
			}
		}
		System.out.printf("%13.11f", x);
		if ( tens != 0 && tens < 10){
			System.out.println("E0" + tens);
		} else if (tens != 0 && tens >= 10){
			System.out.println("E" + tens);
		}else {
			System.out.println();
		}
	}
}