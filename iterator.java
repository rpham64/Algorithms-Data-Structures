import java.util.ArrayList;
import java.util.ListIterator;

public class iterator {

	public static void main(String[] args){
		
	    ArrayList<String> path = new ArrayList<>();
	    
	    path.add("1");
	    path.add("2");
	    path.add("5");
	    path.add("7");

	    System.out.println(path);
	    ListIterator<String> itr =  path.listIterator();
	    itr.next();
	    
	    while(itr.hasNext()) {
	    	
	    	System.out.print(itr.previous() + "," + itr);
	    	itr.next();
	    	
	    }

	}
	
}
