package myPackage;

public class HolidayBonus extends java.lang.Object{
	public HolidayBonus() { };
	
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
	{
		double [] totalBonuses = new double [data.length];
		
		double bestsales;
		int hibon;
		int lowbon;
		double sale;
		double highest, lowest;
		int i, j, k;
		
		for (k = 0; k < data.length; k++) { // for each store
			totalBonuses[k]=0.0;
			for(j = 0; j < data[k].length; j++) {//for each category
				sale = data[k][j];
			    highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, j);
			    lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, j);
			    if (sale == highest) { totalBonuses[k] += high;}
			    else if (sale == lowest) {totalBonuses[k] += low; }
			    else {totalBonuses[k] += other;}
			    
			    }
	}
	return totalBonuses;		
			
				}
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
	{
		double [] totalBonuses = new double[data.length];
		double sum = 0.0;
		
		double bestsales;
		int hibon;
		int lowbon;
		double sale;
		double highest, lowest;
		int i, j, k;
		
		for (k = 0; k < data.length; k++) { // for each store
			totalBonuses[k]=0.0;
			for(j = 0; j < data[k].length; j++) {//for each category
				sale = data[k][j];
			    highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, j);
			    lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, j);
			    if (sale == highest) { totalBonuses[k] += high;}
			    else if (sale == lowest) {totalBonuses[k] += low; }
			    else {totalBonuses[k] += other;}
			    
			    }
			sum+= totalBonuses[k];
	}
	return sum;		
			
				      
	}

}
