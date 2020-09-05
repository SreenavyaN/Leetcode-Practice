public class removeElement {
    public static void main(String args[]){
        int[] arr = {1};
        int elementToRemove = 1;
        int len = removeElement(arr,elementToRemove);
        for(int i = 0 ; i < len ; i++)
            System.out.print(arr[i]);
    }
    public static int removeElement(int[] arr, int elem)
    {
        if(arr.length == 0)
            return 0;

        int count = 0;
        int i = 0 ;
        do
        {
            if(arr[i] == elem) {
                arr = remove(arr,i,count);
                count++;
            }
            else
                i++;
        }while(i < arr.length -count);
        return arr.length - count;
    }
    public static int[] remove(int[] arr, int indexToRemove,int count){
        while(indexToRemove < arr.length - count - 1) {
            arr[indexToRemove] = arr[indexToRemove + 1];
            indexToRemove++;
        }
        return arr;
    }
}