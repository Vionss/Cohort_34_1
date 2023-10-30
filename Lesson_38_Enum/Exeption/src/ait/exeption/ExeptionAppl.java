package ait.exeption;

public class ExeptionAppl {
    public static void main(String[] args) {
        int a = 0;
        int b = 12;
        try {
            int x = solution(a, b);
            System.out.println("Solution = " + x);

        }catch (ArithmeticException e){
  //          e.printStackTrace();
            System.out.println("Solution any number");
            return;
        }catch (IllegalArgumentException e){
            System.out.println("No solution");
            return;
        }finally {
            System.out.println("Bye-bye");
        }
        System.out.println("Math is great!");
    }

    public static int solution(int a, int b){
        if(a == 0 && b !=0){
            throw new IllegalArgumentException();
        }
        if(a == 0 && b == 0){
            throw new ArithmeticException();
        }
        int res = b / a;
        return res;
    }
}
