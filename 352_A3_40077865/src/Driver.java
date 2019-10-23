

public class Driver {

	public static void main(String[] args) {
		AFPQ pq = new AFPQ();
		pq.insert(21, 21);
		Object p=pq.top();
		//pq.remove(p);
		pq.printPQ();
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(7, 7);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(45, 45);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(64, 64);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(18, 18);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(6, 6);
		
		Object k=pq.top();
		
		
		
		pq.printPQ();
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(9, 9);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(1, 1);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(2, 2);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(4, 4);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(55, 55);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(21, 21);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(45, 45);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(102, 102);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(72, 72);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(52, 52);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(8, 8);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(92, 92);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(132, 132);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(13, 13);
	System.out.println("size: " + pq.size());
		System.out.println("Array size: " + pq.ArraySize);
		pq.insert(60, 60);
	System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(74, 74);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.insert(44, 44);
		//System.out.println("size: " + pq.size());
		//System.out.println("Array size: " + pq.ArraySize);
		pq.printPQ();
		AFPQ.Entry j= pq.new Entry(55,55);
		pq.replaceValue(j, 44);

		//pq.remove(j);
		System.out.println("\n"+pq.state());
		
		pq.printPQ();
		pq.toggle();
		System.out.println(pq.state());
		pq.printPQ();
		pq.removeTop();
		pq.insert(139, 139);
		pq.printPQ();
		pq.toggle();
		System.out.println(pq.state());
		pq.printPQ();
		System.out.println("Top: "+pq.top());
		pq.toggle();
		System.out.println(pq.state());
		pq.printPQ();
		pq.toggle();
		System.out.println(pq.state());
		pq.printPQ();
		pq.removeTop();
		pq.printPQ();
		pq.removeTop();
		pq.printPQ();
		pq.removeTop();
		pq.printPQ();
		pq.insert(80, 80);
		pq.printPQ();
		pq.toggle();
		System.out.println(pq.state());
		pq.printPQ();

	}

}
