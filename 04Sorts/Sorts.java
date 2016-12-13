public class Sorts {
    
    public static String name() {
        return "06.Last.First";
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp = i;
        a[i] = a[j];
        a[j] = temp;
    }
    
    private static void minIndex(int[] a, int startIndex, int endIndex) {
        int min = a[startIndex];
        int val;
        int index = startIndex;
        for (int i = startIndex + 1; i < endIndex; i++) {
            if ((val = a[i]) < min) {
                min = val;
                index = i;
            }
        }
        return index;
    }
    
    public static void selectionSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            swap(a, i, minIndex(a, i, len));
        }
    }
    
    private static void insertIndex(int[] a, int index) {
        int val = a[index];
        for (int i = index - 1; i >= 0; i--) {
            if (val < a[i]) {
                return i;
            }    
        }
        return index;
    }
    
    private static void insert(int[] a, int index) {
        int insertIndex = insertIndex(index);
        int val = a[index];
        System.arraycopy(a, insertIndex, a, insertIndex + 1, index - insertIndex);
        a[insertIndex] = val;
    }
    
    public static void insertionSort(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            insert(a, i);
        }
    }
    
    private static void quickSort(int[] a, int left, int right) {
        int i = left, j = right;
        int pivot = a[(i + j) / 2];
        int temp;
        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                temp = arr[i];
                a[i++] = arr[j];
                a[j--] = temp;
            }
        }
        if (left < j) {
            sort(a, left, j);
        }
        if (i < right) {
            sort(a, i, right);
        }
    }
    
    public static void quickSort(int[] a) {
        quickSort(a, 0, arr.length - 1);
    }
    
    private static int[] mergeSort(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int aVal;
        int bVal;
        for (int k = 0; k < merged.length; k++) {
            if ((aVal = a[i]) < (bVal = b[j])) {
                merged[k] = aVal;
                i++
            } else {
                merged[k] = bVal;
                j++;
            }
        }
        return merged;
    }
    
    public static void mergeSort(int[] a) {
        int splitIndex = a.length / 2;
        int[] b = Arrays.copyOfRange(a, splitIndex, a.length);
        a = Arrays.copyOfRange(a, 0, splitIndex);
        
    }
    
}
