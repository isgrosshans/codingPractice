/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1;
        
        int min=1, max=-1;
        while(!(isBadVersion(n) && !isBadVersion(n-1))){
            if(isBadVersion(n)){
                max=n;
                n=min + (max - min) / 2;
            }
            else{
                if(max==-1){
                    if(n>2147483647/2){
                        n=2147483647;
                        max=2147483647;
                    }
                    else n=n*2;
                }
                else {
                    min=n+1;
                    n=min + (max - min) / 2;
                }
            }
        }
        return n;
    }
}
