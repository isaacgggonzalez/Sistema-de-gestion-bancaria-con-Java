package modelo.exceptions;

/**
 * La clase SaldoInsuficienteException representa una excepción lanzada cuando se intenta realizar una operación
 * y el saldo en la cuenta es insuficiente.
 */
public class SaldoInsuficienteException extends Exception{
    /**
     * Constructor de la clase SaldoInsuficienteException.
     *
     * @param msg Mensaje que describe la razón de la excepción.
     */
    public SaldoInsuficienteException(String msg){
        super(msg);
    }
}
