// https://leetcode.com/problems/reverse-words-in-a-string

/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let arr = s.trim().split(" ").filter((ele)=> ele != "");
    for(let i=0;i<arr.length/2;i++){
        let temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
    }
    let ans = arr[0];
    for(let i= 1;i<arr.length;i++){
        ans = ans+" "+arr[i];
    }
    return ans;
};