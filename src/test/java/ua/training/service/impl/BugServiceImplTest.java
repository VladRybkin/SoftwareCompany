package ua.training.service.impl;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.training.model.entity.Bug;

import ua.training.service.BugService;


import static org.mockito.Mockito.lenient;


@ExtendWith(MockitoExtension.class)
class BugServiceImplTest {

    @Mock
    private BugService bugServiceMock;


    @Test
    void ShouldThrowBugDoesntExistException() throws Exception {
        Bug bug = new Bug();
        bug.setId(1);
        lenient().doThrow(new Exception()).when(bugServiceMock).updateBug(bug);
    }


}