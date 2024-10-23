# jjStore 프로젝트
### API 설계
|기능|매서드|URI|method|view|redirect URI|기타|
|--------|-----|-----|-----|------|-------|-------|
|상품 등록|get|/products?action=insert|insert()|productsInsert.jsp||화면 표시
|				 |post|/products?action=insert|insert()|productsInsert.jsp|/products?action=list|DB 작업
|상품 목록 조회|get|/products||productsList.jsp|/products?action=list
|            |get|/products?action=list|list()|productsList.jsp|
|상품 상세 조회|get|/products?action=info&id=1|info()|productsInfo.jsp|
|상품 수정|get|/products?action=update&id=1|update()|productsUpdate.jsp||화면 표시
|				|post|/products?action=update|update()|productsUpdate.jsp|/products?action=list|DB 작업 / name, price 만 변경 가능
|상품 삭제|get|/products?action=delete&id=1|delete()|productsUpdate.jsp|/products?action=list|수정 페이지의 버튼으로 작업


### DB 설계
#### table 이름: products
|컬럼명|속성명|데이트 타입|PK|null|AI|기본값|
|-|------|-----|-------|-|-|-|
|id|상품 id|INT|○|×|○|
|name|상품 이름|VARCHAR(45)||×||
|price|상품 가격|INT||×||0
|maker|상품 제조사|VARCHAR(45)||○||
|stock|상품 재고량|INT||×||0

#### DB 예시
|id|name|price|maker|stock|
|-|------|-----|-------|-|
|1|Galaxy|10000|Samsung|0|
|2|IPhone|25000|Apple  |0|
