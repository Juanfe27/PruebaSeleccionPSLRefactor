package refactorizacion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImpresorLCD {

    // Puntos fijos
    private final int[] pf1;
    private final int[] pf2;
    private final int[] pf3;
    private final int[] pf4;
    private final int[] pf5;
    private String[][] matriz;

    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
 
    private int size;
    private int filas;
    private int totalColumnas;
    private int columnaDigito;

    public ImpresorLCD() {
        // Inicializa variables
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
    }
    
    /**
    *
    * Metodo encargado de procesar la entrada que contiene el size del segmento
    * de los digitos y los digitos a imprimir
    *
    * @param comando Entrada que contiene el size del segmento de los digito
    * y el numero a imprimir
    * @return String[][] devuelve la matriz para ser dibujada en el tester
    */  
   public String[][] procesar(String comando) {      
       String[] parametros = Validator.validateParams(comando);
       this.size = Integer.parseInt(parametros[0]);
       establecerParametros(parametros[1]);
       obtenerMatriz(parametros[1]);
       return this.matriz;
   }   

   
   /**
    * Método encargado de calcular las filas y columnas totales de la matriz, luego la inicializa y establece
    * las coordenadas de fila de los puntos fijos, siempre se mantienen para cada uno de los números.
    * @param numeroImp El número que se quiere dibujar
    * @param espacio El espacio que separa cada uno de los números
    */
   
   public void establecerParametros(String numeroImp){
	 
       this.filas = (2 * this.size) + 3;      
       this.columnaDigito = this.size+2;
       this.totalColumnas = ((this.columnaDigito + 2)*numeroImp.length()) + (numeroImp.length());
       this.matriz = new String[this.filas][this.totalColumnas];
       for (int i = 0; i < this.filas; i++) 
       {
           for (int j = 0; j < this.totalColumnas; j++) 
           {
               this.matriz[i][j] = " ";
           }
       }         
       this.pf1[0] = 0;
       this.pf2[0] = (this.filas/2);
       this.pf3[0] = (this.filas -1);
       this.pf4[0] = (this.columnaDigito -1);
       this.pf5[0] = 0;
   }
   
   /**
   * Metodo encargado de devolver la matriz que contiene el numero deseado, calculando para cada uno de ellos
   * las coordenadas de puntos fijos para columnas
   *
   * @param numeroImp Numero a Imprimir
   * @param espacio Espacio Entre digitos
   */    
  private void obtenerMatriz(String numeroImp) 
  {
      int pivotX = 0;
      char[] digitos;
      digitos = numeroImp.toCharArray();      
      for (char digito : digitos) {          
          Validator.validateDigit(digito);
          int numero = Integer.parseInt(String.valueOf(digito));
          this.pf1[1] = pivotX;          
          this.pf2[1] = pivotX;
          this.pf3[1] = pivotX;
          this.pf4[1] = (this.filas / 2) + pivotX;
          this.pf5[1] = (this.columnaDigito - 1) + pivotX;
          pivotX = pivotX + this.columnaDigito + 1;
          adicionarDigito(numero);
      }
  }
  
  /**
  *
  * Metodo encargado de definir los segmentos que componen un digito y
  * a partir de los segmentos adicionar la representacion del digito a la matriz
  *
  * @param numero Digito
  */
 private void adicionarDigito(int numero) {
     
     List<Integer> segList = new ArrayList<>();
     switch (numero) {
         case 1:
             segList.add(3);
             segList.add(4);
             break;
         case 2:
             segList.add(5);
             segList.add(3);
             segList.add(6);
             segList.add(2);
             segList.add(7);
             break;
         case 3:
             segList.add(5);
             segList.add(3);
             segList.add(6);
             segList.add(4);
             segList.add(7);
             break;
         case 4:
             segList.add(1);
             segList.add(6);
             segList.add(3);
             segList.add(4);
             break;
         case 5:
             segList.add(5);
             segList.add(1);
             segList.add(6);
             segList.add(4);
             segList.add(7);
             break;
         case 6:
             segList.add(5);
             segList.add(1);
             segList.add(6);
             segList.add(2);
             segList.add(7);
             segList.add(4);
             break;
         case 7:
             segList.add(5);
             segList.add(3);
             segList.add(4);
             break;
         case 8:
             segList.add(1);
             segList.add(2);
             segList.add(3);
             segList.add(4);
             segList.add(5);
             segList.add(6);
             segList.add(7);
             break;
         case 9:
             segList.add(1);
             segList.add(3);
             segList.add(4);
             segList.add(5);
             segList.add(6);
             segList.add(7);
             break;
         case 0:
             segList.add(1);
             segList.add(2);
             segList.add(3);
             segList.add(4);
             segList.add(5);
             segList.add(7);
             break;
         default:
             break;
     }

     Iterator<Integer> iterator = segList.iterator();
     while (iterator.hasNext()) 
     {
         adicionarSegmento(iterator.next());
     }
 }
 
 /**
 *
 * Metodo encargado de agregar un segmento a la matriz de Impresion
 *
 * @param segmento Segmento a adicionar
 */  
private void adicionarSegmento(int segmento) {

    switch (segmento) {
        case 1:
            adicionarLinea(this.pf1, CARACTER_VERTICAL);
            break;
        case 2:
            adicionarLinea(this.pf2, CARACTER_VERTICAL);
            break;
        case 3:
            adicionarLinea(this.pf5, CARACTER_VERTICAL);
            break;
        case 4:
            adicionarLinea(this.pf4, CARACTER_VERTICAL);
            break;
        case 5:
            adicionarLinea(this.pf1, CARACTER_HORIZONTAL);
            break;
        case 6:
            adicionarLinea(this.pf2, CARACTER_HORIZONTAL);
            break;
        case 7:
            adicionarLinea(this.pf3, CARACTER_HORIZONTAL);
            break;
        default:
            break;
    }
}

    /**
     *
     * Metodo encargado de aÃ±adir una linea a la matriz de Impresion
     *
     * @param punto Punto Pivote
     * @param caracter Caracter Segmento, representa si es horizontal o vertical
     */    
    private void adicionarLinea(int[] punto, String caracter) {

        if (caracter.equalsIgnoreCase(CARACTER_HORIZONTAL)) 
        {
            for (int y = 1; y <= this.size; y++) 
            {
                int valor = punto[1] + y;
                this.matriz[punto[0]][valor] = caracter;
            }
        } 
        else 
        {
            for (int i = 1; i <= this.size; i++) 
            {
                int valor = punto[0] + i;
                this.matriz[valor][punto[1]] = caracter;
            }
        }
    }         

}
