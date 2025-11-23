package learnings;

public class MutableStrings {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abcde");
		sb.insert(2, "jkl");
		System.out.println(sb);
		
		StringBuilder sbd = new StringBuilder("pqrstu");
		sbd.insert(2, "jkl");
		System.out.println(sbd);
	}

}
