import java.util.Arrays;
import java.util.Random;
/*
veri siralama
brute force  en kötü zamanda n^2 karmaşıklığına sahiptir
quick sort en kötü zman karmaşıklığı n logn'dir
performans açısından en iyilerden biri olan quick sort bir pivot deger alarak elemanları en hızlı sekilde siralar
brute force ise her elemanı tum diziyi kontrol edrek siralar bu yuzden performans acisindan quick sort daha verimlidir
*/
public class SortKarilastimasi {
  
  public static void main(String[] args) {
    int[] dizi = new int[10000];
    Random rand = new Random();
    for (int i = 0; i < dizi.length; i++) {
      dizi[i] = rand.nextInt(10000);
    }
    
    int[] dizi1 = Arrays.copyOf(dizi, dizi.length);
    long ilk = System.currentTimeMillis();
    quickSort(dizi1, 0, dizi1.length-1);
    long son = System.currentTimeMillis();
    long sure = son - ilk;
    System.out.println("Quicksort calisma suresi: " + sure + " ms");
    
    int[] arrCopy2 = Arrays.copyOf(dizi, dizi.length);
    ilk = System.currentTimeMillis();
    bruteForceSort(arrCopy2);
    son = System.currentTimeMillis();
    sure = son - ilk;
    System.out.println("Brute force calisma suresi: " + sure + " ms");
  }
  
  public static void quickSort(int[] arr, int left, int right) {
    if (left < right) {
      int pivotIndex = siralama(arr, left, right);
      quickSort(arr, left, pivotIndex-1);
      quickSort(arr, pivotIndex+1, right);
    }
  }
  
  public static int siralama(int[] dizi, int left, int right) {
    int pivotdeger = dizi[right];
    int i = left-1;
    for (int j = left; j < right; j++) {
      if (dizi[j] <= pivotdeger) {
        i++;
        int gecici = dizi[i];
        dizi[i] = dizi[j];
        dizi[j] = gecici;
      }
    }
    int gecici = dizi[i+1];
    dizi[i+1] = dizi[right];
    dizi[right] = gecici;
    return i+1;
  }
  
  public static void bruteForceSort(int[] dizi) {
    for (int i = 0; i < dizi.length; i++) {
      for (int j = i+1; j < dizi.length; j++) {
        if (dizi[i] > dizi[j]) {
          int temp = dizi[i];
          dizi[i] = dizi[j];
          dizi[j] = temp;
        }
      }
    }
  }
  
}


