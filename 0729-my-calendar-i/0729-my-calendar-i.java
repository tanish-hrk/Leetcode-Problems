class MyCalendar {

    ArrayList<int[]> event;

    public MyCalendar() {
        event = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] curr:event){
            int currstart=curr[0];
            int currend=curr[1];

            if(startTime<currend && endTime>currstart){
                return false;
            }
        }
        event.add(new int[]{startTime,endTime});
        return true;
       }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */