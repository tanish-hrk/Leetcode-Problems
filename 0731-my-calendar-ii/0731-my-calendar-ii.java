class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        // Check for triple booking
        for (int[] interval : overlaps) {
            if (startTime < interval[1] && endTime > interval[0]) {
                return false; // triple booking occurs
            }
        }

        // Record new double bookings
        for (int[] interval : bookings) {
            if (startTime < interval[1] && endTime > interval[0]) {
                int overlapStart = Math.max(startTime, interval[0]);
                int overlapEnd = Math.min(endTime, interval[1]);
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }

        // Safe to book
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}
