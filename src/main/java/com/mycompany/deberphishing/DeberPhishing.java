/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.deberphishing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DeberPhishing {

public static void main(String[] args) {
      String[] palabras = {
            "Etiqueta",
            "Factura",
            "Publicar",
            "Verificación",
            "Contraseña",
            "Suspensión",
            "Banco",
            "Alerta",
            "Ganador",
            "Información",
            "La contraseña de su cuenta ha caducado, actualice su contraseña ahora para mantener el acceso a Office 365",
            "no te pierdas esta oferta única en la vida.",
            "le hemos grabado mientras utilizaba un sitio web porno...",
            "¿puedes procesar urgentemente esta transferencia a nuestro último proveedor? Si no lo haces hoy, perderemos un gran pedido \"",
            "Urgente",
            "Se requiere verificación.",
            "Premio",
            "Problema",
            "Importante",
            "¡Necesito ayuda urgente!",
            "Actividad sospechosa de Outlook",
            "Importante! Su contraseña está a punto de expirar",
            "Acción requerida",
            "Se ha identificado una vulnerabilidad en",
            "ha sido bloqueada por razones de seguridad",
            "Su cuenta ha sido suspendida temporalmente. Haga clic aquí para restablecer el acceso.",
            "Verificación de cuenta necesaria. Confirme su información para evitar el bloqueo de su cuenta.",
            "¡Felicidades! Ha sido seleccionado como ganador de un premio exclusivo. Complete su información para reclamarlo.",
            "Urgente: Actualice su contraseña de inmediato para mantener la seguridad de su cuenta.",
            "Estimado cliente, se ha detectado una actividad inusual en su cuenta. Inicie sesión para revisar los detalles."
        };

        // Crear la lista con las palabras clave y sus valores de puntos
        Map<String, Integer> phishingKeywords = new HashMap<>();
        phishingKeywords.put("banco", 2);
        phishingKeywords.put("contraseña", 3);
        phishingKeywords.put("urgente", 2);
        phishingKeywords.put("verificación de cuenta", 3);
        phishingKeywords.put("premio", 2);
         }

    public static int countOccurrences(String text, String keyword) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }

        return count;
    }
}
