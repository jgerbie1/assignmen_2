
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.*;
public class central_tendency {

	public static void main(String[] args) {
		//Scanner scanner = new File(numbers.txt);
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> h  = new ArrayList<Integer>();
		int  random = (int) (Math. random() * 20) + 5; 
	//	System.out.print(random);
		for(int i =0; i < random; i++) {
			System.out.println(i + ". input a number " );
			int x = input.nextInt();
			h.add(x);
		}
		
		System.out.println("This is the mean " + findMean(h));
		System.out.println("This is the mode " + findMode(h));
		System.out.println("This is the median " +findMedian(h));
		System.out.println("This is the range " + findRange(h));
		System.out.println("This is the qOne " + qOne(h));
		System.out.println("This is the q3 " + qThree(h));
		System.out.println("This is the max " + findMax(h));
		System.out.println("This is the min " + findMin(h));
		
	}
	public static double findMean(ArrayList<Integer> h) {
		double total = 0;
		for(int i =0; i < h.size(); i++) {
			total = total + h.get(i);
		}
		total = total/h.size();
		return total;
		
	}
	//------------------------------------------------------------------
	public static int findMode(ArrayList<Integer> h) {		
		ArrayList<Integer> temp = new ArrayList<>();
		ArrayList<Integer> mode = new ArrayList<>();
		int num = (int) Double.NEGATIVE_INFINITY;
		for(int i = 0; i < h.size(); i++) {
			temp.add(h.get(i));
		}
		for(int i =0; i < h.size(); i++) {
			int count = 0;
			for(int j =0; j < temp.size(); j++) {
				if(h.get(i) == temp.get(j)) {
					count++;
				}			
			}
			if (count > num) {
				mode.clear();
				num = count;
				mode.add(h.get(i));
			}
		}	
		return mode.get(0);
	}
	//------------------------------------------------------------------
	public static double findMedian(ArrayList<Integer> h) {
		double med = 0;
		int pos = h.size();
		Collections.sort(h);
//		for (int i = 0; i <h.size(); i++) {
//			System.out.println(h.get(i));
//		}
		if(pos % 2 == 0){
			pos = pos/2;
			med = (h.get(pos) + h.get(pos + 1))/2;
		}
		else if (pos%2 != 0){
		pos = pos/2;
			med = h.get(pos + 1);
		}
		else {
			pos = 0;
		}

		return med;
	}
	
	//------------------------------------------------------------------
	public static double findRange(ArrayList<Integer> h) {
		double range = findMax(h) - findMin(h);	
		return range;
		
	}
	//------------------------------------------------------------------
	public static double qOne(ArrayList<Integer> h) {
		Collections.sort(h);
		for (int i = 0; i <h.size(); i++) {
			System.out.println(h.get(i));
		}
		
		int pos = h.size();
		double med = 0;
		if( pos % 2 == 0){
			pos = pos / 2;
			if(pos % 2 == 0){	
				pos = pos / 2;
				med = (h.get(pos) + h.get(pos + 1))/2;
				return med;
			}
			else {
				pos = pos / 2;
				pos = pos + 1;
				med = h.get(pos);
				return med;
			}
		}
		else {
			pos = pos / 2;
			pos = pos + 1;
			if(pos % 2 == 0){	
				pos = pos / 2;
				med = (h.get(pos) + h.get(pos + 1))/2;
				return med;
			}
			else {
				pos = pos / 2;
				pos = pos + 1;
				med = h.get(pos);
				return med;
			}
		}

		

	}
	//------------------------------------------------------------------
	public static int qThree(ArrayList<Integer> h) {
		ArrayList<Integer> temp = new ArrayList<>();

		Collections.sort(h);
		int pos = h.size()/2;
				
		for(int i = pos; i < h.size(); i++) {
			temp.add(h.get(i));
		}
		pos = 0;
		if((temp.size() % 2) == 0){
			pos = (temp.size() / 2);
			return (temp.get(pos) + temp.get(pos + 1))/2;
		}
		if((temp.size() % 2) != 0){
			pos = (temp.size() / 2);
			return temp.get(pos + 1);
		}
		
		return 0;
		
	}
	//------------------------------------------------------------------
	public static double findMin(ArrayList<Integer> h) {
		double min = Double.POSITIVE_INFINITY;
		for(int i =0; i < h.size(); i++) {
			if(min > h.get(i)) {
				min = h.get(i);
			}
			else {
				min = min;
			}
		}
		return min;
		
	}
	//------------------------------------------------------------------
	public static double findMax(ArrayList<Integer> h) {
		double max = Double.NEGATIVE_INFINITY;
		for(int i =0; i < h.size(); i++) {
			if(max < h.get(i)) {
				max = h.get(i);
			}
			else {max = max;}
		}
		return max;
		
	}
}
