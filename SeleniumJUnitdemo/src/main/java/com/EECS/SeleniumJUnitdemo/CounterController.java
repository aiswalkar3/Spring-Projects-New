package com.EECS.SeleniumJUnitdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/counter")
public class CounterController {
    private AtomicInteger count = new AtomicInteger(0);

    @ModelAttribute("resetForm")
    public ResetForm initResetForm()
    {
        ResetForm result = new ResetForm();
        result.setValue(0);
        return result;
    }

    @ModelAttribute("count")
    public Integer initCount()
    {
        return count.get();
    }

    @GetMapping
    public String getCounterPage(Model model)
    {
        return "counter";
    }

    @PostMapping
    public String postCounterPage(Model model)
    {
        Integer newCount = count.incrementAndGet();
        model.addAttribute("count",newCount);
        return "counter";
    }

    @PostMapping("/reset")
    public String reset(@ModelAttribute("resetForm") ResetForm resetForm, Model model)
    {
        count.set(resetForm.getValue());
        model.addAttribute("count",resetForm.getValue());
        resetForm.setValue(resetForm.getValue());
        return "counter";
    }
}
