
public class Main {
	public static void main(String[] args) {
		int[] arr = {56,23,55,1,5754,2,6,57,2,6,7,2,45,75,3,24,25,536,35,3537,78,27,4};
		System.out.println("Final Result");
		mergeSort(arr, 0, arr.length - 1);
		printArray(arr);
		
	}
	
	static void mergeSort(int[] arr, int ini, int end) {
		if(ini < end) {
			int mid = (ini + end) / 2;
			mergeSort(arr, ini, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, ini, mid, end);
		}
	}
	
	static void merge(int[] arr, int ini, int mid, int end) {
		
		int[] temp = new int[end - ini + 1];
		
		int i = ini, j = mid + 1, k = 0;
		
		while(i <= mid && j <= end) {
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				k += 1;
				i += 1;
			}else if(arr[j] <= arr[i]) {
				temp[k] = arr[j];
				k += 1;
				j += 1;
			}
		}
		while(i <= mid) {
			temp[k] = arr[i];
			k += 1;
			i += 1;
		}
		while(j <= end) {
			temp[k] = arr[j];
			k += 1;
			j += 1;
		}
		for(i = ini; i <= end; i += 1) {
			arr[i] = temp[i - ini];
		}
	}

	//Alexey--------------------------------------------------------------------------------------------------------------------------
	public static int[] sort(int[] arr) {
		//Si el array introducido tiene una longitud menor o igual a 1 elemento, esta ordenado
		//y lo podemos devolver sin modificaciones.
		if(arr.length <= 1) {
			return arr;
		}
		
		//Calculamos el punto medio de division del array, utilizando su longitud
		int middle = arr.length / 2;
		
		//Definimos los arrays auxiliares que van a ser usados.
		//Podemos asignar el tama�o del array izquierdo en este paso, ya que este siempre sera
		//de un tama�o medio del array principal introducido.
		int[] leftArr = new int[middle];
		int[] rightArr;
		int[] result = new int[arr.length];
		
		//Para asignar el tama�o al array de la derecha, comprobaremos si el numero de elementos
		//en el array introducido es par o impar, en caso de ser par, podemos asignar el tama�o
		//a ser el mismo que el lado izquiedo. En caso contrario, lo asignamos a alojar
		//un elemento mas que el array izquierdo.
		if(arr.length % 2 == 0) {
			rightArr = new int[middle];
		} else {
			rightArr = new int[middle+1];
		}
		
		//Rellenamos el array izquierdo, utilizando un puntero desde 0 hasta la posicion media.
		for(int i = 0; i < middle; i++) {
			leftArr[i] = arr[i];
		}
		
		//Rellenamos el array derecho, utilizando un puntero desde 0 hasta el tama�o de array
		//derecho. En este caso, para no introducir elementos repetidos del array principal,
		//usaremos "middle + 1" para extraer el elemendo deseado.
		for(int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[middle + i];
		}
		
		//Asignamos el array izquierdo y derecho al resultado de llamar este propio metodo de
		//nuevo, hasta que el tama�o de ambos sea de 1 y se de el caso base de devolver el 
		//propio array sin modificaciones.
		leftArr = sort(leftArr);
		rightArr = sort(rightArr);
		
		//Una vez llegado al caso base, el resultado se obtiene mediante la mezcla de los dos
		//arrays derecho e izquierdo.
		result = merge(leftArr, rightArr);
		
		//Devolvemos el array obtenido, en este caso, sera un array de paso a ser dividido una
		//vez mas, ya que este caso no es el caso base.
		return result;
	}
	
	public static int[] merge(int[] leftArr, int[] rightArr) {
		//Inicializamos el array resultado, que sera del tama�o de la suma de los tama�os
		//de los arrays derecho e izquierdo
		int[] result = new int[leftArr.length + rightArr.length];
		
		//Inicializamos los punteros auxiliares para navegar los arrays.
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		
		//Este codigo se ejecuta en bucle mientras existan datos en alguno de los 2 arrays.
		while(leftPointer < leftArr.length || rightPointer < rightArr.length) {
			
			//Comprobamos si ambos arrays tienen elementos que no hayan sido accedidos por el 
			//puntero.
			if(leftPointer < leftArr.length && rightPointer < rightArr.length) {
				if(leftArr[leftPointer] < rightArr[rightPointer]) {
					result[resultPointer++] = leftArr[leftPointer++];
				} else {
					result[resultPointer++] = rightArr[rightPointer++];
				}
				
			//En el caso de que existan elementos restantes en alguno de los lados, estos se
			//a�aden al array resultado.
			} else if (leftPointer < leftArr.length){
				result[resultPointer++] = leftArr[leftPointer++];
			} else if (rightPointer < rightArr.length) {
				result[resultPointer++] = rightArr[rightPointer++];
			}
		}
		
		//Devolvemos el resultado, el cual sera ya un array mezclado y ordenado correctamente.
		return result;
	}
	
	//Metodo auxiliar de impresion de array.
	public static void printArray(int[] arr) {
		if(arr.length == 0) {
			System.out.println("Empty");
			return;
		} else if(arr.length == 1) {
			System.out.println("[" + arr[0] + "]");
		} else {
			for(int i = 0; i < arr.length; i++) {
				if(i == 0) {
					System.out.print("[" + arr[i] + ", ");
				} else if(i == arr.length-1) {
					System.out.print(arr[i] + "]");
				} else {
					System.out.print(arr[i] + ", ");
				}
			}
			
			System.out.println();
		}
		
	}

}