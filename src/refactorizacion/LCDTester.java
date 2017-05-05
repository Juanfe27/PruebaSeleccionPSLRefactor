package refactorizacion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        String comando;        
        try {
            try (Scanner lector = new Scanner(System.in)) {                
                do
                {
                    System.out.print("Entrada: ");
                    comando = lector.nextLine();
                    if(!comando.equalsIgnoreCase(CADENA_FINAL))
                    {
                        listaComando.add(comando.replace(" ", ""));
                    }
                }while (!comando.equalsIgnoreCase(CADENA_FINAL)); 
            }

            ImpresorLCD impresorLCD = new ImpresorLCD();
            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) 
            {
                try 
                {
                    imprimirNumero(impresorLCD.procesar(iterator.next()));
                } catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        } catch (Exception ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }

    }
    
    public static void imprimirNumero(String[][] matriz){
    	// Imprime matriz
        for (int i = 0; i < matriz.length; i++) 
        {
            for (int j = 0; j < matriz[i].length; j++) 
            {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    	
    }

}
