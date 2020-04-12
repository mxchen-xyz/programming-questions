package 剑指Offer.数组;

/**
 * @author 梦仙尘
 * @create 2020-03-28 20:17
 */
public class 数组中重复的数字 {
    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
     * 那么对应的输出是第一个重复的数字2。
     */
    // Parameters:
    //    numbers:     一个Int数组
    //    length:      数组的长度
    //    duplication: （输出）数组中的重复数，重复arr的长度
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       如果输入有效，并且数组num中有一些重复，则为true
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i = 0;i< length;i++){
            int index = numbers[i];//值对应位的坐标
            if(index>=length){
                index -= length;
            }
            if( numbers[index]>=length){
                duplication[0] = index;
                return true;
            }
            numbers[index] = numbers[index] + length;
        }
        return false;
    }
}
