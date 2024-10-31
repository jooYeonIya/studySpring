package org.example.spring_data_jpa.employee.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
//@Commit
class EmpServiceTest {
    @BeforeEach
    void setUp() {
        //tx.begin();
    }
    @AfterEach
    void tearDown() {
        //tx.rollback();
    }

    @Test
    void test1() {}

    @Test
    void test2() {}
}