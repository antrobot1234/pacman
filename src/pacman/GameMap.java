package pacman;

import pacman.objects.Entity;
import pacman.util.Const;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class GameMap {
	public ArrayList<String> file;
	public int[] sizeArr;
	public char[][] map;
	public HashMap<String, Entity> objList;
	public int pellets;
	public int powerTime;

	public GameMap(String fileName){
		this.file = getFile(fileName);
		sizeArr = getDimensions(file);
		map = createMap(file,sizeArr);
		pellets = getPellets(map);
		objList = parseMap(map,sizeArr);
	}

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
	public static char[][] createMap(ArrayList<String> map,int[] sizeArr){
		if(map==null) return null;
		char[][] output = new char[sizeArr[1]][sizeArr[0]];
		for(int i =0;i<map.size();i++) {
			output[i] = map.get(i).toCharArray();
		}
		return output;
	}
	public static HashMap<String,Entity> parseMap(char[][] map,int[] sizeArr){
		String[] colors = {"red","orange","blue","pink"};
		int ghostCounter = 0;
		char c;
		HashMap<String,Entity> objList = new HashMap<>();
		for(int y = 0;y<map.length;y++) {
			for(int x = 0;x<map[y].length;x++) {
				c = map[y][x];
				if(c=='4') {
					objList.put(colors[ghostCounter],new Entity(x,y,"ghost", Const.Dir.up,sizeArr[0]));
					ghostCounter++;
				}
				else if(c=='5') {
					objList.put("pac",new Entity(x,y,"pac",Const.Dir.up,sizeArr[0]));
				}
			}
		}
		return objList;
	}
	public int getPellets(char[][] map){
		int p = 0;
		for(char[] line:map){
			for(char c:line){
				if(c=='1')p++;
			}
		}
		return p;
	}
	public void waka(int[] arr){
		char c = map[arr[1]][arr[0]];
		if(c=='1'){
			map[arr[1]][arr[0]]='0';
			pellets--;
		}
		if(c=='2'){
			map[arr[1]][arr[0]]='0';
			powerTime = 300;
		}
	}
	public boolean check(Entity e,Const.Dir dir){
		int[] temp = Const.vectSum(Const.dirMap.get(dir),e.pos.asArr());
		if(temp[0]<0||temp[0]>=sizeArr[0]){
			return true;
		}
		return(map[temp[1]][temp[0]] != ' ');
	}
}