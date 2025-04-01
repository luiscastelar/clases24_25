package ut9.examen;

import java.util.List;

public interface DAO<E> {
    /** Obtiene el elemento con el id facilitado.
     *
      * @param id Identificador único del elemento
     * @return Devuelve el elemento solicitado o null si no existe
     */
    public E getById(long id);

    /** Obtiene una lista con todos los elementos almacenados.
     *
     * @return Retorna una lista con todos los elementos almacenados. Una lista vacía si no hay elementos o null si no
     * hay almacén.
     */
    public List<E> getAll();

    /** Añade un elemento al almacén.
     *
     * @param entity El elemento a añadir
     * @return true si se realizó o false en otro caso
     */
    public boolean insert(E entity);

    /** Sustituimos un elemento por otro.
     *
     * @param id El identificador del elemento a sustituir
     * @param entity El elemento por el que sustituirlo
     * @return Si se ha sustituido devuelve true.
     */
    public boolean updateById(long id, E entity);

    /** Elimina un elemento.
     *
     * @param id El identificador del elemento a eliminar
     * @return Si se ha eliminado devuelve true.
     */
    public boolean deleteById(long id);

    /** Número de elementos almacenados
     *
     * @return la cantidad de elementos
     */
    public long size();
}
