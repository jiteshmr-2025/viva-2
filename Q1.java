/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viva2;

import java.util.Scanner;

public class Q1 {

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