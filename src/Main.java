import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
// Instance de DonneesSalle

        donneesSalle salle = new donneesSalle(20.5, 10.2, 3);

        System.out.println("Temperature: " + salle.getTemperature() + "°C");
        System.out.println("humidité: " + salle.getHumidite() + "%");
        System.out.println("PpmCCO2: " + salle.getPpmCO2());
        System.out.println(salle.getAll());
        System.out.println(salle.airQuality());

        // Saisie dans le console.log de la demande MQTT
        String demande;
        String motDePasse;
        System.out.println("Que souhaitez-vous demander?");
        Scanner saisieInfo = new Scanner(System.in);
        demande = saisieInfo.nextLine();
        String response = salle.toMQTT(demande);

        //tentative de Lecture avec comme paramètre la réponse de la méthode toMQTT et un mot de passe
        String encrypt = cryptMQTT.Main.encrypt(response, "hello");
        System.out.println(encrypt);
        System.out.println("Inserer le mot de passe");
        Scanner saisieMotDePasse = new Scanner(System.in);
        motDePasse = saisieMotDePasse.nextLine();

        // Boucle de vérification du mot de passe pour le ressaisir .
        // Utilisation de equals qui verifie les chaines de caractères
        while (!motDePasse.equals("hello")) {
            System.out.println("mot de passe faux, recommencez");
            System.out.println("Inserer le mot de passe");
            motDePasse = saisieMotDePasse.nextLine();
        }

        // Lecture en clair
        System.out.println("Voici le relevé de la donnée : " + demande);
        String decr = cryptMQTT.Main.decrypt(encrypt, motDePasse);
        System.out.println(decr);
    }
}
