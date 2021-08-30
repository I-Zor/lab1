package se.nackademin.java20.lab1.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Mock
    User mockUser;

    @Test
    public void shouldGiveRightName(){
        User user = new User("Ivona", "12345");

        when(mockUser.getName()).thenReturn(user.getName());

        assertEquals(mockUser.getName(), "Ivona");

        verify(mockUser).getName();

    }

}