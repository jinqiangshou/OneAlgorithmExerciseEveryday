/******************************Question*********************************
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 ***********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-06-12
 */
void quickSort(struct Interval* intervals, int low, int high){
    int start = low;
    int end = high;
    if(end<=start){
        return ;
    }
    struct Interval key;
    key.start = intervals[start].start;
    key.end = intervals[start].end;
    
    while(start<end){
        while(start<end && intervals[end].start>=key.start){
            end--;
        }
        intervals[start].start = intervals[end].start;
        intervals[start].end = intervals[end].end;
    
        while(start<end && intervals[start].start <= key.start){
            start++;
        }
        intervals[end].start = intervals[start].start;
        intervals[end].end = intervals[start].end;
    }
    intervals[start].start = key.start;
    intervals[start].end = key.end;
    quickSort(intervals, low, start-1);
    quickSort(intervals, start+1, high);
}

/**
 * @author Horst Xu
 * @date 2015-06-12
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 * };
 */
struct Interval* merge(struct Interval* intervals, int intervalsSize, int* returnSize) {
    if(intervalsSize == 0){
        (*returnSize) = 0;
        return NULL;
    }
    quickSort(intervals, 0, intervalsSize-1);
    struct Interval* result = (struct Interval*)malloc(intervalsSize*sizeof(struct Interval));
    memset(result, 0, sizeof(intervalsSize*sizeof(struct Interval)));
    
    int count = -1;
    for(int i=0; i<intervalsSize; i++){
        if(count < 0){
            count++;
            result[0].start = intervals[i].start;
            result[0].end = intervals[i].end;
        }else if(result[count].end>= intervals[i].start){
            result[count].end =result[count].end>=intervals[i].end?result[count].end:intervals[i].end;
        }else if(result[count].end < intervals[i].start){
            count++;
            result[count].start = intervals[i].start;
            result[count].end = intervals[i].end;
        }
    }
    (*returnSize) = count+1;
    return result;
}
