package lambda;

@FunctionalInterface
public interface Computation {
	static final int MULTIPLIER = 10; 
	
	int compute(int x, int y);
		
	default int magnify(int z) {
		return MULTIPLIER*z;
	}
}