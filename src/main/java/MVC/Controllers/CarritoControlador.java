/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.Models.ItemCarrito;
import MVC.Models.Producto;
import MVC.Models.Carrito;
import MVC.DAO.ProductoDAO;
import MVC.Models.TempItem;
import Main.fika.Fika;
import Velocity.VelocityTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Tomas
 */
public class CarritoControlador {
    public static Route carrito = (Request req, Response res) -> {
        ObjectMapper mapper = new ObjectMapper();
        Carrito carrito = new Carrito();

        String json = mapper.writeValueAsString(carrito);

        return json;
    };

    public static Route agregar = (Request req, Response res) -> {
        ObjectMapper mapper = new ObjectMapper();
        Carrito carrito = new Carrito();
        ProductoDAO bd = new ProductoDAO();
        String producto_id = req.queryParams("producto_id");
        String cantidad = req.queryParams("cantidad");
        List<Producto> prod = bd.obtenerProductoId(Integer.parseInt(producto_id));

        ItemCarrito resp = carrito.addItem(prod.get(0), Integer.parseInt(cantidad));

        String json = mapper.writeValueAsString(resp);

        return json;

    };

    public static Route init = (Request request, Response response) -> {
        ObjectMapper mapper = new ObjectMapper();
        String json_item = request.cookie("item");
        ProductoDAO bd = new ProductoDAO();
        Carrito carrito = new Carrito();
        
        if (json_item != null) {
            TempItem[] items = Fika.gson.fromJson(json_item, TempItem[].class);
            for(TempItem item: items) {
                int producto_id = Integer.parseInt(item.getId());
                int cantidad_producto = Integer.parseInt(item.getCantidad());
                List<Producto> producto = bd.obtenerProductoId(producto_id);
                carrito.addItem(producto.get(0), cantidad_producto);
            }
        }
        
        HashMap model = new HashMap();
        model.put("template", "templates/carrito.vsl");
        model.put("itemCarrito", carrito.getListaCarrito());
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));

    };
}
