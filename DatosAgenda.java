import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DatosAgenda extends JFrame implements ActionListener{

   JTextField Nombre, Telefono, Correo, Cumpleaños,txtAccion;
   JLabel lblNom, lblTel, lblCorreo, lblCumpleaños,lblAccion;
   JPanel panel;
   JButton btnGuardar,btnBuscar,btnBorrar,btnModificar;
   ArrayList<PersonaAgenda> datosPer = new ArrayList<PersonaAgenda>();
   JTable tabla;
   JScrollPane scroll = new JScrollPane();
   ManejoPersona mp = new ManejoPersona();
   
   
   public DatosAgenda(){
   
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      initComponents();
   }
  
   private void initComponents(){
      setSize(500,300);
      setTitle("Agenda");
      lblNom = new JLabel("Nombre(s): ",SwingConstants.RIGHT);
      lblNom.setText("Nombre: ");
      Nombre = new JTextField(15);
      lblTel = new JLabel("Telefono: ",SwingConstants.RIGHT);
      Telefono = new JTextField(15);
      lblCorreo = new JLabel("Correo: ",SwingConstants.RIGHT);
      Correo = new JTextField(15);
      lblCumpleaños = new JLabel("Cumpleaños: ",SwingConstants.RIGHT);
      Cumpleaños = new JTextField(15);
      btnGuardar = new JButton("Guardar");
      btnBuscar = new JButton("Buscar");
      btnBorrar = new JButton("Borrar");
      btnModificar = new JButton("Modificaar");
      txtAccion = new JTextField(20);
      lblAccion = new JLabel("Escriba el nombre y elija buscar,borrar o modificar",SwingConstants.RIGHT);
      panel = new JPanel(new GridLayout(7,2,3,3));
      panel.add(lblNom);
      panel.add(Nombre);
      
      panel.add(lblTel);
      panel.add(Telefono);
      
      panel.add(lblCumpleaños);
      panel.add(Cumpleaños);
      
      panel.add(lblCorreo);
      panel.add(Correo);
      
      panel.add(btnGuardar);
      btnGuardar.addActionListener(this);
      
      panel.add(btnBuscar);
      btnBuscar.addActionListener(this);
      
      panel.add(btnBorrar);
      panel.add(btnModificar);
      
      panel.add(lblAccion);
      panel.add(txtAccion);
      
      this.getContentPane().add(panel);
      //setResizable(false);
      setVisible(true);
      
      datosPer = mp.datos();
      String titulos [] = {"Nombre", "Teléfono", "Cumpleaños","Correo" };
      String info[][] = obtenerDatos();
      setLayout(new GridLayout(1,1));
     
      tabla = new JTable(info, titulos);
      tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      scroll.setViewportView(tabla);
      add(scroll);
        
   }
   
   public void Mostrardatos(){
      datosPer = mp.datos();
      String titulos [] = {"Nombre", "Teléfono","Cumpleaños","Correo" };
      String info[][] = obtenerDatos();
      setLayout(new GridLayout(1,1));
      setResizable(false);
     
      tabla = new JTable(info,titulos);
      tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      scroll.setViewportView(tabla);
      add(scroll);  
   }
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource()==btnGuardar){
         if (Nombre.getText()==null||Nombre.getText().isEmpty())
         { 
            JOptionPane.showMessageDialog(null, "Debes colocar al menos el nombre",
               "Aviso", JOptionPane.INFORMATION_MESSAGE);
            Nombre.requestFocus();
         
         }
         else
            if(Telefono.getText()==null||Telefono.getText().isEmpty()) 
            {
               JOptionPane.showMessageDialog(null, "Debes capturar su teléfono",
                  "Aviso", JOptionPane.INFORMATION_MESSAGE);
               Telefono.requestFocus();
            }
            else
            {  
               mp.agregar(Nombre.getText(), Telefono.getText(),Cumpleaños.getText(), Correo.getText());
               JOptionPane.showMessageDialog(null, "Datos Guardados",
                  "Aviso", JOptionPane.INFORMATION_MESSAGE);
               Nombre.setText(null);		
               Telefono.setText("");
               Cumpleaños.setText("");
               Correo.setText("");
               Mostrardatos();
               Nombre.requestFocus();
            }  
      }
      else
         if(e.getSource()==btnBuscar){
            String info[][] = obtenerDatos();
            if(txtAccion.getText().isEmpty()){
               JOptionPane.showMessageDialog(null, "ingrese algun dato para buscar",
                     "Aviso", JOptionPane.INFORMATION_MESSAGE);
               txtAccion.setText("");
            
            }
            else
               for(int y=0; y<datosPer.size(); y++){
                  if(txtAccion.getText().equals(info[y][0])){
                     JOptionPane.showMessageDialog(null, "el dato se encuentra en la agenda",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                     txtAccion.setText("");
                     txtAccion.requestFocus();
                  } 
               }                            
         }
         else 
            if(e.getSource()==btnBorrar){
            
               
            }
         
   }
   
   private String[][] obtenerDatos()
   {
      int x=0;
      String informacion[][] = new String[datosPer.size()][4];
      Iterator<PersonaAgenda> itrPersonaAgenda = datosPer.iterator();
      while(itrPersonaAgenda.hasNext()){
         PersonaAgenda persona = itrPersonaAgenda.next();
         informacion[x][0] = persona.getNombre();
         informacion[x][1] = persona.getTelefono();
         informacion[x][2] = persona.getCumpleaños();
         informacion[x][3] = persona.getCorreo();
         x++;
      }
      return informacion;
   }
      
   
}