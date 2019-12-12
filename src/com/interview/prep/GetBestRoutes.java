package com.interview.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;


//This question was asked in the Amazon online coding challenge.


//Question is: There are two routes that need to be considered - forward and backward. Need to
//consider the best route to maximize, yet be within or exactly equal to the max distance
// mentioned in the second variable


//I FINALLY GOT ITTTTTTT!!!!

public class GetBestRoutes {


	public static List<Integer> getBestRoutes(List<List<Integer>> forwardRouteList,List<List<Integer>> returnRouteList, 
			int maxDistance ){



		List<Integer> output= new ArrayList<Integer>();

		Map<List<Integer>, Integer> map=new HashMap<List<Integer>, Integer>();


		for(int i=0;i<forwardRouteList.size();i++) {
			for(int j=0; j<returnRouteList.size();j++) {
				List<Integer> list=new ArrayList<Integer>();

				int value=forwardRouteList.get(i).get(1)+returnRouteList.get(j).get(1);
				list.add(forwardRouteList.get(i).get(0));
				list.add(returnRouteList.get(j).get(0));
				map.put(list, value);

			}


		}


		//Set setOfKeys = 
		Iterator iterator=map.keySet().iterator();
		

		int maxVal=0;
		while(iterator.hasNext()) {

			List<Integer> array=(List<Integer>) iterator.next();
			
		
			Integer routeDistance=map.get(array);

			if (routeDistance==maxDistance) {

				output.addAll(array);



			}
			else {
				if(maxVal<maxDistance && routeDistance< maxDistance && maxVal<routeDistance) {
					maxVal=routeDistance;




				}
			}


		}

		if(output.size()!=0) {


			return output;
		}
		else {

			//Set<Integer> keys = new HashSet<Integer>();
		
			
			for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
				if (Objects.equals(maxVal, entry.getValue())) {
					output.addAll(entry.getKey());

				}
			}
		}

		return output;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		List<List<Integer>> forwardRoutesList= new ArrayList<List<Integer>>();
		List<List<Integer>> returnRoutesList= new ArrayList<List<Integer>>();
		int maxDist= 11000;


		List<Integer> list1=new ArrayList<Integer>();
		List<Integer> list2=new ArrayList<Integer>();
		List<Integer> list3=new ArrayList<Integer>();
		List<Integer> list4=new ArrayList<Integer>();

		list1.add(1);
		list1.add(3000);
		forwardRoutesList.add(0,list1);

		list2.add(2);
		list2.add(5000);
		forwardRoutesList.add(1,list2);

		list3.add(2);
		list3.add(5000);
		returnRoutesList.add(0,list3);

		list4.add(1);
		list4.add(7000);
		returnRoutesList.add(1,list4);
		//forwardRoutesList.add(list1);
		//list1.add(3, 7000);
		//forwardRoutesList.add(list1);


		/*list2.add(1, 3000);
		returnRoutesList.add(list2);
		list2.add(2, 5000);
		returnRoutesList.add(list2);
		list2.add(3, 7000);
		returnRoutesList.add(list2);
		 */

		List<Integer> finalRoutes=getBestRoutes(forwardRoutesList, 	returnRoutesList, maxDist);

		System.out.println(finalRoutes);


	}

}
