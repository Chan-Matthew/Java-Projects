import java.io.*;
public class Sort {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int hi [] = new int[7];
		int temp;
		for (int x = 0; x<7;x++)
			hi[x] = Integer.parseInt(br.readLine());
		for (int x = 0; x<7;x++){
			for (int y = 0; y<7-1; y++) {
				if (hi[y+1] > hi[y]) {
					temp = hi[y];
					hi[y] = hi[y+1];
					hi[y+1] = temp;
				}
					
			}
		}
		for (int z=0; z<7;z++)
			System.out.println (hi[z]);
	}

}
