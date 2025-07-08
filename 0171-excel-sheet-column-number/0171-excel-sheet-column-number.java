public class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        
        int columnNumber = 0;
        
        for(int i = 0;i < n;i++){
            int currentColumn = columnTitle.charAt(i) - 'A' + 1;
            columnNumber = columnNumber * 26 + currentColumn;
        }
        return columnNumber;
    }
}