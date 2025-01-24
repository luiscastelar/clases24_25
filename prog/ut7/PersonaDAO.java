package ut7.dao;

import ut7.herencia.personas.Persona;

import java.util.List;

public interface PersonaDAO {
    /** Obtiene la persona con id proporcionado
     *
     * @param id long
     * @return Persona
     */
    public Persona getPersona(long id);

    /** Obtiene una lista con TODAS las personas almacenadas
     *
     * @return List<Persona>
     */
    public List<Persona> getAll();

    /** Actualiza los datos de la persona con id proporcionado
     *
      * @param id long
     * @param persona Persona a modificar
     * @return Boolean true si éxito. False en cualquier otro caso
     */
    public boolean updatePersona(long id, Persona persona);

    /** Elimina la persona con id proporcionado
     *
     * @param id long
     * @return Boolean true si éxito. False en cualquier otro caso
     */
    public boolean deletePersona(long id);

    /** Añadimos una persona a nuestra "base de datos"
     *
     * @param persona Persona a añadir
     * @return long con el id de la persona
     */
    public long insertPersona(Persona persona);
}
