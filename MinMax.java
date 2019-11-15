/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Scanner;
/**
 *
 * @author Jidan
 */
public class MinMax {

	static Scanner sc = new Scanner(System.in);

	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int a[];
	static int size;

	static void MaxMin(int i, int j)
	{
		int max1, min1, mid;
		if(i==j)
		{
			max = min = a[i];
		}
		else
		{
			if(i == j-1){   
				if(a[i] < a[j]){
					max = a[j];
					min = a[i];
				}
				else{
					max = a[i];
					min = a[j];
				}
			}

			else{	
				mid = (i+j)/2;
				MaxMin(i, mid);

				max1 = max;   
				min1 = min;
				MaxMin(mid+1, j);
				if(max < max1) max = max1;//update disini
				if(min > min1) min = min1;
			}
		}
	}

	public static void inputArray()
	{
		for(int i=0; i< size; i++){
			a[i] = sc.nextInt();
		}
	}
          public static void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "|");
        }
        System.out.println();
    }

	public static void main(String[] args) {
		System.out.println("Masukkan Jumlah Angka yang ingin diinput : ");
		size = sc.nextInt();
		a = new int[size];
                System.out.println(" Masukkan Angka: ");
		inputArray();
                print();
		MaxMin(0, size-1);
		System.out.println("Nilai Terbesar: "+max+"\nNilai Terkeciil: "+min);
	}

} 