/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbertest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dlehner1703
 */
public class NumberTester {

    int n = 0;
    List<String> list = new ArrayList<>();
    NumberTest oet;
    NumberTest prt;
    NumberTest pat;
    NumberTest pnt;

    public NumberTester(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; ++i) {
                list.add(br.readLine());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setOddEvenTester(NumberTest oddTester) {
        oet = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        prt = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        pat = palindromeTester;
    }
    
    public void setPerfectNumberTester(NumberTest perfectNumberTester){
        pnt=perfectNumberTester;
    }

    public void testFile() {
        setOddEvenTester((a) -> (a % 2) != 0);
        setPrimeTester((a) -> {
            for (int i = a / 2; i > 2; --i) {
                if ((a % i) == 0)return false;              
            }
            return true;
        });
        
        setPalindromeTester((a) ->{
            String s=a+"";
            String s1="";
            for(int i=s.length()-1;i>=0;--i){
                s1+=s.charAt(i);
            }
            if(s.equals(s1))return true;           
            return false;
        });
        
    
        for (String s : list) {
            int i = Integer.parseInt(s.split(" ")[0]);
            switch(i)
            {
                case 1:
                    if(oet.testNumber(Integer.parseInt(s.split(" ")[1])))System.out.println("ODD");                       
                    else System.out.println("EVEN");                   
                    break;
                case 2:
                    if(prt.testNumber(Integer.parseInt(s.split(" ")[1])))System.out.println("PRIME");                       
                    else System.out.println("NO PRIME");  
                    break;
                case 3:
                    if(pat.testNumber(Integer.parseInt(s.split(" ")[1])))System.out.println("PALINDROME");                       
                    else System.out.println("NO PALINDROME");  
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error");
                    break;
            }

        }
    }
}
