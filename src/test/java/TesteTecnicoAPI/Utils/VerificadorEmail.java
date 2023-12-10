package TesteTecnicoAPI.Utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class VerificadorEmail {
    public static boolean validarEmail(String email) {
        boolean emailValido = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            emailValido = false;
        }
        return emailValido;
    }
}
