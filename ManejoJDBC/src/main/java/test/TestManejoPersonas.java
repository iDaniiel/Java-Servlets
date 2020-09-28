package test;

import domain.Persona;
import domain.PersonaDAO;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();

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
        Persona personaEliminar = new Persona(6, "Karla", "Rangel", "karla.rangel@mail.com.mx", "45781245");
        personaDAO.elimina(personaEliminar);

        List<Persona> personasEliminadas = personaDAO.seleccionar();
        personasEliminadas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
