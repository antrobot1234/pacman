package pacman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class GameMap {
	public static ArrayList<String> file = getFile("src/files/pacmanscribed.txt");
	public static int[] sizeArr = getDimensions(file);
	public static char[][] map = createMap(file);
	public static HashMap<String,Entity> objList = parseMap(map);
	

	public static ArrayList<String> getFile(String fileName){
		ArrayList<String> list = new ArrayList<>();
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader(fileName));
			String line = file.readLine();
			while(line != null && !line.isEmpty()) {
				list.add(line);
				line = file.readLine();
			}
			file.close();
			return list;
		} catch(Exception e) {
			return null;
		}
	}
	public static int[] getDimensions(ArrayList<String> file) {
		int[] arr = new int[2];
		arr[0]= file.get(0).length();
		arr[1]= file.size();

		return arr;
	}
	/**public static int[] getDimensions(char[][] map) {
		int[] arr = new int[2];
		arr[0] = map[0].length;
		arr[1] = map.length;
		return arr;
	}**/
	public static char[][] createMap(ArrayList<String> map){
		if(map==null) return null;
		char[][] output = new char[sizeArr[1]][sizeArr[0]];
		for(int i =0;i<map.size();i++) {
			output[i] = map.get(i).toCharArray();
		}
		return output;
	}
	public static HashMap<String,Entity> parseMap(char[][] map){
		String[] colors = {"red","orange","blue","pink"};
		int ghostCounter = 0;
		char c;
		HashMap<String,Entity> objList = new HashMap<>();
		for(int y = 0;y<map.length;y++) {
			for(int x = 0;x<map[y].length;x++) {
				c = map[y][x];
				if(c=='4') {
					objList.put(colors[ghostCounter],new Entity(x,y,"ghost",Const.Dir.up,sizeArr[0]));
					ghostCounter++;
				}
				else if(c=='5') {
					objList.put("pac",new Entity(x,y,"pac",Const.Dir.up,sizeArr[0]));
				}
			}
		}
		return objList;
	}
}