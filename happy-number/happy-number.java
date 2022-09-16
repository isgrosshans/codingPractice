class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int temp;
        
        while(true){
            if(visited.contains(n)) return false;
            if(n==1) return true;
            visited.add(n);
            temp = n;
            n=0;
            while(temp>0){
                n += (temp%10) * (temp%10);
                temp = temp/10;
            }
        }
    }
}