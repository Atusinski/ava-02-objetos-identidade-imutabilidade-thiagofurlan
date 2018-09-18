class Randomizer {

    long semente;
    
    Randomizer() {
        this.semente = System.currentTimeMillis();
        this.semente %= this.semente / 1000000;
    }

    int next() {
        int q = this.quadrado();
        String s = this.toString(q);
        String m = this.middle(s);
        return this.toInt(m) / 1000000;   
    }

    int nextInt(int n) {
        int q = this.quadrado();
        String s = this.toString(q);
        String m = this.middle(s);
        return this.toLong(m) / 100000;   
    }

    private int quadrado() {
        int s = this.semente;
        s *= this.semente;
        return s;
    }

    private String toString(int n) {
        return "" + n;
    }

    private String middle(String s) {
        int m = s.length() / 2;
        String ns = "";
        for (int i = (m-3); i < (m+3); i++) {
            ns += s.charAt(i);
        }
        return ns;
    }
    
    private int toInt(String s) {
        int aux = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '0':
                    aux = 0;
                    break;
                case '1':
                    aux = 1;
                    break;
                case '2':
                    aux = 2;
                    break;
                case '3':
                    aux = 3;
                    break;
                case '4':
                    aux = 4;
                    break;
                case '5':
                    aux = 5;
                    break;
                case '6':
                    aux = 6;
                    break;
                case '7':
                    aux = 7;
                    break;
                case '8':
                    aux = 8;
                    break;
                case '9':
                    aux = 9;
                    break;
                default: throw new IllegalArgumentException();
            }
            switch (i) {
                case 0:
                    n += aux * 100000;
                    break;
                case 1:
                    n += aux * 10000;
                    break;
                case 2:
                    n += aux * 1000;
                    break;
                case 3:
                    n += aux * 100;
                    break;
                case 4:
                    n += aux * 10;
                    break;
                case 5:
                    n += aux;
                    break;
            }
        }
        return n;
    }

}