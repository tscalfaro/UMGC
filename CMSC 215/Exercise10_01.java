//Terence Boyce  
//Exercise 10_01
//Aug 20 2023


//
public class Exercise10_01 {
    private int hour;
    private int minute;
    private int second;

    // No-arg constructor
    public Exercise10_01() {
        this(System.currentTimeMillis());
    }

    // Constructor with elapsed time
    public Exercise10_01(long elapseTime) {
        setTime(elapseTime);
    }

    // Constructor with hour, minute, and second
    public Exercise10_01(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Getter methods
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    // Set time using elapsed time
    public void setTime(long elapseTime) {
        long totalSeconds = elapseTime / 1000;
        second = (int) (totalSeconds % 60);
        long totalMinutes = totalSeconds / 60;
        minute = (int) (totalMinutes % 60);
        long totalHours = totalMinutes / 60;
        hour = (int) (totalHours % 24);
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    public static void main(String[] args) {
        Exercise10_01 time1 = new Exercise10_01();
        Exercise10_01 time2 = new Exercise10_01(555550000);
        Exercise10_01 time3 = new Exercise10_01(5, 23, 55);

        System.out.println("Time1: " + time1);
        System.out.println("Time2: " + time2);
        System.out.println("Time3: " + time3);
    }
}
