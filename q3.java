import java.util.Scanner;
public class q3 {

    public static boolean isLuckyTicket (String ticketNumber){
            
      
            
         int firstHalfDigit = 0;
          int secondHalfDigit = 0;
        for (int j = 0; j < ticketNumber.length() / 2; j++) {
           
            firstHalfDigit += Character.getNumericValue(ticketNumber.charAt(j));
            

           
            secondHalfDigit += Character.getNumericValue(ticketNumber.charAt(ticketNumber.length() - 1 - j));}
    
        return firstHalfDigit == secondHalfDigit;
}
        
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter ticket number:");

        String ticketNumber = input.nextLine();

          for (int i = 0; i < ticketNumber.length() ; i++) {
            char c = ticketNumber.charAt(i);

            if(!Character.isDigit(c)){
                System.out.println("Invalid ticket number.");
                input.close();
                return;     
            }}

            if (ticketNumber.length() % 2 != 0) {
                System.out.println("Invalid ticket number.");
                return;
            }

            if (isLuckyTicket(ticketNumber)) {
                System.out.println("Lucky");;
            } else {
                System.out.println("Unlucky");
            }


        input.close();
       

    }
    
}
