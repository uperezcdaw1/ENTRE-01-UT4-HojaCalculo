
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -   
 *  
 */
public class HojaCalculo
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila1 = null;
        this.fila1 = null;

    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;

    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1() {
        return fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return fila3;

    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int contador = 0;
        if(this.fila1 != null){
            contador ++;
        }
        if(this.fila2 != null){
            contador ++;
        }
        if(this.fila3 != null){
            contador ++;
        }
        return contador;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if(getNumeroFilas() == 3){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(hojaCompleta() == true){
            System.out.println("No puedes añadir más filas, la hoja está completa");
        } else if (this.fila1 == null){
            fila1 = new Fila("fila1");
        } else if (this.fila2 == null){
            fila2 = new Fila("fila2");
        } else if (this.fila3 == null){
            fila3 = new Fila("fila3");
        }

    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        if(hojaCompleta() == true){
            System.out.println("No puedes añadir más filas, la hoja está completa");
        } else if (this.fila1 == null){
            fila1 = new Fila(id, fecha, ingresos, gastos);
        } else if (this.fila2 == null){
            fila2 = new Fila(id, fecha, ingresos, gastos);
        } else if (this.fila3 == null){
            fila3 = new Fila(id, fecha, ingresos, gastos);
        }
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double totalIngresos = 0.0;
        if(fila1 != null){
            totalIngresos = fila1.getIngresos();
        }
        if(fila2 != null){
            totalIngresos = fila1.getIngresos() + fila2.getIngresos();
        }
        if(fila3 != null){
            totalIngresos = fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos();
        }
        return totalIngresos; 
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double totalGastos = 0.0;
        if(fila1 != null){
            totalGastos = fila1.getGastos();
        }
        if(fila2 != null){
            totalGastos = fila1.getGastos() + fila2.getGastos();
        }
        if(fila3 != null){
            totalGastos = fila1.getGastos() + fila2.getGastos() + fila3.getGastos();
        }
        return totalGastos; 
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        return getTotalIngresos() - getTotalGastos();
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        if(getNumeroFilas() > 3){
            System.out.println("No se puede añadir fila4 a la hoja" + getNombre());
        }
        
        //Variables para la suma de ingresos, gastos y beneficios
        double beneficiosTotal = getBeneficio();
        double ingresosTotal = getTotalIngresos();
        double gastosTotal = getTotalGastos();
        String dinero = "€";
        String patron = ("%40.2f%s %16.2f%s %17.2f%s");
        String resultado = String.format(patron, ingresosTotal, dinero, gastosTotal, dinero, beneficiosTotal, dinero);
        
        if(getNumeroFilas() == 1){  
            System.out.println(nombre + "\n");
            System.out.println(fila1.toString() 
                + "\n-----------------------------------------------------------------------"
                + "\n" + resultado);
            }
        if(getNumeroFilas() == 2){
            System.out.println(nombre + "\n");
            System.out.println(fila1.toString() + "\n" + fila2.toString() 
                + "\n-----------------------------------------------------------------------"
                + "\n" + resultado);
            }
        if(getNumeroFilas() == 3){
            System.out.println(nombre + "\n");
            System.out.println(fila1.toString() + "\n" + fila2.toString() + "\n" + fila3.toString()
                + "\n-----------------------------------------------------------------------"
                + "\n" + resultado);
        }
        return "";
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo hojaDuplicada = new HojaCalculo("Duplicada");
        if(getNumeroFilas() == 1){
            Fila duplicadaFila1 = fila1.duplicar();
            hojaDuplicada.addFila(duplicadaFila1);
        }
        if(getNumeroFilas() == 2){
            Fila duplicadaFila2 = fila2.duplicar();
            hojaDuplicada.addFila(duplicadaFila2);
        }
        if(getNumeroFilas() == 3){
            Fila duplicadaFila3 = fila3.duplicar();
            hojaDuplicada.addFila(duplicadaFila3);
        }
        return hojaDuplicada;
    }

}
