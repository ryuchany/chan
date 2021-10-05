package api.lang.string;

public class StarGenerator {

	public static String generate(int size) {
		StringBuilder builder = new StringBuilder();
		for(int i=0; i < size; i++) {
			builder.append("*");
		}
		return builder.toString();
	}

}
