package com.example.skus.demo.laba4.controller;

import com.example.skus.demo.laba4.model.Book;
import com.example.skus.demo.laba4.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static com.example.skus.demo.laba4.controller.BooksController.BOOKS_CONTROLLER;

@Controller
@RequestMapping(BOOKS_CONTROLLER)
@RequiredArgsConstructor
public class BooksController {
    static final String BOOKS_CONTROLLER = "/laba4";

    private static final String BOOKS_ATTRIBUTE = "books";

    private final BookService bookService;

    @GetMapping
    public String index(Model model,
                        @RequestParam(required = false, defaultValue = "false") Boolean condition) {
        if (condition)
            model.addAttribute(BOOKS_ATTRIBUTE,
                    bookService.findAllByYearGreaterThenTen((short) LocalDate.now().getYear()));
        else
            model.addAttribute(BOOKS_ATTRIBUTE,
                    bookService.findAllBooks());
        return "laba4";
    }

    @PostMapping(value = "/add")
    public String addNewBook(@RequestParam("author") String author,
                             @RequestParam("name") String name,
                             @RequestParam("year") Short year,
                             @RequestParam("number") Long number) {
        Book book = new Book(null, author, name, year, number);
        bookService.addNewBook(book);
        return "redirect:/laba4";
    }

    @PostMapping(value = "/remove/{id}")
    public String removeBook(@PathVariable Long id) {
        bookService.removeBookById(id);
        return "redirect:/laba4";
    }

    @GetMapping(value = "/getBooks")
    @ResponseBody
    public Double gerPercent() {
        List<Book> filteredBooks = bookService.findAllByYearGreaterThenTen((short) LocalDate.now().getYear());
        List<Book> books = bookService.findAllBooks();
        return books.isEmpty() ? 1 : (double) filteredBooks.size() / books.size();
    }
}
