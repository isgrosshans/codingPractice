class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> res = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        int lenSum = 0;
        
        for (int i = 0; i < n; i++) {
            
            if(lenSum + queue.size() +words[i].length() > maxWidth){
                res.add(justifyLine(queue, lenSum, maxWidth));
                queue = new LinkedList<>();
                lenSum=0;
            }
            queue.add(words[i]);
            lenSum = lenSum + words[i].length();
        }
        
        String last = queue.poll();
        while (!queue.isEmpty()) {
            last = last + " " + queue.poll();
        }
        last = last + " ".repeat(maxWidth - last.length());
        res.add(last);

        return res;
    }
    
    private String justifyLine(Queue<String> words, int lensum, int max) {
        int n = words.size();
        int m = n - 1;
        int spaces = max-lensum;
        
        if(n==1) {
            return words.poll() + " ".repeat(spaces);
        }

        int b = spaces % m;
        int s = m - b;

        String sml = " ".repeat(spaces/m);
        String big = sml + " ";

        String res = words.poll();

        for (int i = 0; i < b; i++) {
            res = res + big + words.poll();
        }

        for (int i = 0; i < s; i++) {
            res = res + sml + words.poll();
        }

        return res;
    }
}