package pacman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Map {
	public static char[][] map = Map.parseMap("src/files/pacmanscribed.txt");
	public static int[] sizeArr;
	public static ArrayList<Entity> objList;
	
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
	public static char[][] grid; static {
		try {grid = createMap("src/files/pacmanscribed.txt");} catch(Exception e) {}
	}
	public static int[] getDimensions(ArrayList<String> file) {
		int[] arr = new int[2];
		arr[0]= file.get(0).length();
		arr[1]= file.size();
		
		return arr;
	}
	public static int[] getDimensions(char[][] map) {
		int[] arr = new int[2];
		arr[0] = map[0].length;
		arr[1] = map.length;
		return arr;
	}
	public static char[][] createMap(String fileName){
		ArrayList<String> map = getFile(fileName);
		if(map==null){return null;}
		int[] sizeArr = getDimensions(map);
		char[][] output = new char[sizeArr[1]][sizeArr[0]];
		for(int i =0;i<map.size();i++) {
			output[i] = map.get(i).toCharArray();
		}
		return output;
	}
	public static char[][] parseMap(String fileName){
		String[] colors = {"red","orange","blue","pink"};
		char[][] map = createMap(fileName);
		sizeArr = getDimensions(map);
		char[][] out = new char[map.length][map[0].length];
		int ghostCounter = 0;
		char c;
		ArrayList<Entity> objList = new ArrayList<>();
		for(int y = 0;y<out.length;y++) {
			for(int x = 0;x<out[y].length;x++) {
				c = map[y][x];
				if(c=='1'||c=='2'||c==' ') {out[y][x]=c;}
				else if(c=='3') {out[y][x]='0';}
				else if(c=='4') {
					out[y][x]='4';
					String[] arr = {"ghost",colors[ghostCounter]};
					objList.add(new Entity(x,y,arr,Const.Dir.up));
					ghostCounter++;
				}
				else if(c=='5') {
					out[y][x]='0';
					String[] arr = {"pac"};
					objList.add(new Entity(x,y,arr,Const.Dir.up));
				}
			}
		}
		Map.objList = objList;
		return out;
	}
}
