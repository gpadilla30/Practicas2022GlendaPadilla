/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas_2022;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author sofia
 */
public class ventana extends JFrame{
    usuario usu_sistema [] = new usuario[10];
    JPanel panel_inicio_sesion = new JPanel();
    JPanel panel_control = new JPanel();
    JPanel panel_crear_usu = new JPanel();
    int control = 2;
   
    public ventana(){
        objetos();
        crear_admin();
    }
    
    public void crear_admin(){
      usu_sistema[0] = new usuario();
      usu_sistema[0].nom_usuario = "admin";
      usu_sistema[0].nom = "administrador";
      usu_sistema[0].contra = "123456";
      
      usu_sistema[1] = new usuario();
      usu_sistema[1].nom_usuario = "sofi";
      usu_sistema[1].nom = "sofia";
      usu_sistema[1].contra = "789";
    }
    
    public void objetos(){
        this.getContentPane().add(panel_inicio_sesion);
        panel_inicio_sesion.setLayout(null);
        
        JLabel lbl_login = new JLabel("Login");
        lbl_login.setBounds(20, 7, 100, 15);
        panel_inicio_sesion.add(lbl_login);
        
        JLabel lbl_usu = new JLabel("Usuario");
        lbl_usu.setBounds(60, 40, 100, 15);
        panel_inicio_sesion.add(lbl_usu);
        
        JLabel lbl_contra = new JLabel("Contraseña");
        lbl_contra.setBounds(60, 100, 100, 15);
        panel_inicio_sesion.add(lbl_contra);
        
        JTextField txt_usu = new JTextField();
        txt_usu.setBounds(150, 40, 200, 25);
        panel_inicio_sesion.add(txt_usu);
        
        JPasswordField txt_contra = new JPasswordField();
        txt_contra.setBounds(150, 100, 200, 25);
        panel_inicio_sesion.add(txt_contra);
        
        JButton btn_ingresar = new JButton("Ingresar");
        btn_ingresar.setBounds(120, 145, 180, 35);
        panel_inicio_sesion.add(btn_ingresar);
        ActionListener ingresar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txt_usu.getText().equals("") || txt_contra.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }else{
                    recorrer_usu(txt_usu.getText(), txt_contra.getText());
                }
            }
        };
        btn_ingresar.addActionListener(ingresar);
        
        JButton btn_crear_usu = new JButton("Registrar");
        btn_crear_usu.setBounds(120, 185, 180, 35);
        panel_inicio_sesion.add(btn_crear_usu);
        ActionListener crear_usu = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                crear_usu();
                panel_crear_usu.setVisible(true);
            }
        };
        btn_crear_usu.addActionListener(crear_usu);
    }
    
    public void recorrer_usu(String nom_usu, String contra){
        boolean encontrado = false;
        for(int i = 0; i<10; i++){
            if(usu_sistema[i] != null){
                if(usu_sistema[i].nom_usuario.equals(nom_usu) && usu_sistema[i].contra.equals(contra)){
                    JOptionPane.showMessageDialog(null, "Bienvenido al sistema " + nom_usu);
                    encontrado = true;
                    break;
                }else{
                    encontrado = false;
                }
            }
        }
        if(encontrado == false){
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
    }
    
    public void panel_control(){
        this.getContentPane().add(panel_control);
        panel_control.setLayout(null);
        this.setSize(700, 600);
        this.setTitle("Control Principal");
        panel_inicio_sesion.setVisible(false);
                
        JButton btn_admin_cli = new JButton("Administración de Clientes");
        btn_admin_cli.setBounds(150, 10, 250, 25);
        panel_control.add(btn_admin_cli);
        
        JButton btn_admin_pro = new JButton("Administración de Productos");
        btn_admin_pro.setBounds(150, 80, 250, 25);
        panel_control.add(btn_admin_pro);
        
        JButton btn_rep = new JButton("Reportes");
        btn_rep.setBounds(150, 10, 250, 25);
        panel_control.add(btn_rep);
       
    }
    
    public void crear_usu(){
        this.getContentPane().add(panel_crear_usu);
        panel_crear_usu.setLayout(null);
        this.setSize(500, 450);
        this.setTitle("Registro de nuevo usuario");
        panel_inicio_sesion.setVisible(false);
    
        JLabel lbl_registro = new JLabel("Registro de usuario");
        lbl_registro.setBounds(20, 20, 150, 20);
        panel_crear_usu.add(lbl_registro);
        
        JLabel lbl_usu = new JLabel("Usuario");
        lbl_usu.setBounds(50, 50, 150, 20);
        panel_crear_usu.add(lbl_usu);
        
        JLabel lbl_nom = new JLabel("Nombre");
        lbl_nom.setBounds(50, 100, 150, 20);
        panel_crear_usu.add(lbl_nom);
        
        JLabel lbl_contra = new JLabel("Contraseña");
        lbl_contra.setBounds(50, 150, 150, 20);
        panel_crear_usu.add(lbl_contra);
        
        JLabel lbl_confirmar = new JLabel("Confirmar contraseña");
        lbl_confirmar.setBounds(50, 200, 150, 20);
        panel_crear_usu.add(lbl_confirmar);
        
        JTextField txt_usu = new JTextField();
        txt_usu.setBounds(200, 50, 150, 20);
        panel_crear_usu.add(txt_usu);
        
        JTextField txt_nom = new JTextField();
        txt_nom.setBounds(200, 100, 150, 20);
        panel_crear_usu.add(txt_nom);
        
        JPasswordField txt_contra = new JPasswordField();
        txt_contra.setBounds(200, 150, 150, 20);
        panel_crear_usu.add(txt_contra);
        
        JPasswordField txt_confi_contra = new JPasswordField();
        txt_confi_contra.setBounds(200, 200, 150, 20);
        panel_crear_usu.add(txt_confi_contra);
        
        JButton btn_registrar = new JButton("Registrar");
        btn_registrar.setBounds(130, 280, 200, 35);
        panel_crear_usu.add(btn_registrar);
        ActionListener registro = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txt_usu.getText().equals("") || txt_nom.getText().equals("") || txt_contra.getText().equals("") || txt_confi_contra.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }else{
                    if(txt_contra.getText().equals(txt_confi_contra.getText())){
                        guardar_usu(txt_usu.getText(), txt_usu.getText(), txt_contra.getText());
                        txt_usu.setText("");
                        txt_nom.setText("");
                        txt_contra.setText("");
                        txt_confi_contra.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                    }
                }
            }
            
        };
        btn_registrar.addActionListener(registro);
        
        JButton btn_inicio = new JButton("Inicio");
        btn_inicio.setBounds(130, 350, 200, 35);
        panel_crear_usu.add(btn_inicio);
        ActionListener volver_inicio = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel_inicio_sesion.setVisible(true);
                panel_crear_usu.setVisible(false);
               
            }
        };
        btn_inicio.addActionListener(volver_inicio);
    }
       
    public void guardar_usu(String nom_usu, String nom, String contra){
        int posicion = 0;
        if(control < 10){
            for(int i = 0; i < 9; i++){
                if(usu_sistema[i] == null){
                    posicion = i;
                    break;
                }
            }
            //System.out.println("la pos libre es" + posicion);
            usu_sistema[posicion] = new usuario();
            usu_sistema[posicion].nom_usuario = nom_usu;
            usu_sistema[posicion].nom = nom;
            usu_sistema[posicion].contra = contra;
            control++; 
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
            
        }else{
            JOptionPane.showMessageDialog(null, "No se puede registrar más usuarios");
        }    
    }
}