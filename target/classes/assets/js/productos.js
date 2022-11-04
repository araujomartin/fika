function agregarCarrito(producto_id) {
    let cant = document.getElementById('cantidad'+producto_id).innerHTML;
    let new_item = {id: producto_id, cantidad: Number(cant) } 
        
           let item = JSON.parse(localStorage.getItem('item'));
               let find = false;
               if (item) {
                    item.forEach( (producto)=> {
                        if(producto.id == new_item.id) {
                            producto.cantidad += new_item.cantidad;
                            find = true;
                        }
                    });
                    if(!find) {
                        item.push(new_item);
                    }
                    localStorage.setItem('item',JSON.stringify(item));
               } else {
                    item = []; 
                    item.push(new_item);
                    localStorage.setItem('item',JSON.stringify(item));
                }
                document.cookie = "item="+JSON.stringify(item);
    }