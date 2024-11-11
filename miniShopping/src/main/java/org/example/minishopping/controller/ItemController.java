package org.example.minishopping.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.minishopping.dto.Item;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@Slf4j
public class ItemController {
  @PostMapping
  public Object createItem(@Validated @RequestBody Item item, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      log.error("validation errors: {}", bindingResult.getAllErrors());
      return bindingResult.getAllErrors();
    }

    log.info("Create Item: {}", item);
    return item;
  }
}
