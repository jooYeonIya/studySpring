package org.example.minishopping.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
  private Long id;
  @NotBlank(message = "item의 name은 값을 입력해야합니다")
  private String name;
  @NotNull
  @Range(min=10, max=10000)
  private Integer cost;
  @NotNull
  @Range(min=10, max=10000)
  private Integer price;
  @NotNull
  @Max(9999)
  private Integer quantity;
}
