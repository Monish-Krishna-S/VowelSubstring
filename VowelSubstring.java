package l2;

import java.util.Scanner;

/*
 * @author Monish Krishna Selva
 */
public class VowelSubstring {

    /*
    The problem is to find longest substring between two vowels in a given string of lowercase letters. 
    If there is more than one longest substrings, you have to print them too.
    
    Sample I/Os:
    
    Input 1:
        single
    Output 1:
        ngl
    
    Input 2:
        america
    Output 2:
        m,r,c
    
    Input 3:
        alphabet
    Output 3:
        lph
    */
    public static void start() {
       Scanner s = new Scanner(System.in);
       String input = s.next();
       int len = input.length();
       char A[]=input.toCharArray();
       int count=0,vowNo=0,max=0,j=0;
       String str="";
       char vowel=' ';
       for(int i=0;i<len;i++){
           if(A[i]=='a'||A[i]=='e'||A[i]=='i'||A[i]=='o'||A[i]=='u'){
               vowNo++;
               if(vowNo==1){ 
                   j=i; 
                   vowel=A[i];
                }
               else{
                   count=i-j;
                   if(count>1&&count>=max){
                       if(count>max){
                           str="";
                           max=count;
                           for(int x=j+1;x<i;x++) str=str+A[x];
                       }else if(count==max){
                           str=str+",";
                           for(int x=j+1;x<i;x++) str=str+A[x];
                       }
                   }
                   j=i;
               }
           }
       }
       System.out.print(str);
       if(vowNo==len) System.out.print("Input consists of only vowels. ");
       if(vowNo==0) System.out.print("No vowels present in the given input.");
       if(vowNo==1) System.out.printf("Only vowel '%c' is present in the given input.",vowel);
    }
}
