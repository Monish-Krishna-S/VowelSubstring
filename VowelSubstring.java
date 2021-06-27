package l2;

import java.util.Scanner;

/*
 * @author Monish Krishna Selva
 */
public class VowelSubstring {
    public static void start() {
       Scanner s = new Scanner(System.in);
       String input = s.next();
       int len = input.length();
       char A[]=input.toCharArray();
       int count=0,vowNo=0,max=0,j=0;
       String str="";
       char vowel=' ';
       for(int i=0;i<len;i++){
           if(A[i]=='a'||A[i]=='e'||A[i]=='i'||A[i]=='o'||A[i]=='u'){  //checking for vowels
               vowNo++;
               if(vowNo==1){    //noting the first vowel appearance
                   j=i; //setting the first vowel appearance to j
                   vowel=A[i];
                }
               else{
                   count=i-j;   //from number 2 vowels, getting the length b/w two vowels
                   if(count>1&&count>=max){ //if count is 1, it means vowels are next to each other; checking whether count is greater than or equal to previous max.
                       if(count>max){   //if count is max, we gonna reset max 
                           str="";      //since new max is obtained, string is emptied
                           max=count;   //updating max
                           for(int x=j+1;x<i;x++) str=str+A[x]; //appending current maxLength-substring to string
                       }else if(count==max){    //if there is another substring having same length as maxSubstring-length
                           str=str+",";
                           for(int x=j+1;x<i;x++) str=str+A[x]; //appending other maxLength-substring to previous maxLength-substring
                       }
                   }
                   j=i; //setting current vowel position to j
               }
           }
       }
       System.out.print(str);   //just outputing😎
       if(vowNo==len) System.out.print("Input consists of only vowels. ");
       if(vowNo==0) System.out.print("No vowels present in the given input.");
       if(vowNo==1) System.out.printf("Only vowel '%c' is present in the given input.",vowel);
    }
}
