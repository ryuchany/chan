package array;

public class Test06 {

	public static void main(String[] args) {

		int[] a = new int[3];  //(a) -----> [ 0 ] [ 0 ] [ 0 ] 
		long[] b = new long[3];  //(b) -----> [ 0L ] [ 0L ] [ 0L ] 
		float[] c = new float[3];  //(c) -----> [ 0.0f ] [ 0.0f ] [ 0.0f ] 
		double[] d = new double[3];  //(d) -----> [ 0.0 ] [ 0.0 ] [ 0.0 ] 
		String[] e = new String[3];  //(e) -----> [ null ] [ null ] [ null ] 
		boolean[] f = new boolean[3];  //(f) -----> [ false ] [ false ] [ false ]
		System.out.println(f[0]);
	}
}
