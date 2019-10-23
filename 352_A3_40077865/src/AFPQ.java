/**
 
 * @author XavierMorin
 *
 */
public class AFPQ {

	
	public class Entry {
		private Integer key;
		private Integer value;

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		/**
		 * Parametrized constructor
		 * 
		 * @param key
		 * @param value
		 */
		public Entry(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}

		public void setKey(Integer key) {
			this.key = key;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public Integer getKey() {
			return key;
		}

		public Integer getValue() {
			return value;
		}

		public String toString() {
			return "key:" + key + ", value: " + value;
		}

		public Entry clone() {
			return new Entry(this.key, this.value);
		}

		private AFPQ getOuterType() {
			return AFPQ.this;
		}

	}

	public static Integer ArraySize = 10; // Initial array size. Will be dynamically resized if necessary.
	private boolean currentState = true; // true represents a min-heap, false represents a max-heap
	private Integer size = 0; // number of elements in the array
	private Entry[] priorityQueue = new Entry[ArraySize]; // Array of elements. Either a min or max heap.

	/**
	 * Default Constructor
	 */
	public AFPQ() {}

	
	public Entry removeTop() {
		return remove(null);}
	
	public Entry remove(Entry e) {
		if (isEmpty())
			return null;
		int i;
		if(e==null)
			i=0;
		else
		for(i=0;i<priorityQueue.length;i++) 
			if(e.equals(priorityQueue[i])) 
				break;
	
		
		priorityQueue[i] = priorityQueue[size - 1];
		priorityQueue[size - 1] = null;
		size--;
		downHeap(i);
		upHeap(i);
	
		return e;
	}

	/**
	 * Inserts a new Entry at the last position of the heap, and does upHeap
	 * operations until it is in a valid position. If the array is full, the
	 * arraysize is doubled before insertion.
	 * 
	 * @param key
	 * @param value
	 */
	public Integer  insert(Integer key, Integer value) {
		if (containsKey(key)||containsValue(value))
			return null;
		Entry Entry = new Entry(key, value);
		
		if (size == ArraySize) 
			doubleArraySize();
		
		priorityQueue[size] = Entry;
		upHeap(size);
		size++;
		return priorityQueue[size-1].getValue();

	}

	/**
	 * If it is a leaf Entry (i.e. no children), returns. Else, determines the index
	 * of the two possible child and if swapping the parent and the child is a valid
	 * heapify operation, it does so. Recursively calls itself down the heap.
	 * 
	 * @param EntryIndex
	 */
	public void downHeap(int EntryIndex) {
		int leftChildIndex = 2 * EntryIndex + 1;
		int rightChildIndex = 2 * EntryIndex + 2;

		if (leftChildIndex > size || rightChildIndex > size) // leaf Entry.
			return;
		
		Integer correctChildIndex = correctChild(leftChildIndex, rightChildIndex);
		if (correctChildIndex == null)  // Entry is in good place
			return;
		 
		if (compare(priorityQueue[correctChildIndex], priorityQueue[EntryIndex])) {
				swap(EntryIndex, correctChildIndex);
				downHeap(correctChildIndex);
			} 

	}

	/**
	 * If Entry is the root (index 0), return. Else, determine index of parent and,
	 * if it is a valid heap move, swap it with the parent. Recursively go up the
	 * heap.
	 * 
	 * @param EntryIndex
	 */
	public void upHeap(Integer EntryIndex) {
		if (EntryIndex == 0) 
			return;
		
		Integer parentIndex = (EntryIndex - 1) / 2;
		if (compare(priorityQueue[EntryIndex], priorityQueue[parentIndex])) {
			swap(EntryIndex, parentIndex);
			upHeap(parentIndex);
		} 
	}

	/**
	 * Switch to opposite state of what the heap is currently.
	 */
	public void toggle() {
		if (currentState) 
			currentState = false;
		else 
			currentState = true;
			
		for (int i = 0; i < size; i++)
			upHeap(i);
	}
	
	
	/**
	 * Returns in which child subtree downHeap operations should go down, based on
	 * the current state of the heap. If there is no such child (i.e. the Entry is in
	 * a valid position), returns null.
	 * 
	 * @param leftIndex
	 * @param rightIndex
	 * @return
	 */
	public Integer correctChild(int leftIndex, int rightIndex) {
	
		if(leftIndex>priorityQueue.length-1||rightIndex>priorityQueue.length-1)
			return null;
		Entry left = priorityQueue[leftIndex];
		Entry right = priorityQueue[rightIndex];

		if (left == null && right != null) // only a right child
			return rightIndex;
		if (left != null && right == null) // only a left child
			return leftIndex;
		if (left == null && right == null) // no child
			return null;

		return compare(left , right) ? leftIndex : rightIndex;
	}

	

	/**
	 * Swaps two element in the priority queue using their index.
	 * 
	 * @param index1
	 * @param index2
	 */
	public void swap(int index1, int index2) {
		Entry temp = priorityQueue[index1];
		priorityQueue[index1] = priorityQueue[index2];
		priorityQueue[index2] = temp;
	}

	/**
	 * Compares two Values of two Entry according the correct logic depending on the
	 * state. Does comparison in the form x.Value < y.Value if min-heap, otherwise x.Value
	 * > y.Value if max-heap
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean compare(Entry x, Entry y) {
		if (currentState) 
			return x.getValue() < y.getValue();
		 else 
			return x.getValue() > y.getValue();
		

	}

	/**
	 * Updates current ArraySize to double its current value. Creates a new array
	 * using this size and copy previous values of the priority queue. No privacy
	 * leak.
	 */
	public void doubleArraySize() {
		ArraySize = ArraySize * 2;
		Entry[] newArray = new Entry[ArraySize];
		for (int i = 0; i < size; i++) 
			newArray[i] = priorityQueue[i].clone();
		priorityQueue = newArray;
	}

	/**
	 * 
	 * @return root of the heap
	 */
	public Entry top() {
		return priorityQueue[0];
	}

	/**
	 * 
	 * @return String representing the current state of the heap
	 */
	public String state() {
		if (currentState == true)
			return "Min";
		else
			return "Max";
	}

	
	

	/**
	 * 
	 * @return true if priority queue is empty
	 */
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	public boolean containsKey(Integer key) {
		for (int i = 0; i < size; i++) 
			if (priorityQueue[i].getKey() == key)
				return true;
		return false;}
	
	
	public boolean containsValue(Integer Value) {
		for (int i = 0; i < size; i++) 
			if (priorityQueue[i].getValue() == Value)
				return true;
		return false;}
	
	
 public Integer replaceKey(Entry e,Integer key) {
	 for (int i = 0; i < size; i++) 
			if (priorityQueue[i].equals(e)) {
				Integer r=priorityQueue[i].getKey();
				priorityQueue[i].setKey(key);
				return r;}	
	 return null;}
 
 
 
 public Integer replaceValue(Entry e,Integer Value) {
	 for (int i = 0; i < size; i++) 
			if (priorityQueue[i].equals(e)) {
				Integer r= (Integer)(e).getValue();
				remove(e);
				insert(e.getKey(),Value);
				return r;}	
	 return null;}
 
 
	/**
	 * 
	 * @return current number of entries in the priority queue
	 */
	public Integer size() {
		return size;}

	/**
	 * prints an array representation of the heap
	 */
	public void printPQ() {
		for (int i = 0; i < size; i++) 
			System.out.print(priorityQueue[i].getValue() + " | ");
		System.out.println();}
	
	
}

