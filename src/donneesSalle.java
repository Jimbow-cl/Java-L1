public class donneesSalle {
    private double temperature;
    private double humidite;
    private int ppmCO2;

    public donneesSalle(double temperature, double humidite, int ppmCO2) {
        this.temperature = 20.0;
        this.humidite = 10.0;
        this.ppmCO2 = 900;
    }

    ;

    public double getTemperature() {
        return temperature;
    }

    ;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    ;

    public double getHumidite() {
        return humidite;
    }

    ;

    public void setHumidite(double humidite) {
        this.humidite = humidite;
    }

    ;

    public int getPpmCO2() {
        return ppmCO2;
    }

    ;

    public void setPpmCO2(int ppmCO2) {
        this.ppmCO2 = ppmCO2;
    }

    ;

    public String getAll() {
        return "Temperature: " + temperature + ", Humidité: " + humidite + " ,ppmCO2: " + ppmCO2;
    }

    ;

    // Chaine de charatères  permettant de getter les trois atributs
    public String toMQTT(String demande) {

        String mqtt;
        switch (demande) {
            case "temperature":
                mqtt = "sensors/C025/temperature/" + temperature;
                break;
            case "humidite":
                mqtt = "sensors/C025/humidite/" + humidite;
                break;
            case "ppmCO2":
                mqtt = "sensors/C025/ppmCO2/" + ppmCO2;
            default:
                mqtt = "Verifiez votre saisie";
        }
        return mqtt;
    }

    ;
    //Méthode de Qualité de l'air

    public String airQuality() {
        String response;
        if (ppmCO2 < 1000) {
            response = "Bonne";
        } else if (ppmCO2 > 1000 && ppmCO2 < 2000) {
            response = "Moyenne";
        } else {
            response = "Mauvaise";
        }
        return response;
    }

}
