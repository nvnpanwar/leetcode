// https://leetcode.com/problems/simplify-path

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i=0;
        while(i<path.length()){
            int j = i+1;
            while(j<path.length() && path.charAt(j) != '/'){
                j++;
            }
            if(path.substring(i+1,j).equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(!path.substring(i+1,j).equals(".") && !path.substring(i+1,j).equals("")){
                stack.push(path.substring(i+1,j));
            }
            i=j;
        }
        String ans = "";
        if(stack.isEmpty()){
            return "/";
        }
        for(String str: stack){
            ans = ans + "/" + str;
        }
        return ans;
    }
}