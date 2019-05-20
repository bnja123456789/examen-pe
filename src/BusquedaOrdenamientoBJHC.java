
import java.util.Arrays;
import java.util.Scanner;


public class BusquedaOrdenamientoBJHC {

    
    public static void main(String[] args) {
        System.out.println("INGRESE LA OPCIÓN DEL ALGORITMO QUE DESEA PROBAR");
        Scanner leer=new Scanner(System.in);
        int opcion =leer.nextInt();
        while (opcion!=0) {            
            switch(opcion){
            case 1: imprimirBusquedaBinariaRecursivaBJHC(); break;
            case 2: imprimirOrdenamientoRecursivoBJHC();break;
                  default: System.out.println("Opción Inválida!!");break;
            }  
            System.out.println("\nINGRESE LA OPCIÓN DEL ALGORITMO QUE DESEA PROBAR");            
            opcion =leer.nextInt();
        }
    }
	public static int busca(int[] array, int chave) {
		return buscaBinariaRecursivaBJHC(array, 0, array.length - 1, chave);
	}
	public static int buscaBinariaRecursivaBJHC(int[] array, int menor, int maior,int chave) {
		int media = (maior + menor) / 2;
		int valorMeio = array[media];

		if (menor > maior)
			return -1;
		else if(valorMeio == chave) 
			return media;
		else if (valorMeio < chave)
			return buscaBinariaRecursivaBJHC(array, media+1, maior, chave);
		else
			return buscaBinariaRecursivaBJHC(array, menor, media-1, chave);
	}
        public static void imprimirBusquedaBinariaRecursivaBJHC() {
            int[] array = { 1, 8, 34, 67, 9, 6, 78, 12, 56, 41, 90 };
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
                System.out.println("Tamaño: "+array.length);
		System.out.println("El numero 6 esta en la posicion: "+busca(array, 6));
		System.out.println("El numero 78 esta en la posicion: "+busca(array, 78));
		System.out.println("El numero 90 esta en la posicion: "+busca(array, 90));
    }
        public  static int vec[]={20,12,28,24,8,4,16};
        public static void imprimirOrdenamientoRecursivoBJHC() {
                System.out.println("Vector original");
                imprimirVector(vec);
                ordenacionRapida(vec);
                System.out.println("\nVector ordenado");
                imprimirVector(vec);
        }
        public static void ordenacionRapida(int vec[]){
                int N=vec.length;
                quickSortBJHC(vec, 0, N-1);
        }
        public static void quickSortBJHC(int vec[], int inicio, int fin){
                if(inicio>=fin) return;
                int pivote=vec[inicio];
                int elemIzq=inicio+1;
                int elemDer=fin;
                while(elemIzq<=elemDer){
                        while(elemIzq<=fin && vec[elemIzq]<pivote){
                                elemIzq++;
                        }
                        while(elemDer>inicio && vec[elemDer]>=pivote){
                                elemDer--;
                        }
                        if(elemIzq<elemDer){
                                int temp=vec[elemIzq];
                                vec[elemIzq]=vec[elemDer];
                                vec[elemDer]=temp;
                        }
                }
                
                if(elemDer>inicio){
                        int temp=vec[inicio];
                        vec[inicio]=vec[elemDer];
                        vec[elemDer]=temp;
                }
                quickSortBJHC(vec, inicio, elemDer-1);
                quickSortBJHC(vec, elemDer+1, fin);
        }
        public static void imprimirVector(int vec[]){
                for(int i=0;i<vec.length;i++){
                        System.out.print(vec[i]+" ");
                }
        }
    }
    

