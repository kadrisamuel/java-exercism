import java.util.stream.IntStream;

class BirdWatcher {
    private int[] lastweek = { 0, 2, 5, 3, 7, 8, 4 };
    private final int[] birdsPerDay; 

    public static void main(String[] args) {
        int[] birdsPerDay = { 2, 5, 0, 7, 4, 1 };
        BirdWatcher birdCount = new BirdWatcher(birdsPerDay);
        System.out.println(birdCount.getToday());
    }

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return lastweek;
    }

    public int getToday() {
        return this.birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[birdsPerDay.length - 1] = getToday() + 1;
    }

    public boolean hasDayWithoutBirds() {
        return IntStream.of(birdsPerDay).anyMatch(x -> x == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        int count = 0;
        for (int i = 0; i < numberOfDays && i < birdsPerDay.length; i++) {
            count = count + birdsPerDay[i];
        }
        return count;
    }

    public int getBusyDays() {
        int busyDayCounter = 0;
        for (int i : birdsPerDay) {
            busyDayCounter = (i >= 5) ? busyDayCounter + 1 : busyDayCounter; 
        }
        return busyDayCounter;
    }
}
