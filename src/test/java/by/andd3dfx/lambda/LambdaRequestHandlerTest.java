package by.andd3dfx.lambda;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LambdaRequestHandlerTest {

    private final String TEST_STRING = "SOME TEST STRING";
    private LambdaRequestHandler handler;

    @Mock
    Context context;
    @Mock
    LambdaLogger lambdaLogger;

    @BeforeEach
    void setUp() {
        handler = new LambdaRequestHandler();
    }

    @Test
    void handleRequest() {
        when(context.getLogger()).thenReturn(lambdaLogger);

        String result = handler.handleRequest(TEST_STRING, context);

        verify(lambdaLogger).log("Input: " + TEST_STRING);
        assertThat(result).isEqualTo("Hello World - " + TEST_STRING);
    }
}