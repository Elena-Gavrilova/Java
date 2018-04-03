package library.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class GenreValidator implements Validator<String> {

    private static final int DESCRIPTION_MAX_LENGTH = 64;
    private static final int DESCRIPTION_MIN_LENGTH = 1;

    private static final GenreValidator INSTANCE = new GenreValidator();

    @Override
    public List<String> validate(String object) {
        String genre=object.trim().toLowerCase();
        genre=genre.replaceFirst(genre.substring(0,1),genre.substring(0,1).toUpperCase());

        return Collections.singletonList(genre);
    }

    public static GenreValidator getInstance() {
        return INSTANCE;
    }

}
