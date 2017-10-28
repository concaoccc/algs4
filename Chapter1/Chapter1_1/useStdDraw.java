package Chapter1_1;

import edu.princeton.cs.algs4.StdDraw;

public class useStdDraw {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 100;
		StdDraw.setPenRadius(0.005);
		StdDraw.setXscale(0,N);
		StdDraw.setYscale(0,N*N);
		for (int i = 0; i<= N; i++)
		{
			StdDraw.point(i, i);
			StdDraw.point(i, i*Math.log(i));
			StdDraw.point(i, i*i);
		}

	}

}
