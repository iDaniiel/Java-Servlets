package test;

import datos.IPersonaDAO;
import domain.PersonaDTO;
import datos.PersonaDAOJDBC;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        IPersonaDAO personaDao = new PersonaDAOJDBC();
        
        List<PersonaDTO> persona = personaDao.select();
        persona.forEach(per -> {
            System.out.println("persona" + per);
        });
        //insertar nuevo objeto de tipo persona
//        Persona personaNueva = new Persona("Karla", "Sosa", "karla@mail.com", "45781245");
//        personaDAO.insertar(personaNueva);
//
//        List<Persona> personas = personaDAO.seleccionar();
//        personas.forEach(persona -> {
//            System.out.println("persona = " + persona);
//        });
//        Persona personaModificar = new Persona(6, "Karla","Rangel", "karla.rangel@mail.com.mx","45781245");
//        personaDAO.actualiza(personaModificar);
//
//        List<Persona> personasActualizadas = personaDAO.seleccionar();
//        personasActualizadas.forEach(persona -> {
//            System.out.println("persona = " + persona);
//        });
//        PersonaDTO personaEliminar = new PersonaDTO(6, "Karla", "Rangel", "karla.rangel@mail.com.mx", "45781245");
//        personaDAO.delete(personaEliminar);
//
//        List<PersonaDTO> personasEliminadas = personaDAO.select();
//        personasEliminadas.forEach(persona -> {
//            System.out.println("persona = " + persona);
//        });
    }
}
