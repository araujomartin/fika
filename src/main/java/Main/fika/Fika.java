/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Main.fika;

import MVC.Controllers.CarritoControlador;
import MVC.Controllers.MesaControlador;
import MVC.Controllers.PedidoControlador;
import MVC.Controllers.ProductoControlador;
import MVC.Controllers.ReservaControlador;
import com.google.gson.Gson;
import static spark.Spark.*;

/**
 *
 * @author Martin
 */
public class Fika {
    public static Gson gson = new Gson();
    public static void main(String[] args) {
        staticFiles.location("/assets");
        get("/", FikaController.inicio);
        get("/login", FikaController.login);
        get("/productos", ProductoControlador.productos);
        get("producto/detalle", ProductoControlador.detalle);
        get("/carrito", CarritoControlador.carrito);
        put("/carrito", CarritoControlador.agregar);
        get("/reserva",MesaControlador.getMesas); 
        get("/pedidos",PedidoControlador.seepedidos);
        post("/insertarres",ReservaControlador.setReserva); 
    }
}
//http://localhost:4567/
