package assignment7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Assignment7 {
	/*
	 * Q1, Write a program that read sentences from a file and reverse sentences word by word. 
	 * Designed by Kai Tian;
	 */
	public static void reverse(File inputFile, File outputFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));		
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		while (true) {
			String input = reader.readLine();
			if (input == null)
				break;
			String output = reverseSentences(input);			
			
			writer.write(output);
			writer.newLine();
			
		}
		writer.close();
		reader.close();		
	}
	
	public static String reverseSentences(String s) {
		StringBuffer sb = new StringBuffer();
		String[] words = s.split(" ");
		for ( int i = words.length-1; i >= 0; i--) {
			String str = words[i];
			if ( str.length() > 1) {
				if ( str.charAt(str.length()-1) == '.' ||
						 str.charAt(str.length()-1) == ',') {
						str = str.substring(0,str.length()-1);
					}
			}
			sb.append(str);
			sb.append(" ");
		}
		return sb.toString().trim() + '.';
	}
	
	/*
	 * Q2, Write a program that decode a file. Given an encoded file, create its decoded file. 
	 * Designed by Kai Tian;
	 */
	public static void decodeFile(File inputFile, File outputFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));		
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		while (true) {
			String input = reader.readLine();
			if (input == null)
				break;
			String output = decodeFileUtil(input);			
			
			writer.write(output);
			writer.newLine();
			
		}
		writer.close();
		reader.close();		
	}
	
	public static String decodeFileUtil(String s) {
		if ( s == null || s.length() < 1)
            return s;
        
        String result = "";
        int num = 0;
        for ( int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if ( Character.isDigit(c)) {
                num = num * 10;
                num += Character.getNumericValue(c);
            }     
            else if ( c == '['){
                int end = findEnd(s, i+1);
                String res = decodeFileUtil(s.substring(i+1, end));
                for ( int j = 0; j < num; j++){
                	result += res;
                }
                num = 0;
                i = end;
                continue;
            }
            else 
            	result += c;
        }
        return result;
        
    }
    
    public static int findEnd(String s, int start){
        int count = 1;
        int i = start;
        while ( i < s.length() ){        
            if ( s.charAt(i) == '[')                        
                count ++;        
            if ( s.charAt(i) == ']'){
                 count --;
                 if ( count == 0)
                       return i;
            }       
            i++;               
        }     
        return -1;
	}
	
	/*
	 * Q3, Write a program that will count the number of lines in each file that is specified on the command line. 
	 * Designed by Kai Tian;
	 */
	
	public static void listFilesForFolder(File folder) throws IOException {
		String filepath = "/Users/tiankai/eclipse/eclipse-workspace/INFO5100/LineCount/";
	    for (int i = 1; i <=3; i++) {
	    	File file = new File(filepath + "file" + String.valueOf(i)+".txt");	            
            File outputFile = new File(filepath +"LineCounts.txt");
            writeNumbersOfLineIntoFile(file, outputFile);
	    }
	}
	
	public static void writeNumbersOfLineIntoFile(File inputFile, File outputFile) {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		int count = 0;
		try {
			writer = new BufferedWriter(new FileWriter(outputFile,true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			while (true) {
				String input = reader.readLine();
				if (input == null)
					break;			
				count ++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			try {
				writer.append(e.getMessage()+'\n');
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}		

		try {
			String output = inputFile.getName() + " Numbers of line "+ count;			
			writer.append(output+'\n');
			writer.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
	}
	
	/*
	 * Q4, Write a program that calculate the sum value in an array of ints using 4 threads.
	 * Designed by Kai Tian;
	 */
	
	public static class SumValue {
		static long sum1 = 0;
		static long sum2 = 0;
		static long sum3 = 0;
		static long sum4 = 0;
	    /*generate array of random numbers*/
	    static void generateRandomArray(int[] arr){
	    	Random r = new Random();
	    	r.setSeed(1000000);
	    	for( int i = 0; i < arr.length; i++) {
	    		arr[i] =  r.nextInt();
	    	}
	    }

	    /*get sum of an array using 4 threads*/
	    static long sum(int[] arr){
	    	
	    	Thread thread1 = new Thread(){
	    	    public void run(){
	    	      sum1 = countSum(arr,0, 1000000);
	    	    }
	    	};
	    	Thread thread2 = new Thread(){
	    	    public void run(){
	    	      sum2 = countSum(arr,1000000, 2000000);
	    	    }
	    	};
	    	Thread thread3 = new Thread(){
	    	    public void run(){
	    	      sum3 = countSum(arr,2000000, 3000000);
	    	    }
	    	};
	    	Thread thread4 = new Thread(){
	    	    public void run(){
	    	      sum4 = countSum(arr,3000000, 4000000);
	    	    }
	    	};
	    	thread1.start();
	    	thread2.start();
	    	thread3.start();
	    	thread4.start();

	        return sum1+sum2+sum3+sum4;
	    }
	    
	    static long countSum(int[] arr, int start, int end){
	    	long sum = 0;
	    	for ( int i = start; i < end; i++) {
	    		sum += arr[i];
	    	}
	    	return sum;
	    }

	    public void main(String[] args){
	        int[] arr = new int[4000000];
	        generateRandomArray(arr);
	        long sum = sum(arr);
	        System.out.println("Sum: " + sum);
	    }


	}
	
	public static void main(String[] args) throws IOException {
		SumValue s = new SumValue();
		s.main(args);
	}
}
