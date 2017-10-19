package tp.pr1;

public class Cell {
	private int value;
	
	public Cell(){
		value = 0;
	}
	
	public int getValue(){
		return this.value;
	}
	public void setValue(int value){
		this.value=value;
	}
	public boolean Domerge(Cell cell){
		return cell.value==this.value;
	}
	
}
