package learnings.lists;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorsExamples {
	public static void main(String[] args) {
		List<Integer> vectList;
		vectList = new Vector<Integer>();
		
		vectList.add(1);
		vectList.add(2);
		vectList.add(3);
		
		vectList.add(1, 22);
		System.out.println(vectList);
		
		Collections.sort(vectList);
		
		vectList.remove(3);
		System.out.println(vectList);
		
		System.out.println(vectList.size());

		
		vectList.clear();
	}
}
