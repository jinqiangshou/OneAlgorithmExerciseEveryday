/*************************Question*******************************
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 ****************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-03
 * @desc We input two subarrays, one is from A[Astart] to A[Astart+Alen-1], the other
 *       is from B[Bstart] to B[Bstart+Blen-1]. Both of A and B are sorted arrays and
 *       we require Alen <= Blen. The function returns the r'th smallest value after 
 *       combining the two subarrays.
 */
var findNumberRankR = function(A, Astart, Alen, B, Bstart, Blen, r){   
    if(Alen === 0){
        return B[Bstart+r-1];
    }
    if(r === 1){
        return (A[Astart] < B[Bstart])?(A[Astart]):(B[Bstart]);
    }
    var Apos = Astart+((Alen<parseInt(r/2))?(Alen):(parseInt(r/2)));
    var Bpos = Bstart+r-Apos+Astart;
    if(A[Apos-1]<B[Bpos-1]){
        if(Alen-Apos+Astart<Blen){
            return findNumberRankR(A, Apos, Alen-Apos+Astart, B, Bstart, Blen, r-Apos+Astart);
        }else{
            return findNumberRankR(B, Bstart, Blen, A, Apos, Alen-Apos+Astart, r-Apos+Astart);
        }
    }else if(A[Apos-1]>B[Bpos-1]){
        if(Alen<Blen-Bpos+Bstart){
            return findNumberRankR(A, Astart, Alen, B, Bpos, Blen-Bpos+Bstart, r-Bpos+Bstart);
        }else{
            return findNumberRankR(B, Bpos, Blen-Bpos+Bstart, A, Astart, Alen, r-Bpos+Bstart);
        }
    }else{
        return A[Apos-1];
    }
};

/**
 * @author Horst Xu
 * @date 2015-04-03
 * @param {number[]} A
 * @param {number[]} B
 * @return {number}
 */
var findMedianSortedArrays = function(A, B) {
    var Alen = A.length;
    var Blen = B.length;
    var first, second;
    if((Alen+Blen)%2 === 0){
        if(Alen<=Blen){
            first = findNumberRankR(A,0, Alen, B, 0, Blen, (Alen+Blen)/2);
            second = findNumberRankR(A, 0, Alen, B, 0, Blen, (Alen+Blen+2)/2);
            return (first+second)/2.0;
        }else{
            first = findNumberRankR(B, 0, Blen, A, 0, Alen, (Alen+Blen)/2);
            second = findNumberRankR(B, 0, Blen, A, 0, Alen, (Alen+Blen+2)/2);
            return (first+second)/2.0;
        }
    }else{
        if(Alen<=Blen){
            return findNumberRankR(A, 0, Alen, B, 0, Blen, (Alen+Blen+1)/2);
        }else{
            return findNumberRankR(B, 0, Blen, A, 0, Alen, (Alen+Blen+1)/2);
        }
    }
};
