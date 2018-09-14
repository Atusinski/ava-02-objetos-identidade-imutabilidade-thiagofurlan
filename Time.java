public final class Time {

    final int second;

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
        this.second = 0;
    }

    public Time plus (Time t) {
        return new Time(this.second + t.second);
    }

    public Time plusHours (int h) {
        return new Time(this.second + (h*3600));
    }

    public Time plusMinutes (int m) {
        return new Time(this.second + (m*60));
    }

    public Time plusSeconds (int s) {
        return new Time(this.second + s);
    }

    public Time minus (Time t) {
        return new Time(this.second - t.second);
    }

    public Time minusHours (int h) {
        return new Time(this.second - (h*3600));
    }

    public Time minusMinutes (int m) {
        return new Time(this.second - (m*60));
    }

    public Time minusSeconds (int s) {
        return new Time(this.second - s);
    }

    public int hours() {
        int h = this.second / 3600;
        if (h > 23) h %= 24;
        if (h < 0) h = 24 + h;
        return h;
    }

    public int minutes() {
        int m = this.second / 60;
        if (m > 59) {
            //h += m / 60;
            m %= 60;
        }
        return m;
    }

    public int seconds() {
        int s = this.second;
        if (s > 59) {
            //m += s / 60;
            s %= 60;
        }
        return s;
    }

    public boolean isMidDay() {
        return (this.hours() == 12 && this.minutes() == 0 && this.seconds() == 0);
    }

    public boolean isMidNight() {
        return (this.hours() == 0 && this.minutes() == 0 && this.seconds() == 0);
    }

    public Time tick() {
        return new Time(this.second + 1);
    }

    public Time shift() {
        return new Time(this.hours() + 12);
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

    private Time format(int h, int m, int s) {
        if (s > 59) {
            m += s / 60;
            s %= 60;
        }
        if (m > 59) {
            h += m / 60;
            m %= 60;
        }
        if (h > 23) {
            h %= 24;
        }
        if (s < 0) {
            m += s/60;
            s += 60;
        }
        if (m < 0) {
            h += m/60;
            m += 60;
        }
        if (h < 0) {
            h = 24 + h;
        }        
        return new Time(h, m, s);
    }

}