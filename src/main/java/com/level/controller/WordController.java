package com.level.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.level.model.Word;
import com.level.repository.WordRepository;
import com.level.validation.WordValidation;

@Controller
public class WordController {
    @Autowired
    private WordRepository wordRepository;

    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model,@RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "26") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Word> words=wordRepository.findList(pageable);
        System.out.println(words);
        model.addAttribute("words", words);
        return "word/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "word/wordAdd";
    }

    @RequestMapping("/add")
    public String add(@Valid WordValidation wordParam,BindingResult result, ModelMap model) {
        String errorMsg="";
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg=errorMsg + error.getCode() + "-" + error.getDefaultMessage() +";";
            }
            model.addAttribute("errorMsg",errorMsg);
            return "word/wordAdd";
        }
        Word w= wordRepository.findBySpelling(wordParam.getSpelling());
        if(w!=null){
            model.addAttribute("errorMsg","用户已存在!");
            return "word/wordAdd";
        }
        Word word=new Word();
        BeanUtils.copyProperties(wordParam,word);
        wordRepository.save(word);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
    	Word word=wordRepository.findById(id);
        model.addAttribute("word", word);
        return "word/wordEdit";
    }

    @RequestMapping("/edit")
    public String edit(@Valid WordValidation wordParam, BindingResult result,ModelMap model) {
        String errorMsg="";
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg=errorMsg + error.getCode() + "-" + error.getDefaultMessage() +";";
            }
            model.addAttribute("errorMsg",errorMsg);
            model.addAttribute("word", wordParam);
            return "word/wordEdit";
        }

        Word word=new Word();
        BeanUtils.copyProperties(wordParam,word);
        wordRepository.save(word);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
    	wordRepository.delete(id);
        return "redirect:/list";
    }
}
