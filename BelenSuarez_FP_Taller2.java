import java.util.Scanner;

public class BelenSuarez_FP_Taller2 {

  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    
    int asientosDisponibles = 150; 
    boolean continuar = true;

    System.out.println("=================================================");
    System.out.println(" SISTEMA DE RESERVAS DE VUELOS - BIENVENIDO  ");
    System.out.println("=================================================");

    while (continuar && asientosDisponibles > 0) {
      
      // 1. Solicitar P, HF y TB
      System.out.print("\nIngrese nombre y apellido del pasajero (P): ");
      String pasajero = teclado.nextLine();

      System.out.print("Ingrese las horas faltantes para el vuelo (HF): ");
      int horasFaltantes = teclado.nextInt();

      // 2. Si HF > 24
      if (horasFaltantes > 24) {
        
        // 2.1. Si AD > 0
        if (asientosDisponibles > 0) {
          
          System.out.println("Seleccione el tipo de boleto (TB):");
          System.out.println("1. Nacional");
          System.out.println("2. Internacional");
          System.out.print("Opción: ");
          int tipoBoleto = teclado.nextInt();
          
          // 2.1.1. Determinar ruta (R)
          String ruta = "";
          if (tipoBoleto == 1) {
            ruta = "Guayaquil - Quito";
          } else {
            ruta = "Guayaquil - Miami";
          }

          // 2.1.2. Solicitar CM y PE
          System.out.print("Ingrese cantidad de maletas (CM): ");
          int cantidadMaletas = teclado.nextInt();

          System.out.print("Ingrese peso del equipaje en kg (PE): ");
          double pesoEquipaje = teclado.nextDouble();

          // 2.1.3. Si CM <= 2 y PE <= 23
          if (cantidadMaletas <= 2 && pesoEquipaje <= 23.0) {
            
            // 2.1.3.1. AD = AD - 1
            asientosDisponibles = asientosDisponibles - 1;
            
            // 2.1.3.2. Mostrar Reserva Exitosa
            System.out.println("\n-------------------------------------------------");
            System.out.println("¡Reserva Exitosa para: " + pasajero);
            System.out.println("Ruta: " + ruta);
            System.out.println("Asientos disponibles: " + asientosDisponibles);
            System.out.println("-------------------------------------------------");
            
          } else {
            // 2.1.4. En caso contrario
            System.out.println("\n[ERROR] Rechazado por equipaje");
          }

        } else {
          // 2.2. En caso contrario
          System.out.println("\n[ERROR] Sin Asientos");
        }

      } else {
        // 3. En caso contrario
        System.out.println("\n[ERROR] Tiempo Insuficiente");
      }

      teclado.nextLine(); 
      System.out.print("\n¿Desea registrar otra reserva? (S/N): ");
      String respuesta = teclado.nextLine();
      if (respuesta.equalsIgnoreCase("N")) {
        continuar = false;
      }
    }

    System.out.println("\n=================================================");
    System.out.println("Programa finalizado.");
    System.out.println("=================================================");
    teclado.close();
  }
}
