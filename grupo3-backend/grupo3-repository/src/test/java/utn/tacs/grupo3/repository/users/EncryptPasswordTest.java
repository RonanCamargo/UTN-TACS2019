package utn.tacs.grupo3.repository.users;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static utn.tacs.grupo3.model.Encryptor.decrypt;
import static utn.tacs.grupo3.model.Encryptor.getEncryption;

public class EncryptPasswordTest {
    @Before
    public void initialize() {
    }


    @Test
    public void encryptTextTest() {
        Assert.assertEquals("1eWHyzFrmzA=", getEncryption("hola"));
    }

    @Test
    public void decryptTextTest() {
        Assert.assertEquals("hola", decrypt("1eWHyzFrmzA="));

    }
}
