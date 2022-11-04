/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
class Producto {
    id;
    price;
}

class ItemCarrito {
    product_id;
    quantity;
}

class Carrito {
    item = [];
    total = 0;
}

$(document).ready(() => {
    document.cookie = "boca=campeon"
    
            $('#carrito').click((e) => {
            let item_carrito = localStorage.getItem('item');
            console.log(item_carrito);
                $.ajax({
                type: 'GET',
                url: 'http://localhost:4567/carrito/detalle',
                dataType: 'json',
                success: (result, status) => {
                    console.log(result);
                },
                error: (xhr, status, err) => {

                }
            });

        });
    
    });