package hotel.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Authentification {

    private final Map<String, byte[]> hashes = new HashMap<>();

    public Authentification() {
        hashes.put("AG-42", hacher("AG-42", "secret-42"));
        hashes.put("AG-77", hacher("AG-77", "secret-77"));
    }

    private byte[] hacher(String agence, String secret) {
        try {
            byte[] sel = ("hai704i:" + agence).getBytes(StandardCharsets.UTF_8);
            PBEKeySpec spec = new PBEKeySpec(secret.toCharArray(), sel, 10000, 256);
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
                    .generateSecret(spec).getEncoded();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean verifier(String agence, String secret) {
        if (agence == null || secret == null || !hashes.containsKey(agence)) {
            return false;
        }
        return MessageDigest.isEqual(hacher(agence, secret), hashes.get(agence));
    }
}