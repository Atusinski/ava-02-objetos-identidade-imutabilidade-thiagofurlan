public final class Time {

    private final int hour;
    private final int minute;
    private final int second;

    Time(int h, int m, int s) {
        this.hour = h;
        this.minute = m;
        this.second = s;
    }

    Time(int h, int m) {
        this.hour = h;
        this.minute = m;
        this.second = 0;
    }

    Time(int h) {
        this.hour = h;
        this.minute = 0;
        this.second = 0;
    }

    Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time plus (Time t) {
        int h = this.hour + t.hour;
        int m = this.minute + t.minute;
        int s = this.second + t.second;
        return this.format(h, m, s);
    }

    public Time plusHours (int h) {
        return this.format(this.hour + h, this.minute, this.second);
    }

    public Time plusMinutes (int m) {
        return this.format(this.hour, this.minute + m, this.second);
    }

    public Time plusSeconds (int s) {
        return this.format(this.hour, this.minute, this.second + s);
    }

    public Time minus (Time t) {
        int h = this.hour - t.hour;
        int m = this.minute - t.minute;
        int s = this.second - t.second;
        return this.format(h, m, s);
    }

    public Time minusHours (int h) {
        return this.format(this.hour - h, this.minute, this.second);
    }

    public Time minusMinutes (int m) {
        return this.format(this.hour, this.minute - m, this.second);
    }

    public Time minusSeconds (int s) {
        return this.format(this.hour, this.minute, this.second - s);
    }

    public int hours() {
        return this.hour;
    }

    public int minutes() {
        return this.minute;
    }

    public int seconds() {
        return this.second;
    }

    public boolean isMidDay() {
        return (this.hour == 12 && this.minute == 0 && this.second == 0);
    }

    public boolean isMidNight() {
        return (this.hour == 0 && this.minute == 0 && this.second == 0);
    }

    public Time tick() {
        int h = this.hour;
        int m = this.minute;
        int s = this.second + 1;
        return this.format(h, m, s);
    }

    public Time shift() {
        return this.format(this.hour + 12, this.minute, this.second);
    }

    @Override
    public String toString() {
        String s = "";
        s += (this.hour < 10) ? "0" + this.hour + ":" : this.hour + ":";
        s += (this.minute < 10) ? "0" + this.minute + ":" : this.minute + ":";
        s += (this.second < 10) ? "0" + this.second : this.second;
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Time t = (Time) o;
        return (this.hour == t.hour && this.minute == t.minute && this.second == t.second);
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