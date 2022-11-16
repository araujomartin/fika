/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.ItemCarrito;
import MVC.Models.Pedido;
import static Utils.Sql2oDAO.getSql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Tomas
 */
public class ItemCarritoDAO {
    
    
    public void cargarItemCarrito(ItemCarrito itemCarrito){
            Sql2o bd;
        bd = getSql2o();
        
        try (Connection con = bd.open()) {
           
            String sql = "INSERT INTO itemcarrito VALUES(:id_carrito, :id_producto, :cantidad )";
            con.createQuery(sql)
                .bind(itemCarrito)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}
    }
    
}
