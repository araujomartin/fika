/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.Models.Pedido;
import MVC.DAO.PedidoDAO;
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
        
        public static Route pedidos = (Request request, Response response) -> {
        
        PedidoDAO bd = new  PedidoDAO();
        //List<Pedido> pedi = bd.cargarPedido(Pedido pedidos);

        HashMap model = new HashMap();
        //model.put("template", "templates/productos.vsl");   .vsl donde se va a mostrar si es que lo mostramos
       // model.put("pedidos", pedi);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
             
    };
        
        public static Route seepedidos = (Request request, Response response) -> {
        
        PedidoDAO bd = new  PedidoDAO();
        List<Pedido> seepedis = bd.verPedidos();

        HashMap model = new HashMap();
        model.put("template", "templates/verPedidos.vsl");  // .vsl donde se va a mostrar 
        model.put("pedis", seepedis);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
             
    };
        
}
