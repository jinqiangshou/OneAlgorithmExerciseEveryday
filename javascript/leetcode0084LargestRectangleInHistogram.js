/****************************Question******************************
 * Given n non-negative integers representing the histogram's bar 
 * height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 ******************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-23
 * @param {number[]} height
 * @return {number}
 */
var largestRectangleArea = function(height) {
    if(height.length === 0){return 0;}
    if(height.length === 1){return height[0];}
    
    var left = [];
    left.push(0);
    for(var i=1; i<height.length;i++){
        if(height[i] === height[i-1]){
            left.push(left[i-1]);
        }else if(height[i] > height[i-1]){
            left.push(i);
        }else{
            var find1 = left[i-1];
            while(find1>0 && height[find1-1]>=height[i]){
                find1 = left[find1-1];
            }
            left.push(find1);
        }
    }
    var right = [];
    for(var j=0;j<height.length;j++){
        right.push(height.length-1);
    }
    for(var k=height.length-2; k>=0; k--){
        if(height[k] === height[k+1]){
            right[k] = right[k+1];
        }else if(height[k] > height[k+1]){
            right[k] = k;
        }else {
            var find2 = right[k+1];
            while(find2<height.length-1 && height[find2+1] >= height[k]){
                find2 = right[find2+1];
            }
            right[k] = find2;
        }
    }
    
    var result = -1;
    for(var g=0; g<height.length;g++){
        var temp = (right[g]-left[g]+1)*height[g];
        if(result<temp){
            result = temp;
        }
    }
    return result;
};
