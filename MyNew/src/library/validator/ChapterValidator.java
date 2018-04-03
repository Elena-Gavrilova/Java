package library.validator;

import library.dto.book.CreateNewBookDto;
import library.dto.chapter.CreateNewChapterDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class ChapterValidator implements Validator<CreateNewChapterDto> {

    private static final int DESCRIPTION_MAX_LENGTH = 64;
    private static final int DESCRIPTION_MIN_LENGTH = 1;
    private static final String PATTERN = "[a-z-A-zа-яА-Я\\-\\d\\_\\w ]+";

    private static final ChapterValidator INSTANCE = new ChapterValidator();

    @Override
    public List<String> validate(CreateNewChapterDto object) {
        List<String> errors = new ArrayList<>();
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(object.getName());
        if(!m.matches()){
            errors.add("Недопустимые символы в названии главы!");
        }
        if (object.getName().length()>DESCRIPTION_MAX_LENGTH ) {
            errors.add("Длина введенных данных превышает допстимую!");
        }
        if(object.getName().length()<DESCRIPTION_MIN_LENGTH){
            errors.add("Длина введенных данных меньше допустимой!");
        }

        return errors;
    }

    public static ChapterValidator getInstance() {
        return INSTANCE;
    }

}
