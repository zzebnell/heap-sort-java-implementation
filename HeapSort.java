public class HeapSort {

   public int[] heapSort(int[] A) {
      return heapSort(A, A.length);
   }

   private int[] heapSort(int[] A, int n) {
      buildMaxHeap(A, n);

      for (int i = n - 1; i >= 1; i--) {
         swap(A, 0, i);
         n = n - 1;
         maxHeapify(A, 0, n);
      }

      return A;
   }

   private void maxHeapify(int[] A, int i, int n) {
      int l = left(i);
      int r = right(i);
      int largest;

      if ((l < n) && (A[l] > A[i])) {
         largest = l;   
      } else {
         largest = i;
      }

      if ((r < n) && (A[r] > A[largest])) {
         largest = r;
      }

      if (largest != i) {
         swap(A, i, largest);
         maxHeapify(A, largest, n);
      }
   }

   private void buildMaxHeap(int[] A, int n) {
      for (int i = (n / 2) - 1; i >= 0; i--) {
         maxHeapify(A, i, n);
      }
   }

   private int left(int i) {
      return (2 * (i + 1)) - 1;
   }

   private int right(int i) {
      return left(i) + 1;
   }

   private void swap(int[] A, int i, int j) {
      int aux = A[i];
      A[i] = A[j];
      A[j] = aux;
   }

}