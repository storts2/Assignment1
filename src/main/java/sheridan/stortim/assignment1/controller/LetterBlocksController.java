package sheridan.stortim.assignment1.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.servlet.http.Cookie;
import org.springframework.ui.Model;
import sheridan.stortim.assignment1.domain.Letters;

@Controller
@Slf4j
@Validated
public class LetterBlocksController {

    @GetMapping("/")
    public String input(Model model){
        log.trace("called input()");
        model.addAttribute("letters", new Letters("a"));
        return "index";
    }

    @GetMapping("/output")
    public String output(
            @CookieValue(value="letters") String userInput,
            Model model
    ) {
        Letters letters = new Letters(userInput);
        letters.symbolsToSpaces();
        log.info(letters.getLetters());
        letters.getUpper();
        log.info(letters.getLetters());
        letters.initializeList();

        model.addAttribute("letters", letters.getList());

        return "output";
    }

    @PostMapping("/process")
    public String letterBlocksProcess(
            @Validated Letters letters,
            BindingResult bindingResult,
            HttpServletResponse response,
            Model model
    ) {
        if(bindingResult.hasErrors()){
            model.addAttribute(letters);
            return "index";
        }

        letters.encodeForCookies();
        log.info(letters.getLetters());

        Cookie cookie = new Cookie("letters", letters.getLetters());
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);

        return "redirect:/output";
    }
}
