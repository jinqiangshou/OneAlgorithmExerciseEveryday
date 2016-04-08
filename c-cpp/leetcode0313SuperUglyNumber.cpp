/******************************************Question********************************************
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers 
 * given primes = [2, 7, 13, 19] of size 4.
 * 
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 **********************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-04-08
 **/
class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        vector<int> result; // ugly number array
        result.push_back(1);
        int num = primes.size(); // size of parameter 'primes'

        vector<int> index(num, 0);
        // every ugly number is the product of a prime and a previous ugly number
        // vector 'index' records the position of each prime's multiplier

        while(result.size() < n)
        {
            int next = result[index[0]] * primes[0];   // next super ugly number
            for(int i = 0; i < num; i++) // calculate next ugly number
            {
                next = min(next, result[index[i]] * primes[i]);
            }
            for(int i = 0; i < num; i++) // update index
            {
                if(next == result[index[i]] * primes[i])
                {
                    index[i]++;
                }
            }
            result.push_back(next);
        }

        return result[n-1];
    }
};
