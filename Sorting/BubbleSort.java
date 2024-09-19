import java.util.*;
class BubbleSort{
  public static void main(String[] args){
    int size;
    int c=0;
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the size of array: ");
    size=sc.nextInt();
    int[] arr=new int[size];
    System.out.print("Enter the Elements: ");
    for(int i=0;i<size;i++){
        int element;
        element=sc.nextInt();
        arr[c]=element;
        c++;
    }

    System.out.println("Before Sorting");
    for(int i=0;i<size;i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
    for(int i=0;i<size;i++){
        for(int j=0;j<size-i-1;j++){
              if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
              }
        }
    }

    System.out.println("After Sorting: ");
    for(int i=0;i<size;i++){
        System.out.print(arr[i]+" ");
    }
  }
}
