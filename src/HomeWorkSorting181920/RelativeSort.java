package HomeWorkSorting181920;

import java.util.Arrays;
import java.util.Comparator;

public class RelativeSort {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] outputArray = new int[arr1.length];

        int[] countingArray  = new int[1001];

        for(int i=0;i<arr1.length;i++)
        {
            countingArray[arr1[i]] = countingArray[arr1[i]] + 1;
        }

        int outputArrayIndex = 0;


        for(int i=0;i<arr2.length;i++)
        {
            while(countingArray[arr2[i]]>0)
            {
                outputArray[outputArrayIndex] = arr2[i];
                outputArrayIndex++;
                countingArray[arr2[i]] = countingArray[arr2[i]] - 1;
            }
        }

        for(int i=0;i<countingArray.length;i++)
        {
            while(countingArray[i]>0)
            {
                outputArray[outputArrayIndex] = i;
                outputArrayIndex++;
                countingArray[i] = countingArray[i] -1;
            }

        }


        return outputArray;
    }
}
