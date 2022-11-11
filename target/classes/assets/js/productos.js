function hola(id) {
    $('#modal-detail').empty();
    $.ajax({
        type: 'GET',
        url: 'producto/detalle?id='+id,
        success: (result, status) => {
            $('#modal-detail').append(result);
            $('#modal-producto').modal('show');
            
            let resta = document.getElementsByClassName('resta');
            let suma = document.getElementsByClassName('suma');
        
            for (let i = 0; i < resta.length; i++ ) {
                let boton_resta = resta[i];
                let boton_suma = suma[i];
        
                boton_resta.addEventListener('click', (e)=> {
                    let boton_resta_clickeado = event.target;
                    let contador = boton_resta_clickeado.parentElement.children[1];
                    if (contador.innerHTML>1) {
                        contador.innerHTML--;
                    }
                });
        
                boton_suma.addEventListener('click', (e)=> {
                    let boton_suma_clickeado = event.target;
                    let contador = boton_suma_clickeado.parentElement.children[1];
                        contador.innerHTML++;
                });
                
            }
            
        },
        error: (xhr, status, err) => {

        }
    });
}

function agregarCarrito(producto_id) {
    let cant = document.getElementById('cantidad').innerHTML;
    let new_item = { id: producto_id, cantidad: Number(cant) }

    let item = JSON.parse(localStorage.getItem('item'));
    let find = false;
    if (item) {
        item.forEach((producto) => {
            if (producto.id == new_item.id) {
                producto.cantidad += new_item.cantidad;
                find = true;
            }
        });
        if (!find) {
            item.push(new_item);
        }
        localStorage.setItem('item', JSON.stringify(item));
    } else {
        item = [];
        item.push(new_item);
        localStorage.setItem('item', JSON.stringify(item));
    }
    document.cookie = "item=" + JSON.stringify(item);
    $('#modal-producto').modal('hide');
    $(location).prop('href', '/carrito')
}