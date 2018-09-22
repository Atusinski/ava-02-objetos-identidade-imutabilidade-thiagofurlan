class Randomizer {

    private long seed() {
        return System.currentTimeMillis() / 1000000;
    }

    private long square() {
    	return seed()*seed();
    }

    private long middle(long a) {
    	long n = a - ((a / 1000000000) * 1000000000);
		return n / 1000;
    }

    public double next() {
    	return (double) middle(square()) / 1000000;
    }

    public int nextInt(int a) {
    	return (int) next() + a;
    }

    public int nextInt(int a, int b) {
    	int n = (int) next();
    	while (n < a || n > b) {
    		n = (int) next() + a;
    	}
    	return n;
    }

}
