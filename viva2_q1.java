import java.util.Scanner;

public class viva2_q1 {

    //method to calculate digital root
    public static int digital_root(int n){
        //continue summing digits until single digit is obtained
        while(n>=10){
            int sum=0;
            while(n>0){
                sum+=n%10;
                n=n/10;
            }
            n=sum;
        }
        return n;
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //prompt user for input
        System.out.print("Enter number:");
        int number=sc.nextInt();
        //display digital root
        System.out.println("Digital root: "+digital_root(number));
    }
    
}