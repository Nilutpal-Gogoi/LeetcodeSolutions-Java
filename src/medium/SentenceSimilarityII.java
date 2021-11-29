package medium;

import java.util.HashMap;

public class SentenceSimilarityII {
	private static HashMap<String, String> par;  // parent
	private static HashMap<String, Integer> ran;  // rank
	
	private static String find(String x) {
		if(par.containsKey(x) == false) {
			par.put(x,  x);
			ran.put(x,  1);
		}
		if(par.get(x).equals(x) == true) {
			return x;
		}
		String temp = find(par.get(x));
		par.put(x, temp);
		return temp;
	}
	
	private static void union(String u, String v) {
		String lx = find(u);
		String ly = find(v);
		
		if(lx.equals(ly) == false) {
			if(ran.get(lx) > ran.get(ly)) {
				par.put(ly, lx);
			} else if(ran.get(lx) < ran.get(ly)) {
				par.put(lx,  ly);
			} else {
				par.put(ly, lx);
				ran.put(lx,  ran.get(lx)+1);
			}
		}
	}
	
	public static boolean areSetencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
		par = new HashMap<>();
		ran = new HashMap<>();
		
		if(Sentence1.length != Sentence2.length) return false;
		
		for(String[] pair : pairs) {
			union(pair[0], pair[1]);
		}
		
		for(int i = 0; i<Sentence1.length ; i++) {
			String w1 = Sentence1[i];
			String w2 = Sentence2[i];
			
			if(w1.equals(w2) == true || find(w1).equals(find(w2)) == true)  {
				continue;
			} else {
				return false;
			}
		}
		
		return true;
	}
}
