package chc.test.jianzhioffer;

public class InversePairs {

    public double Pairs = 0;
    public int InversePairs(int [] array) {
        if (array.length==0 ||array==null)
            return 0;
        mergesort(array,0,array.length-1);
        Pairs = Pairs + 1000000007;
        return (int) (Pairs % 1000000007);
    }
    public void merge(int []array,int left,int mid,int right){
        //有一点很重要的是，归并分成两部分，其中一段是left到mid，第二段是mid+1到right。
        //不能从0到mid-1，然后mid到right。因为这样左右不均分，会出错。千万注意。
        //mid=(left+right)/2
        if (array.length==0 ||array==null ||left>=right)
            return ;
        int p=left,q=mid+1,k=0;

        int []temp=new int[right-left+1];

        while (p<=mid && q<=right){
            if(array[p]>array[q]){
                temp[k++]=array[q++];
                //当前半数组中有一个数p比后半个数组中的一个数q大时，由于两个数组
                //已经分别有序，所以说明p到中间数之间的所有数都比q大。
                Pairs+=mid-p+1;
            }
            else temp[k++]=array[p++];
        }

        while (p<=mid){
            temp[k++]=array[p++];}
        while (q<=right){
            temp[k++]=array[q++];}

        for (int m = 0; m < temp.length; m++)
            array[left + m] = temp[m];

    }

    public void mergesort(int []arr,int left,int right){
        if (arr.length==0 ||arr==null)
            return ;
        int mid=(right+left)/2;
        if(left<right) {
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left,mid, right);
        }
    }
}
