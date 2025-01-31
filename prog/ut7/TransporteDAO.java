package ut7.examen;
import java.util.List;

/** Examen POO-2, parte 2:
 *
 * EMPRESA DE TRANSPORTES:
 *
 * Debes Implementar el DAO proporcionado. Atento/a a la documentación facilitada en el DAO.
 *
 * Rúbrica: 1 punto por metodo correctamente implementado. No hay medios puntos.
 *
 *  Tenéis hasta las 19:35 del 31 de enero para realizar el commit. Será ignorado cualquier commit posterior.
 *  Deberéis etiquetar el commit como POO-2-parte2 (`git tag POO-2-parte2`) y los archivos deberán ubicarse en
 *  `REPO/prog/examenes/src/main/java/ut7/`. Asegúrate de subir el tag con el comando `git push --tag`.
 *
 */
public interface TransporteDAO {
    /** Obtiene el elemento con id proporcionado
     *
     * @param id long
     * @return Elemento
     */
    public Transporte get(long id);

    /** Obtiene una lista con TODOS los elementos almacenados
     *
     * @return List<Transporte>
     */
    public List<Transporte> getAll();

    /** Elimina el elemento con id proporcionado
     *
     * @param id long
     * @return Boolean true si éxito. False en cualquier otro caso
     */
    public boolean delete(long id);

    /** Añadimos un elemento a nuestra "base de datos"
     *
     * @param transporte Elemento a añadir
     * @return long con el id del elemento
     */
    public long insert(Transporte transporte);

    /** Devuelve el número actual de elementos
     *
     * @return long con la cantidad de elementos. No es el id más alto, ni el siguiente id, es la cantidad de elementos
     * que tiene nuestro DAO.
     */
    public long size();
}
