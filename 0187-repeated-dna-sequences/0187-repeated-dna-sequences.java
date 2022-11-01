class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length()<11) return new LinkedList<>();
        
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        
        for (int i = 10; i<=s.length(); i++) {
            String temp = s.substring(i-10,i);
            if (set.contains(temp)) {
                res.add(temp);
            }
            else set.add(temp);
        }
        List<String> r = new LinkedList<>();
        r.addAll(res);
        return r;
    }
}