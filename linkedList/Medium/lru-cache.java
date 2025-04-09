// https://leetcode.com/problems/lru-cache

class LRUCache {
    Map<Integer, Integer> map;
    int[] list;
    int size;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new int[capacity];
        Arrays.fill(list, -1);
        size = 0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int[] templist = new int[list.length];
        boolean flag = false;
        for(int i=0;i<size-1;i++){
            if(key == list[i]){
                flag = true;
            }
            if(flag){
                templist[i] = list[i+1]; 
            }
            else{
                templist[i] = list[i]; 
            }
        }
        templist[size-1] = key;
        list = templist;
        
        return map.get(key);
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            int[] templist = new int[list.length];
            boolean flag = false;
            for(int i=0;i<size-1;i++){
                if(key == list[i]){
                    flag = true;
                }
                if(flag){
                    templist[i] = list[i+1]; 
                }
                else{
                    templist[i] = list[i]; 
                }
            }
            templist[size-1] = key;
            list = templist;
            map.put(key, value);
        }
        else{
            if(size == list.length){
                int[] templist = new int[size];
                map.remove(list[0]);
                for(int i=0;i<size-1;i++){
                    templist[i] = list[i + 1]; 
                }
                templist[size-1] = key;
                list = templist;
            }
            else{
                list[size] = key;
                size++; 
            }
            map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */