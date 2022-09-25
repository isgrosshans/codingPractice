/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long myN=n;
        long min=1, max=-1;
        while(guess((int)myN)!=0){
            if(guess((int)myN)==1) {   // n < pick ie guessed too low -> go higher
                min = myN+1;
                if(min==-1) { 
                    myN=myN*2;
                    if(myN>=2147483647){
                        myN=2147483647;
                        max=2147483647;
                    }
                }
                else { myN=(min+max)/2; }
            }
            else {              // n > pick ie guessed too high -> go lower
                max=myN-1;
                myN=(min+max)/2;
            }
        }
        return (int)myN;
    }
}
