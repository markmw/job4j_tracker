package ru.job4j.pojo;

import org.junit.Test;
import ru.job4j.encapsulation.pojo.License;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first, is(second));
    }
}