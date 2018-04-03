package library.validator;

import library.dto.user.CreateNewUserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class UserValidator implements Validator<CreateNewUserDto> {

    private static final int DESCRIPTION_MAX_LENGTH = 64;
    private static final int DESCRIPTION_MIN_LENGTH = 4;
    private static final UserValidator INSTANCE = new UserValidator();
    private static final String PATTERN = "[a-z-A-z\\.\\-\\d\\_]+@[a-z]+\\.[a-z]+";

    @Override
    public List<String> validate(CreateNewUserDto object) {
        List<String> errors = new ArrayList<>();
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(object.getLogin());
        if (!m.matches()) {
            errors.add("Неправильно введен логин!");
        }
        if (object.getLogin().length()>DESCRIPTION_MAX_LENGTH || object.getPassword().length()>DESCRIPTION_MAX_LENGTH ||
                object.getName().length() > DESCRIPTION_MAX_LENGTH) {
            errors.add("Длина введенных данных превышает допстимую!");
        }
        if(object.getLogin().length()<DESCRIPTION_MIN_LENGTH
                || object.getPassword().length()<DESCRIPTION_MIN_LENGTH||object.getName().length()<DESCRIPTION_MIN_LENGTH){
            errors.add("Длина введенных данных меньше допустимой!");

        }

        return errors;
    }

    public static UserValidator getInstance() {
        return INSTANCE;
    }

}
