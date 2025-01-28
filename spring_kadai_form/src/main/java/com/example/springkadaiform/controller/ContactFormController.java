package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

	//入力画面表示
    @GetMapping("/form")
    public String input(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contactFormView";
    }

    //確認画面表示
    @GetMapping("/confirm")
    public String confirm(ContactForm form, Model model) {
        model.addAttribute("contactForm", form);
        return "confirmView";
    }

    @PostMapping("/form")
    public String form(RedirectAttributes redirectAttributes, @Validated ContactForm form, BindingResult bindingResult) {
		//バリデーションエラーがあったら終了
        if (bindingResult.hasErrors()) {
            return "contactFormView";
        }
		//バリデーションエラーがなかったら確認画面に移動
        return "confirmView";
    }

}
