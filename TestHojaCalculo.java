
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - 
 *  
 */
public class TestHojaCalculo
{
    //Atributos
    //Variables
    //Constantes
    //Metodos
    /**
     * Constructor  
     */
    public TestHojaCalculo()    {

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el constructor por defecto
     * de fila (el que no tiene parámetros)
     */
    public void test1() {
        HojaCalculo Hoja1 = new HojaCalculo("HOJA1");
        Fecha fecha1 = new Fecha(4,10,2020);
        Fecha fecha2 = new Fecha(5,10,2020);
        Fecha fecha3 = new Fecha(1,1,2020);
        Hoja1.addFila("Fila1",fecha1,25.5,132);
        Hoja1.addFila("Fila2",fecha2,300,350);
        Hoja1.addFila("Fila3",fecha3,0,0);
        Hoja1.addFila("Fila4",fecha1,25.5,132);

        System.out.println(Hoja1.toString());
        System.out.println(Hoja1.duplicarHoja());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        HojaCalculo Hoja2 = new HojaCalculo("HOJA2");
        Fecha fecha1 = new Fecha(7,10,2020);
        Fecha fecha2 = new Fecha(8,10,2020);
        Hoja2.addFila("Fila1",fecha1,260,125);
        Hoja2.addFila("Fila2",fecha2,125,245);

        System.out.println(Hoja2.toString());
        System.out.println(Hoja2.duplicarHoja());

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        HojaCalculo Hoja3 = new HojaCalculo("HOJA3");
        Fecha fecha1 = new Fecha(8,10,2020);
        Hoja3.addFila("Fila1",fecha1,670,234);

        System.out.println(Hoja3.toString());
        System.out.println(Hoja3.duplicarHoja());
    }

}
