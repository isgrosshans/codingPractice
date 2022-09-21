class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1; //empty
        if(s.length()%2!=0) return false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('
              || s.charAt(i)=='['
              || s.charAt(i)=='{')
                stack[++top]=s.charAt(i);
            else if(top<0) return false;
            else {
                if(s.charAt(i)==')'){
                    if(stack[top]=='(')
                        top--;
                    else return false;
                }
                if(s.charAt(i)==']'){
                    if(stack[top]=='[')
                        top--;
                    else return false;
                }
                if(s.charAt(i)=='}'){
                    if(stack[top]=='{')
                        top--;
                    else return false;
                }
            }
        }
        if(top>=0) return false;
        return true;
    }
}