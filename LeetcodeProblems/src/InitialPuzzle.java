import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InitialPuzzle {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> input= new ArrayList<ArrayList<Integer>>(); 
		int target = takePyramidInput(input);
		System.out.println(findTargetString(input,target));
	}
	
	private static String findTargetString(ArrayList<ArrayList<Integer>> input, int target) {
		return targetString(input,target,1,0,0);
	}

	private static String targetString(ArrayList<ArrayList<Integer>> pyramid, int target,int currentProduct, int level, int element) {
		if(target==currentProduct && level==pyramid.size()) 
			return "";
		if(level>=pyramid.size() || currentProduct>target)
			return null;
	
		String out = targetString(pyramid,target,currentProduct*pyramid.get(level).get(element),level+1,element);
		if(out!=null)
			return level==pyramid.size()-1?out:"L"+out;
		out = targetString(pyramid,target,currentProduct*pyramid.get(level).get(element),level+1,element+1);
		if(out!=null)
			return level==pyramid.size()-1?out:"R"+out;
		else 
			return null;
	}	
	
	private static String targetStringOutput(ArrayList<ArrayList<Integer>> input, int target) {
		String[] outputs = new String[input.get(input.size()-1).size() *2];
		int[] targetsAchieved = new int[input.get(input.size()-1).size() *2];
		
		for(int i=input.size()-1;i>=0;i--) {
			for(int j=0;j<input.get(i).size();j++) {
				if(i == input.size()-1) {
//					outputs[]
				}
			}
		}
		return outputs[0];
	}
	

	public static int takePyramidInput(ArrayList<ArrayList<Integer>> input){
		Scanner sc = new Scanner(System.in);
		String line;
		int index=-1;
		int target=1;
		while((line=sc.nextLine())!=null) {
			if(index==-1) {
				String[] lineVals = line.split(" ");
				target = Integer.parseInt(lineVals[lineVals.length-1]);
				index++;
				continue;
			}
			if(line.equals(""))
				break;
			input.add(new ArrayList<Integer>());
			String[] lineNumbers= line.split(",");
			for(String num:lineNumbers)
				input.get(index).add(Integer.parseInt(num));
			index++;
		}
		return target;
	}
	
	private static void printPyramid(ArrayList<ArrayList<Integer>> input) {
		for(int i=0;i<input.size();i++) {
			for(int j=0;j<input.get(i).size();j++)
				System.out.print(input.get(i).get(j)+" ");
			System.out.println();
		}
	}
}
