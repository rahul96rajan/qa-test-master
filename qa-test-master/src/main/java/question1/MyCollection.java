package question1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
	private int lastElemsNextIndex = 0;
	private int sizeOfArray;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
		sizeOfArray = arraySize;
	}

	public int search(int searchingNum) {
		int foundAt = -1;
		for(int i = 0; i<sizeOfArray; i++) {
			if(numArray[i]==searchingNum) {
				foundAt = i;
				break;
			}
		}
		return foundAt;
	}

	public boolean add(int numberToAdd) {
		boolean isAdd;
		if(lastElemsNextIndex==sizeOfArray-1) {
			doubleCapacity();
		}
		if(search(numberToAdd)!=-1) {
			System.out.println("Number Already Exists. Can't add.");
			isAdd = false;
		}else {
			numArray[lastElemsNextIndex] = numberToAdd;
			lastElemsNextIndex++;
			isAdd=true;
		}
		
		return isAdd;
	}

	public void doubleCapacity() {
		sizeOfArray *= sizeOfArray;
		int [] newArray = new int[sizeOfArray];
		for(int i= 0; i<=lastElemsNextIndex; i++) {
			newArray[i] = numArray[i];
		}
		numArray = newArray;
		newArray =null;
	}

	public boolean remove(int numberToRemove) {
		if(lastElemsNextIndex==0) {
			return false;
		}
		else {
			int indexOfNumToRem=0;
			for(int i = 0; i<lastElemsNextIndex; i++) {
				if(numberToRemove==numArray[i]) {
					indexOfNumToRem = i;
					break;
				}
			}
			int j;
			for(j=indexOfNumToRem; j<lastElemsNextIndex; j++) {
				numArray[j] = numArray[j+1];
			}
			lastElemsNextIndex--;
			numArray[j]=0;	
			return true;
		}
		
	}

	public int getCount() {
		int count = 0;
		for(int i = 0; i<numArray.length; i++) {
			if(numArray[i]!=0)
				count++;
		}
		return count;
	}

	public int[] rotate(int n) {
		int [] tempArray = new int[n];
		for(int i = 0; i<n; i++) {
			tempArray[i] = numArray[i];			
		}
		for(int i = n; i<lastElemsNextIndex; i++) {
			numArray[i-2] = numArray[i];
		}
		for(int i= 0; i<n;i++) {
			numArray[lastElemsNextIndex-n+i] = tempArray[i];
 		}
		return numArray;
	}
	
	
	public String toString()
	{
		String str = "{";
		for (int i = 0; i < lastElemsNextIndex; i++)
		{
			if (i != lastElemsNextIndex-1) str += numArray[i] + ",";
			else str += numArray[i];
		}
			
		str += "}";
		return str;
	}
}


