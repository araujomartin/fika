/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.Models.Producto;
import MVC.DAO.ProductoDAO;
import MVC.Models.Carrito;
import MVC.Models.ItemCarrito;
import MVC.Models.TempItem;
import Main.fika.Fika;
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
 * @author Tomas
 */
public class CarritoControlador {
    public static Route carrito = (Request req, Response res) -> {
        String json_item = req.cookie("item");
        ProductoDAO bd = new ProductoDAO();
        Carrito c = new Carrito();
        HashMap model = new HashMap();
        if (json_item != null) {
            TempItem[] items = Fika.gson.fromJson(json_item, TempItem[].class);
            for(TempItem item: items) {
                int producto_id = Integer.parseInt(item.getId());
                int cantidad_producto = Integer.parseInt(item.getCantidad());
                List<Producto> producto = bd.obtenerProductoId(producto_id);
                c.addItem(producto.get(0), cantidad_producto);
            }
        }
                
        model.put("template", "templates/carrito.vsl");
        model.put("itemCarrito", c.getListaCarrito());
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
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
    
}
