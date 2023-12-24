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
         // Asignar un valor de punto aleatorio (1 al 3) a cada palabra
     // Asignar un valor de punto aleatorio (1 al 3) a cada palabra
        Random random = new Random();
        for (String palabra : palabras) {
            String palabraMinusculas = palabra.toLowerCase(); // Convertir a minúsculas
            int valorAleatorio = random.nextInt(3) + 1; // Genera valores aleatorios de 1 a 3
            phishingKeywords.put(palabraMinusculas, valorAleatorio);
        }


        // Ruta del archivo de texto a analizar
        System.out.println(System.getProperty("user.dir"));
        String filePath = "src\\main\\java\\com\\mycompany\\deberphishing\\archivo.txt";

        // Llamada al método para analizar el archivo y calcular los puntos
        int totalPoints = analyzeFile(filePath, phishingKeywords);

        // Mostrar el total de puntos para todo el mensaje
        System.out.println("Total de puntos: " + totalPoints);
    }

    public static int analyzeFile(String filePath, Map<String, Integer> phishingKeywords) {
        int totalPoints = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Map<String, Integer> occurrences = new HashMap<>();

            while ((line = br.readLine()) != null) {
                // Convertir todas las palabras a minúsculas para evitar distinción entre mayúsculas y minúsculas
                line = line.toLowerCase();
                
                // Buscar las ocurrencias de palabras clave y contar los puntos
                for (String keyword : phishingKeywords.keySet()) {
                    int keywordPoints = phishingKeywords.get(keyword);
                    int count = countOccurrences(line, keyword);
                    
                    if (count > 0) {
                        occurrences.put(keyword, count);
                        totalPoints += count * keywordPoints;
                    }
                }
            }

            // Mostrar las palabras clave encontradas y el número de ocurrencias
            for (String keyword : occurrences.keySet()) {
                int count = occurrences.get(keyword);
                int keywordPoints = phishingKeywords.get(keyword);
                System.out.println(keyword + " - Ocurrencias: " + count + ", Puntos: " + (count * keywordPoints));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalPoints;
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
