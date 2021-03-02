import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IngresoAgenda extends JPanel implements ActionListener
{
   private JButton btnIngresar, btnCancelar;
   private JTextField txtUser;
   private JPasswordField contra;
   
   public IngresoAgenda()
   {
      setLayout(new GridLayout(3,2));
      JLabel lblUser = new JLabel("Usuario",JLabel.RIGHT);
      txtUser = new JTextField(20);
      add(lblUser);
      add(txtUser);
   
      JLabel lblContra = new JLabel("Contraseña",JLabel.RIGHT);
      contra = new JPasswordField(20);
      contra.setToolTipText("Ingrese Contraseña");
      add(lblContra);
      add(contra);
   
      btnIngresar = new JButton ("Ingresar");
      btnIngresar.addActionListener(this);
      btnCancelar = new JButton ("Cancelar");
      btnCancelar.addActionListener(this);
   
      add(btnIngresar);
      add(btnCancelar);
   
   }
   
   public void actionPerformed(ActionEvent e)
   {
      String usuario = txtUser.getText();
      String password = new String(contra.getPassword());
   
      if(e.getSource() == btnIngresar)
      {
         if(usuario.isEmpty() && password.isEmpty())
         {
            JOptionPane.showMessageDialog(null,"Ingrese su nombre de usuario y contraseña");
            txtUser.requestFocus();
         }
         else 
         {
            if(usuario.equals("Link") && password.equals("1234"))
            {
               JOptionPane.showMessageDialog(null, "Bienvenido");
               DatosAgenda datos = new DatosAgenda();
               setVisible(false);
            }
            else
            {
               JOptionPane.showMessageDialog(null,"Usuario o Password incorrecto", 
                  "Warning",JOptionPane.WARNING_MESSAGE);
               txtUser.setText(null);
               contra.setText(null);
               txtUser.requestFocus();
            }
         }
      }//if aceptar
      
      if(e.getSource() == btnCancelar){
         System.exit(0);
      }
   }
}