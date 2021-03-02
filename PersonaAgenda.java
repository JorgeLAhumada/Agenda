public class PersonaAgenda {
   private String Nombre;
   private String Telefono;
   private String Cumpleaños;
   private String Correo;
   
   public String getNombre(){
      return Nombre;
   }
   
   public void setNombre(String nombre){
      this.Nombre = nombre;
   }
   
   public String getTelefono(){
      return Telefono;
   }
   
   public void setTelefono(String telefono){
      this.Telefono = telefono;
   }
   
   public String getCumpleaños(){
      return Cumpleaños;
   }
   
   public void setCumpleaños(String cumpleaños){
      this.Cumpleaños = cumpleaños;
   }
   
   public String getCorreo(){
      return Correo;
   }
   
   public void setCorreo(String correo){
      this.Correo = correo;
   }
  
}