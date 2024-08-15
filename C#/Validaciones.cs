public class Validations
{
  /// <summary>
  /// Método para usar en consola y forzar al usuario a seleccionar una opción del menú
  /// </summary>
  /// <param name="mensaje"></param>
  /// <param name="nMin"></param>
  /// <param name="nMax"></param>
  /// <returns></returns>
  public static short GetMenuOption(String mensaje, int nMin, int nMax)
  {
    while (true)
    {
      Console.WriteLine(mensaje);

      if (short.TryParse(Console.ReadLine(), out short opcion))
      {
        if (opcion >= nMin && opcion <= nMax) return opcion;
      }
      Console.WriteLine("Error: Ingrese un número entero que se encuentre entre los valores." + nMin + " y " + nMax);
    }
  }

  /// <summary>
  /// Método para usar en consola y forzar al usuario a ingresar un número
  /// </summary>
  /// <param name="mensaje"></param>
  /// <returns></returns>
  public static int GetInt(String mensaje)
  {
    while (true)
    {
      Console.WriteLine(mensaje);

      if (int.TryParse(Console.ReadLine(), out int temperatura))
      {
        return temperatura;
      }
      Console.WriteLine("Error: Ingrese un número válido.");
    }
  }

  /// <summary>
  /// Método para usar en consola y forzar al usuario a ingresar un número
  /// </summary>
  /// <param name="mensaje"></param>
  /// <returns></returns>
  /// </summary>
  /// <param name="mensaje"></param>
  /// <returns></returns>
  public static double GetDouble(String mensaje)
  {
    while (true)
    {
      Console.WriteLine(mensaje);

      if (double.TryParse(Console.ReadLine(), out double temperatura))
      {
        return temperatura;
      }
      Console.WriteLine("Error: Ingrese un número válido.");
    }
  }
}