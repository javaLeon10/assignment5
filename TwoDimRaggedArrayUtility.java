package myPackage;
import java.io.*;
import java.util.*;

public final class TwoDimRaggedArrayUtility extends java.lang.Object
 {
	public TwoDimRaggedArrayUtility() { }
		
	public static double[][] readFile(File file) throws FileNotFoundException,IOException {
		
		//public static void fileReaderMethod(String fileName) throws FileNotFoundException, IOException {
			// This method reads the file and inputs the measurements 
	        //Scanner input ;
	    
		//String fileName = file.getName();
		String fileName = file.getAbsolutePath();
		System.out.println("Our File is "+fileName);
		
		
		try{                                                                                            // into an array of type int.
	            Scanner input = new Scanner (new File(fileName));
	            }
	            catch (FileNotFoundException e){
	                System.out.println("No such file");
	            }
	                /*
	                System.out.println("Choose another file");
	                Scanner in = new Scanner(System.in);
	               	fileName = in.next();
	                input = new Scanner (new File(fileName));
	            */
	                
		FileReader fr2 = new FileReader(fileName);
        BufferedReader textReader2 = new BufferedReader(fr2);
        int row=0;
       String currentRow2;
        while((currentRow2 = textReader2.readLine())!= null){
            
        	row++;
        }
	    
	        
	        FileReader fr1 = new FileReader(fileName);
            BufferedReader textReader = new BufferedReader(fr1);
            double [][] myArray1 = new double[row][];
            int r2=0;
            int cl =0; 
            String currentRow;
            while((currentRow = textReader.readLine())!= null){
                System.out.println(currentRow);
                String[] line1 = currentRow.trim().split(" ");
                myArray1[r2] = new double[line1.length];
	              
	              for (int j=0; j<line1.length; j++) {
	                 myArray1[r2][j] = Double.parseDouble(line1[j]); 
	              }
                
            	r2++;
            }
            
            /*
            cl = myArray1[0].length;
            double [][] myArray = new double [row][];
            
            
            
	        System.out.println("Total rows"+row);
	        
	        for (int ii=0; ii < row; ii++) {
	        	for (int jj=0; jj < myArray1[ii].length; jj++) {
	     
	        		myArray[ii][jj] = myArray1[ii][jj];
	        		//System.out.println(myArray[ii][jj]+" ");
	        	
	        	//System.out.println("\n");
	        }
	        }
	        
	        */
	        
	     /*
	        
	    Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
	    
	    
	        double [][] myArray = new double[row][];
	        while(sc.hasNextLine()) {
	        	//System.out.println("Yay!");
	        	
	           for (int i=0; i<myArray.length; i++) {
	        	   
	        	   System.out.println(sc.nextLine());
	              String[] line = sc.nextLine().trim().split(" ");
	              
	              
	              //myArray[i] = new double[myArray.length];
	              myArray[i] = new double[line.length];
	              
	              for (int j=0; j<line.length; j++) {
	                 myArray[i][j] = Double.parseDouble(line[j]); 
	              }
	           }
	        }
	        sc.close();
	        //System.out.println(Arrays.deepToString(myArray));
	        //File fff = new File("/home/andrei/eclipse-workspace/Assignment5/src/myPackage/res1.txt");
	        //writeToFile(myArray,fff);
	        return myArray;
	        */
	        return myArray1;
	     }
	  
	        
	public static void writeToFile(double[][] data,File outputFile) throws java.io.FileNotFoundException
	{
		String fileName = outputFile.getAbsolutePath();
		
		if (!outputFile.exists()) {
	        try {
				outputFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < data.length; i++)//for each row
		{
		   for(int j = 0; j < data[i].length; j++)//for each column
		   {
		      builder.append(data[i][j]);//append to the output string
		      if(j < data.length - 1)//if this is not the last row element
		         builder.append(" ");//then add comma (if you don't like commas you can use spaces)
		   }
		   builder.append("\n");//append new line at the end of the row
		}
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	        
			writer.write(builder.toString());//save the string representation of the board
			writer.close();
	    

	} catch (IOException e) {

	}
		
		
	}
	
	public static double getTotal(double[][] data) {
		double tot =0.0;
		for(int i = 0; i < data.length; i++)//for each row
		{
		   for(int j = 0; j < data[i].length; j++)//for each column
		   {
			   tot+= data[i][j];
		   }
		}
		return tot;
	}
	
	public static double getAverage(double[][] data) {
		double tot =0.0;
		int numEl = 0;
		for(int i = 0; i < data.length; i++)//for each row
		{
		   for(int j = 0; j < data[i].length; j++)//for each column
		   {
			   tot+= data[i][j];
			   if (data[i][j] > 0.0) numEl++;
		   }
		}
		return tot/numEl;
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double tot =0.0;
		int numEl = 0;
		for(int i = 0; i < data[row].length; i++)//for each row
		{
		   
			   if (data[row][i] >= 0.0) tot+= data[row][i];
			   
		   
		}
		return tot;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double tot =0.0;
		int numEl = 0;
		for(int i = 0; i < data.length; i++)//for each row
		{
		   
			   //if (data[i][col] >= 0.0) tot+= data[i][col];
			   if (data[i].length > col) tot += data[i][col];
		   
		}
		return tot;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double hi =0.0;
		
		for(int i = 0; i < data[row].length; i++)
		{
		   
			   if (data[row][i] > hi) hi= data[row][i];
			   
		   
		}
		return hi;
	}     
	
	public static double getHighestInRowIndex(double[][] data, int row) {
		double hi =0.0;
		int hi_ind =0;
		
		for(int i = 0; i < data[row].length; i++)
		{
		   
			   if (data[row][i] > hi) {
				   hi = data[row][i];
				   hi_ind= i;
			   }
			   
		   
		}
		return hi_ind;
	}      
	
	
	public static double getLowestInRow(double[][] data, int row) {
		double lo = data[row][0];
		
		for(int i = 0; i < data[row].length; i++)
		{
		   
			   if (data[row][i] < lo) lo= data[row][i];
			   
		   
		}
		return lo;
	}     
	
	public static double getLowestInRowIndex(double[][] data, int row) {
		double lo = data[row][0];
		int lo_ind =0;
		
		for(int i = 0; i < data[row].length; i++)
		{
		   
			   if (data[row][i] < lo) {
				   lo = data[row][i];
				   lo_ind= i;
			   }
			   
		   
		}
		return lo_ind;
	}      
	
	public static double getHighestInColumn(double[][] data, int col) {
		double hi =0.0;
		
		for(int i = 0; i < data.length; i++)
		{
			if (data[i].length > col) {
			   if (data[i][col] > hi) hi= data[i][col];
			}
		   
		}
		return hi;
	}     
	
	public static double getHighestInColumnIndex(double[][] data, int col) {
		double hi =0.0;
		int hi_ind =0;
		
		for(int i = 0; i < data.length; i++)
		{
			if (data[i].length > col) {
			   if (data[i][col] > hi) {
				   hi = data[i][col];
				   hi_ind= i;
			   }
			}
		   
		}
		return hi_ind;
	}      
	
	
	public static double getLowestInColumn(double[][] data, int col) {
		double lo = data[0][col];
		
		for(int i = 0; i < data.length; i++)
		{
			if (data[i].length > col) {
			   if (data[i][col] < lo) lo= data[i][col];
			}
		   
		}
		return lo;
	}     
	
	public static double getLowestInColumnIndex(double[][] data, int col) {
		double lo = data[0][col];
		int lo_ind =0;
		
		for(int i = 0; i < data.length; i++)
		{
			if (data[i].length > col) {
			   if (data[i][col] < lo) {
				   lo = data[i][col];
				   lo_ind= i;
			   }
			}
		   
		}
		return lo_ind;
	}      
	
	
	public static double getHighestInArray(double[][] data) {
		double hi =0.0;
		
		for(int i = 0; i < data.length; i++)//for each row
		{
		   for(int j = 0; j < data[i].length; j++)//for each column
		   {
			   
			   if (data[i][j] > hi) hi = data[i][j];
		   }
		}
		return hi;
	}
	
	public static double getLowestInArray(double[][] data) {
		double lo = data[0][0];
		
		for(int i = 0; i < data.length; i++)//for each row
		{
		   for(int j = 0; j < data[i].length; j++)//for each column
		   {
			   
			   if (data[i][j] < lo) lo = data[i][j];
		   }
		}
		return lo;
	}
	
	
/*
	
		public static void main (String [] args)throws FileNotFoundException, IOException {
		    //fileReaderMethod("Calories.txt");
			File fi = new File ("/home/andrei/eclipse-workspace/Assignment5/src/myPackage/dataSet2.txt");
			//readFile("/home/andrei/eclipse-workspace/Assignment5/src/myPackage/Calories.txt");
		double[][] dt = readFile(fi);
		double ave = getAverage(dt);
		double tot1 = getTotal(dt);
		System.out.println("Average is "+ave+" and total is "+tot1);
		double[] result = HolidayBonus.calculateHolidayBonus(dt, 5000, 1000, 2000);
		double sumresult = HolidayBonus.calculateTotalHolidayBonus(dt, 5000, 1000, 2000);
		System.out.println("Overall bonus is "+sumresult);
		}
	*/	
}
 
	
	
	
	
	
