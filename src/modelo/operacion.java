package modelo;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class operacion extends Resultados {
    private String operador;
    private String resultado;

    // Constructor con parámetros
    public operacion(String numero1, String numero2, String operador, String resultado) {
        super(numero1, numero2);
        this.operador = operador;
        this.resultado = resultado;
    }

    // Getters y Setters para el operador y el resultado
    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public void agregar() {
        guardarEnArchivo();
    }

    private void guardarEnArchivo() {
        String datos = getNumero1() + System.lineSeparator() +
                       getOperador() + System.lineSeparator() +
                       getNumero2() + System.lineSeparator() +
                       getResultado() + System.lineSeparator() +
                       "NUEVO" + System.lineSeparator();

        try (FileWriter escritura = new FileWriter("bitacoraCalculadora.txt", true)) {
            escritura.write(datos);
        } catch (IOException excepcion) {
            excepcion.printStackTrace();
        }
    }
    
    private void leerEnArchivo() {
        try (FileReader lector = new FileReader("bitacoraCalculadora.txt");
             BufferedReader lectura = new BufferedReader(lector)) {
             
            String linea;
            while ((linea = lectura.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException excepcion) {
            excepcion.printStackTrace();
        }
    }
}
//}












    
