package org.example.minishopping.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.minishopping.dto.ErrorResult;
import org.example.minishopping.dto.Item;
import org.example.minishopping.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@Slf4j
public class ItemController {
  @PostMapping
//  public Object createItem(@Validated @ModelAttribute Item item, BindingResult bindingResult) {
    public Object createItem(@Validated @RequestBody Item item, BindingResult bindingResult) {

    // 위치가 중요
    // reject한 후에 bindingResult.hasErrors() 해줄 필요 있음
    if (item.getCost() >= item.getPrice()) {
//      bindingResult.reject("costPrice", "cost exceeds price");
      throw new ValidationException("cost exceeds price ~~~");
    }

    if (bindingResult.hasErrors()) {
      log.error("validation errors: {}", bindingResult.getAllErrors());
      return bindingResult.getAllErrors();
    }

    log.info("Create Item: {}", item);
    return item;
  }
}
