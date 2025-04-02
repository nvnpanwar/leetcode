// https://leetcode.com/problems/eat-pizzas/description/

class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int day = pizzas.length / 4;
        int even = day / 2;
        int odd = day - even;
        int i = pizzas.length -1;
        long maxWeight = 0;
        while(odd > 0 && i>=0){
            maxWeight += pizzas[i];
            i--;
            odd--;
        }
        while(even > 0 && i>0){
            maxWeight += pizzas[i - 1];
            i-=2;
            even--;
        }
        return maxWeight;

    }
}