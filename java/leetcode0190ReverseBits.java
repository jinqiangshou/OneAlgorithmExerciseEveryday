/* ********************************Question************************************
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * ****************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-12-07
 * */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long result = 0L;
        for(int i=0;i<32;i++){
            if((n & 0x1) == 1){
                result = (result << 1)+1;
            }else{
                result = (result << 1);
            }
            n = (n >> 1);
        }
        return (int)result;
    }
}
