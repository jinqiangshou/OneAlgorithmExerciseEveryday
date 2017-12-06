/**************************************Question***************************************
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.
 *
 * Example:
 * Given n = 2, return 91. 
 * (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 *************************************************************************************/

/**
 * @author Horst Xu
 * @date 2017-12-06
 */
int countNumbersWithUniqueDigits(int n) {
    int result = 0;
    if (n > 10) {
        n = 10;
    }
    if (n >= 0) {
        result += 1;
    }
    if (n >= 1) {
        result += 9;
    }
    int curr = 0;
    int prev = 9;
    for (int i = 2; i <= n; i++) {
        curr = prev * (11 - i);
        result += curr;
        prev = curr;
    }
    return result;
}
