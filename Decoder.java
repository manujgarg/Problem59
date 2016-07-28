import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;


class Decoder{
	public static void main(String[] pqr){
		String str="asdfg";
		File f=new File("/home/zemoso/Desktop/p059_cipher.txt");
		try {

        	Scanner sc = new Scanner(f);

        	str=sc.nextLine();
        	sc.close();
    	} 
    	catch (FileNotFoundException e) {
      		e.printStackTrace();
    	}
    	String[] numArray=str.split(",");
    	ArrayList<ArrayList<Integer>> possibleKeys=new ArrayList<ArrayList<Integer>>();
    	for(int i=0; i<=2; i++){
    		ArrayList<Integer> temp=new ArrayList<Integer>();
    		for(int j=0; j<=127; j++){
    			int flag=1;
    			for(int k=i; k<numArray.length; k=k+3){
    				int t=Integer.parseInt(numArray[k])^j;
    				if(t>=32 && t!=127 && t!=96 && t!=43 && t!=126){
    					continue;
    				}
    				else{
    					flag=0;
    					break;
    				}
    			}
    			if(flag==1){
    				temp.add(j);
    			}
    		}
    		possibleKeys.add(temp);
    	}
    	String ans="";
    	for(int i=0; i<numArray.length; i++){
    		ans=ans+Character.toString( (char)(Integer.parseInt(numArray[i])^possibleKeys.get(i%3).get(0)) );
    	}
    	System.out.println(ans);
	}
}