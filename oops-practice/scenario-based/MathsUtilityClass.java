public class MathsUtilityClass {
    public long calculateFactorial(int num){
        if(num<0){
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        long fact=1;
        for(int i=2;i<=num;i++){
            fact*=i;
        }
        return fact;
    }
    public boolean isPrime(int num){
        if(num<=1) return false;
        if(num==2) return true;
        if(num%2==0) return false;
        for(int i=3;i*i<=num;i+=2){
            if(num%i==0) return false;
        }
        return true;
    }
    public int gcd(int num1, int num2){
        num1=Math.abs(num1);
        num2=Math.abs(num2);
        while(num2!=0){
            int remainder=num1%num2;
            num1=num2;
            num2=remainder;
        }
        return num1;
    }
    public int findFibonacciNumber(int n){
        if(n<0) throw new IllegalArgumentException("n must be >=0");
        if(n<=1) return n;
        int[] series=new int[n+1];
        series[1]=1;
        for(int i=2;i<=n;i++){
            series[i]=series[i-1]+series[i-2];
        }
        return series[n];
    }

    public static void main(String[] args) {
        MathsUtilityClass fun=new MathsUtilityClass();
        System.out.println("8 fibonacci number: "+fun.findFibonacciNumber(8));
        System.out.println("GCD of 108 and 16: "+fun.gcd(108,16));
        System.out.println("is 23 prime: "+fun.isPrime(23));
        System.out.println("factorial of 5 is "+fun.calculateFactorial(5));
    }
}
