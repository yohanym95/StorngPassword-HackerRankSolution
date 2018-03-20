package solution;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers="0123456789";
        String charLower="abcdefghijklmnopqrstuvwxyz"; 
        String charUpper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChar="!@#$%^&*()-+";
        int minnum=0;
        boolean isNumberContains=false;
        boolean isCharUpperContains=false;
        boolean isCharLowerContains=false;
        boolean isSpecialCharContains=false;
        
        char[] pass=password.toCharArray();
        
        for(int i=0;i<pass.length;i++){
            CharSequence cs1 =String.valueOf(pass[i]);
            
            if(numbers.contains(cs1)){ 
                isNumberContains=true;
                continue;
            }else if(charUpper.contains(cs1)){ 
                isCharUpperContains=true;
                continue;
            }else if (charLower.contains(cs1)){
                isCharLowerContains=true;
                continue;                
            }else if(specialChar.contains(cs1)){ 
                isSpecialCharContains=true;
                continue;
            }
        }
      
        minnum+=isNumberContains ? 0 : 1;
        minnum+=isCharUpperContains ? 0 : 1;
        minnum+=isCharLowerContains ? 0 : 1;
        minnum+=isSpecialCharContains ? 0 : 1;
        
        //System.out.println(minnum);
        
        if(n<6){
            if((6-n)>=minnum){
                minnum=6-n;
            } 
        }
        
        return minnum; 
          }
        
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}