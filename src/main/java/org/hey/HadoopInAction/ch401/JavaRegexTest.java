package org.hey.HadoopInAction.ch401;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "llll&9+ddsafda&14+$12";
		Pattern p = Pattern.compile("\\&(\\d+)(?:[^\\&]*(?:\\&(\\d+)))");
		Matcher m = p.matcher(input);

		System.out.println("find " + m.find());
		System.out.println("groupCount(): " + m.groupCount());

		for (int i = 1; i <= m.groupCount(); i++) {
			// 2
			System.out.println("group(" + i + "):" + m.group(i));
			System.out.println("start(" + i + "):" + m.start(i));
		      System.out.println("end(" + i + "):" + m.end(i));
		}

	}

}
