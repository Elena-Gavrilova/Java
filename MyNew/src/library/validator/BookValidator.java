package library.validator;

import library.dto.book.CreateNewBookDto;
import library.dto.user.CreateNewUserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class BookValidator implements Validator<CreateNewBookDto> {

    private static final int DESCRIPTION_MAX_LENGTH = 64;
    private static final int DESCRIPTION_MAX_DESCR = 500;
    private static final int DESCRIPTION_MIN_LENGTH = 1;
    private static final String PATTERN = "[a-z-A-zа-яА-Я\\-\\d\\_\\w ]+";

    private static final BookValidator INSTANCE = new BookValidator();

    @Override
    public List<String> validate(CreateNewBookDto object) {
        List<String> errors = new ArrayList<>();
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(object.getName());
        if(!m.matches()){
            errors.add("Недопустимые символы в названии книги!");
        }
        if (object.getName().length()>DESCRIPTION_MAX_LENGTH || object.getDescription().length()>DESCRIPTION_MAX_DESCR) {
            errors.add("Длина введенных данных превышает допстимую!");
        }
        if(object.getName().length()<DESCRIPTION_MIN_LENGTH){
            errors.add("Длина введенных данных меньше допустимой!");

        }
        if(object.getGenreId()==0){
            errors.add("Выберите жанр!");
        }

        return errors;
    }

    public static BookValidator getInstance() {
        return INSTANCE;
    }

}
