/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.DAO.CarritoDAO;
import MVC.DAO.ItemCarritoDAO;
import MVC.Models.Pedido;
import MVC.DAO.PedidoDAO;
import MVC.Models.Carrito;
import Velocity.VelocityTemplateEngine;
import java.util.HashMap;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
/**
 *
 * @author Fikaneta
 */
public class PedidoControlador {
        
        public static Route finalizar = (Request request, Response response) -> {
        
        PedidoDAO bd = new  PedidoDAO();
        CarritoDAO carrito_bd = new CarritoDAO();
        ItemCarritoDAO item_bd = new ItemCarritoDAO();
        int user_id = Integer.parseInt(request.queryParams("user_id"));
        int pago_id = Integer.parseInt(request.queryParams("pago_id"));
        String fecha = request.queryParams("fecha");
        String hora = request.queryParams("hora");
        int estado_id = 5; // Pendiente
        
        Pedido p = new Pedido();
        p.setId_usuario(user_id);
        p.setId_estado(estado_id);
        p.setHora_pedido(hora);
        p.setFecha_pedido(fecha);
        p.setNro_pedido(1000); //Implementar un index para el numero de los pedidos
        
        bd.cargarPedido(p);
        Carrito carrito_usuario = carrito_bd.getCarritoByUserId(user_id).get(0);
        // Limpia el carrito del usuario
        item_bd.clearItemCarrito(carrito_usuario.getId_carrito());
        
        
        
        
        
        
        HashMap model = new HashMap();
        //model.put("template", "templates/productos.vsl");   .vsl donde se va a mostrar si es que lo mostramos
       // model.put("pedidos", pedi);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
             
    };
        
        public static Route viewPedidos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        PedidoDAO bd = new  PedidoDAO();
        List<Pedido> pedidos = bd.verPedidos();
        
        model.put("template", "templates/verPedidos.vsl");  // .vsl donde se va a mostrar 
        model.put("pedidos", pedidos);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout_backoffice.vsl"));
             
    };
        
}
