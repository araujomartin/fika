/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.fika;
import MVC.Models.Carrito;
import Velocity.VelocityTemplateEngine;
import java.util.HashMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Martin
 */
public class FikaController {
    public static Route inicio = (Request req, Response res)-> {
        HashMap model = new HashMap();
        Carrito carrito = new Carrito();
        model.put("carrito", carrito);
        model.put("navbar", "templates/navbar.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
    };
    
}
