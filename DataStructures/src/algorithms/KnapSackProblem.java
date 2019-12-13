package algorithms;

import java.util.Map;
import java.util.HashMap;

class Index{
	int remainingWt;
	int remainingitem;
	
	@Override
	public boolean equals(Object o) {
		if(this==o)
			return true;
		if(o==null|| getClass()!=o.getClass())
			return false;
		
		Index index=(Index) o;
		
		if(remainingWt!=index.remainingWt)
			return false;
		
		return remainingitem==index.remainingitem;
	}
	
	@Override
	public int hashCode() {
		int result=remainingWt;
		result=31 * result+remainingitem;
		return result;
	}
}

public class KnapSackProblem {
	public static int topDownRecursive(int values[],int weights[],int W) {
		Map<Index,Integer> computedMap=new HashMap<Index,Integer>();
		return topDownRecursiveUtil(values, weights, W, values.length, 0, computedMap);
	}
	
	public static int topDownRecursiveUtil(int values[],int weight[],int remainingWt,int totalItem,int currentItem,Map<Index,Integer> map) {
		if(currentItem>=totalItem || remainingWt<=0)
			return 0;
		
		Index key=new Index();
		key.remainingitem=totalItem-currentItem-1;
		key.remainingWt=remainingWt;
		
		if(map.containsKey(key)) {
			return map.get(key);
		}
		
		int maxValue;
		
		if(remainingWt<=weight[currentItem]) {
			maxValue=topDownRecursiveUtil(values, weight, remainingWt, totalItem, currentItem+1, map);
		}else {
			maxValue=Math.max(values[currentItem]+topDownRecursiveUtil(values, weight, remainingWt-weight[currentItem], totalItem, currentItem+1, map),
					topDownRecursiveUtil(values, weight, remainingWt, totalItem, currentItem+1, map));
		}
		
		map.put(key,maxValue);
		return maxValue;
	}
	
	public static void main(String args[]) {
		int values[]= {2,4,6,9};
		int weight[]= {2,2,4,5};
		System.out.println("Solution is : "+topDownRecursive(values, weight, 8));
	}
}
