package calculadoraSimple;

public class Calculadora {

    public double suma(double numero1, double numero2) {
        return numero1 + numero2;
    }

    public double resta(double numero1, double numero2) {
        return numero1 - numero2;
    }

    public double multiplicacion(double numero1, double numero2) {
        return numero1 * numero2;
    }

    public double division(double numero1, double numero2) {
        if (numero2 == 0) {
            throw new ArithmeticException("¡Operación inválida! No es posible dividir por 0.");
        }
        return numero1 / numero2;
    }
}
