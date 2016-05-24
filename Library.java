package bookTest;

import java.util.ArrayList;

public class Library {

	private ArrayList<Shelf> shelves;
	private String genre;
	
	public Library(int i, String s){
		shelves = new ArrayList<Shelf>(i);
		genre = s;
	}
	
	public Shelf getShelf(int i){
		return this.shelves.get(i);
	}
	
	
	public int round(double x){
		if ((int)(x+.5)>x){
			return ((int)(x+.5));
		} else {
			return (int)x;
		}
	}
	
	public void display(){
		int r = round(Math.sqrt(this.shelves.size()));
		int c = round(Math.sqrt(this.shelves.size()));
		Shelf[][] map = new Shelf[r][c];
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				System.out.print("Shelf " + r+c + " - " + map[i][j].getGenre());
			}
			System.out.println();
		}
	}

}
