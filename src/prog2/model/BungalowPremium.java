package prog2.model;

public class BungalowPremium extends Bungalow {

    private boolean serveisExtra;
    private String codiWifi;

    // Constructor
    public BungalowPremium(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        setServeisExtra(serveisExtra);
        setCodiWifi(codiWifi);
    }

    // Getters y Setters
    public boolean getserveisExtra() {
        return serveisExtra;
    }
    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }
    public String getCodiWifi() {
        return codiWifi;
    }
    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }
    public boolean getServeisExtra(){
        return serveisExtra;
    }

    // Implementació del mètode correcteFuncionament
    public boolean correcteFuncionament(){
        int num_digits = codiWifi.length();
        return super.correcteFuncionament() && (7 < num_digits && num_digits < 17);
    }

    @Override
    public String toString() {
        String baseString = super.toString();
        baseString = baseString.substring(0, baseString.length() - 1);
        return baseString + ", serveisExtra=" + serveisExtra + ", codiWifi='" + codiWifi + "'}";
    }
}
