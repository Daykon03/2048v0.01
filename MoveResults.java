package tp.pr1;

public class MoveResults {

	private boolean moved;
	private int score;
	private int max;
	
	public int getScore(){
		return score;
	}
	public int getMax(){
		return max;
	}
	public boolean hasMoved(){
		return moved;
	}
	public MoveResults(){
		moved=false;
		score=0;
		max=0;
	}
	public String toString(){
		String str = "";
		str += moved;
		str += " ";
		str += score;
		str += " ";
		str += max;
		str += " ";
		return str;
	}
	public void setScore(int score){
		this.score=score;
	}
	public void setMax(int max){
		this.max=max;
	}
	public void setMoved(boolean moved){
		this.moved=moved;
	}
}
