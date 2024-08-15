/**
 * @file validaciones.c
 * @brief Archivo que contiene las funciones de validacion de los datos ingresados por el usuario.
 */
#include "validaciones.h"

/**
 * @brief Funcion que valida que el dato ingresado por el usuario sea un numero entero.
 * @param mensaje Mensaje a mostrar al usuario.
 * @param rmenor Rango menor del numero.
 * @param rmayor Rango mayor del numero.
 * @return El numero ingresado por el usuario.
 */
int solicitarNumero(char mensaje[25],int rmenor, int rmayor){
    int numero;
    char buffer[100];
    while (1) {
        fgets(buffer, 100, stdin);
        if (sscanf(buffer, "%d", &numero) == 1) {
            if (numero >= rmenor && numero <= rmayor) {
                break;
            }
        }
        printf("%s, recuerda debe ser un numero entre el %d y %d.: \n", mensaje, rmenor, rmayor);
        
    }
    return numero;
}
/**Example:
  int nConductores = solicitarNumero("No es un dato aceptable",1,100);
 */

/**
 * @brief Funcion que valida que el dato ingresado por el usuario sea un numero double.
 * @param mensaje Mensaje a mostrar al usuario.
 * @param rmenor Rango menor del numero.
 * @return El numero ingresado por el usuario.
 */
//Funcion que valida que el dato ingresado por el usuario sea un numero double.*/
double solicitarDouble(char mensaje[25], int rmenor){
    double numero;
    char buffer[100];
    int primera = 0;
    while (1) {
        fgets(buffer, 100, stdin);
        if (sscanf(buffer, "%lf", &numero) == 1) {
            if (numero >= rmenor) {
                break;
            }
        }
        if(primera == 1) printf("%s, recuerda debe ser un numero mayor o igual a %d: \n", mensaje, rmenor);
        primera = 1;
    }
    return numero;
}

/**
  Example: 
  double numero = solicitarDouble("Numero de kilometraje incorrecto",0);
 */

/**
 * @brief Funcion que valida que el dato ingresado por el usuario sea una cadena de caracteres, sin espacios en blanco.
 * @param mensaje Mensaje a mostrar al usuario.
 * @param resultado Variable donde se almacena la cadena de caracteres.
 * @param longitud Longitud maxima de la cadena de caracteres.
 */
//Funcion que valida que el dato ingresado por el usuario sea una cadena de caracteres, sin espacios en blanco.*/
void solicitarString(char mensaje[25], char resultado[], size_t longitud) {
    do {
        fgets(resultado, longitud, stdin);
        // Eliminar el salto de línea al final del string
        resultado[strcspn(resultado, "\n")] = '\0';

        // Verificar si el string es solo un espacio en blanco
        if (strlen(resultado) == 0 || strspn(resultado, " ") == strlen(resultado)) {
            printf("%s",mensaje);
        }
    } while (strlen(resultado) == 0 || strspn(resultado, " ") == strlen(resultado));
}
/**Example:
  char arrayNombres[25]
  solicitarString("\nNo se permite un nombre con espacio al inicio\n",arrayNombres[i],sizeof(arrayNombres[i]));
 */