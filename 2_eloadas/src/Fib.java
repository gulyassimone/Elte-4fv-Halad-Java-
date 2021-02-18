public class Fib {
   public static int fib(int n){
       if(n == 1) return 1;
       if(n == 2) return 1;
       return fib(n-1) + fib(n-2);
   }

   public static int plus(int a , int b){
       return a + b;
   }
}
