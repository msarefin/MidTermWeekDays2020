package algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sort extends helper {

    long executionTime = 0;
    /*
     * Please implement all the sorting algorithm. Feel free to add helper methods.
     * Store all the sorted data into one of the databases.
     */


    public int[] selectionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;

        for (int j = 0; j < array.length - 1; j++) {
            int min = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] insertionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        for (int i = 1; i < array.length; i++) {
            int t = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > t) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = t;
        }


        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] bubbleSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] mergeSort(int[] array) {
        long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here

        mSort(array);

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    final void mSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];
            for (int i = 0; i < arr.length; i++) {
                if (i < mid) {
                    left[i] = arr[i];
                } else {
                    right[i - mid] = arr[i];
                }
            }
            mSort(left);
            mSort(right);

            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }
            while (i < left.length) {
                arr[k++] = left[i++];
            }
            while (j < right.length) {
                arr[k++] = right[j++];
            }
        }
    }

    public int[] quickSort(int[] array) {
        long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        qSort(array, 0, array.length - 1);
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    final void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = new Random().nextInt((high - low) + 1) + low;
            swap(arr, pivotIndex, high);
            int b = low;
            for (int i = b; i < high; i++) {
                if (arr[i] < arr[high]) {
                    swap(arr, i, b++);
                }
            }
            swap(arr, b, high);
            qSort(arr, low, b - 1);
            qSort(arr, b + 1, high);
        }
    }

    public int[] heapSort(int[] array) {
        long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        int n = array.length;
        for (int p = (n - 1) / 2; p >= 0; p--) {
            heapify(array, n, p);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    final void heapify(int[] arr, int n, int i) {
        int highest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[highest]) {
            highest = l;
        }
        if (r < n && arr[r] > arr[highest]) {
            highest = r;
        }
        if (i != highest) {
            swap(arr, i, highest);
            heapify(arr, n, highest);
        }
    }

    public int[] bucketSort(int[] array) {
        long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        int neg = 0;
        int pos = 0;
        for (int n : array) {
            if (n < 0) {
                neg++;
            } else {
                pos++;
            }
        }

        List[] nBucket = null;
        List[] pBucket = null;

        if (neg > 0) {
            int nb = (int) sqrt(neg);
            nBucket = new List[nb];

            for (int i = 0; i < nBucket.length; i++) {
                nBucket[i] = new ArrayList();
            }
            int min = 0;
            for (int n : array) {
                if (min > n) {
                    min = n;
                }
            }

            for (int n : array) {
                if (n < 0) {
                    int bi = (n * nBucket.length) / (min - 1);
                    nBucket[bi].add(n);
                }
            }

            for (List nbkt : nBucket) {
                for (int i = 1; i < nbkt.size(); i++) {
                    int t = (int) nbkt.get(i);
                    int j = i - 1;
                    while (j >= 0 && (int) nbkt.get(j) > t) {
                        nbkt.set(j + 1, nbkt.get(j));
                        j--;
                    }
                    nbkt.set(j + 1, t);
                }
            }


        }

        if (pos > 0) {
            int pb = (int) sqrt(pos);
            pBucket = new List[pb];

            for (int i = 0; i < pBucket.length; i++) {
                pBucket[i] = new ArrayList();
            }

            int max = 0;
            for (int n : array) {
                if (max < n) {
                    max = n;
                }
            }
            for (int n : array) {
                if (n >= 0) {
                    int bi = (n * nBucket.length) / (max + 1);
                    pBucket[bi].add(n);
                }
            }

            for (List pbkt : pBucket) {
                for (int i = 1; i < pbkt.size(); i++) {
                    int t = (int) pbkt.get(i);
                    int j = i - 1;
                    while (j >= 0 && (int) pbkt.get(j) > t) {
                        pbkt.set(j + 1, pbkt.get(j));
                        j--;
                    }
                    pbkt.set(j + 1, t);
                }

            }
        }

        int index = 0;

        if (nBucket != null) {
            for (int i = nBucket.length - 1; i >= 0; i--) {
                for (int j = 0; j < nBucket[i].size(); j++) {
                    array[index++] = (int) nBucket[i].get(j);
                }
            }
        }
        if (pBucket != null) {
            for (List pbkt : pBucket) {
                for (int i = 0; i < pbkt.size(); i++) {
                    array[index++] = (int) pbkt.get(i);
                }
            }
        }


        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] shellSort(int[] array) {
        long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here

        int n = array.length;
        for (int g = n / 2; g > 0; g /= 2) {
            for (int i = g; i < n; i++) {
                int t = array[i];
                int j = i;
                while (j >= g && array[j - g] > t) {
                    array[j] = array[j - g];
                    j -= g;
                }
                array[j] = t;
            }
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public static void printSortedArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

class helper {

    int[] initialize(int[] a) {
        int[] arr = null;
        if (a == null || a.length == 0) {
            arr = new int[10];
            Random r = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextInt(100);
            }
        } else {
            arr = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                arr[i] = a[i];
            }
        }

        return arr;
    }

    final void swap(int[] arr, int m, int n) {
        int t = arr[m];
        arr[m] = arr[n];
        arr[n] = t;
    }

    final void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    final double sqrt(double n) {
        double t;
        double sq = n / 2;
        do {
            t = sq;
            sq = (t + (n / t)) / 2;
        } while ((t - sq) != 0);
        return sq;
    }
}