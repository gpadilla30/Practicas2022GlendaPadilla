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
import java.io.PrintWriter;
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
    JPanel panel_control_cli;
    int control_clientes = 2;
    JPanel panel_control_pro;
    producto productos[] = new producto[100];
    int control_productos = 2;
    
    public ventana(){
        objetos();
        crear_admin();
        crear_cli();
        crear_pro();
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
    public void crear_pro(){
        productos[0] = new producto();
        productos[0].cat = 'P';
        productos[0].nom = "hojas iris";
        productos[0].precio = 0.25;
        productos[0].cantidad = 500;     
        
        productos[1] = new producto();
        productos[1].cat = 'U';
        productos[1].nom = "goma en barra";
        productos[1].precio = 3;
        productos[1].cantidad = 60;
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
        btn_admin_pro.setBounds(90, 80, 250, 25);
        panel_control.add(btn_admin_pro);  
        ActionListener admin_pro = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel_control_pro();
                panel_control_pro.setVisible(true);
            }
            
        };
        btn_admin_pro.addActionListener(admin_pro);
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
        barra_des.setBounds(10, 10, 300, 150);
        panel_control_cli.add(barra_des);
        
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Masculino", totalH());
        datos.setValue("Femenino", totalM());
        
        JFreeChart grafico_circular = ChartFactory.createPieChart("Géneros en el sistema", datos);
        ChartPanel panel_circular = new ChartPanel(grafico_circular);
        panel_circular.setBounds(10, 220, 300, 300);
        panel_control_cli.add(panel_circular);
     
        DefaultCategoryDataset datos2 = new DefaultCategoryDataset();
        datos2.addValue(rango18a30(), "18-30", "Edad");
        datos2.addValue(rango31a45(), "31-45", "Edad");
        datos2.addValue(rango46mas(), "Mayor a 45", "Edad");
        JFreeChart grafico_columnas = ChartFactory.createBarChart("Rango de edades", "Edad", "Escala", datos2, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel_columnas = new ChartPanel(grafico_columnas);
        panel_columnas.setBounds(350, 220, 300, 300);
        panel_control_cli.add(panel_columnas);
                
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
                if(archivo_selec == null){
                    JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo");
                }else{
                   leer_archivo(archivo_selec.getPath());
                    panel_control_cli.setVisible(false);
                    panel_control_cli(); 
                }
            }
        };
        btn_cargar_archivo.addActionListener(buscar_archivo);
        
        JButton btn_reporte = new JButton("Crear reporte HTML");
        btn_reporte.setBounds(350, 50, 200, 25);
        panel_control_cli.add(btn_reporte);
        ActionListener crearHTML = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               crear_reporte();
            }
        };
        btn_reporte.addActionListener(crearHTML);
        
        JButton btn_inicio = new JButton("Menú Principal");
        btn_inicio.setBounds(350, 90, 200, 25);
        panel_control_cli.add(btn_inicio);
        ActionListener volver_inicio = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel_control.setVisible(true);
                panel_control_cli.setVisible(false);
               volver_menu();
            }
        };
        btn_inicio.addActionListener(volver_inicio);
    }
    public void volver_menu(){
        this.setTitle("Control Principal");
        this.setSize(450, 200);
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
    public int rango18a30(){
        int total = 0;
        for(int i = 0; i<100; i++){
            if(clientes[i] != null){
                if(clientes[i].edad >= 18 && clientes[i].edad <= 30){
                    total++;
                }
            }
        }
        return total;
    }
    public int rango31a45(){
        int total = 0;
        for(int i = 0; i<100; i++){
            if(clientes[i] != null){
                if(clientes[i].edad >= 31 && clientes[i].edad <= 45){
                    total++;
                }
            }
        }
        return total;
    }
    public int rango46mas(){
        int total = 0;
        for(int i = 0; i<100; i++){
            if(clientes[i] != null){
                if(clientes[i].edad >= 46){
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
    public void ordenar(){
        cliente auxiliar;
        for(int i=0; i<99; i++){
            for(int j=0; j<99; j++){
                if(clientes[j+1] == null){
                    break;
                }else{
                    if(clientes[j].edad > clientes[j+1].edad){
                        auxiliar = clientes[j+1];
                        clientes[j+1] = clientes[j];
                        clientes[j] = auxiliar;
                    }
                }
            }
        }
    }  
    public void crear_reporte(){
        try{
            ordenar(); 
            PrintWriter escribir_css = new PrintWriter("reportes clientes/estilo.css","UTF-8");
            escribir_css.print("html {   font-size: 20px; font-family: 'Open Sans', sans-serif; }");
            escribir_css.print("h1 { font-size: 60px; text-align: center; }");
            escribir_css.print("p, li {   font-size: 16px;   line-height: 2;   letter-spacing: 1px; }");
            escribir_css.print("table { table-layout: fixed;   width:250px;}   td{border: 1px solid black; width: 190px;  word-wrap: break-word}");
            escribir_css.print("html { background-color: #00539F; }");
            escribir_css.print("body { width: 970px; margin: 0 auto; background-color: #FF9500; padding: 0 20px 20px 20px; border: 5px solid black; }");
            escribir_css.print("h1 { margin: 0; padding: 20px 0; color: #00539F; text-shadow: 3px 3px 1px black; }");
            escribir_css.close();
            
            PrintWriter escribir = new PrintWriter("reportes clientes/reporte.html","UTF-8");
            escribir.println("<!doctype html>");
            escribir.println("<html>");
            escribir.println("<head>");
            escribir.println("<title>Reporte del sistema</title>");
            escribir.println("<link rel=\"stylesheet\" href=\"estilo.css\">");
            escribir.println("</head>");
            escribir.println("<body>");
            escribir.println("<h1>Listado de clientes en el sistema</h1>");
            escribir.println("<br>");
            escribir.println("<table border=1>");
            escribir.println("<tr>");
            escribir.println("<td>NIT</td> <td>Nombre</td> <td>Edad</td> <td>Género</td>");
            escribir.println("</tr>");
            
            for(int i=0; i<99; i++){
                if(clientes[i] != null){
                    escribir.println("<tr>");
                    escribir.println("<td>" + clientes[i].nit + "</td><td>" + clientes[i].nom + "</td><td>" + clientes[i].edad + "</td><td>" + clientes[i].genero + "</td>");
                    escribir.println("</tr>");
                }
            }
            escribir.println("</table>");
            escribir.println("</body>");
            escribir.println("</html>");
            escribir.close();
            JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");
        }catch(IOException error){
            JOptionPane.showMessageDialog(null, "No se pudo crear el reporte");
        }
    }
    
    public void panel_control_pro(){
        panel_control_pro = new JPanel();
        this.getContentPane().add(panel_control_pro);
        panel_control_pro.setLayout(null);
        this.setSize(700, 600);
        this.setTitle("Administración de productos");
        panel_control.setVisible(false);
        
        DefaultTableModel datos_tabla2 = new DefaultTableModel();
        datos_tabla2.addColumn("Categoría");
        datos_tabla2.addColumn("Nombre");
        datos_tabla2.addColumn("Precio");
        datos_tabla2.addColumn("Cantidad");
        
        for(int i = 0; i<10; i++){
            if(productos[i] != null){
                String fila[] = {String.valueOf(productos[i].cat), productos[i].nom, Double.toString(productos[i].precio), String.valueOf(productos[i].cantidad)};
                datos_tabla2.addRow(fila);
            }
        }    
        JTable tabla_pro = new JTable(datos_tabla2);
        JScrollPane barra_des = new JScrollPane(tabla_pro);
        barra_des.setBounds(10, 10, 300, 150);
        panel_control_pro.add(barra_des);
        
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Papelería", totalP());
        datos.setValue("Útiles", totalU());
        
        JFreeChart grafico_circular = ChartFactory.createPieChart("Categorías de productos", datos);
        ChartPanel panel_circular = new ChartPanel(grafico_circular);
        panel_circular.setBounds(10, 220, 300, 300);
        panel_control_pro.add(panel_circular);
     
        DefaultCategoryDataset datos2 = new DefaultCategoryDataset();
        datos2.addValue(precio5(), "0.25-5.00", "Precio");
        datos2.addValue(precio10(), "6.00-10.00", "Precio");
        datos2.addValue(precio11mas(), "Mayor a 10.00", "Precio");
        JFreeChart grafico_columnas = ChartFactory.createBarChart("Rango de precios", "Precio", "Escala", datos2, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel_columnas = new ChartPanel(grafico_columnas);
        panel_columnas.setBounds(350, 220, 300, 300);
        panel_control_pro.add(panel_columnas);
                
        JButton btn_cargar_archivo = new JButton("Cargar archivo CSV");
        btn_cargar_archivo.setBounds(350, 10, 200, 25);
        panel_control_pro.add(btn_cargar_archivo);
        ActionListener buscar_archivo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                File archivo_selec;
                JFileChooser ventana_archivo = new JFileChooser();
                ventana_archivo.showOpenDialog(null);
                archivo_selec = ventana_archivo.getSelectedFile();
                if(archivo_selec == null){
                    JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo");
                }else{
                    leer_archivo2(archivo_selec.getPath());
                    panel_control_pro.setVisible(false);
                    panel_control_pro();
                }
            }
        };
        btn_cargar_archivo.addActionListener(buscar_archivo);
        
        JButton btn_reporte = new JButton("Crear reporte HTML");
        btn_reporte.setBounds(350, 50, 200, 25);
        panel_control_pro.add(btn_reporte);
        ActionListener crearHTML = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               crear_reporte2();
            }
        };
        btn_reporte.addActionListener(crearHTML);
        
        JButton btn_inicio = new JButton("Menú Principal");
        btn_inicio.setBounds(350, 90, 200, 25);
        panel_control_pro.add(btn_inicio);
        ActionListener volver_inicio = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel_control.setVisible(true);
                panel_control_pro.setVisible(false);
               volver_menu();
            }
        };
        btn_inicio.addActionListener(volver_inicio);
    }
    public int totalP(){
        int total = 0;
        for(int i = 0; i<100; i++){
            if(productos[i] != null){
                if(productos[i].cat == 'P'){
                    total++;
                }
            }
        }
        return total;
    }
    public int totalU(){
        int total = 0;
        for(int i = 0; i<100; i++){
            if(productos[i] != null){
                if(productos[i].cat == 'U'){
                    total++;
                }
            }
        }
        return total;
    }
    public int precio5(){
        int total = 0;
        for(int i = 0; i<100; i++){
            if(productos[i] != null){
                if(productos[i].precio >= 0.25 && productos[i].precio <= 5){
                    total++;
                }
            }
        }
        return total;
    }
    public int precio10(){
        int total = 0;
        for(int i = 0; i<100; i++){
            if(productos[i] != null){
                if(productos[i].precio >= 6 && productos[i].precio <= 10){
                    total++;
                }
            }
        }
        return total;
    }
    public int precio11mas(){
        int total = 0;
        for(int i = 0; i<100; i++){
            if(productos[i] != null){
                if(productos[i].precio >= 11){
                    total++;
                }
            }
        }
        return total;
    }
    public void leer_archivo2(String ruta){
        try{
            BufferedReader archivo_temp = new BufferedReader(new FileReader(ruta));
            String linea_leida = "";
            while(linea_leida != null){
                linea_leida = archivo_temp.readLine();
                if(linea_leida != null){
                    String datos_separados[] = linea_leida.split(",");
                    
                    int posicion = 0;
                    if (control_productos < 100) {
                        for (int i = 0; i < 99; i++) {
                            if (productos[i] == null) {
                                posicion = i;
                                break;
                            }
                        }
                        productos[posicion] = new producto();
                        productos[posicion].cat = datos_separados[0].charAt(0);
                        productos[posicion].nom = datos_separados[1];
                        productos[posicion].precio = Double.parseDouble(datos_separados[2]);
                        productos[posicion].cantidad = Integer.parseInt(datos_separados[3]);
                        control_productos++;
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede registrar más productos");
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Productos registrados exitosamente, total de Productos " + control_productos);
            archivo_temp.close();
        }catch(IOException error){
            JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
        }
    }
    public void ordenar2(){
        producto auxiliar;
        for(int i=0; i<99; i++){
            for(int j=0; j<99; j++){
                if(productos[j+1] == null){
                    break;
                }else{
                    if(productos[j].precio > productos[j+1].precio){
                        auxiliar = productos[j+1];
                        productos[j+1] = productos[j];
                        productos[j] = auxiliar;
                    }
                }
            }
        }
    }  
    public void crear_reporte2(){
        try{
            ordenar2(); 
            PrintWriter escribir_css = new PrintWriter("reportes productos/estilo.css","UTF-8");
            escribir_css.print("html {   font-size: 20px; font-family: 'Open Sans', sans-serif; }");
            escribir_css.print("h1 { font-size: 60px; text-align: center; }");
            escribir_css.print("p, li {   font-size: 16px;   line-height: 2;   letter-spacing: 1px; }");
            escribir_css.print("table { table-layout: fixed;   width:250px;}   td{border: 1px solid black; width: 190px;  word-wrap: break-word}");
            escribir_css.print("html { background-color: #00539F; }");
            escribir_css.print("body { width: 970px; margin: 0 auto; background-color: #FF9500; padding: 0 20px 20px 20px; border: 5px solid black; }");
            escribir_css.print("h1 { margin: 0; padding: 20px 0; color: #00539F; text-shadow: 3px 3px 1px black; }");

            escribir_css.close();
            
            PrintWriter escribir = new PrintWriter("reportes productos/reporte.html","UTF-8");
            escribir.println("<!doctype html>");
            escribir.println("<html>");
            escribir.println("<head>");
            escribir.println("<title>Reporte del sistema</title>");
            escribir.println("<link rel=\"stylesheet\" href=\"estilo.css\">");
            escribir.println("</head>");
            escribir.println("<body>");
            escribir.println("<h1>Listado de productos en el sistema</h1>");
            escribir.println("<br>");
            escribir.println("<table border=1>");
            escribir.println("<tr>");
            escribir.println("<td>Categoría</td> <td>Nombre</td> <td>Precio</td> <td>Cantidad</td>");
            escribir.println("</tr>");
            
            for(int i=0; i<99; i++){
                if(productos[i] != null){
                    escribir.println("<tr>");
                    escribir.println("<td>" + productos[i].cat + "</td><td>" + productos[i].nom + "</td><td>" + productos[i].precio + "</td><td>" + productos[i].cantidad + "</td>");
                    escribir.println("</tr>");
                }
            }
            escribir.println("</table>");
            escribir.println("</body>");
            escribir.println("</html>");
            escribir.close();
            JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");
        }catch(IOException error){
            JOptionPane.showMessageDialog(null, "No se pudo crear el reporte");
        }
    }
}