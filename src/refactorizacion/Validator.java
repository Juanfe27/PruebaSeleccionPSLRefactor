package refactorizacion;

public class Validator {
	

    /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param cadena Cadena
     */ 
	public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
	
	   
	  /**
	   * Método utilizado para validar que el tamaño ingresado por el usuario sea un número y que se encuentre entre 1 y 10
	   * @param size El tamaño ingresado por el usuario para el número que se quiere mostrar
	   */
	   
	  public static String[] validateParams(String comando){
		  String[] parametros;
	      if (!comando.contains(",")) 
	      {
	          throw new IllegalArgumentException("Cadena " + comando + " no contiene caracter ','");
	      }       
	      parametros = comando.split(",");       
	      //Valida la cantidad de parametros
	      if(parametros.length>2 || parametros.length<2)
	      {
	         throw new IllegalArgumentException("Cadena " + comando + " contiene mas caracter ',' o no contiene los parámetros requeridos"); 
	      }
		   
	      if(Validator.isNumeric(parametros[0]))
	      {
	          int tam = Integer.parseInt(parametros[0]);           
	          if(tam <1 || tam >10)
	          {
	              throw new IllegalArgumentException("El parametro size ["+tam+"] debe estar entre 1 y 10");
	          }
	      }
	      else
	      {
	          throw new IllegalArgumentException("Parametro Size [" + parametros[0] + "] no es un numero");
	      }   
	      return parametros;
	  }
	  
	  /**
	   * Método que valida si el digito corresponde a un numero
	   * @param digito Digito a validar
	   */
	  
	  public static void validateDigit(char digito){
		  if( ! Character.isDigit(digito))
          {
              throw new IllegalArgumentException("Caracter " + digito + " no es un digito");
          }
	  }

}
