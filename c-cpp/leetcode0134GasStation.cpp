/*****************************************Question******************************************
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 *******************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-09-29
 **/
class Solution {
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        int start = 0;
        int end = gas.size()-1;
        int tank = 0;
        while(start <= end){
            if(tank + gas[start] >= cost[start]){
                tank += gas[start] - cost[start];
                start++;
            }else{
                tank += gas[end] - cost[end];
                end--;
            }
        }
        return tank >= 0? start % gas.size() : -1;
    }
};
