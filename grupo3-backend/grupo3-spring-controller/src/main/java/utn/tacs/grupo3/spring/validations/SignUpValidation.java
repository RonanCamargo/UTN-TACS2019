package utn.tacs.grupo3.spring.validations;

import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.signUpValidation.*;
import utn.tacs.grupo3.repository.UserRepository;

public class SignUpValidation {

    public void validate(User user, UserRepository userRepository) throws ExceptionbySignUpValidation {

        if (user.areThereEmptyFieldsToSignUp()) {
            throw new ExceptionByEmptyFields();
        }
        if (!(user.getUsername().length() >= 3)) {
            throw new ExceptionbyVeryshortUserName();
        }
        if (userRepository.isThereAnUser(user)) {
            throw new ExceptionbyRepeatedUserName();
        }
        if (!(user.getPasswordPlane().length() >= 3)) {
            throw new ExceptionbyVeryShortPassword();
        }
    }
}
