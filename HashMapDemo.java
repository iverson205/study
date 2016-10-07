package Study;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Allen
 * @version 2016,10,6
 */
public class HashMapDemo
{
	static int arr[] = {0,2,3,2,4,3,2,1,4,3};
	

	public static void main(String[] args)
	{
		numCount(arr);

	}

	private static void numCount(int[] arr)
	{
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(int a:arr)
		{
			if(hm.containsKey(a))
			{
				hm.put(a, hm.get(a)+1);
			}
			else
				hm.put(a, 1);
		}
		
//		Set<Entry<Integer, Integer>> tmp=hm.entrySet();
//		for(Entry<Integer, Integer> h1:tmp)
//		{
//			System.out.println(h1.getKey()+":"+h1.getValue());
//		}
		
/*		for(Entry<Integer, Integer> h1:hm.entrySet())
		{
			System.out.println(h1.getKey()+":"+h1.getValue());
		}*/
		
		Set<Integer> h1=hm.keySet();
		Iterator<Integer> it=h1.iterator();
		while(it.hasNext())
		{
			Integer tmp=it.next();
			System.out.println(tmp+":"+hm.get(tmp));;
		}
	}

}
