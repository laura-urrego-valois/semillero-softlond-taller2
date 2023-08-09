package conversorMonedas;

public class ConversorMonedas {

    private static final double USD_EUR = 0.91;
    private static final double COP_USD = 4090.52;

    public static <T extends Number> double convertirDolaresAEuros(T valorEnDolares) {
        double cantidad = valorEnDolares.doubleValue();
        double resultado = cantidad * USD_EUR;
        double resultadoRedondeado = Math.round(resultado * 10.0) / 10.0;
        return resultadoRedondeado;
    }

    public static <T extends Number> double convertirPesosColombianosADolares(T valorEnPesosColombianos) {
        double cantidad = valorEnPesosColombianos.doubleValue();
        double resultado = cantidad / COP_USD;
        double resultadoRedondeado = Math.round(resultado * 10.0) / 10.0;
        return resultadoRedondeado;
    }
}
