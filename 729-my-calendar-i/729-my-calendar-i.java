class MyCalendar {
    HashMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new HashMap<>();
    }
    
    public boolean book(int start, int end) {

        for(int key: calendar.keySet()){
            if(start <= key && calendar.get(key) <= end)
                return false;
            if(key < start && start < calendar.get(key))
                return false;
            if(key < end && end < calendar.get(key))
                return false;
        }
        
            calendar.put(start, end);
            return true;
    }
    
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */