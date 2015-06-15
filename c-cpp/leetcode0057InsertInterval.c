/******************************Question******************************
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 ********************************************************************/
 

/**
 * @author Horst Xu
 * @date 2015-06-15
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 * };
 */
struct Interval* insert(struct Interval* intervals, int intervalsSize, struct Interval newInterval, int* returnSize) {
    struct Interval* result = (struct Interval*)malloc(sizeof(struct Interval)*(intervalsSize+1));
    memset(result, 0, sizeof(struct Interval)*(intervalsSize + 1));
    if(intervalsSize == 0){
        result[0].start = newInterval.start;
        result[0].end = newInterval.end;
        *returnSize = 1;
        return result;
    }
    int count = 0;
    int i=0;
    int insertnew = 1;
    for(i=0; i<intervalsSize; i++){
        if(newInterval.start > intervals[i].end){
            result[count].start= intervals[i].start;
            result[count].end = intervals[i].end;
            count++;
        }else if(newInterval.end<intervals[i].start){
            result[count].start= newInterval.start;
            result[count].end = newInterval.end;
            count++;
            while(i<intervalsSize){
                result[count].start=intervals[i].start;
                result[count].end=intervals[i].end;
                count++;
                i++;
            }
            insertnew = 0;
            break;
        }else{
            newInterval.start = intervals[i].start<newInterval.start?intervals[i].start:newInterval.start;
            newInterval.end = intervals[i].end >newInterval.end?intervals[i].end:newInterval.end;
        }
    }
    if(insertnew){
        result[count].start = newInterval.start;
        result[count].end = newInterval.end;
        count++;
    }
    *returnSize = count;
    return result;
}
