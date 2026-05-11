# Psp-ChatRMI
# PSP-Proyecto UD3 - SERVIDOR RMI

## 1- Descripción del proyecto
Este servidor actua como un directorio de usuarios. Cuando el cliente se registra con un nombre el servidor registra su referencia RMI. Esta informacion es guardada en un hashMap. Cuando un cliente quiere hablar con otro le pide esa referencia al servidor y desde ese momento la comunicación es P2P entre ambos.

## 2- Arquitectura del sistema
La distribución en paquetes y clases es la siguiente: 
### 2.1 ChatRMI
 - PspChatRMI: Implementación del servidor . Tiene un HashMap con los  usuarios.
### 2.2 Interfaz
 - Chat: interfaz que define el contrato de comunicacion para comunicarse de forma remota

## 3-Requisitos
- Sistema operativo compatible con java
- Arrancar el servifor antes que los clientes
