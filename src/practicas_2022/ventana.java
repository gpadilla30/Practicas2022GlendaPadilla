/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas_2022;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.String.valueOf;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author sofia
 */
public class ventana extends JFrame{
    usuario usu_sistema [] = new usuario[10];
    JPanel panel_inicio_sesion;
    JPanel panel_control;
    JPanel panel_crear_usu;
    int control = 2;
    cliente clientes[] = new cliente[100];
    int control_cli = 0;
    JPanel panel_control_cli;
    int control_clientes = 2;
   
    public ventana(){
        objetos();
        crear_admin();
        crear_cli();
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
    public void crear_cli(){
        clientes[0] = new cliente();
        clientes[0].nom = "cli_1";
        clientes[0].edad = 22;
        clientes[0].genero = 'M';
        clientes[0].nit = 150;
        
        clientes[1] = new cliente();
        clientes[1].nom = "cli_2";
        clientes[1].edad = 22;
        clientes[1].genero = 'M';
        clientes[1].nit = 300;
    }
    
    public void objetos(){
        panel_inicio_sesion = new JPanel();
        this.getContentPane().add(panel_inicio_sesion);
        panel_inicio_sesion.setLayout(null);
        this.setSize(500, 400);
        this.setTitle("Sistema administrativo de clientes y recursos");
        
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
        btn_ingresar.setBounds(400, 40, 180, 35);
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
        btn_crear_usu.setBounds(400, 85, 180, 35);
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
                    panel_control();
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
        panel_control = new JPanel();
        this.getContentPane().add(panel_control);
        panel_control.setLayout(null);
        this.setSize(450, 200);
        this.setTitle("Control Principal");
        panel_inicio_sesion.setVisible(false);
                
        JButton btn_admin_cli = new JButton("Administración de Clientes");
        btn_admin_cli.setBounds(90, 20, 250, 25);
        panel_control.add(btn_admin_cli);
        ActionListener admin_cli = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel_control_cli();
                panel_control_cli.setVisible(true);
            }
        };
        btn_admin_cli.addActionListener(admin_cli);
        
        JButton btn_admin_pro = new JButton("Administración de Productos");
        btn_admin_pro.setBounds(90, 60, 250, 25);
        panel_control.add(btn_admin_pro);
        
        JButton btn_rep = new JButton("Reportes");
        btn_rep.setBounds(90, 100, 250, 25);
        panel_control.add(btn_rep);
       
    }
    
    public void crear_usu(){
        panel_crear_usu = new JPanel();
        this.getContentPane().add(panel_crear_usu);
        panel_crear_usu.setLayout(null);
        this.setSize(650, 300);
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
        btn_registrar.setBounds(400, 80, 200, 35);
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
        btn_inicio.setBounds(400, 150, 200, 35);
        panel_crear_usu.add(btn_inicio);
        ActionListener volver_inicio = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel_inicio_sesion.setVisible(true);
                panel_crear_usu.setVisible(false);
               volver_inicio();
            }
        };
        btn_inicio.addActionListener(volver_inicio);
    }
    
    public void volver_inicio(){
        this.setTitle("Sistema administrativo de clientes y recursos");
        this.setSize(650, 200);
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
    public void panel_control_cli(){
        panel_control_cli = new JPanel();
        this.getContentPane().add(panel_control_cli);
        panel_control_cli.setLayout(null);
        this.setSize(700, 600);
        this.setTitle("Administración de clientes");
        panel_control.setVisible(false);
        
        DefaultTableModel datos_tabla = new DefaultTableModel();
        datos_tabla.addColumn("Nombre");
        datos_tabla.addColumn("Edad");
        datos_tabla.addColumn("Género");
        datos_tabla.addColumn("NIT");
        
        for(int i = 0; i<10; i++){
            if(clientes[i] != null){
                String fila[] = {clientes[i].nom, String.valueOf(clientes[i].edad), String.valueOf(clientes[i].genero), String.valueOf(clientes[i].nit)};
                datos_tabla.addRow(fila);
            }
        }    
        JTable tabla_cli = new JTable(datos_tabla);
        JScrollPane barra_des = new JScrollPane(tabla_cli);
        barra_des.setBounds(10, 10, 300, 200);
        panel_control_cli.add(barra_des);
        
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Masculino", totalH());
        datos.setValue("Femenino", totalM());
        
        JFreeChart grafico_circular = ChartFactory.createPieChart("Géneros en el sistema", datos);
        ChartPanel panel_circular = new ChartPanel(grafico_circular);
        panel_circular.setBounds(10, 220, 300, 300);
        panel_control_cli.add(panel_circular);
        
        JButton btn_cargar_archivo = new JButton("Cargar archivo CSV");
        btn_cargar_archivo.setBounds(350, 10, 200, 25);
        panel_control_cli.add(btn_cargar_archivo);
        ActionListener buscar_archivo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                File archivo_selec;
                JFileChooser ventana_archivo = new JFileChooser();
                ventana_archivo.showOpenDialog(null);
                archivo_selec = ventana_archivo.getSelectedFile();
                System.out.println("La ubicación del archivo seleccionado es " + archivo_selec.getPath());
                leer_archivo(archivo_selec.getPath());
                panel_control_cli.setVisible(false);
                panel_control_cli();
            }
        };
        btn_cargar_archivo.addActionListener(buscar_archivo);
    }
    public int totalH(){
        int total = 0;
        for(int i = 0; i<100; i++){
            if(clientes[i] != null){
                if(clientes[i].genero == 'M'){
                    total++;
                }
            }
        }
        return total;
    }
    public int totalM(){
        int total = 0;
        for(int i = 0; i<100; i++){
            if(clientes[i] != null){
                if(clientes[i].genero == 'F'){
                    total++;
                }
            }
        }
        return total;
    }
    
    public void leer_archivo(String ruta){
        try{
            BufferedReader archivo_temp = new BufferedReader(new FileReader(ruta));
            String linea_leida = "";
            while(linea_leida != null){
                linea_leida = archivo_temp.readLine();
                if(linea_leida != null){
                    String datos_separados[] = linea_leida.split(",");
                    
                    int posicion = 0;
                    if (control_clientes < 100) {
                        for (int i = 0; i < 99; i++) {
                            if (clientes[i] == null) {
                                posicion = i;
                                break;
                            }
                        }
                        clientes[posicion] = new cliente();
                        clientes[posicion].nom = datos_separados[0];
                        clientes[posicion].edad = Integer.parseInt(datos_separados[1]);
                        clientes[posicion].genero = datos_separados[2].charAt(0);
                        clientes[posicion].nit = Integer.parseInt(datos_separados[3]);
                        control_clientes++;
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede registrar más clientes");
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Clientes registrados exitosamente, total de clientes " + control_clientes);
            archivo_temp.close();
        }catch(IOException error){
            JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
        }
    }
}