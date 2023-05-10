package SongTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Songs.SongsList;

public class TestSongs {

	
	@DataProvider
	public  Object[] getSongsData(){

		ArrayList<String> actual1 =new ArrayList<String>();
		ArrayList<String> actual2 =new ArrayList<String>();
		ArrayList<String> actual3=new ArrayList<String>();
		ArrayList<String> actual4=new ArrayList<String>();
		actual1.add("S1");
		actual1.add("S2");
		actual1.add("S3");

		ArrayList<String> expected1=new ArrayList<String>();
		ArrayList<String> expected2=new ArrayList<String>();
		ArrayList<String> expected3=new ArrayList<String>();
		ArrayList<String> expected4=new ArrayList<String>();
		expected1.add("S1");
		expected1.add("S2");
		expected1.add("S3");

		Map<String,List<String>> map1 =new HashMap<String, List<String>>();
		Map<String,List<String>> map2 =new HashMap<String, List<String>>();
		Map<String,List<String>> map3 =new HashMap<String, List<String>>();
		Map<String,List<String>> map4 =new HashMap<String, List<String>>();
		map1.put("actual",actual1);
		map1.put("expected",expected1);


		ArrayList<Map<String,List<String>>> data = new ArrayList();
		data.add(map1);


		
		
		actual2.add("S1");
		actual2.add("S2");
		actual2.add("S3");
		actual2.add("S4");

		expected2.clear();
		expected2.add("S2");
		expected2.add("S3");
		expected2.add("S4");

		map2.clear();
		map2.put("actual",actual2);
		map2.put("expected",expected2);
		data.add(map2);
		
		
		actual3.add("S1");
		actual3.add("S2");
		actual3.add("S3");
		actual3.add("S4");
		actual3.add("S2");
		
		expected3.clear();
		expected3.add("S3");
		expected3.add("S4");
		expected3.add("S2");
		map3.clear();
		map3.put("actual",actual3);
		map3.put("expected",expected3);
		data.add(map3);
		
		
		actual4.clear();
		actual4.add("S1");
		actual4.add("S2");
		actual4.add("S3");
		actual4.add("S4");
		actual4.add("S2");
		actual4.add("S1");
		
		expected4.clear();
		expected4.add("S4");
		expected4.add("S2");
		expected4.add("S1");
		map4.clear();
		map4.put("actual",actual4);
		map4.put("expected",expected4);
		data.add(map4);

		
		
		
		return data.toArray();


	}


	@Test(dataProvider="getSongsData")
	public void testHappyFlow(Map<String,List<String>> mp) {

		ArrayList<String> al =(ArrayList<String>) mp.get("actual");


		ArrayList<String> expected = (ArrayList<String>) mp.get("expected");
		
		System.out.println("al data"+al.toString());
		System.out.println("expected:"+expected.toString());
		


		SongsList ls = new SongsList(5,3);

		for(String st:al) {
			ls.addSong(st);
		}

		ArrayList<String> actuallist = ls.getSongsList();

		System.out.println(expected.toString());
		System.out.println(actuallist.toString());

		AssertJUnit.assertTrue(actuallist.equals(expected));

	}








}
