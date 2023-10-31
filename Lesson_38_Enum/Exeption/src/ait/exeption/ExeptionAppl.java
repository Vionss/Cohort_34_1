package ait.exeption;

public class ExeptionAppl {
    public static void main(String[] args)  {
        int a = 0;
        int b = 0;
        try {
            int x = solution(a, b);
            System.out.println("Solution = " + x);

        }catch (SolutionAnyNumberException e){
  //          e.printStackTrace();
   //         System.out.println("Solution any number");
            System.out.println(e.getMessage());
        }catch (NoSolutionException e){
            System.out.println(e.getMessage());
 //           return;
        }catch (Exception e){
            System.out.println("Unknown exception");
        }finally {
            System.out.println("Bye-bye");
        }
        System.out.println("Math is great!");
    }

    public static int solution(int a, int b) throws NoSolutionException{
        if(a == 0 && b !=0){
            throw new NoSolutionException("No solution");
        }
        if(a == 0 && b == 0){
            throw new SolutionAnyNumberException("Solution any number");
        }
        int res = b / a;
        return res;
    }
}
