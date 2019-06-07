package utn.tacs.grupo3.spring.validations;

import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.signUpValidation.ExceptionbyRepeatedUserName;
import utn.tacs.grupo3.model.exception.signUpValidation.ExceptionbySignUpValidation;
import utn.tacs.grupo3.model.exception.signUpValidation.ExceptionbyVeryShortPassword;
import utn.tacs.grupo3.model.exception.signUpValidation.ExceptionbyVeryshortUserName;
import utn.tacs.grupo3.repository.UserRepository;

public class SignUpValidation {

    public void validate(User user, UserRepository userRepository) throws ExceptionbySignUpValidation {

        if (!(user.getUsername().length() >= 3)) {
            throw new ExceptionbyVeryshortUserName();
        }
        if (!userRepository.usersByUsername(user.getUsername()).isEmpty()) {
            throw new ExceptionbyRepeatedUserName();
        }

        if (!(user.getPassword().length() >= 9)) {
            throw new ExceptionbyVeryShortPassword();
        }
    }
}
