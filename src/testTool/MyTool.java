package testTool;

public class MyTool {
	public static void print(Object ...object) {
		for (int i = 0; i < object.length; i++) {
			System.out.println("-------------------" + object[i] + "------------------");
		}
	}
}
