import java.io.*;
public class MdArrayTwo {

	public static void main(String[] args) throws IOException{
		MdArrayTwo hi = new MdArrayTwo();
		int square[][] = new int [5][5];
		square= hi.fill(square);
		hi.squareCheck(hi.rowCheck(square), hi.columnCheck(square), hi.diaCheck(square));
	}
	
	public int [][] fill (int array[][]) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		for (int x=0;x<5;x++) {
			for (int y=0;y<5;y++){
			array[x][y] = Integer.parseInt(br.readLine());
			}
		}
		return array;
	}
	
	public boolean rowCheck(int array[][]){
		int sum[] = new int[5];
		for (int x = 0;x<5;x++){
			for (int y=0;y<5;y++){
				sum[x] += array[x][y];
			}
		}
		for (int a=0;a<4; a++){
			if (sum[a]!=sum[a+1])
				return false;
		}
		return true;
	}
	
	public boolean columnCheck(int array[][]){
		int sum[] = new int[5];
		for (int x = 0;x<5;x++){
			for (int y=0;y<5;y++){
				sum[x] += array[y][x];
			}
		}
		for (int a=0;a<4; a++){
			if (sum[a]!=sum[a+1])
				return false;
		}
		return true;
	}
	
	public boolean diaCheck(int array[][]){
		int sum[] = new int[2];
		for (int y=0;y<5;y++){
			sum[0] += array[y][y];
		}
		for (int x=4;x<-1;x++){
			sum[1]+= array[x][5-x];
		}
		if (sum[0]!=sum[1])
				return false;
		else
		return true;
	}
	public void squareCheck(boolean row, boolean col, boolean dia){
		if (row == true || col == true || dia == true)
			System.out.println ("That is a magic square");
		else 
			System.out.println("Wrecked");
	}
}
	
