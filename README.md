# Recuperación de hackathon 1
1. crear un evento personalizado:
* ordercreatedevent que contenga informacion del pedido (id, email, productos)
2. crear los observadores (listeners):
* emailnotificationlistener - envia un correo de confirmacion (simulado con logs)
* inventoryupdatelistener - reduce el stock disponible
* auditloglistener - registra el pedido en los logs
3. crear un controlador REST:
* endpoint POST /orders que reciba el pedido y publique el evento.
4. Usar log4j para mostrar lo que hace cada observador
