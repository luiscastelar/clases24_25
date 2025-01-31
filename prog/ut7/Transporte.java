package ut7.examen;

/** Examen POO-2, parte 1:
 *
 * EMPRESA DE TRANSPORTES:
 *
 * Se pide desarrollar el medio de `Transporte` de tipo `Autobus`, de forma que, además de desempeñar su cometido, podamos
 * ordenarlos según la `CAPACIDAD` de transporte, como es natural.
 *
 * También nos gustaría poder ordenarlos ordenar por la `AUTONOMIA` del mismo (distancia máxima que puede recorrer).
 *
 * Para probar nuestra clase deberemos crear una clase `Principal` donde deberás crear una lista desordenada de `Autobus`es
 * y utilizar los métodos oportunos para desempeñar las funciones solicitadas.
 *
 * Rúbrica:
 *  + Implementación: 1p
 *  + Orden natural: 2p
 *  + OrdenarPorAutonomia: 1p
 *  + Mostrar resultados (main): 1p
 *  No hay medios puntos. O realiza lo que se pide o no obtienes puntuación correspondiente a esa la funcionalidad.
 *  
 *  La clase principal debe llamarse Main.
 *
 *  Tenéis hasta las 18:15 del 31 de enero para realizar el commit. Será ignorado cualquier commit posterior.
 *  Deberéis etiquetar el commit como POO-2-parte1 (`git tag POO-2-parte1`) y los archivos deberán ubicarse en
 *  `REPO/prog/examenes/src/main/java/ut7/`. Asegúrate de subir el tag con el comando `git push --tag`.
 */
public interface Transporte {
    /** Marcamos el destino siguiente (no el final)
     *
     * @param parada Siguiente parada (nombre de calle, aeropuerto, estación o puerto)
     * @param distancia Los kilometros hasta la siguiente parada
     * @return Si ha conseguido llegar o se ha estropeado (por si es un tren de extremadura)
     */
    public boolean ir(String parada, int distancia);

    /** Solicitud de subida de pasajeros
     *
     * @param suben Los que quieren subir.
     * @return Los que suben en realidad. Puede que se llene y no puedan subir todos.
     */
    public int cargar(int suben);

    /** Solicitud de badaja de pasajeros
     *
     * @param bajan Los que compraron billete para ese destino.
     * @return Los que bajan en ese destino. Puede que alguno se haya bajado antes.
     */
    public int descargar(int bajan);
}
