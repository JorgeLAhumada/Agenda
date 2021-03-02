import java.util.*;
public class ManejoPersona
{
   static ArrayList<PersonaAgenda> Arrperson = new ArrayList<PersonaAgenda>(); 
   private PersonaAgenda objPersona;
   
   public ManejoPersona()
   {  }
   
   public void agregar(String nom,String tel, String cum, String cor)
   {
      objPersona = new PersonaAgenda();
      objPersona.setNombre(nom);
      objPersona.setTelefono(tel);
      objPersona.setCumpleaños(cum);
      objPersona.setCorreo(cor);
      Arrperson.add(objPersona);//Agrega el objeto al arraylist
   }
   
   public ArrayList datos() //metodo que regresa el arrayList
   {
      return Arrperson;
   }
   
   public void mostrar()
   {
      System.out.println("... Datos guardados en la agenda ...");
      Iterator<PersonaAgenda> itrPersonaAgenda = Arrperson.iterator();
      while(itrPersonaAgenda.hasNext()){
         PersonaAgenda persona = itrPersonaAgenda.next();
         System.out.println(persona.getNombre() + "  "
            + persona.getTelefono() + "  "
            + persona.getCumpleaños()+ " "
            + persona.getCorreo());
      }
   }
}