package library.service;

import library.dao.BookDao;

import library.dto.book.CreateNewBookDto;
import library.dto.book.ViewBookBasicInfoDto;

import library.dto.book.ViewBookFullInfoDto;
import library.dto.book.ViewBookTextDto;
import library.entity.Book;
import library.entity.Genre;
import library.formatter.LocalDateFormat;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookService {

    private static final BookService INSTANCE = new BookService();

    public List<ViewBookBasicInfoDto> findAll() {
        return BookDao.getInstance().findAll().stream()
                .map(it -> new ViewBookBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public List<ViewBookFullInfoDto> findAllUser() {
        return BookDao.getInstance().findAllBookUser().stream()
                .map(it -> new ViewBookFullInfoDto(it.getId(), it.getName(),
                        UserService.getInstance().findById(it.getIdUser()).getName(),
                        it.getDescription(), LocalDateFormat.format(it.getDate()),
                        it.getBookWhole(), it.getGenre().getName()))
                .collect(Collectors.toList());
    }

    public List<ViewBookFullInfoDto> findBookUserId(Long userId) {
        return BookDao.getInstance().findBookUserId(userId).stream()
                .map(it -> new ViewBookFullInfoDto(it.getId(), it.getName(),
                        UserService.getInstance().findById(it.getIdUser()).getName(),
                        it.getDescription(), LocalDateFormat.format(it.getDate()),
                        it.getBookWhole(), it.getGenre().getName()))
                .collect(Collectors.toList());
    }

    public ViewBookFullInfoDto findById(Long bookId) {
        return BookDao.getInstance().findById(bookId)
                .map(it -> ViewBookFullInfoDto.builder()
                        .id(it.getId())
                        .name(it.getName())
                        .nameUser(UserService.getInstance().findById(it.getIdUser()).getName())
                        .description(it.getDescription())
                        .date(LocalDateFormat.format(it.getDate()))
                        .bookWhole(it.getBookWhole())
                        .genreName(it.getGenre().getName())
                        .build())
                .orElse(null);
    }

    public ViewBookTextDto findByIdText(Long bookId) {
        return BookDao.getInstance().findById(bookId)
                .map(it -> ViewBookTextDto.builder()
                        .id(it.getId())
                        .url(it.getUrl())
                        .build())
                .orElse(null);
    }

    public List<ViewBookFullInfoDto> findAllPage(int numberPage) {
        return BookDao.getInstance().findAllPage(numberPage).stream()
                .map(it -> new ViewBookFullInfoDto(it.getId(), it.getName(),
                        UserService.getInstance().findById(it.getIdUser()).getName(),
                        it.getDescription(),
                        LocalDateFormat.format(it.getDate()), it.getBookWhole(), it.getGenre().getName()))
                .collect(Collectors.toList());
    }

    public List<ViewBookFullInfoDto> findAll(int genreId) {
        return BookDao.getInstance().findByIdGenre(genreId).stream()
                .map(it -> new ViewBookFullInfoDto(it.getId(), it.getName(),
                        UserService.getInstance().findById(it.getIdUser()).getName(), it.getDescription(),
                        LocalDateFormat.format(it.getDate()), it.getBookWhole(), it.getGenre().getName()))
                .collect(Collectors.toList());
    }

    public List<ViewBookFullInfoDto> findAll(String nameBook) {
        return BookDao.getInstance().findByName(nameBook).stream()
                .map(it -> new ViewBookFullInfoDto(it.getId(), it.getName(),
                        UserService.getInstance().findById(it.getIdUser()).getName(), it.getDescription(),
                        LocalDateFormat.format(it.getDate()), it.getBookWhole(), it.getGenre().getName()))
                .collect(Collectors.toList());
    }

    public List<ViewBookFullInfoDto> findAllUser(String nameUser) {
        return BookDao.getInstance().findByUser(nameUser).stream()
                .map(it -> new ViewBookFullInfoDto(it.getId(), it.getName(),
                        UserService.getInstance().findById(it.getIdUser()).getName(), it.getDescription(),
                        LocalDateFormat.format(it.getDate()), it.getBookWhole(), it.getGenre().getName()))
                .collect(Collectors.toList());
    }

    public List<ViewBookFullInfoDto> findAll(int genreId, String nameUser) {
        return BookDao.getInstance().findByGenreUser(genreId, nameUser).stream()
                .map(it -> new ViewBookFullInfoDto(it.getId(), it.getName(),
                        UserService.getInstance().findById(it.getIdUser()).getName(), it.getDescription(),
                        LocalDateFormat.format(it.getDate()), it.getBookWhole(), it.getGenre().getName()))
                .collect(Collectors.toList());
    }

    public List<ViewBookFullInfoDto> findAllBookGenre(String nameBook, int genreId) {
        return BookDao.getInstance().findByBookGenre(nameBook, genreId).stream()
                .map(it -> new ViewBookFullInfoDto(it.getId(), it.getName(),
                        UserService.getInstance().findById(it.getIdUser()).getName(), it.getDescription(),
                        LocalDateFormat.format(it.getDate()), it.getBookWhole(), it.getGenre().getName()))
                .collect(Collectors.toList());
    }

    public ViewBookBasicInfoDto save(CreateNewBookDto dto) {
        Book savedBook = BookDao.getInstance().save(
                Book.builder()
                        .name(dto.getName())
                        .idUser(dto.getIdUser())
                        .bookWhole(dto.getBookWhole())
                        .description(dto.getDescription())
                        .url(dto.getUrl())
                        .genre(Genre.builder().id(dto.getGenreId()).build())
                        .build());
        BookDao.getInstance().saveBook_User(savedBook.getId(), savedBook.getIdUser());
        return new ViewBookBasicInfoDto(savedBook.getId(), savedBook.getName());
    }

    public static BookService getInstance() {
        return INSTANCE;
    }
}
