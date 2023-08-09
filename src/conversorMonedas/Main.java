package conversorMonedas;

public class Main {

    public static void main(String[] args) {

        double valorEnDolares = 100.0;
        double valorEnPesosColombianos = 100000.0;

        double conversionEnEuros = ConversorMonedas.convertirDolaresAEuros(valorEnDolares);
        double conversionEnDolares = ConversorMonedas.convertirPesosColombianosADolares(valorEnPesosColombianos);

        System.out.println("CONVERSIÓN DE DIVISAS");
        System.out.println(valorEnDolares + " dólares estadounidenses equivalen a " + conversionEnEuros + " euros.");
        System.out.println(valorEnPesosColombianos + " pesos colombianos equivalen a " + conversionEnDolares + " dólares estadounidenses.");

    }
}
