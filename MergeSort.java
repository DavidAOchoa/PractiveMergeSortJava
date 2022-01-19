import java.util.Scanner;

public class MergeSort {
     // Merges two subarrays of arr[]
    // First subarray is arr[1..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int sizeOne = m - l + 1;
        int sizeTwo = r - m;

        // Create temp arrays
        int L[] = new int[sizeOne];
        int R[] = new int[sizeTwo];

        // Copy data to temp arrays
        for (int i = 0; i < sizeOne; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < sizeTwo; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while ( i < sizeOne && j < sizeTwo)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < sizeOne)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of r[] if any
        while (j < sizeTwo)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // find the middle point
            int m = l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        

        Scanner sc = new Scanner(System.in);
        System.out.println("Specify a length for the array");
        
        int length = sc.nextInt();
        int arr[] = new int[length];
        System.out.println("This is the length you specified: " + length);
        System.out.println("Enter the values of your array.");
        
        for(int i = 0; i < length; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
        printArray(arr);  
    }
}
