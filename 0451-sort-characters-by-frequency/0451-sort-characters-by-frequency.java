class Solution {
    class Node {
        char val;
        int count;

        Node(char c, int freq) {
            this.val = c;
            this.count = freq;
        }
    }

    public String frequencySort(String s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (b.count != a.count) {
                return b.count - a.count; // higher frequency comes first
            } else {
                return a.val - b.val; // lower ASCII value comes first
            }
        });

        int[] freq = new int[76];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - '0']++;
        }
        for (int i = 0; i < 76; i++) {
            if (freq[i] > 0) {
                int val = i + 48;
                Node temp = new Node((char) val, freq[i]);
                pq.add(temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            int data = temp.count;
            for (int i = 0; i < data; i++) {
                sb.append(temp.val);
            }
        }
        return sb.toString();
    }
}