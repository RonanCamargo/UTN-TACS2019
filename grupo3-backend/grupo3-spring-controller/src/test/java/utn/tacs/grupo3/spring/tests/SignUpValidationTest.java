package utn.tacs.grupo3.spring.tests;

import org.junit.Before;
import org.junit.Test;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.signUpValidation.ExceptionbyRepeatedUserName;
import utn.tacs.grupo3.model.exception.signUpValidation.ExceptionbySignUpValidation;
import utn.tacs.grupo3.model.exception.signUpValidation.ExceptionbyVeryShortPassword;
import utn.tacs.grupo3.model.exception.signUpValidation.ExceptionbyVeryshortUserName;
import utn.tacs.grupo3.repository.UserRepository;
import utn.tacs.grupo3.spring.validations.SignUpValidation;

public class SignUpValidationTest {
    private User user1;
    private SignUpValidation signUpValidation;
    private UserRepository userRepository;

    @Before
    public void initialize() {
        user1 = new User("Pedro", "Rodriguez", "pedrito", null, null);
        signUpValidation = new SignUpValidation();
        userRepository = new UserRepository();
    }


    @Test(expected = ExceptionbyVeryshortUserName.class)
    public void userNameMustBeGreaterThan2Characters() throws ExceptionbySignUpValidation {
        user1.setUsername("AA");
        signUpValidation.validate(user1, userRepository);
    }

    @Test(expected = ExceptionbyVeryShortPassword.class)
    public void passwordMustBeGreaterThan2Characters() throws ExceptionbySignUpValidation {
        user1.setPassword("12");
        signUpValidation.validate(user1, userRepository);
    }

    @Test(expected = ExceptionbyRepeatedUserName.class)
    public void usernameAlreadyExists() throws ExceptionbySignUpValidation {
        userRepository.createUser(user1 = new User("Pedro", "Rodriguez", "pedrito", null, null));
        signUpValidation.validate(user1, userRepository);
    }
}
