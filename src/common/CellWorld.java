package common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class CellWorld {
	static int height;
	static int width;
	int[][] cellWorld;
	int[][] cellWorldNext;
	ArrayList<Point> coordinate;
	public void initialize(ArrayList<Point> input){
		this.coordinate = (ArrayList<Point>)(input.clone());
		int listLength = coordinate.size();
		for (int i = 0; i < listLength; i++){
			Point point = this.coordinate.get(i);
			int x = point.x;
			int y = point.y;
			this.cellWorld[x][y] = 1;
		}
	
	}
	public CellWorld(int W, int H){
		this.cellWorld = new int[W][H];
		this.cellWorldNext = new int[W][H];
		this.height = H;
		this.width = W;
	}
	public ArrayList<Point> Next(){
		for(int i=0;i<width;i++){
			for (int j = 0;j<height;j++){
				cellWorldNext[i][j]=cellWorld[i][j];
			}
		}
		int state;
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				int x = i, y = j;
				state = checkState(x, y);
				if (state == 3){
					cellWorldNext[x][y] = 1;
				}
				else if (state == 2){
					continue;
				}
				else{
					cellWorldNext[x][y] = 0;
				}
			}
		}		
		
		ArrayList<Point> coordinateNext = new ArrayList<Point>();
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				if (cellWorldNext[i][j] == 1){
					Point newpoint = new Point(i, j);
					coordinateNext.add(newpoint);
				}
			}
			
		}
		for(int i=0;i<width;i++){
			for (int j = 0;j<height;j++){
				cellWorld[i][j]=cellWorldNext[i][j];
			}
		}

		
		return coordinateNext;
	}
	public int checkState(int x, int y){
		int cellCounter = 0;
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++){
				if (i==0 && j==0)
					continue;
				int ix = x+i;
				int jy = y+j;
				if (boundCheck(ix, jy)){
					if (this.cellWorld[ix][jy] == 1)
						cellCounter++;
				}
					
			}
		return cellCounter;
		
	}
	private boolean boundCheck(int ix, int jy) {
		if (ix < 0 || ix >= width)
			return false;
		else if (jy < 0 || jy >= height)
			return false;
		else 
			return true;
	}

	public String Next_JSON() {
		JSONArray result = new JSONArray();
		java.util.List<Point> items=new ArrayList<Point>();
		items = Next();
		for (Point item:items
				) {
			JSONObject json = new JSONObject();
			json.put("x",item.x);
			json.put("y", item.y);
			result.add(json);
		}
		return result.toString();
	}

	public static ArrayList<Point> drawRandom(int m, int n){
		ArrayList<Point> input = new ArrayList<Point>();
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++){
				double prob = Math.random();
				if ( prob > 0.5){
					input.add(new Point(i, j));
				}
			}
		return input;
	}
	public static void main(String[] args){
		test_init();
		System.out.println("--------!!!!!----------");
		test_next();
		System.out.println("--------!!!!!----------");
		test_next2();


	}
	public static void test_init(){
		ArrayList<Point> input = new ArrayList<Point>();
		CellWorld newCellWorld = new CellWorld(3,3);
//		Point p1 = new Point(0, 1);
//		Point p2 = new Point(1, 1);
//		Point p3 = new Point(2, 1);
//		input.add(p1);
//		input.add(p2);
//		input.add(p3);
		input.add(new Point(0,0));
		input.add(new Point(0,2));
		input.add(new Point(2,0));
		input.add(new Point(2,2));
		input.add(new Point(1,1));
		newCellWorld.initialize(input);
		for(int i=0;i<newCellWorld.width;i++)
		{
			for(int j=0;j<newCellWorld.height;j++)
			{
				if(newCellWorld.cellWorld[j][i] == 1)
				{
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
				System.out.println();
		}
		
		
	}
	public static void test_next2(){
		ArrayList<Point> input = new ArrayList<Point>();
		CellWorld newCellWorld = new CellWorld(3,3);
//		Point p1 = new Point(0, 1);
//		Point p2 = new Point(1, 1);
//		Point p3 = new Point(2, 1);
//		input.add(p1);
//		input.add(p2);
//		input.add(p3);
		input.add(new Point(0,0));
		input.add(new Point(0,2));
		input.add(new Point(2,0));
		input.add(new Point(2,2));
		input.add(new Point(1,1));
		newCellWorld.initialize(input);
		newCellWorld.Next();
		for(int i=0;i<newCellWorld.width;i++)
		{
			for(int j=0;j<newCellWorld.height;j++)
			{
				if(newCellWorld.cellWorldNext[j][i] == 1)
				{
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
				System.out.println();
		}
		System.out.println("+++++++++++++++++");
		newCellWorld.Next();
		for(int i=0;i<newCellWorld.width;i++)
		{
			for(int j=0;j<newCellWorld.height;j++)
			{
				if(newCellWorld.cellWorldNext[j][i] == 1)
				{
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
		}


	}

	public static void test_next(){
		ArrayList<Point> input = new ArrayList<Point>();
		CellWorld newCellWorld = new CellWorld(3,3);
//		Point p1 = new Point(0, 1);
//		Point p2 = new Point(1, 1);
//		Point p3 = new Point(2, 1);
//		input.add(p1);
//		input.add(p2);
//		input.add(p3);
		input.add(new Point(0,0));
		input.add(new Point(0,2));
		input.add(new Point(2,0));
		input.add(new Point(2,2));
		input.add(new Point(1,1));
		newCellWorld.initialize(input);
		newCellWorld.Next();
		for(int i=0;i<newCellWorld.width;i++)
		{
			for(int j=0;j<newCellWorld.height;j++)
			{
				if(newCellWorld.cellWorldNext[j][i] == 1)
				{
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
				System.out.println();
		}
		newCellWorld.Next_JSON();


	}

	

}

//
//		import javafx.scene.control.Cell;
//
//
//		import java.awt.*;
//		import java.util.ArrayList;
//		import java.util.List;
//
///**
// * Created by hhy on 2017/6/3.
// */
//public class Cellworld {
//	class Cell{
//		int x;
//		int y;
//	}
//	public static java.util.List<Point> Init(){
//		java.util.List<Point> result=new ArrayList<Point>();
//		result.add(new Point(0, 0));
//		result.add(new Point(0, 1));
//		return result;
//	}
//
//	public static ArrayList<Point> Next() {
//		ArrayList<Point> result=new ArrayList<Point>();
//		result.add(new Point(0, 0));
//		result.add(new Point(1, 1));
//		result.add(new Point(2, 2));
//		return result;
//	}
//
//	public static String Next_JSON() {
//		JSONArray result = new JSONArray();
//		java.util.List<Point> items=new ArrayList<Point>();
//		items = Next();
//		for (Point item:items
//				) {
//			JSONObject json = new JSONObject();
//			json.put("x",item.x);
//			json.put("y", item.y);
//			result.add(json);
//		}
//		return result.toString();
//	}
//
//	public static void main(String[] arg) {
//		test_init();
//		test_next();
//		System.out.println(Next_JSON());
//	}
//
//	public static void test_init() {
//		java.util.List<Point> result ;
//		java.util.List<Point> expect = new ArrayList<Point>();
//		expect.add(new Point(0, 1));
//		expect.add(new Point(0, 0));
//
//		result = Init();
//		boolean b = result.containsAll(expect) && expect.containsAll(result);
//		if (b) {
//			System.out.println("test ok");
//		}else {
//			System.out.println("test failed");
//		}
//	}
//
//	public static void test_next() {
//		java.util.List<Point> result ;
//		java.util.List<Point> expect = new ArrayList<Point>();
//		expect.add(new Point(0, 1));
//
//		result = Next();
//		boolean b = result.containsAll(expect) && expect.containsAll(result);
//		if (b) {
//			System.out.println("test ok");
//		}else {
//			System.out.println("test failed");
//		}
//	}
//}
// hahaha