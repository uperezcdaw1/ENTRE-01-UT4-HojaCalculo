
/**
 *  Representa a una fila de la hoja de cálculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author - 
 *  
 */
public class Fila
{   
    //Atributos
    //Variables
    private String id;
    private Fecha fecha;
    private double ingresos;
    private double gastos;
    //Constantes
    //Métodos
    /**
     * Constructor  
     */
    public Fila(String id)    {
         this.ingresos = 0;
         this.gastos = 0;
         this.id = id;
         this.fecha = new Fecha(1,1,2000);
    }

    /**
     * Constructor  
     */
    public Fila(String id, Fecha fecha, double ingresos, double gastos)    {
        this.id = id;
        this.fecha = fecha;
        this.ingresos = ingresos;
        this.gastos = gastos;
    }
    
    /**
     * accesor para el id de la fila
     */
    public String getId() {
        return this.id;

    }


    /**
     * accesor para la fecha
     */
    public Fecha getFecha() {
        return this.fecha;

    }

    /**
     * accesor para los ingresos
     */
    public double getIngresos() {
        return this.ingresos;

    }

    /**
     * accesor para los gastos
     */
    public double getGastos() {
        return this.gastos;

    }

    /**
     * calcula y devuelve el beneficio
     */
    public double getBeneficio() {
        return this.ingresos - this.gastos;

    }
    
    /**
     * obtiene una copia idéntica a la fila actual.
     * La fecha que incluye la fila duplicada también es una copia
     * 
     */
    public Fila duplicar() {

       return new Fila(id, fecha, ingresos, gastos);
       
    }

    /**
     * Representación textual de una fila
     * (leer enunciado)
     */
    public String toString() {
      String fila = id;
      Fecha dia = fecha;
      double ingresar = ingresos;
      double gastar = gastos;
      double beneficio = ingresos - gastos;
      String patron = ("%8s %15s %15.2f %15.2f %15.2f");
      String resultado = String.format(patron,fila,dia,ingresar,gastar,beneficio);
      System.out.println(resultado);
      return " ";
    }
    

}
