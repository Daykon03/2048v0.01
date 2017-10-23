package tp.pr1;

public class Cell {
	private int value;
	
	public Cell(){
		value = 0;
	}
	
	public Cell(int n){
		value = n;
	}
	
	public int getValue(){
		return this.value;
	}
	public void setValue(int value){
		this.value=value;
	}
	public boolean doMerge(Cell cell){
		if (cell.value==this.value)
		{	
			this.value *= 2;
			cell.value = 0;
			return true;
		}
		return false;
	}
	public String toString(){
		return Integer.toString(this.value); //?
	}
}
