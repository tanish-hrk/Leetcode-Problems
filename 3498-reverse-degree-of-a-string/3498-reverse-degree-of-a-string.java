class Solution {
    public int reverseDegree(String s) {
        int deg = 0;
        for(int i=0;i<s.length();i++){
            int index = 'z'-s.charAt(i)+1;
            deg += (i+1)*index;
        }
        return deg;
    }
}