package calculadoraSimple;

public class Main {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        double numero1 = 50.0;
        double numero2 = 10.0;

        System.out.println("OPERACIONES CALCULADORA");
        System.out.println("Operación suma +");
        System.out.println("El resultado de la suma es --> " + calculadora.suma(numero1, numero2));
        System.out.println("Operación resta -");
        System.out.println("El resultado de la resta es -->  " + calculadora.resta(numero1, numero2));
        System.out.println("Operación multiplicación x");
        System.out.println("El resultado de la multiplicación es -->  " + calculadora.multiplicacion(numero1, numero2));
        System.out.println("Operación división /");
        try {
            System.out.println("El resultado de la división es -->  " + calculadora.division(numero1, numero2));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
