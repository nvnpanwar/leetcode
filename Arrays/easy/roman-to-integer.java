// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        h.put('I',1);
        h.put('V',5);
        h.put('X',10);
        h.put('L',50);
        h.put('C',100);
        h.put('D',500);
        h.put('M',1000);
        int i=0;
        int sum=0;
        while(i<=s.length()-1){
            if((i!=s.length()-1) && (h.get(s.charAt(i))<h.get(s.charAt(i+1)))){
                sum=sum+h.get(s.charAt(i+1))-h.get(s.charAt(i));
                i+=2;
            }
            else{
                sum=sum+h.get(s.charAt(i));
                i++;
            }
        }
        return sum;
    }
}
