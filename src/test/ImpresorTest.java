package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import refactorizacion.ImpresorLCD;
import refactorizacion.Validator;

public class ImpresorTest {
	
	@BeforeClass
    public static void setUpClass() {
		
    }

	@Before
	public void setUp() throws Exception {
		
	}
	
	public void elaborarPruebaFormula(String entrada, int esperado){
		ImpresorLCD LCD = new ImpresorLCD();
        String[][] salida =LCD.procesar(entrada);
        assertEquals(esperado, salida.length);     
    }

	@Test
	public void ValidacionParametroSinComa() {
		try{
		Validator.validateParams("345345");
		fail();
		}
		catch (IllegalArgumentException e){
			
		}
		
	}
	@Test
	public void ValidacionParametroConDobleComa() {
		try{
		Validator.validateParams("34,53,45");
		fail();
		}
		catch (IllegalArgumentException e){
			
		}
		
	}
	@Test
	public void ValidacionSizeNoNumerico() {
		try{
		Validator.validateParams("a,345345");
		fail();
		}
		catch (IllegalArgumentException e){
			
		}
		
	}
	@Test
	public void ValidacionSizeFueraDeRango() {
		try{
		Validator.validateParams("11,4567");
		fail();
		}
		catch (IllegalArgumentException e){
			
		}
		
	}
	
	@Test
	public void ValidacionFormulaFilas() {
		int filas = 2*3+3;
		elaborarPruebaFormula("3,4546", filas);		
	}
	

}
