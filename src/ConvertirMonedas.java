public class ConvertirMonedas {
   private double valor;
   private String monedaInicial;
   private String monedaFinal;
   private Moneda moneda;

   public ConvertirMonedas(double valor, String monedaInicial, String monedaFinal, Moneda moneda){
      this.valor = valor;
      this.monedaInicial = monedaInicial;
      this.monedaFinal = monedaFinal;
      this.moneda = moneda;

   }
  ;
   public double convertirMoneda (){

      return this.valor*resolverValor(this.monedaFinal);
      }
   private double resolverValor (String valor){
      switch (valor){
         case "ARS":
            return moneda.ARS();
         case "BOB":
            return moneda.BOB();
         case "BRL":
            return moneda.BRL();
         case "CLP":
            return moneda.CLP();
         case "COP":
            return moneda.COP();
         case "USD":
            return moneda.USD();
         default:
            return 0.0;
      }


   }
}
