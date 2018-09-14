class Randomizer {

    long semente;
    
    Randomizer() {
        //this.semente = System.currentTimeMillis();
        this.semente = 675248;
    }

    long next() {
        return middle();
    }

    private long quadrado() {
        long p = this.semente;
        p *= this.semente;
        return p;
    }

    private long[] middle() {
        long n = this.quadrado();
        long[] a = new long[6];
        for (int i = 0; i < 6; i++) {
            a[i] = s[i+2];
        }
        return a;
    }

}