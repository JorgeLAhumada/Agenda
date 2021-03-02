import javax.swing.*;
import java.awt.*;

public class JFrameIngresoAgenda extends JFrame
{
   IngresoAgenda pss = new IngresoAgenda();

   public JFrameIngresoAgenda()
   {  super.dispose();
      initComponents();
   }

   private void initComponents() 
   {
      super.dispose();
      setSize(300,200);
      setTitle("Login - Usuario y Contraseña");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setContentPane(pss);
      setVisible(true);
   }
}