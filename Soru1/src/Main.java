import java.util.Random;
// dizi icinde en buyuk sayıyı bulmak icin ben quick sort algıoritmasini kullanirdim en verimli üc algoritmadan biri oldugu icin  en basta
//kodu derledigimzide bruteforce'ın quicksorta göre küçük dizilerde daha hızlı daha verimli çalıştıgını goruyoruz 
//ancak dizinin boyutunu daha buyuk yaparsak quick sortun daha verimli calistigini gorecegiz.
public class Main {
    public static void main(String[] args) {
        //10000 elemanli bir dizi oluşturduk
        Random random = new Random();
        int[] dizi = new int[10000];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = random.nextInt();
        }

        // QuickSort algoritmasi ile en buyuk sayiyi bulma islemi
        long ilk = System.currentTimeMillis();
        int maxsayi = quickSortMaxSayi(dizi);
        long son = System.currentTimeMillis();
        System.out.println("QuickSort algoritmasi ile en buyuk sayi: " + maxsayi);
        System.out.println("QuickSort algoritmasinin calisma suresi: " + (son - ilk) + " ms");

        // BruteForce algoritması ile en buyuk sayiyi bulma
        ilk = System.currentTimeMillis();
        maxsayi = bruteForceMaxSayi(dizi);  //en buyuk sayiyi aliyor
        son = System.currentTimeMillis();
        System.out.println("BruteForce algoritmasi ile en buyuk sayi: " + maxsayi); //yazdirma islemi
        System.out.println("BruteForce algoritmasinin calisma suresi: " + (son - ilk) + " ms");
    }

    // QuickSort algoritmasi ile en buyuk sayiyi bulan fonksiyon
    public static int quickSortMaxSayi(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr[arr.length - 1];
    }

    private static void quickSort(int[] dizi, int low, int high) {
        if (low < high) {
            int pivotI = siralama(dizi, low, high);
            quickSort(dizi, low, pivotI - 1);
            quickSort(dizi, pivotI + 1, high);
        }
    }

    private static int siralama(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                gecici(arr, i, j);
            }
        }
        gecici(arr, i + 1, high);
        return i + 1;
    }

    private static void gecici(int[] arr, int i, int j) { //gecici 
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // BruteForce(kaba kuvvet) algoritması ile en buyuk sayiyi bulan fonksiyon 
    public static int bruteForceMaxSayi(int[] dizi) {
        int max = dizi[0];
        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] > max) {
                max = dizi[i];
            }
        }
        return max;
    }
}
