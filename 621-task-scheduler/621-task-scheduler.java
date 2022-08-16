class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int max_freq = 0;
        for(char c: tasks){
            max_freq = Math.max(max_freq, ++freq[c-'A']);
        }
        
        max_freq--;
        int idle_slots = (max_freq * n) + max_freq;
        for(int i = 0; i<26; i++){
            idle_slots -= Math.min(freq[i], max_freq);
        }
        
        return idle_slots > 0? idle_slots + tasks.length: tasks.length;
    }
}