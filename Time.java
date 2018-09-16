public final class Time {

    private final int second;

    Time(int h, int m, int s) {
        this.second = (h*3600) + (m*60) + s;
    }

    Time(int h, int m) {
        this.second = (h*3600) + (m*60);
    }

    Time(int h) {
        this.second = (h*3600);
    }

    Time() {
        this.second = 0;
    }

    Time(double s) {
        this.second = (int)s;
    }

    public Time plus (Time t) {
        double s = this.second + t.second;
        return new Time(s);
    }

    public Time plusHours (int h) {
        double s = this.second + (h*3600);
        return new Time(s);
    }

    public Time plusMinutes (int m) {
        double s = this.second + (m*60);
        return new Time(s);
    }

    public Time plusSeconds (int second) {
        double s = this.second + second;
        return new Time(s);
    }

    public Time minus (Time t) {
        double s = this.second - t.second;
        if(s < 0) s += 86400;
        return new Time(s);
    }

    public Time minusHours (int h) {
        double s = this.second - (h*3600);
        return new Time(s);
    }

    public Time minusMinutes (int m) {
        double s = this.second - (m*60);
        return new Time(s);
    }

    public Time minusSeconds (int second) {
        double s = this.second - second;
        return new Time(s);
    }

    public int hours() {
        int h = this.second / 3600;
        if (h > 23) h %= 24;
        if (h < 0) h = 24 + h;
        return h;
    }

    public int minutes() {
        int m = this.second / 60;
        if (m > 59) m %= 60;
        return m;
    }

    public int seconds() {
        int s = this.second;
        if (s > 59) s %= 60;
        return s;
    }

    public boolean isMidDay() {
        return (this.hours() == 12 && this.minutes() == 0 && this.seconds() == 0);
    }

    public boolean isMidNight() {
        return (this.hours() == 0 && this.minutes() == 0 && this.seconds() == 0);
    }

    public Time tick() {
        double s = this.second + 1;
        return new Time(s);
    }

    public Time shift() {
        double s = this.second + (12*3600);
        return new Time(s);
    }

    @Override
    public String toString() {
        String s = "";
        s += (this.hours() < 10) ? "0" + this.hours() + ":" : this.hours() + ":";
        s += (this.minutes() < 10) ? "0" + this.minutes() + ":" : this.minutes() + ":";
        s += (this.seconds() < 10) ? "0" + this.seconds() : this.seconds();
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Time t = (Time) o;
        return (this.hours() == t.hours() && this.minutes() == t.minutes() && this.seconds() == t.seconds());
    }

}