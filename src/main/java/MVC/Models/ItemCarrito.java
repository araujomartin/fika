/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Models;

import MVC.Models.Producto;
import lombok.Data;

/**
 *
 * @author Tomas
 */
@Data
public class ItemCarrito{
    
    private int cantidad;
    private Producto producto;
    
    public ItemCarrito(Producto p, int cant){
        this.producto=p;
        this.cantidad=cant;
    }
        
    public void actualizarCantidad(int cantidad) {
        this.cantidad = this.cantidad + cantidad;
    }
    
    public double getTotal() {
        return this.cantidad * this.producto.getPrecio_vta();
    }
    
}
