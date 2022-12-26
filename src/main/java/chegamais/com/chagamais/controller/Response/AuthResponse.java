package chegamais.com.chagamais.controller.Response;

public class AuthResponse {
    private String tokenDeAcesso;

    public AuthResponse(String tokenDeAcesso) {
        this.tokenDeAcesso = tokenDeAcesso;
    }

    public String getTokenDeAcesso() {
        return tokenDeAcesso;
    }

    public void setTokenDeAcesso(String tokenDeAcesso) {
        this.tokenDeAcesso = tokenDeAcesso;
    }
}
