/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesproject;

/**
 *
 * @author tyoun66
package FilesProject;
*/
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException; 
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
/*
Tyler Young
890090583
Lab Section 111
Lab # 1
Submission Time 7:11
*/
 
 
public class FilesProject {
    public static void main(String [] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your file name:");
       String fileName = input.next();
       
        System.out.println("Enter your file size:");
        int size = input.nextInt();
       
        populateFile(fileName, size);
         
        System.out.printf("File:%-20s Mean:%7.2f Max:%d\n",fileName,getMean(fileName), getMax(fileName));
        
       
    }
    public static void populateFile(String fileName, int size)throws FileNotFoundException 
    {
        PrintWriter outFile = new PrintWriter(fileName+".txt");
        Random rand = new Random();
        
        
        for(int i = 0; i<size; i++) 
        {
            outFile.println(rand.nextInt((2000 - 1000) + 1) + 1000);
        }
        outFile.close();
        File inFile = new File(fileName);
        
        
    }
    public static double getMean(String fileName)throws FileNotFoundException 
    {
        File inputFile = new File(fileName+".txt");
        Scanner scan = new Scanner(inputFile);
       float sum = 0; 
       int count = 0; 
       
       while(scan.hasNextInt())
       {
       sum += scan.nextInt();
       count++; 
       }
               
      scan.close();
      
      return sum / count; 
            
                    
        }
    public static int getMax(String fileName)throws FileNotFoundException 
    {
        File inputFile = new File(fileName+".txt");
        Scanner scan = new Scanner(inputFile);
        int max=scan.nextInt();
        int num;
        while(scan.hasNextInt()) 
        {
            num = scan.nextInt();
            if(num>max) 
            {
                max = num;
            }
        }
        return max;
    }
    
    /*
    public static double getMean(out)
        
    }
*/
    

    
}

