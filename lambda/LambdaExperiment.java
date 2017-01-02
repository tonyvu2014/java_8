package lambda;

import lambda.Worker;
import lambda.Computation;

public class LambdaExperiment {
	public static void main(String[] args) {
	    Worker roadWorker = () -> {System.out.println("Building road");};
	    roadWorker.doWork();
		
		int result = doComputation(10, -5, (x, y) -> x+y);
		System.out.println("Result: " + String.valueOf(result));
		
    }
	
	private static int doComputation(int x, int y, Computation computation) {
		return computation.compute(x, y);
	} 
}